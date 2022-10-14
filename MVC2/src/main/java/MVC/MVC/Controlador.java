package MVC.MVC;

import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.SQLError;

public class Controlador {
	Vista vista;
	ModeloDB modelo = new ModeloDB();

	public Controlador(Vista vista) {
		super();
		this.vista = vista;
	}

	public void iniciar() {

		Vista.menuPrincipal();
		int seleccion = Vista.seleccion();

		switch (seleccion) {
		
		case 1:
			//Instanciar la tabla
		
			modelo.InstanciarTabla();
			
			break;

		case 2:
			// Borrar tabla
			modelo.BorrarTabla();
			break;
			
		case 3:
			// Menu crud
			crud();
			break;
			
		case 4:
			// Salir del programa
			Vista.salida();
			break;
		}
	}



/**
 * Empezar menu crud
 */
	public void crud() {
		
		String codigoPieza;
		String nombrePieza;
		Vista.mostrarMenu();
		int seleccion = Vista.seleccion();

		switch (seleccion) {
		case 1:

			// Crear
			codigoPieza = Vista.preguntarCodigoPieza();
			nombrePieza = Vista.preguntarNombrePieza();
			modelo.NuevoProducto(codigoPieza, nombrePieza);
			break;

		case 2: 

			// Buscar
			codigoPieza = Vista.preguntarCodigoPieza();
			modelo.BuscarProducto(codigoPieza);
			break;

		case 3: 

			// Actualizar
			codigoPieza = Vista.preguntarCodigoPieza();
			nombrePieza = Vista.preguntarNombrePieza();
			modelo.ActualizarProducto(codigoPieza, nombrePieza);
			break;

		case 4: 

			// Borrar	
			codigoPieza =  Vista.preguntarCodigoPieza();
			modelo.EliminarProducto(codigoPieza);
			break;

		}

	}
}


