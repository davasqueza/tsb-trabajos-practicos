package tsb_tp1;

public class Node
{
   private Comparable info;
   private Node next, back;
   
   public Node ( )
   {
   }
   
   public Node (Comparable x, Node p)
   {
     info = x;
     next = p;
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
