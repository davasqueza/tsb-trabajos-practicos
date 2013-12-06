
import clases.ListaIndexada;
import clases.CP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CP.txt"));
        Scanner scIn = new Scanner(System.in);
        ListaIndexada<Integer,CP> listaCP = new ListaIndexada<Integer, CP>();
        int cant=0; 
        
        while (sc.hasNextLine()) {
            char p = sc.next().charAt(0);
            int c = sc.nextInt();
            String n = sc.nextLine();
            CP nuevo = new CP(p,c,n);
            listaCP.add(c,nuevo);
            cant++;
        }

        System.out.println(cant);
        while(scIn.hasNextInt()) {
            int c = scIn.nextInt();
            CP r = listaCP.search(c);
            System.out.println(r);
        }
    }
}
