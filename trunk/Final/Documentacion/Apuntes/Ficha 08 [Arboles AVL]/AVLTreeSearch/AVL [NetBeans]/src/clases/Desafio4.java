package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Desafio4 {
    public static void main(String[] args) throws FileNotFoundException {
        
        String fileName = "D:\\Trabajo 2012\\UTN\\TSB\\Desafio4\\lote01.txt";
        Scanner sc=null;
        sc = new Scanner(new FileReader(fileName));
        
        TreeSearch arbol1 = new TreeSearch();
        AVLTreeSearch arbol2 = new AVLTreeSearch();

        int c=0;
        while(sc.hasNextInt()) {
            int x = sc.nextInt();
            
            arbol1.add(x);
            arbol2.add(x);
            c++;
        }
        
        System.out.println(c);
        int [] buscados = new int[] {155, 2344, 7721, 14556, 27546, 38772, 53379, 73478, 93994, 105239, 122427, 134589, 156553, 173446, 186566, 198121, 203446, 213558, 235572, 248764};
        
        int ac1 = 0, ac2 = 0;
                
                
        for(int n: buscados) {
            ac1 += arbol1.searchCount(n);
            ac2 += arbol2.searchCount(n);
        }
        
        System.out.println(ac1);
        System.out.println(ac2);
        
        System.out.println(arbol1.height());
        System.out.println(arbol2.height());
    }
}
