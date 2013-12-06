/**
 * Contiene un main para indicar la forma de comenzar a trabajar con Colecciones predefinidas.
 * 
 * @author Ing. Valerio Frittelli
 * @version Junio de 2004
 */
import java.util.*;
public class Principal
{
     public static void main(String[] args)
     {
         // mostramos un objeto de la clase ArrayList
         List list = new ArrayList(); // admite duplicados y preserva el orden de inserción
         
         list.add(new Byte((byte)1));
         list.add(new Short((short) 2));
         list.add(new Integer(3));
         list.add(new Integer(4));
         list.add(new Float(5.0F));
         list.add(new Long(60)); 
         list.add(new Double(60.00));
         list.add(new Float(70.00));
         list.add(new Double(60));
         System.out.println("Una lista de números: ");
         System.out.println(list);
         
         // Ahora un objeto de tipo LinkedList
         LinkedList personas = new LinkedList();
         
         personas.add(new Persona("Juan"));
         personas.add(new Persona("Pedro"));
         personas.add(new Persona("Roberto"));
         personas.add(new Persona("Ana"));
         personas.add(new Persona("Carlos"));
  
         System.out.println("\n\nUna lista de personas");
         System.out.println(personas);
  
         System.out.println("\n\n Agregamos personas");

         //Obtenemos un objeto iterador para recorrer la lista. El iterador comienza apuntando al principio de la lista
         ListIterator personasI = personas.listIterator();
         
         // si queremos añadir objetos pero no al final de la lista, se usa el iterador para insertar en la posición actual
         personasI.add(new Persona("Maria"));
         personasI.next();  // avanzamos en la lista
         personasI.next();
         personasI.add(new Persona("Daniel"));
         personasI.next();
         personasI.set(personas.getLast());  // obtiene el último de la lista y lo añade en la posición actual
         personasI.add(new Persona("Guille"));
  
         personasI.next();
         personasI.add(new Persona("Ernesto"));
         personasI.next();
         personasI.add(new Persona("Marco"));
         personasI.previous();  // volvemos ahora un par de posiciones hacia atrás
         personasI.previous();
         personasI.add(new Persona("José"));
         System.out.println("\n\nAsí quedó la lista");
         System.out.println(personas);
         
         Iterator li2 = personas.iterator();
         // vamos hasta el sexto elemento...
         for(int i = 1; i<=6; i++)
         {
            li2.next();
         }   
         // y mostramos el séptimo
         Persona x = (Persona) li2.next();  // esto puede dar una exception de la clase "NoSuchElementException" si nos pasamos de largo..
         System.out.println("Persona elegida: " + x);
         li2.remove(); // eliminamos ese objeto de la estructura
         System.out.println("\n\nAsí quedó la lista");
         System.out.println(personas);
         
         // volvemos a inicializar el iterador, para ir hasta la quinta persona
         li2 = personas.iterator();
         for(int j = 1; j<=4 ; j++)
         {
            li2.next();   
         }
         x = (Persona)li2.next();
         System.out.println("Otra persona elegida: " + x);
         
         Collections.sort(personas);  // ordenamos la lista
         System.out.println("\n\nAsí quedó la lista ordenada");
         System.out.println(personas);
         
         Collections.reverse(personas);  // ordenamos la lista al revés
         System.out.println("\n\nAsí quedó la lista ordenada al revés");
         System.out.println(personas);
         
         Collections.shuffle(personas);  // y acá la mezclamos...
         System.out.println("\n\nAsí quedó la lista mezclada");
         System.out.println(personas);
         
         
     }
}

