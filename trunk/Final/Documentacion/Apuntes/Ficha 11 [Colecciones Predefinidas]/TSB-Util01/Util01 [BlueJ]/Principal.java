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
         /*
          * Comenzamos probando con un objeto de la clase HashSet: un conjunto implementado con tecnolog�a de tabla hash.
          * Notar la declaraci�n de la referencia set en base a la clase Set: esto logra mayor amplitud polim�rfica si luego se desea
          * cambiar el tipo de variable creada...
          */
         Set set = new HashSet();  // ver la jerarqu�a: HashSet es polim�rficamente abarcable por Set...
         
         /* 
          * Un conjunto es una colecci�n de valores que no mantiene ning�n orden, ni admite duplicados de valores: el �ltimo add no 
          * funcionar�, pues intenta insertar el 60 que ya pertenece al conjunto... (notar que no es lo mismo 60 que 60.0)
          */
         set.add(new Byte((byte)1));
         set.add(new Short((short) 2));
         set.add(new Integer(3));
         set.add(new Integer(4));
         set.add(new Float(5.0F));
         set.add(new Long(60)); 
         set.add(new Double(60.00));
         set.add(new Float(70.00));
         set.add(new Double(60));
         System.out.println("Primer conjunto: " + set);  // Invocamos al m�todo toString, que todo objeto del framework Collection redefine...
         
         
         Set set2 = new HashSet();
         set2.add(new Persona("Juan",23));
         set2.add(new Persona("Ana",24));
         set2.add(new Persona("Ana",34));  // ya hay una persona de nombre Ana...
         set2.add(new Persona("Pedro",24));
         System.out.println("Segundo conjunto: " + set2);
     }
} 
