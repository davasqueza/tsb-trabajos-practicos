package clases;

/**
 * Una tabla hash gen�rica, con listas de desborde
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.io.*;
public class HashTable implements Serializable
{
   private SimpleList []items;
   private Class clase;   // la clase de objetos que contiene la tabla
   private int cant;
   
   /**
    * Crea una tabla hash con tama�o 11 por defecto. El valor 11 es el primer n�mero primo 
    * mayor a 10, y se eligi� por su cercan�a con el valor "t�pico" de 10...
    */
   public HashTable()
   {
      this(11);   
      cant = 0;
   }
   
   /**
    * Crea una tabla hash con tama�o n. Si n es cero o negativo, el tama�o se ajusta a 11. Este
    * constructor no controla si n es primo, ni busca el siguiente primo mayor a n...
    * @param n el tama�o de la tabla a crear.
    */
   public HashTable (int n)
   {
      if (n <= 0) { n = 11; }
      
      items = new SimpleList[n];
      for (int i=0; i<n; i++)
      {
          items[i] = new SimpleList();
      } 
      cant = 0;
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
          if ( averageLength() >= 30 ) rehash();
          
          // ahora si: primero tomamos el hashCode() del objeto...
          int k = x.hashCode();
          
          // ... luego dispersamos la clave...
          int y = h(k);
          
          // ... y finalmente pedimos a la lista que corresponda que haga la inserci�n
          items[y].addFirst(x);
          cant++;
      }
   }

   /**
    * Inserta un objeto x en la tabla. La inserci�n s�lo se lleva a cabo si x es de la misma
    * clase que los objetos que ya est�n en la tabla.
    * @param x el objeto a insertar.
    */
   public void put (Comparable c, Comparable v)
   {
      if( c != null && v != null )  
      {
          // capturamos la clase del primer objeto que entr� en la tabla...
          if ( clase == null ) clase = v.getClass(); 
          
          // control de homogeneidad a nivel tabla...
          if( v.getClass() != clase ) return;
          
          // controlamos si es hora de redispersar...
          if ( averageLength() >= 30 ) rehash();
          
          // ahora si: primero tomamos el hashCode() del objeto...
          int k = c.hashCode();
          
          // ... luego dispersamos la clave...
          int y = h(k);
          
          // ... y finalmente pedimos a la lista que corresponda que haga la inserci�n
          items[y].addFirst(new Pair(c,v));
          cant++;
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
          items[y].remove(x);
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

          int k = x.hashCode();
          int y = h(k);
          return items[y].search(new Pair(x, null));
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
      // si no hay nada en la tabla, sale sin hacer nada...
      if ( clase == null )  return false;
      
      if( x != null )  
      {
          // control de homogeneidad a nivel tabla...
          if( x.getClass() != clase ) return false;

          int k = x.hashCode();
          int y = h(k);
          return items[y].contains(new Pair(x, null));
     }
     return false;
   }
   
   
   
   /**
    * Devuelve el contenido de la tabla en forma de String.
    * @return un String con el contenido de la tabla.
    */
   public String toString()
   {
      StringBuffer cad = new StringBuffer("");
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
       
       // creamos un nuevo arreglo de listas, de ese tama�o...
       SimpleList temp[] = new SimpleList[n];
       for(int j = 0; j < temp.length; j++) temp[j] = new SimpleList();
       
       // recorremos la vieja tabla, para extraer uno a uno los objetos que conten�a...
       for (int i = 0; i < items.length; i++)
       {
           // entramos en la lista n�mero i, y la recorremos con el iterador...
           items[i].startIterator();
           while( items[i].hasNext() )
           {
               // obtenemos un objeto de la vieja lista...
               Comparable x = items[i].next();
               
               // obtenemos su nuevo valor de dispersi�n para el nuevo arreglo...
               int k = x.hashCode();
               int y = k % temp.length;
               
               // y lo insertamos en el nuevo arreglo, en la lista n�mero "y"...
               temp[y].addFirst(x);
           }
       }
       
       // cambiamos la referencia items para que apunte a la nueva tabla...
       items = temp;
   }
    
   /**
    * Funci�n hash. Toma el hashCode() de un objeto, y retorna un �ndice para entrar en 
    * el arreglo items.
    * @param k el valor hashCode del objeto a almacenar.
    * @return el �ndice para entrar en la tabla items.
    */
   private int h (int k)
   {
      return Math.abs(k) % items.length;
   }
   
   /**
    * Calcula la longitud promedio de las listas de la tabla
    * @return la longitud promedio de la listas contenidas en la tabla.
    */
   private int averageLength()
   {
       return cant / items.length;
   }
}
