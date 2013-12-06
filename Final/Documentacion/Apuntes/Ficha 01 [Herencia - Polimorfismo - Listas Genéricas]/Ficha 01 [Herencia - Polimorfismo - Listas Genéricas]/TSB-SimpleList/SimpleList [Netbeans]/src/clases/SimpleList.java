package clases;

/**
 *  Una lista gen�rica
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
       *  Inserta un objeto al principio de la lista.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(Object x)
      {
            if ( x != null )
            {
               Node p = new Node(x, frente);
               frente = p;
            }
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
      public Object getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         return frente.getInfo();
      }
      
      /**
       *  Retorna (y remueve) el objeto ubicado al principio de la lista. 
       *  @return el primer elemento de la lista.
       *  @throws NoSuchElementException si la lista estaba vac�a.
       */
      public Object removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         Object x = frente.getInfo();
         frente = frente.getNext();
         return x;
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
}
