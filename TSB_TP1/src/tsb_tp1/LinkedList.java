package tsb_tp1;


public class LinkedList {
    private Node frente;
    private int size;
    
    /**
     * Contructor de la Linked List.
     */
    public LinkedList ()
    { 
        frente = null;
    }
    
    /**
     * Agrega un Comparable al principio de la lista. 
     */
    public void addFirst(Comparable x)
    {
        Node nuevo=new Node(x);
        if (frente==null)
        {
            frente=nuevo;
            nuevo.setNext(frente);
            nuevo.setBack(frente);
            size++;
        }
        else 
        {
            if(!esHomogeneo(x))
                System.out.println("No es homogeneo.");
            else
            {
                Node ultimoNodo = frente.getBack();
                Node desplazado = frente;
                frente = new Node(x,desplazado,ultimoNodo);
                ultimoNodo.setNext(frente);
                desplazado.setBack(frente);
                size++;
            }
        }
        
    }
      
    /**
     * Agrega un Comparable en una posicion contemplada por la lista.
     */
    public void add (int index, Comparable element)
    {
        if(this.getNode(index)!=null)
        {
            if (index==0) {
                this.addFirst(element);
            }
            else{
                if(!esHomogeneo(element))
                    System.out.println("No es homogeneo.");
                else{
                    Node actual = frente;
                    do{
                        if(index==actual.getIndex())
                        {
                            Node e=new Node(element,actual,actual.getBack());
                            actual.getBack().setNext(e);
                            actual.setBack(e);
                            size++;
                            break;
                        }
                        actual=actual.getNext();
                    }while(actual!=frente);
                    }
                }
        }
        else
            System.out.println("Out of Index.");
    }
    
    /**
     * Agrega un Comparable al final de la lista retornando un booleano.
     */
    
    public boolean add(Comparable element)
    {
        this.addLast(element);
        return true;
    }

    /**
     * Asigna los indices correspondientes a los nodos de la lista.
     */
    private void setIndexNodes()
    {
        Node actual = frente;
        int i=0;
        do
        {
            actual.setIndex(i);
            i++;
            actual = actual.getNext();
        }while(actual != frente);
    }
      
    /**
     * Borra la lista.
     */
    public void clear( )
    {
        frente = null;
        size = 0;
    }
      
    /**
     * Retorna el primer Comparable de la lista.
     */
    public Comparable getFirst()
    {
        if (frente != null)
        return frente.getInfo();
        else return null;
    }
      
    /**
     * Remueve el ultimo Comparable de la lista retornando su info.
     */
    public Comparable removeFirst()
    {
        if(frente==null)
            return null;
        else if (frente.getNext()==frente)
        {
            Node removido = frente;
            this.clear();
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
      
    /**
     * Verifica si la lista contiene el Comparable pasado por Parametro.
     */
    public boolean contains (Comparable x)
    {
        if (x == null) 
            return false;
        Node actual = frente;
        do{
            if(x.compareTo(actual.getInfo()) == 0) 
                return true;
            actual=actual.getNext();
        }while(actual!=frente);
        return false;
    }
     
    @Override
    public String toString()
    {
        Node p = frente;
        String res = "[ ";
        do{
            res = res + p.toString();
            if ( p.getNext() != null ) res = res + " -\n- ";
            p = p.getNext();
        }while( p != frente );
        res = res + " ]";
        return res;
    }
    
    /**
     * Verifica si el Comparable ingresado por parametro es de la misma clase
     * que el de la lista.
     */
    private boolean esHomogeneo (Comparable x)
    {
        if ( x == null ) return false;
        if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
        return true;
    }
    
    /*
     * Agrega a la lista un Comparable ordenado segun el critero del compareTo()
     * redefinido.
     */
    public void addInOrder(Comparable x)
    {
        if (!esHomogeneo(x))
            System.out.println("No es homogeneo.");
        else{
                this.addFirst(x);
                this.ordenarLista();
            }
    }  
    
    /**
     * Retorna el tamaño de la lista. 
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Remueve el ultimo elemento de la lista.
     */
    public Comparable removeLast()
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
            Node removido = frente.getBack();
            frente.setBack(removido.getBack());
            removido.getBack().setNext(frente);
            size--;
            return removido.getInfo();
        }
    }
    
    /*
     * Retorna el nodo ubicado en la posicion indicada por parametro.
     */
    public Node getNode(int index)
    {
        this.setIndexNodes();
        if(frente!=null)
        {
            if(index==0)
            {
                return frente;
            }
            else
            {
                Node actual = frente;
                do
                {
                if(index==actual.getIndex())
                {
                    return actual;
                }
                actual=actual.getNext();
               }while(actual != frente);
           }
        }
        return null;
    }
    
    /**
     * Remueve el nodo ubicado en la posicion indicada por parametro.
     */
    public Comparable remove(int index)
    {
        if(this.getNode(index)!=null)
        {
            Node actual=this.getNode(index);
            if(actual==frente&&frente.getNext()==frente)
            {
                frente=null;
                
            }
            else{
                actual.getBack().setNext(actual.getNext());
                actual.getNext().setBack(actual.getBack());
                if(index==0)
                {
                frente=actual.getNext();
                }
            }
            size--;
            return actual.getInfo();
        }
        return null;
    }
    
