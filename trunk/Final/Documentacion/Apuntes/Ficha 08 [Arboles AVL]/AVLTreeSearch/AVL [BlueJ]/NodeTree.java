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
      Inicializa los atributos tomando los valores de los parámetros
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
      Modificador de la dirección del subárbol izquierdo
      @param iz Nuevo valor del atributo izq
   */
   public void setIzquierdo (NodeTree iz)
   {
      izq = iz;
   }

   /**
      Modificador de la dirección del subárbol derecho
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
      Acceso a la dirección del subárbol izquierdo
      @return valor de la dirección del subárbol izquierdo
   */
   public NodeTree getIzquierdo ()
   {
      return izq;
   }

   /**
      Acceso a la dirección del subárbol derecho
      @return valor de la dirección del subárbol derecho
   */
   public NodeTree getDerecho ()
   {
      return der;
   }

   /**
     Redefinición de toString
     @return representación del contenido del nodo como un String
   */
   public String toString()
   {
     return info.toString();
   }
}
