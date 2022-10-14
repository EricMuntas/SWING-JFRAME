package MVC.MVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
	 /* DATOS PARA LA CONEXION */
	  /** base de datos por defecto es test*/
	  private String db = "PiezasProveedores";
	  /** usuario */
	  private String user = "root";
	  /** contraseña de MySql*/
	  private String password = "";
	  /** Cadena de conexion */
	  private String url = "jdbc:mysql://localhost/"+db;
	  /** variable para trabajar con la conexion a la base de datos */
	  private Connection conn = null;

	   /** Constructor de clase */
	   public ConexionDB(){
	        this.url = "jdbc:mysql://localhost/"+this.db;
	       try{
	         //obtenemos el driver de para mysql
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         //obtenemos la conexión
	         conn = DriverManager.getConnection( this.url, this.user , this.password );     
	        
	      }catch(SQLException e){
	         System.err.println( e.getMessage() );
	      }catch(ClassNotFoundException e){
	         System.err.println( e.getMessage() );
	      }
	   }
	  // com.mysql.jdbc.Driver


	   public Connection getConexion()
	   {
	    return this.conn;
	   }
	
	
}