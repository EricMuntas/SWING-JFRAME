package MVC.MVC;
import java.util.Scanner;
public class Vista {

	//private ModeloDB modelo;
	
	static Scanner teclado = new Scanner(System.in);
	
	
	/**
	 * Menu principal
	 */
	public static void menuPrincipal() {
		
		System.out.println("--- Menú ---");
		System.out.println("1. Instanciar tabla");
		System.out.println("2. Borrar tabla");
		System.out.println("3. CRUD");
		System.out.println("4. Salir");
	
	}
	
	/**
	 * Mostrar el menu CRUD
	 */
	public static void mostrarMenu() {
		
		System.out.println("--- CRUD Menú piezas ---");
		System.out.println("1. Crear");
		System.out.println("2. Buscar");
		System.out.println("3. Actualizar");
		System.out.println("4. Borrar");
	
	}
	
	
	/**
	 * Seleccionar en el menu
	 * @return
	 */
	public static int seleccion() {
		
		int seleccion = teclado.nextInt();
		return seleccion;
	}

	/**
	 * Método para preguntar codigo pieza
	 * @return
	 */
	public static String preguntarCodigoPieza() {
		
		System.out.println("Codigo de la pieza:");
		int codigoPieza = teclado.nextInt();
		String codigoPiezaStr = codigoPieza + "";
		return codigoPiezaStr;
		
	}
	
	/**
	 * Metodo preguntar nombre de la pieza
	 * @return
	 */
	public static String preguntarNombrePieza() {
	
	System.out.println("Nombre de la pieza:");
	String nombrePieza = teclado.next();
	return nombrePieza;
	
}
	/**
	 * Salir del programa
	 */
	public static void salida() {
		System.out.println("Saliste!");
	}
	

	
	
}
