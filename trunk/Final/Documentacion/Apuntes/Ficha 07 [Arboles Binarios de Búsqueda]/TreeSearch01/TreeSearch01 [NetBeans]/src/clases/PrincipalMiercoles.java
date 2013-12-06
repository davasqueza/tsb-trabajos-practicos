/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Iterator;

/**
 *
 * @author Diego
 */
public class PrincipalMiercoles {
    public static void main(String []args) {
        TreeSearch arbol = new TreeSearch();
        
        arbol.add(1);
        arbol.add(5);
        arbol.add(2);
        arbol.add(8);
        arbol.add(7);
        arbol.add(10);
        arbol.add(3);
        arbol.add(6);
        arbol.add(4);
        arbol.add(9);
        
        arbol.imprimir();

        System.out.println("Recorrido con iterator:");
        Iterator it = arbol.iterator();
        
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        
        System.out.println("Recorrido con iteratorDecreciente:");
        Iterator itD = arbol.iteratorDecreciente();
        
        while(itD.hasNext()) {
            System.out.println(itD.next());
        }

    }
}
