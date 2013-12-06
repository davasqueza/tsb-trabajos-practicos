/**
 *  Una lista genérica. Suponemos ahora que cada nodo referencia a un Comparable, y no a un Object. La clase controla
 *  homogeneidad mediante generics, y también provee métodos para facilitar su recorrido externo a modo de implementación liviana del 
 *  patrón Iterator.
 *  @author  Ing. Valerio Frittelli.
 *  @version Agosto de 2008.
 */
import java.util.NoSuchElementException;
public class SimpleList < E extends Comparable >
{
      private Node <E> frente;
      private Node <E> actual; // patrón Iterator: dirección del nodo que toca procesar.
      
      /** 
       * Constructor por defecto
       */
      public SimpleList ()
      {
          frente = null;
          actual = null;
      }
      
      /**
       *  Inserta un objeto al principio de la lista. La inserción se hará sólo si el parámetro recibido 
       *  no es null.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(E x)
      {
            if ( x == null ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node < E > p = new Node < E > (x, frente);
            frente = p;
      }  
      
      /**
       *  Inserta un objeto en forma ordenada en la lista. La inserción se hará sólo si el parámetro recibido 
       *  no es null. Se supone que la lista está ya ordenada (es decir, se supone que todas las inserciones fueron realizadas llamando a
       *  este método). Este método no viene en la clase LinkedList tomada como modelo para el planteo realizado
       *  en clase de SimpleList: se incorpora desde la materia TSB por tratarse de un algoritmo clásico e interesante.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addInOrder(E x)
      {
            if ( x == null ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node <E> nuevo = new Node <E> ( x, null );
            Node <E> p = frente, q = null;
            while ( p != null && x.compareTo( p.getInfo() ) >= 0 )
            {
                q = p;
                p = p.getNext();
            }
            nuevo.setNext( p );
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
      }  

      
      /**
       *  Inserta un objeto al final de la lista. La inserción se hará sólo si el parámetro recibido 
       *  no es null.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addLast(E x)
      {
            if ( x  == null ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node <E> nuevo = new Node < E >( x, null );
            Node <E> p = frente, q = null;
            while ( p != null )
            {
                q = p;
                p = p.getNext();
            }
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
      }  
      
      /**
       *  Remueve todos los elementos de la lista.
       */
      public void clear( )
      {
         frente = null; // ¿alguna duda?
      }
      
      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al principio de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public E getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         return  (E) frente.getInfo();
      }
      
      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al final de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public E getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         Node <E> p = frente, q = null;
         while( p != null )
         {
            q = p;
            p = p.getNext();
         }
         return (E) (( q != null )? q.getInfo() : frente.getInfo());
      }
      
      /**
       *  Indica si queda algún objeto en el recorrido del iterador. Se incorpora para cumplir nuestra 
       *  implementación liviana del patrón Iterator. Corresponde al método hasNext() de la clase
       *  Iterator del lenguaje Java.
       *  @return true si queda algún objeto en el recorrido - false si no quedan objetos.
       */
      public boolean hasNext()
      {
         if ( frente == null ) return false;
         if ( actual != null && actual.getNext() == null ) return false;
         return true;
      }
      
      /**
       * Retorna true si la lista está vacía.
       * @return true si la lista está vacía - false en caso contrario.
       */
      public boolean isEmpty()
      {
         return (frente == null);    
      }
      
      /**
       *  Retorna el siguiente objeto en el recorrido del iterador. Se incorpora para cumplir nuestra 
       *  implementación liviana del patrón Iterator. Corresponde al método next() de la clase Iterator 
       *  del lenguaje Java.
       *  @return el siguiente objeto en el recorrido.
       *  @throws NoSuchElementException si la lista está vacía o en la lista no quedan elementos por recorrer.
       */
      public E next()
      {
          if ( ! hasNext() ) throw new NoSuchElementException("No quedan elementos por recorrer");
          
          if ( actual == null ) actual = frente;
          else actual = actual.getNext();
          return (E)actual.getInfo();
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al final de la lista. 
       *  @return el último elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public E removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         Node <E> p = frente, q = null;
         while( p.getNext() != null )
         {
            q = p;
            p = p.getNext();
         }
         E x = (E)p.getInfo();
         if( q != null ) q.setNext( p.getNext() );
         else frente = p.getNext();
         return x;
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al principio de la lista. 
       *  @return el primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public E removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         E x = (E)frente.getInfo();
         frente = frente.getNext();
         return x;
      }
     
      /**
       *  Inicializa el mecanismo de recorrido. Hace que la próxima invocación a next() retorne el primer objeto de
       *  la lista. Forma parte de nuestra implementación liviana del patrón Iterator. En la clase LinkedList de Java, 
       *  nuestro método sería equivalente a invocar al método iterator(), el cual retorna un objeto de la clase 
       *  Iterator (predefinida de Java). Decidimos cambiar el nombre por razones de claridad.
       */
      public void startIterator()
      {
            actual = null;    
      }
      
      /**
       *  Redefine el método toString heredado desde Object.
       *  @return el contenido de la lista convertido a String.
       */
      public String toString()
      {
             Node <E> p = frente;
             String res = "[ ";
             while( p != null )
             {
                res = res + p.toString();
                if ( p.getNext() != null ) res = res + " - ";
                p = p.getNext();
             }
             res = res + " ]";
             return res;
      }
}
