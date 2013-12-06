package estructuras;

/**
 * Representa un nodo para una Skip List.
 * @author Ing. Bett - Ing. Frittelli - Catedra de TSB.
 * @version Agosto de 2012.
 */
public class Node
{
      private Comparable info;
      private Node [] next;
  
      /**
       * Crea un nodo con nivel igual a level e info igual a data.
       * @param level el nivel que será asociado al nodo.
       * @param data el objeto a almacenar en el nodo.
       */
      public Node(int level, Comparable data)
      {
        info = data;
        next = new Node[level + 1];
        for(int i = 0; i <= level; i++) next[i] = null;
      }   
      
      /**
       * Obtiene el objeto almacenado en el nodo.
       * @return el objeto almacenado en el nodo.
       */
      public Comparable getInfo()
      {
        return info;  
      }
      
      /**
       * Cambia el objeto almacenado en el nodo.
       * @param x el objeto a almacenar en el nodo.
       */
      public void setInfo(Comparable x)
      {
        info = x;        
      }
      
      /**
       * Obtiene el siguiente nodo en el nivel i.
       * @return una referencia al siguiente nodo en el nivel i.
       */
      public Node getNext(int i)
      {
        return next[i];  
      }
      
      /**
       * Cambia el siguiente nodo en el nivel i.
       * @param x el nuevo nodo a asignar como sucesor en el nivel i.
       * @param i el nivel en el cual se cambiara el sucesor.
       */
      public void setNext(Node x, int i)
      {
        next[i] = x; 
      }
          
      /**
       * Obtiene la conversion a String del objeto almacenado en el nodo.
       * @return la conversion a String del objeto almacenado.
       */
      public String toString()
      {
         return info.toString();  
      }
}