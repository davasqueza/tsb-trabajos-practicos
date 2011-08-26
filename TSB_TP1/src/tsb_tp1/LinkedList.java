package tsb_tp1;



public class LinkedList {
      private Node frente;
      

      public LinkedList ()
      { 
          frente = null;
      }
     
         public void addFirst(Comparable x) {
      if (x==null) {
         frente = new Node(x,frente,frente);
      }
      else {
      	 Node actual = frente;
      	 while(actual.getNext() != frente) {
      	 	actual = actual.getNext();
      	 }
      	 Node ultimoNodo = actual;
         Node desplazado = frente;
         frente = new Node(x,desplazado,ultimoNodo);
         ultimoNodo.setNext(frente);
      	 desplazado.setBack(frente);
      }
   }
      
      public void clear( )
      {
         frente = null;
      }
      
      public Comparable getFirst()
      {
         if (frente != null)
         return frente.getInfo();
         else return null;
      }
      
      public Comparable removeFirst()
      {
         if(frente==null)
             return null;
         else if (frente.getNext()==frente)
         {
             Node removido = frente;
             frente = null;
             return removido.getInfo();
         }
            else
            {
                Node removido = frente;
                frente=frente.getNext();
                frente.setBack(removido.getBack());
                removido.getBack().setNext(frente);
                return removido.getInfo();
            }
         
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

