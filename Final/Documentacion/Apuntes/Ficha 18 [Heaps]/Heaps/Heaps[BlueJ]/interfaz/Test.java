package interfaz;

import estructuras.*;
public class Test
{
    public static void main(String args[])
    {
        Heap ah = new Heap(6, true);
        ah.add(8);
        ah.add(3);
        ah.add(7);
        ah.add(9);
        ah.add(4);
        ah.add(2);
        ah.add(1);
        System.out.println("Heap ascendente: " + ah);
        
        System.out.print("Mostramos en orden de extracción: \n[ ");
        while( ! ah.isEmpty() )
        {
            Comparable x = ah.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
        
        Heap dh = new Heap(6, false);
        dh.add(8);
        dh.add(3);
        dh.add(7);
        dh.add(9);
        dh.add(4);
        dh.add(2);
        dh.add(1);
        System.out.println("Heap descendente: " + dh);
        
        System.out.print("Mostramos en orden de extracción: \n[ ");
        while( ! dh.isEmpty() )
        {
            Comparable x = dh.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
    }
}
