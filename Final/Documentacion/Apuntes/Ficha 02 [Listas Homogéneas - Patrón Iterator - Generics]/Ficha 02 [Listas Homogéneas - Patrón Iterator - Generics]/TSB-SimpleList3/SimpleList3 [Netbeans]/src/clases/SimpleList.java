package clases;

/**
 *  Una lista gen�rica. Suponemos ahora que cada nodo referencia a un Comparable, y no a un Object.
 *  @author  Ing. Valerio Frittelli
 *  @version Agosto de 2008
 */
import java.util.NoSuchElementException;
public class SimpleList
{
      private Node frente;
      
      /** 
       * Constructor por defecto
       */
      public SimpleList ()
      {
          frente = null;
      }
      
      /**
       *  Inserta un objeto al principio de la lista. La inserci�n se har� s�lo si el par�metro recibido 
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si lleg� ac�, est� todo ok... inserte tranquilo
            Node p = new Node(x, frente);
            frente = p;
      }  
      
      /**
       *  Inserta un objeto en forma ordenada en la lista. La inserci�n se har� s�lo si el par�metro recibido 
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista. Se supone 
       *  que la est� ya ordenada (es decir, se supone que todas las inserciones fueron realizadas llamando a
       *  este m�todo). Este m�todo no viene en la clase LinkedList tomada como modelo para el planteo realizado
       *  en clase de SimpleList: se incorpora desde la materia TSB por tratarse de un algoritmo cl�sico e interesante.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addInOrder(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si lleg� ac�, est� todo ok... inserte tranquilo
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
       *  Inserta un objeto al final de la lista. La inserci�n se har� s�lo si el par�metro recibido 
       *  no es null y si el objeto representado es compatible con el contenido actual de la lista
       *  @param x el objeto a almacenar en la lista.
       */
      public void addLast(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            // si lleg� ac�, est� todo ok... inserte tranquilo
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
         frente = null; // �alguna duda?
      }
      
      /**
       *  Determina si en la lista existe un elemento que coincida con x. Usamos compareTo() para
       *  realizar las comparaciones (aunque podr�a usarse equals()).
       *  @return true si x est� en la lista - false si x no est� o si x es null.
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
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         return frente.getInfo();
      }
      
      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al final de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public Comparable getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         Node p = frente, q = null;
         while( p != null )
         {
            q = p;
            p = p.getNext();
         }
         return ( q != null )? q.getInfo() : frente.getInfo();
         /* lo anterior es equivalente a:
          * if (q!=null) return q.getInfo();
          * else return frente.getInfo();
          */
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al final de la lista. 
       *  @return el �ltimo elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public Comparable removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
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
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public Comparable removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         Comparable x = frente.getInfo();
         frente = frente.getNext();
         return x;
      }
     
      /**
       * Busca un objeto x en la lista, y en caso de encontrarlo retorna una referencia al objeto 
       * que EST� EN LA LISTA. Retorna null si x no est� en la lista o si x es null o si x no es
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
       *  Redefine el m�todo toString heredado desde Object.
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
      
      // Este m�todo controla que x sea homogeneo con el contenido de la lista
      // Retorna true si es homog�neo y false en caso contrario
      private boolean isHomogeneus (Comparable x)
      {
            if ( x == null ) return false;
            if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
            return true;
      }
}