    /**
     * Agrega un Comparable al final de la lista.
     */
    
    public void addLast(Comparable c)
    {
        Node actual=frente;
        if(c==null)
        {
            System.out.println("EL objeto que quiere ingresar esta vacio");
        }
        else {
            if (!esHomogeneo(c))
                System.out.println("No es homogeneo.");
            else{
                if(actual==null)
                    this.addFirst(c);
                else
                {
                    Node e=new Node(c,actual,actual.getBack());
                    actual.getBack().setNext(e);
                    actual.setBack(e);
                    size++;
                }
            }
        }   
        
    }
    
    /**
     * Agrega una Lista al final de la lista.
     */
    
    public void addLinkedList(LinkedList l)
    {
        Node actual=frente;
        Node ultimo=l.frente.getBack();
        if(l==null||l.frente==null)
        {
            System.out.println("EL objeto que quiere ingresar esta vacio");
        }
        else {
            if (!esHomogeneo(l.getFirst()))
                System.out.println("No es homogeneo.");
            else{
                if(actual==null)
                    this.frente=l.frente;
                else
                {
                    actual.getBack().setNext(l.frente);
                    l.frente.setBack(actual.getBack());
                    actual.setBack(ultimo);
                    ultimo.setNext(this.frente);
                    
                    size+=l.size;
                }
            }
        }   
        
    }
    
    /**
     * Remueve el nodo que contiene el Comparable indicado por parametro.
     */
    public boolean remove(Comparable c)
    {
        if(c!=null&&frente!=null)
        {
            Node actual=frente;
            do
            {
                if(actual.getInfo().compareTo(c)==0)
                {
                     if(actual==frente&&frente.getNext()==frente)
                     {
                         frente=null;
                
                     }
                     else{
                         actual.getBack().setNext(actual.getNext());
                         actual.getNext().setBack(actual.getBack());
                     }
                     size--;
                     return true;
                }
                actual=actual.getNext();
            }while(actual != frente);
        }
        return false;
    }
    
    /**
     * Retorna la info del nodo en la posicion indicada por parametro.
     */
    public Comparable get(int index)
    {
        return this.getNode(index).getInfo();       
    }
    
    /**
     * Retorna la info del ultimo nodo de la lista.
     */
    public Comparable getLast()
    {
        if(frente!=null)
        {
            return frente.getBack().getInfo();
        }
        return null;
    }
    
    /**
     * Asigna la info indicada por parametro a la posicion de la lista determinada
     * por parametro.
     */
    public Comparable set(int index, Comparable element)
    {
        Comparable c=this.getNode(index).getInfo();
        if(c!=null)
        {
            this.getNode(index).setInfo(element);
        }
        return c;
    }
    
    /**
     * Retorna el indice de la ultima ocurrencia del Comparable indicado por parametro.
     */
    public int lastIndexOf(Comparable c)
    {
        this.setIndexNodes();
        if(frente!=null)
        {
            Node actual=frente;
            if(actual.getBack()!=frente)
            {
               do{
                if(actual.getInfo().compareTo(c)==0)
                {
                    return actual.getIndex();
                }
                actual=actual.getBack();
                }while(actual!=frente);
            }
            else
            {
                if(actual.getInfo().compareTo(c)==0)
                {
                    return actual.getIndex();
                }
            }                      
        }
        return -1;
    }
    
    /**
     * Retorna el indice de la primer ocurrencia del Comparable indicado por parametro.
     */
    public int indexOf(Comparable element)
    {
        this.setIndexNodes();
        if(element!=null&&frente!=null)
        {
            Node actual=frente;
            do
            {
                if(actual.getInfo().compareTo(element)==0)
                {
                     return actual.getIndex();
                }
                actual=actual.getNext();
            }while(actual != frente);
        }
        return -1;
    }
    
    /**
     * Devuelve los elementos contenidos en la lista en una estructura Array.
     */
    public Object[] toArray(){
    	Object[] salida=new Object[this.size];
    	Node puntero=this.frente;
    	if(puntero!=null)
        {
            for(int i=0;i<salida.length;i++)
            {    		
    		salida[i]=(Object)puntero.getInfo();
    		if(i!=salida.length)
                    puntero=puntero.getNext();
            }
    	}
    	return salida;
    }

    private void ordenarLista() {
       
      boolean ordenado = false;
      int i , j , n = size;
      Comparable aux;
      for (i=0;  i < n - 1  &&  !ordenado;  i++)
      {
            ordenado = true;
            for ( j=0;  j < n - i - 1;  j++ )
            {
                 if (this.getNode(j).getInfo().compareTo(this.getNode(j+1).getInfo()) > 0)
                 {
                       ordenado = false;
                       aux = this.getNode(j).getInfo();
                       this.getNode(j).setInfo(this.getNode(j+1).getInfo());
                       this.getNode(j+1).setInfo(aux);
                 }
            }
      }
    }
}