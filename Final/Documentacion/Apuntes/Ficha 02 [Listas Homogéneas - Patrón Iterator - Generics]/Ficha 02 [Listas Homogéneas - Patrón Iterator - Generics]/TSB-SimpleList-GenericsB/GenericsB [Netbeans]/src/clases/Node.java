package clases;

/**
 *  Segunda versi�n de una clase para representar un nodo para una lista simple gen�rica.
 *  Se usa parametrizaci�n de clases (generics) para controlar autom�ticamente el contenido homog�neo.
 *  @author Ing. Valerio Frittelli
 *  @version Agosto de 2008
 */
public class Node < E extends Comparable >
{
   private E info;
   private Node <E> next;
   
   /**
    *  Constructor por defecto. 
    */
   public Node ( )
   {
   }
   
   /**
    *  Crea un nodo incializando todos los atributos en base a par�metros 
    */
   public Node (E x, Node <E> p)
   {
     info = x;
     next = p;
   }
   
   /**
    *  Accede a la direcci�n del sucesor
    *  @return la direcci�n del nodo sucesor
    */
   public Node <E> getNext()
   {
     return next;
   }
   
   /**
    * Cambia la direcci�n del sucesor
    * @param p direcci�n del nuevo sucesor
    */
   public void setNext(Node <E> p)
   {
     next = p;
   }
   
   /**
    *  Accede al valor del info
    *  @return el valor del info
    */
   public E getInfo()
   {
     return info;
   }
   
   /**
    * Cambia el valor del info
    * @param p nuevo valor del info
    */
   public void setInfo(E p)
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

