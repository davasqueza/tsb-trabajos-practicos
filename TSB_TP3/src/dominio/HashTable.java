package dominio;

/**
 * Una tabla hash gen�rica, con listas de desborde
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.io.*;
public class HashTable implements Serializable
{
   private Comparable  items[];
   private Class clase;   // la clase de objetos que contiene la tabla
   
   
   public HashTable ()
   {
      items = new Comparable[11];
   }
   
   public HashTable (int n)
   {
      items = new Comparable[n];
   }
   
   /**
    * Inserta un objeto x en la tabla. La inserci�n s�lo se lleva a cabo si x es de la misma
    * clase que los objetos que ya est�n en la tabla.
    * @param x el objeto a insertar.
    */
   public void put (Comparable x)
   {
      if( x != null )  
      {
          // capturamos la clase del primer objeto que entr� en la tabla...
          if ( clase == null ) clase = x.getClass(); 
          
          // control de homogeneidad a nivel tabla...
          if( x.getClass() != clase ) return;
          
          // controlamos si es hora de redispersar...
          if (arregloDemasiadoLleno()) rehash();
          
          // ahora si: primero tomamos el hashCode() del objeto...
          int k = x.hashCode();
          
          // ... luego dispersamos la clave...
          int y = h(k);
          
          // ... y finalmente pedimos a la lista que corresponda que haga la inserci�n
          y=verificarInsercion(y);
          items[y]=x;
          
      }
   }

   private int verificarInsercion(int n)
   {
       if(items.length>n)
       {
           if(items[n]==null)
              return n;
           else{
              return verificarInsercion(n+1);
            }
       }
       else{
           return verificarInsercion(0);
       }
   }
   /**
    * Elimina el objeto x de la tabla. No hace nada si x no es de la misma clase que los
    * objetos que ya estaban en la tabla, o si x no estaba en la tabla.
    * @param x el objeto a eliminar.
    */
   public void remove (Comparable x)
   {
      // si no hay nada en la tabla, sale sin hacer nada...
      if ( clase == null )  return;
      
      if( x != null )  
      {
          // control de homogeneidad a nivel tabla...
          if( x.getClass() != clase ) return;
          
          int k = x.hashCode();
          int y = h(k);
          
          int r=verificarItem(y,x, false,y);
          if(r>-1)
            items[r]=null;
      }
   }   
   
    private int verificarItem(int n, Comparable x, boolean ban, int limite)
   {
       if(items.length>n)
       {
           if(items[n]!=null&&x.compareTo(items[n])==0)
              return n;
           else{
              if(ban&&n==limite)
                return -1;
              else
                return verificarItem(n+1, x, ban, limite);
            }
       }
       else{
           return verificarItem(0, x, true, limite);
       }
   }
   
   /**
    * Busca el objeto x en la tabla, y retorna la direcci�n del objeto que est� en la tabla 
    * y coincida con x, o null si x no exist�a en la tabla o no era de la misma clase que el 
    * contenido de la tabla.
    * @param x el objeto a buscar.
    * @return la direcci�n del objeto que coincide con x en la tabla, o null si no exist�a.
    */
   public Comparable get (Comparable x)
   {
      // si no hay nada en la tabla, sale sin hacer nada...
      if ( clase == null )  return null;
      
      if( x != null )  
      {
          // control de homogeneidad a nivel tabla...
          if( x.getClass() != clase ) return null;

          int k = x.hashCode();
          int y = h(k);
          int r=verificarItem(y,x, false,y);
          if(r>-1)
            return items[r];
     }
     return null;
   }
   
   /**
    * Comprueba si x est� en la tabla y retorna true en ese caso, o retorna false si x no 
    * existe en la tabla o no es de la misma clase que el contenido de la tabla.
    * @param x el objeto a buscar.
    * @return true si x est� en la tabla.
    */
   public boolean contains (Comparable x)
   {
      if(get(x)!=null)
          return true;
      return false;
   }

   
   /**
    * Devuelve el contenido de la tabla en forma de String.
    * @return un String con el contenido de la tabla.
    */
    @Override
   public String toString()
   {
      StringBuilder cad = new StringBuilder("");
      for (int i = 0; i < items.length; i++)
      {
        cad.append("\nLista " + i + ":\n\t" + items[i].toString());   
      }
      return cad.toString();
   }

   /**
    *  Incrementa el tama�o de la tabla y reorganiza su contenido. Se invoca autom�ticamente
    *  cuando se detecta que el promedio de nodos por lista supera a cierto valor cr�tico
    *  (que en nuestra implementaci�n de es de 3 nodos por lista, aunque ser�a aceptable 
    *  hasta unos 10 nodos por lista)
    */
   protected void rehash ()
   {
       // calculamos un aumento del 50% sobre el tama�o anterior... aunque no busco un n�mero primo...
       int n = (int)(1.5 * items.length);
       
       // creamos un nuevo arreglo de comparables, de ese tama�o...
       HashTable aux = new HashTable(n);
              
       // recorremos la vieja tabla, para extraer uno a uno los objetos que conten�a...
       for (int i = 0; i < items.length; i++)
       {
           
            aux.put(items[i]); 
       }
              
       // cambiamos la referencia items para que apunte a la nueva tabla...
       this.items = aux.items;
   }
    
   /**
    * Funci�n hash. Toma el hashCode() de un objeto, y retorna un �ndice para entrar en 
    * el arreglo items.
    * @param k el valor hashCode del objeto a almacenar.
    * @return el �ndice para entrar en la tabla items.
    */
   private int h (int k)
   {
      return k % items.length;
   }
   
   /**
    * Calcula el nivel de ocupacion del vector
    * @return true si hay lugares ocupados que vacios
    */
   private boolean arregloDemasiadoLleno()
   {
       int ocupado = 0;
       int vacio = 0;
       for(int i = 0; i < items.length; i++)
       {
           if(items[i]!=null) 
               ocupado++;
           else
               vacio++;
       }
       if(ocupado>vacio)
            return true;
       else
           return false;
   }
}
