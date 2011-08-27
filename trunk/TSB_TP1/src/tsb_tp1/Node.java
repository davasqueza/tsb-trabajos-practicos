package tsb_tp1;

public class Node
{
   private Comparable info;
   private Node next, back;
   private int index;
   
   public Node ( Comparable x )
   {
       info=x;
   }
   
   public Node (Comparable x, Node p, Node s)
   {
     info = x;
     next = p;
     back = s;
   }
   
   public Node getNext()
   {
     return next;
   }
   
   public void setNext(Node p)
   {
     next = p;
   }
   
   public Node getBack()
   {
     return back;
   }
   
   public void setBack(Node p)
   {
     back = p;
   }
   
   public int getIndex()
   {
       return index;
   }
   
   public void setIndex(int i)
   {
       index=i;
   }
   
   public Comparable getInfo()
   {
     return info;
   }
   
   public void setInfo(Comparable p)
   {
     info = p;
   }

    @Override
   public String toString()
   {
     return info.toString();   
   }
}

