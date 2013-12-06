/**
 * Describe un intento de insertar objetos de tipos distintos en una estructura homogénea
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public class InsercionHeterogeneaException extends Exception
{
    private String mensaje = "Error: Inserción Heterogénea";
    
	/**
	 * Constructor nulo
	 */
	public InsercionHeterogeneaException()
	{
	}

	/**
	 * Constructor. Toma el mensaje como parámetro
	 */
	public InsercionHeterogeneaException(String mens)
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
