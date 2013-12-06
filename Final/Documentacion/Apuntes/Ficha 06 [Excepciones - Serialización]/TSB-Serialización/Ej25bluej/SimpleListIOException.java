/**
 * Representa situaciones de error en IO enla serialización de objetos de la clase 
 * SimpleList. Estos errores serán casi siempre debidos a intentos de Serialización 
 * fallidos, pero puede usarse en cualquier otra situación que implique IO por algún 
 * dispositivo externo.
 * 
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008
 */
public class SimpleListIOException extends Exception
{
       private String message = "Problema al serializar la lista";
    
      /**
       * Inicializa el objeto de excepción con valores por default.
       */
       public SimpleListIOException()
       {
       }  
    
      /**
       * Inicializa el mensaje a retornar con getMessage() con la cadena tomada como
       * parámetro.
       * @param msg el mensaje que sera retornado con getMessage().
       * @see getMessage()
       */
       public SimpleListIOException(String msg)
       {
            message = msg;
       }
    
      /**
       * Retorna una descripción del error que provocó la excepción
       * @return una cadena con la descripción del error.
       */
       public String getMessage()
       {
         return message;
       }   
}