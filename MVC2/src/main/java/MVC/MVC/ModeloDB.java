package MVC.MVC;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModeloDB extends ConexionDB{

	 /** Constructor de clase */
    public ModeloDB(){}

    /** Obtiene registros de la tabla PRODUCTO y los devuelve en un DefaultTableModel*/
    public DefaultTableModel getTablaProducto()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"codigoPieza","nombrePieza"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM piezas");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][2];
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM piezas");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codigoPieza" );
                data[i][1] = res.getString( "nombrePieza" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }

    /** Registra un nuevo producto */
    public boolean NuevoProducto(String codigoPieza, String nombrePieza)
    {
        if(valida_datos(/*codigoPieza,*/ nombrePieza))
        {
           
            //Se arma la consulta
            String q=" INSERT INTO piezas ( codigoPieza , nombrePieza ) "
                    + "VALUES ( '" + codigoPieza + "', '" + nombrePieza  + "' ) ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null, "Nuevo producto creado correctamente");
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
                JOptionPane.showMessageDialog(null, "No se pudo crear este producto");
            }
            return false;
        }
        else
         return false;
    }
    
    public boolean ActualizarProducto(String codigoPieza, String nombrePieza)
    {
        if(valida_datos(/*codigoPieza,*/ nombrePieza))
        {
          
            //Se arma la consulta
        	String q = " UPDATE piezas SET nombrePieza = '" + nombrePieza + "'  WHERE codigoPieza = '" + codigoPieza + "' ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
                JOptionPane.showMessageDialog(null, "No se puede actualizar este producto.");
            }
            return false;
        }
        else
         return false;
    }
   
    /** Busca un registro dado su ID -> Llave primaria */
    public boolean BuscarProducto(String id)
    {
         boolean res=false;
        //se arma la consulta
        String q = " SELECT * FROM piezas WHERE codigoPieza='" + id + "' " ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
         	   System.out.println("Codigo: " + rs.getInt(1)+" Nombre: "+rs.getString(2));
         	  JOptionPane.showMessageDialog(null, "Codigo: " + rs.getInt(1)+" Nombre: "+rs.getString(2));
            }
            pstm.close();       
            res=true;
               
         }catch(SQLException e){
            System.err.println(e.getMessage() );
            JOptionPane.showMessageDialog(null, "Este producto no existe o no se pudo encontrar");
        }
        return res;
    }

    /** Elimina un registro dado su ID -> Llave primaria */
    public boolean EliminarProducto(String id)
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM piezas WHERE  codigoPieza='" + id + "' " ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
         }catch(SQLException e){
            System.err.println( e.getMessage() );
            JOptionPane.showMessageDialog(null, "No se puede borrar este producto.");
        }
        return res;
    }
    
    /** Elimina un registro dado su ID -> Llave primaria */
    public boolean BorrarTabla()
    {
         boolean res=false;
        //se arma la consulta
        String q = " DROP TABLE piezas" ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            JOptionPane.showMessageDialog(null, "Tabla borrada correctamente");
         }catch(SQLException e){
            System.err.println( e.getMessage() );
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tabla");
        }
        return res;
    }
    
    /** Elimina un registro dado su ID -> Llave primaria */
    public boolean InstanciarTabla()
    {
         boolean res=false;
        //se arma la consulta
        String q = "CREATE TABLE piezas (codigoPieza INT PRIMARY KEY AUTO_INCREMENT, nombrePieza NVARCHAR(100))";
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            JOptionPane.showMessageDialog(null, "Tabla instanciada correctamente");
         }catch(SQLException e){
            System.err.println( e.getMessage() );
            JOptionPane.showMessageDialog(null, "La tabla ya existe");
        }
        return res;
    }
    
    

    /** Metodo privado para validar datos */
    private boolean valida_datos(/*String codigoPieza,*/ String nombrePieza)
    {
        if( nombrePieza.length() <= 100)
        {
            return true;
        }
        else  return false;
    }

}
