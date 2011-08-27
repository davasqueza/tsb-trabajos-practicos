package tsb_tp1;

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
       *  Inserta un objeto al principio de la lista.
       *  @param x el objeto a almacenar en la lista.
       */
      public void addFirst(Comparable x)
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
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         return frente.getInfo();
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
       *  Determina si en la lista existe un elemento que coincida con x. Usamos compareTo() para
       *  realizar las comparaciones (aunque podr�a usarse equals()).
       *  @return true si x est� en la lista - false si x no est� o si x es null.
       *  @param x el objeto a buscar.
       */
      public boolean contains (Comparable x)
      {
          if (x == null) return false;
           
          Node p = frente;
          while ( p != null && x.compareTo( p.getInfo() ) != 0 )
          {
                p = p.getNext();    
          }
          return ( p != null );
          /*
           * lo anterior es los mismo que:
           * if(p!=null) return true;
           * else return false;
           */
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
