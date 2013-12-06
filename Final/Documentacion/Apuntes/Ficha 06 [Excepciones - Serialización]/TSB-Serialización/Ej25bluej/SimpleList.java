/**
 *  Una lista genérica. Suponemos ahora que cada nodo referencia a un Comparable, y no a un Object. La clase controla
 *  homogeneidad, y también provee métodos para facilitar su recorrido externo a modo de implementación liviana del 
 *  patrón Iterator.
 *  @author  Ing. Valerio Frittelli.
 *  @version Agosto de 2008.
 */
import java.util.NoSuchElementException;
import java.io.Serializable;
public class SimpleList implements Serializable
{
      private Node frente;
      private Node actual; // patrón Iterator: dirección del nodo que toca procesar.
      
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
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node p = new Node(x, frente);
            frente = p;
      }  
      
      /**
       *  Inserta un objeto en forma ordenada en la lista. La inserción se hará sólo si el parámetro recibido 
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista. Se supone 
       *  que la está ya ordenada (es decir, se supone que todas las inserciones fueron realizadas llamando a
       *  este método). Este método no viene en la clase LinkedList tomada como modelo para el planteo realizado
       *  en clase de SimpleList: se incorpora desde la materia TSB por tratarse de un algoritmo clásico e interesante.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addInOrder(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node nuevo = new Node( x, null );
            Node p = frente, q = null;
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
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista
       *  @param x el objeto a almacenar en la lista.
       */
      public void addLast(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si llegó acá, está todo ok... inserte tranquilo
            Node nuevo = new Node( x, null );
            Node p = frente, q = null;
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
       *  Determina si en la lista existe un elemento que coincida con x. Usamos compareTo() para
       *  realizar las comparaciones (aunque podría usarse equals()).
       *  @return true si x está en la lista - false si x no está o si x es null.
       *  @param x el objeto a buscar.
       */
      public boolean contains (Comparable x)
      {
          if ( ! isHomogeneus( x ) ) return false;
          
          Node p = frente;
          while ( p != null && x.compareTo( p.getInfo() ) != 0 )
          {
                p = p.getNext();    
          }
          return ( p != null );
      }

      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al principio de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         return frente.getInfo();
      }
      
      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al final de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public Comparable getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         Node p = frente, q = null;
         while( p != null )
         {
            q = p;
            p = p.getNext();
         }
         return ( q != null )? q.getInfo() : frente.getInfo();
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
      public Comparable next()
      {
          if ( ! hasNext() ) throw new NoSuchElementException("No quedan elementos por recorrer");
          
          if ( actual == null ) actual = frente;
          else actual = actual.getNext();
          return actual.getInfo();
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al final de la lista. 
       *  @return el último elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public Comparable removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         Node p = frente, q = null;
         while( p.getNext() != null )
         {
            q = p;
            p = p.getNext();
         }
         Comparable x = p.getInfo();
         if( q != null ) q.setNext( p.getNext() );
         else frente = p.getNext();
         return x;
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al principio de la lista. 
       *  @return el primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vacía.
       */
      public Comparable removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista está vacía...");
         
         Comparable x = frente.getInfo();
         frente = frente.getNext();
         return x;
      }
     
      /**
       * Busca un objeto x en la lista, y en caso de encontrarlo retorna una referencia al objeto 
       * que ESTÁ EN LA LISTA. Retorna null si x no está en la lista o si x es null o si x no es
       * compatible con el contenido de la lista
       */
      public Comparable search (Comparable x)
      {
            if ( ! isHomogeneus( x ) )  return null;
            
            Comparable r = null;
            Node p = frente;
            while ( p != null && x.compareTo( p.getInfo() ) != 0)
            {
                p = p.getNext();   
            }
            if ( p != null ) r = p.getInfo();
            return r;
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
             Node p = frente;
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
      
      // Este método controla que x sea homogeneo con el contenido de la lista
      // Retorna true si es homogéneo y false en caso contrario
      private boolean isHomogeneus (Comparable x)
      {
            if ( x == null ) return false;
            if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
            return true;
      }
}
