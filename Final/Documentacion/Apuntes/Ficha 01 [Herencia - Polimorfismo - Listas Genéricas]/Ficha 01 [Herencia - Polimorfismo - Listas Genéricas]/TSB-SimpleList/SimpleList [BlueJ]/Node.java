/**
 *  Primera versión de una clase para representar un nodo para una lista simple genérica.
 *  @author Ing. Valerio Frittelli
 *  @version Agosto de 2008
 */
public class Node
{
   private Object info;
   private Node next;
   
   /**
    *  Constructor por defecto. 
    */
   public Node ( )
   {
   }
   
   /**
    *  Crea un nodo incializando todos los atributos en base a parámetros 
    */
   public Node (Object x, Node p)
   {
     info = x;
     next = p;
   }
   
   /**
    *  Accede a la dirección del sucesor
    *  @return la dirección del nodo sucesor
    */
   public Node getNext()
   {
     return next;
   }
   
   /**
    * Cambia la dirección del sucesor
    * @param p dirección del nuevo sucesor
    */
   public void setNext(Node p)
   {
     next = p;
   }
   
   /**
    *  Accede al valor del info
    *  @return el valor del info
    */
   public Object getInfo()
   {
     return info;
   }
   
   /**
    * Cambia el valor del info
    * @param p nuevo valor del info
    */
   public void setInfo(Object p)
   {
     info = p;
   }

   /**
    * Convierte el contenido del nodo en String
    * @return el contenido del nodo convertido en String
    */
   public String toString()
   {
     return info.toString();   
   }
}

