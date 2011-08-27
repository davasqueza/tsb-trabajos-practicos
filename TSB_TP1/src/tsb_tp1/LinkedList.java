package tsb_tp1;



public class LinkedList {
      private Node frente;
      private int size;

      public LinkedList ()
      { 
          frente = null;
      }
      

      public void addFirst(Comparable x)
      {
      if (frente==null) {
         frente = new Node(x,frente,frente);
         size++;
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
             size++;
           }
      }
      
      
      /*                   Este metodo no haria falta, le hice atributo size y cada vez que agrego o saco un nodo le sumo o resto uno.
      public int size()
      {
          int contador=0;
          if (frente!=null)
          {
             Node actual = frente;
             contador=1;
             while(actual.getNext() != frente) {
                    actual = actual.getNext();
                    contador++;
        	 }
          }
          return contador;
      }
      */
      
      
    /*     public void add (int index, Comparable element)
      {
          if(this.size()>=index && index>-1)
          {
              if (index==0) {
                this.addFirst(element);
              }
              else {
           Node actual = frente;
              int indice=0;
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
          
      }*/
      
      
                             
      public int getIndex(Node n) {
        int index = -1;
        if (frente!=null)
        {
            index=0;
            if (frente!=n)
            {
                Node actual=frente;
                while(actual.getNext() != frente) {
                    if(actual==n)
                    {
                        break;
                    }
                    actual = actual.getNext();
                    index++;
        	 }
                if(actual!=n)
                {
                    index=-1;
                }
            }
        }
        return index;
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
             size--;
             return removido.getInfo();
         }
            else
            {
                Node removido = frente;
                frente=frente.getNext();
                frente.setBack(removido.getBack());
                removido.getBack().setNext(frente);
                size--;
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



/*
//Method Summary
 
//       Inserts the specified element at the specified position in this list.
 boolean 	add(Object o)
     //     Appends the specified element to the end of this list.
 boolean 	addAll(Collection c)
     //     Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
 boolean 	addAll(int index, Collection c)
     //     Inserts all of the elements in the specified collection into this list, starting at the specified position.
 void 	addFirst(Object o)
     //     Inserts the given element at the beginning of this list.
 void 	addLast(Object o)
     //     Appends the given element to the end of this list.
 void 	clear()
     //     Removes all of the elements from this list.
 Object 	clone()
     //     Returns a shallow copy of this LinkedList.
 boolean 	contains(Object o)
     //     Returns true if this list contains the specified element.
 Object 	get(int index)
     //     Returns the element at the specified position in this list.
 Object 	getFirst()
     //     Returns the first element in this list.
 Object 	getLast()
     //     Returns the last element in this list.
 int 	indexOf(Object o)
     //     Returns the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.
 int 	lastIndexOf(Object o)
     //     Returns the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
 ListIterator 	listIterator(int index)
     //     Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
 Object 	remove(int index)
     //     Removes the element at the specified position in this list.
 boolean 	remove(Object o)
     //     Removes the first occurrence of the specified element in this list.
 Object 	removeFirst()
     //     Removes and returns the first element from this list.
 Object 	removeLast()
     //     Removes and returns the last element from this list.
 Object 	set(int index, Object element)
     //     Replaces the element at the specified position in this list with the specified element.
 
     //     Returns the number of elements in this list.
 Object[] 	toArray()
     //     Returns an array containing all of the elements in this list in the correct order.
 Object[] 	toArray(Object[] a)
     //     Returns an array containing all of the elements in this list in the correct order; the runtime type of the returned array is that of the specified array.
 */