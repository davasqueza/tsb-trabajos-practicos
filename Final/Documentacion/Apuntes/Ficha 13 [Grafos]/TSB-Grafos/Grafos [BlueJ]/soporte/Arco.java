package soporte;

/**
 *  Esta clase se usa para representar un arco en un grafo. Cada objeto de esta clase almacena un valor que ser� 
 *  el "peso" del arco (y que simplemente suponemos que es un valor num�rico) En implementaciones m�s detalladas,
 *  el peso de un arco puede ser definido en s� mismo como un objeto complejo.
 *  @author Ing. Valerio Frittelli
 *  @version Noviembre de 2009
 */

public class Arco 
{
   private int peso;
   private boolean existe;
   
   public Arco ( )
   {
   }
   
   public Arco ( int p )
   {
      peso = p;
      existe = true;
   }
   
   public int getPeso()
   {
      return peso;    
   }
   
   public void setPeso(int p)
   {
      peso = p;    
   }
   
   public boolean exists()
   {
       return existe;
   }
   
   public void set (boolean e)
   {
       existe = e;
   }
   public String toString()
   {
      return "Peso: " + peso;    
   }
}
