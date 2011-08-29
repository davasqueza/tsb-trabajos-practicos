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
            Node actual = frente;
            Node ultimoNodo = actual.getBack();
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
        if(size>=index && index>-1)
        {
            if (index==0) {
                this.addFirst(element);
            }
            else{
                if(!esHomogeneo(element))
                    System.out.println("No es homogeneo.");
                else{
                    this.setIndexNodes();
                    Node actual = frente;
                    while(actual.getNext() != frente)
                    {
                        if(index==actual.getIndex())
                        {
                            Node e=new Node(element,actual,actual.getBack());
                            actual.getBack().setNext(e);
                            actual.setBack(e);
                            size++;
                            this.setIndexNodes();
                            break;
                        }
                    actual=actual.getNext();
                    }
                    }
                }
        }
          
    }

      
    private void setIndexNodes()
    {
        Node actual = frente;
        int i=0;
        while(actual.getNext() != frente)
        {
            actual.setIndex(i);
            i++;
            actual = actual.getNext();
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
            frente = new Node(x,frente,frente);
            size++;
            }
            else{
                Node actual=frente;
                while (actual != null && x.compareTo(actual.getInfo()) >= 0)
                {
                actual=actual.getNext();
                }
                Node nuevo=new Node(x,actual,actual.getBack());
                actual.getBack().setNext(nuevo);
                actual.setBack(nuevo);
                size++;
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
        if(frente!=null)
        {
            if(index==0)
            {
                return frente;
            }
            else
            {
                 Node actual = frente;
                 while(actual.getNext() != frente)
                 {
                 if(index==actual.getIndex())
                 {
                       return actual;
                 }
                 actual=actual.getNext();
               }
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
                this.setIndexNodes();
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
            }while(actual.getNext() != frente);
        }
        return false;
    }
    
}
