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
        if(!esHomogeneo(x))
            System.out.println("No es homogeneo.");
        else{
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
                            break;
                        }
                    actual=actual.getNext();
                    }
                    }
                }
        }
          
    }

      
    public void setIndexNodes()
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
            Node actual=frente;
            while (actual != null && x.compareTo(actual.getInfo()) >= 0)
            {
               actual=actual.getNext();
            }
            Node nuevo=new Node(x,actual,actual.getBack());
            actual.getBack().setNext(nuevo);
            actual.setBack(nuevo);
        }
    }  
    
    
    
}
