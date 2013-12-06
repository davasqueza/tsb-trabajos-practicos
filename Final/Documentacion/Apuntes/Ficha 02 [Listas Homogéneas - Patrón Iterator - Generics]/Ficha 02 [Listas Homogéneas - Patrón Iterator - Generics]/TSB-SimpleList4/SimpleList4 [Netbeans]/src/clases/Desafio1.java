/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Desafio1 {
    
    public static void main(String []args) {
        
        for (int i = 1; i <= 10; i++) {
            Evaluador e = new Evaluador();
            
            e.lote = i;
            e.run();
            //Thread t = new Thread(e);
            //t.start();
        }
    }
}

class Evaluador implements Runnable {

    public int lote;
    public void run() {
        String fileName = "D:\\Trabajo 2012\\UTN\\TSB\\Desafio1\\lote" + lote + ".txt";
        Scanner sc=null;
        try {
            sc = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Evaluador.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleList l = new SimpleList();
        long contador = 0;
        //int cn = 0;
        //int valores[] = new int[150001];
        while (sc.hasNextInt()) {
            int numero = sc.nextInt();
            contador += l.addInOrder(numero);
            //valores[cn++] = numero;
        }
        sc.close();

        //for (int j = 0; j < cn; j++)
        //    contador += l.addInOrder(valores[j]);

        System.out.println(contador + "");
        l = null;
        System.gc();
    }
    
}
