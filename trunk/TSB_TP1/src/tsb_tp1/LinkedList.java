package tsb_tp1;

import java.util.NoSuchElementException;

public class LinkedList {
      private Node frente;
      private Node fondo;
      public LinkedList ()
      { 
          frente = null;
          fondo = null;
      }
     
      public void addFirst(Comparable x)
      {
            if ( x != null )
            {
               Node p = new Node(x, frente);
               frente = p;
            }
      }  
      
      public void clear( )
      {
         frente = null; // �alguna duda?
      }
      
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         return frente.getInfo();
      }
      
      public Comparable removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista est� vac�a...");
         
         Comparable x = frente.getInfo();
         frente = frente.getNext();
         return x;
      }
      
      public boolean contains (Comparable x)
      {
          if (x == null) return false;
           
          Node p = frente;
          while ( p != null && x.compareTo( p.getInfo() ) != 0 )
          {
                p = p.getNext();    
          }
          return ( p != null );
       
      }
     
    @Override
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

