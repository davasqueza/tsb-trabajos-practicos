/**
 * Una tabla hash genérica, con listas de desborde
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.io.*;
public class HashTable implements Serializable
{
   private SimpleList []items;
   private Class clase;   // la clase de objetos que contiene la tabla
   
   /**
    * Crea una tabla hash con tamaño 11 por defecto. El valor 11 es el primer número primo 
    * mayor a 10, y se eligió por su cercanía con el valor "típico" de 10...
    */
   public HashTable()
   {
      this(11);   
   }
   
   /**
    * Crea una tabla hash con tamaño n. Si n es cero o negativo, el tamaño se ajusta a 11. Este
    * constructor no controla si n es primo, ni busca el siguiente primo mayor a n...
    * @param n el tamaño de la tabla a crear.
    */
   public HashTable (int n)
   {
      if (n <= 0) { n = 11; }
      
      items = new SimpleList[n];
      for (int i=0; i<n; i++)
      {
          items[i] = new SimpleList();
      } 
   }
   
   /**
    * Inserta un objeto x en la tabla. La inserción sólo se lleva a cabo si x es de la misma
    * clase que los objetos que ya están en la tabla.
    * @param x el objeto a insertar.
    */
   public void put (Comparable x)
   {
      if( x != null )  
      {
          // capturamos la clase del primer objeto que entró en la tabla...
          if ( clase == null ) clase = x.getClass(); 
          
          // control de homogeneidad a nivel tabla...
          if( x.getClass() != clase ) return;
          
          // controlamos si es hora de redispersar...
          if ( averageLength() >= 3 ) rehash();
          
          // ahora si: primero tomamos el hashCode() del objeto...
          int k = x.hashCode();
          
          // ... luego dispersamos la clave...
          int y = h(k);
          
          // ... y finalmente pedimos a la lista que corresponda que haga la inserción
          items[y].addFirst(x);
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
    * Busca el objeto x en la tabla, y retorna la dirección del objeto que esté en la tabla 
    * y coincida con x, o null si x no existía en la tabla o no era de la misma clase que el 
    * contenido de la tabla.
    * @param x el objeto a buscar.
    * @return la dirección del objeto que coincide con x en la tabla, o null si no existía.
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
          return items[y].search(x);
     }
     return null;
   }
   
   /**
    * Comprueba si x está en la tabla y retorna true en ese caso, o retorna false si x no 
    * existe en la tabla o no es de la misma clase que el contenido de la tabla.
    * @param x el objeto a buscar.
    * @return true si x está en la tabla.
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
          return items[y].contains(x);
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
    *  Incrementa el tamaño de la tabla y reorganiza su contenido. Se invoca automáticamente
    *  cuando se detecta que el promedio de nodos por lista supera a cierto valor crítico
    *  (que en nuestra implementación de es de 3 nodos por lista, aunque sería aceptable 
    *  hasta unos 10 nodos por lista)
    */
   protected void rehash ()
   {
       // calculamos un aumento del 50% sobre el tamaño anterior... aunque no busco un número primo...
       int n = (int)(1.5 * items.length);
       
       // creamos un nuevo arreglo de listas, de ese tamaño...
       SimpleList temp[] = new SimpleList[n];
       for(int j = 0; j < temp.length; j++) temp[j] = new SimpleList();
       
       // recorremos la vieja tabla, para extraer uno a uno los objetos que contenía...
       for (int i = 0; i < items.length; i++)
       {
           // entramos en la lista número i, y la recorremos con el iterador...
           items[i].startIterator();
           while( items[i].hasNext() )
           {
               // obtenemos un objeto de la vieja lista...
               Comparable x = items[i].next();
               
               // obtenemos su nuevo valor de dispersión para el nuevo arreglo...
               int k = x.hashCode();
               int y = k % temp.length;
               
               // y lo insertamos en el nuevo arreglo, en la lista número "y"...
               temp[y].addFirst(x);
           }
       }
       
       // cambiamos la referencia items para que apunte a la nueva tabla...
       items = temp;
   }
    
   /**
    * Función hash. Toma el hashCode() de un objeto, y retorna un índice para entrar en 
    * el arreglo items.
    * @param k el valor hashCode del objeto a almacenar.
    * @return el índice para entrar en la tabla items.
    */
   private int h (int k)
   {
      return k % items.length;
   }
   
   /**
    * Calcula la longitud promedio de las listas de la tabla
    * @return la longitud promedio de la listas contenidas en la tabla.
    */
   private int averageLength()
   {
       int ac = 0;
       for(int i = 0; i < items.length; i++)
       {
            ac += items[i].size();    
       }
       return ac / items.length;
   }
}
