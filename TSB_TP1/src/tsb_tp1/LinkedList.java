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
    if (frente==null)
    {
        frente = new Node(x,frente,frente);
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
    }
    
    public boolean add(Comparable element)
    {
        this.addLast(element);
        return true;
    }

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
      
    public void clear( )
    {
        frente = null;
        size = 0;
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
        while( p != null )
        {
            res = res + p.toString();
            if ( p.getNext() != null ) res = res + " - ";
            p = p.getNext();
        }
        res = res + " ]";
        return res;
    }
    
    private boolean esHomogeneo (Comparable x)
    {
        if ( x == null ) return false;
        if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
        return true;
    }
    
    public void addInOrder(Comparable x)
    {
        if (!esHomogeneo(x))
            System.out.println("No es homogeneo.");
        else{
            if (frente==null){
            this.addFirst(x);
            }
            else{
                Node actual=frente;
                do{
                     if(x.compareTo(actual.getInfo()) >= 0)
                     {
                        Node nuevo=new Node(x,actual,actual.getBack());
                        actual.getBack().setNext(nuevo);
                        actual.setBack(nuevo);
                        size++;
                     }
                actual=actual.getNext();
                }while (actual!=frente);
            }
        }
    }  
    
    public int size()
    {
        return size;
    }
    
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
            }
            size--;
            return actual.getInfo();
        }
        return null;
    }
    
    public void addLast(Comparable c)
    {
        Node actual=frente;
        if(c==null)
        {
            System.out.println("EL objeto que quiere ingresar esta vacio");
        }
        else
        {            
            Node e=new Node(c,actual,actual.getBack());
            actual.getBack().setNext(e);
            actual.setBack(e);
            size++;
            this.setIndexNodes();
        }   
        
    }
    
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
                         this.setIndexNodes();
                     }
                     size--;
                     return true;
                }
                actual=actual.getNext();
            }while(actual != frente);
        }
        return false;
    }
    
    public Comparable get(int index)
    {
        return this.getNode(index).getInfo();       
    }
    
    public Comparable getLast()
    {
        if(frente!=null)
        {
            return frente.getBack().getInfo();
        }
        return null;
    }
    
    public Comparable set(int index, Comparable element)
    {
        Comparable c=this.getNode(index).getInfo();
        if(c!=null)
        {
            this.getNode(index).setInfo(element);
        }
        return c;
    }
    
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
}
