package clases;

/**
 * Representa situaciones de error en IO enla serializaci�n de objetos de la clase 
 * SimpleList. Estos errores ser�n casi siempre debidos a intentos de Serializaci�n 
 * fallidos, pero puede usarse en cualquier otra situaci�n que implique IO por alg�n 
 * dispositivo externo.
 * 
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008
 */
public class SimpleListIOException extends Exception
{
       private String message = "Problema al serializar la lista";
    
      /**
       * Inicializa el objeto de excepci�n con valores por default.
       */
       public SimpleListIOException()
       {
       }  
    
      /**
       * Inicializa el mensaje a retornar con getMessage() con la cadena tomada como
       * par�metro.
       * @param msg el mensaje que sera retornado con getMessage().
       * @see getMessage()
       */
       public SimpleListIOException(String msg)
       {
            message = msg;
       }
    
      /**
       * Retorna una descripci�n del error que provoc� la excepci�n
       * @return una cadena con la descripci�n del error.
       */
       public String getMessage()
       {
         return message;
       }   
}