package clases;

/**
 *  Una lista gen�rica. Empleamos generics para control de homogeneidad.
 *  @author  Ing. Valerio Frittelli.
 *  @version Agosto de 2008.
 */
import java.util.NoSuchElementException;
public class SimpleList < E >
{
      private Node <E> frente;
      private Node <E> actual; // patr�n Iterator: direcci�n del nodo que toca procesar.
      
      /** 
       * Constructor por defecto
       */
      public SimpleList ()
      {
          frente = null;
          actual = null;
      }
      
      /**
       *  Inserta un objeto al principio de la lista. La inserci�n se har� s�lo si el par�metro recibido 
       *  no es null.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(E x)
      {
            if ( x == null ) return;
            
            // si lleg� ac�, est� todo ok... inserte tranquilo
            Node < E > p = new Node < E > (x, frente);
            frente = p;
      }  

      /**
       *  Inserta un objeto al final de la lista. La inserci�n se har� s�lo si el par�metro recibido 
       *  no es null.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addLast(E x)
      {
            if ( x  == null ) return;
            
            // si lleg� ac�, est� todo ok... inserte tranquilo
            Node < E > nuevo = new Node < E >( x, null );
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
         frente = null; // �alguna duda?
      }
      
      /**
       *  Retorna (pero sin removerlo) el objeto ubicado al principio de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public E getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         return  (E) frente.getInfo();
      }
            /**
       *  Retorna (pero sin removerlo) el objeto ubicado al final de la lista. 
       *  @return una referencia al primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public E getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         Node <E> p = frente, q = null;
         while( p != null )
         {
            q = p;
            p = p.getNext();
         }
         return (E) (( q != null )? q.getInfo() : frente.getInfo());
      }
      
      /**
       *  Indica si queda alg�n objeto en el recorrido del iterador. Se incorpora para cumplir nuestra 
       *  implementaci�n liviana del patr�n Iterator. Corresponde al m�todo hasNext() de la clase
       *  Iterator del lenguaje Java.
       *  @return true si queda alg�n objeto en el recorrido - false si no quedan objetos.
       */
      public boolean hasNext()
      {
         if ( frente == null ) return false;
         if ( actual != null && actual.getNext() == null ) return false;
         return true;
      }
      
      /**
       * Retorna true si la lista est� vac�a.
       * @return true si la lista est� vac�a - false en caso contrario.
       */
      public boolean isEmpty()
      {
         return (frente == null);    
      }
      
      /**
       *  Retorna el siguiente objeto en el recorrido del iterador. Se incorpora para cumplir nuestra 
       *  implementaci�n liviana del patr�n Iterator. Corresponde al m�todo next() de la clase Iterator 
       *  del lenguaje Java.
       *  @return el siguiente objeto en el recorrido.
       *  @throws NoSuchElementException si la lista est� vac�a o en la lista no quedan elementos por recorrer.
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
       *  @return el �ltimo elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public E removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
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
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public E removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         E x = (E)frente.getInfo();
         frente = frente.getNext();
         return x;
      }
     
      /**
       *  Inicializa el mecanismo de recorrido. Hace que la pr�xima invocaci�n a next() retorne el primer objeto de
       *  la lista. Forma parte de nuestra implementaci�n liviana del patr�n Iterator. En la clase LinkedList de Java, 
       *  nuestro m�todo ser�a equivalente a invocar al m�todo iterator(), el cual retorna un objeto de la clase 
       *  Iterator (predefinida de Java). Decidimos cambiar el nombre por razones de claridad.
       */
      public void startIterator()
      {
            actual = null;    
      }
      
      /**
       *  Redefine el m�todo toString heredado desde Object.
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
