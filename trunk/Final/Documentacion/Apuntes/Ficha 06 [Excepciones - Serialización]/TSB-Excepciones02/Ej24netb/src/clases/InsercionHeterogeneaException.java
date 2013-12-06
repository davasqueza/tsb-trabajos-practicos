package clases;

/**
 * Describe un intento de insertar objetos de tipos distintos en una estructura homog�nea
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public class InsercionHeterogeneaException extends Exception
{
    private String mensaje = "Error: Inserci�n Heterog�nea";
    
	/**
	 * Constructor nulo
	 */
	public InsercionHeterogeneaException()
	{
	}

	/**
	 * Constructor. Toma el mensaje como par�metro
	 */
	public InsercionHeterogeneaException(String mens)
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
