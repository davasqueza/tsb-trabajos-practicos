/**
 * Contiene un main para indicar la forma de comenzar a trabajar con Colecciones predefinidas.
 * 
 * @author Ing. Valerio Frittelli
 * @version Junio de 2004
 */

import java.util.*;
public class Principal
{
      public static void main (String[] args)
      {
          // Probamos ahora con objetos TreeSet: conjuntos ordenados
          SortedSet s1, s2;  
          s1 = new TreeSet();  // La clase TreeSet implementa SortedSet
          s2 = new TreeSet();  // Un TreeSet es un conjunto ordenado, sin repetición de valores

           s1.add(new Persona("Juan", 21));
           s1.add(new Persona("Ana", 12));
           //s1.add(new Integer(34));
           s1.add(new Persona("Carlos", 34));
           s1.add(new Persona("Ana", 35)); // no lo va a insertar... ya hay uno con el mismo nombre
           s1.add(new Persona("Luis", 14));
           s1.add(new Persona("Maria", 16));
           s1.add(new Persona("Horacio", 35));

           s2.add(new Integer(45));
           s2.add(new Integer(12));
           s2.add(new Integer(70));
           s2.add(new Integer(33));
           s2.add(new Integer(12));
           s2.add(new Integer(55));
           s2.add(new Integer(54));
  
           System.out.println(" \n\nConjunto ordenado de personas");
           System.out.println(s1);
  
           System.out.println(" \n\nConjunto ordenado de números");
           System.out.println(s2);
  
           SortedSet start =  s1.headSet(new Persona("Horacio"));
           System.out.println("\n\nConjunto ordenado con los menores que una persona específica: ");
           System.out.println(start);
  
           SortedSet personas = s1.subSet(new Persona("Ana"), new Persona("Luis"));
           System.out.println("\n\nUn subconjunto ordenado: ");
           System.out.println(personas);
  
           Integer min = (Integer) s2.first();
           Integer max = (Integer) s2.last();
  
           System.out.println("\n\nUn conjunto ordenado de números");
           System.out.println("El menor es: " + s2.first());
           System.out.println("El mayor es: " + s2.last());
           
           // creamos un Vector
           Vector v = new Vector();
           v.add(new Persona("Valerio"));
           v.add(0, new Persona("Ana"));  // pedimos insertarlo en la posición cero del Vector
           v.add(new Persona("Fede"));
           v.add(new Persona("Conrado"));
           v.add(1, new Persona("Noemí")); // pedimos insertarlo en la posición 1
           //v.add(6, new Persona("Carlos")); // esto genera una IndexOutOfBoundsException: 
           System.out.println("Un vector de personas: ");
           System.out.println(v);
           Persona p = (Persona) v.get(3);  // para recuperar un objeto se usa get(), pero debemos moldear el resultado....
           System.out.println(p);
      } 
}



