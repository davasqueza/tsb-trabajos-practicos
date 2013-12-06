package clases;

/**
 * Describe un intento de acceder a objetos a�n no creados en el Listado
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
	 * Constructor. Toma el mensaje como par�metro
	 */
	public AccesoIncorrectoException(String mens)
	{
	    mensaje = mens;
	}
	
	/**
	 * Redefinici�n del m�todo heredado desde Throwable
	 * @return un String con la descripci�n del error
	 */
	public String getMessage()
	{
	   return mensaje;   
	}
}
