package dominio;

/**
  Clase para representar al Nodo de un Arbol Binario 
  @author Ing. Valerio Frittelli
  @version Septiembre de 2008
*/
public class NodeTree
{
   private Comparable info;
   private NodeTree izq, der;
   
   /**
      Constructor por defecto
   */
   public NodeTree ()
   {
   }
   
   /**
      Inicializa los atributos tomando los valores de los par�metros
   */
   public NodeTree(Comparable x, NodeTree iz, NodeTree de)
   {
       info = x;
       izq  = iz;
       der  = de;
   }

   /**
      Modificador del info
      @param x nuevo valor del info
   */
   public void setInfo (Comparable x)
   {
      info = x;
   }

   /**
      Modificador de la direcci�n del sub�rbol izquierdo
      @param iz Nuevo valor del atributo izq
   */
   public void setIzquierdo (NodeTree iz)
   {
      izq = iz;
   }

   /**
      Modificador de la direcci�n del sub�rbol derecho
      @param de Nuevo valor del atributo der
   */
   public void setDerecho (NodeTree de)
   {
      der = de;
   }

   /**
      Acceso al info
      @return valor del info
   */
   public Comparable getInfo ()
   {
      return info;
   }

   /**
      Acceso a la direcci�n del sub�rbol izquierdo
      @return valor de la direcci�n del sub�rbol izquierdo
   */
   public NodeTree getIzquierdo ()
   {
      return izq;
   }

   /**
      Acceso a la direcci�n del sub�rbol derecho
      @return valor de la direcci�n del sub�rbol derecho
   */
   public NodeTree getDerecho ()
   {
      return der;
   }

   /**
     Redefinici�n de toString
     @return representaci�n del contenido del nodo como un String
   */
   public String toString()
   {
     return info.toString();
   }
}
