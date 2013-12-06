/**
 * Describe un intento de acceder a objetos aún no creados en el Listado
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public class AccesoIncorrectoException extends Exception
{
    private String mensaje = "Error: Acceso Incorrecto";
    
	/**
	 * Constructor nulo
	 */
	public AccesoIncorrectoException()
	{
	}

	/**
	 * Constructor. Toma el mensaje como parámetro
	 */
	public AccesoIncorrectoException(String mens)
	{
	    mensaje = mens;
	}
	
	/**
	 * Redefinición del método heredado desde Throwable
	 * @return un String con la descripción del error
	 */
	public String getMessage()
	{
	   return mensaje;   
	}
}
