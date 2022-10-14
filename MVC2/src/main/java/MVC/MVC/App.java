package MVC.MVC;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        new Controlador(new Vista()).iniciar();
    }
}
