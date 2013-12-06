
import clases.HashTable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Desafio5 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "D:\\Trabajo 2012\\UTN\\TSB\\Desafio5\\lote01.txt";
        Scanner sc=null;
        sc = new Scanner(new FileReader(fileName));
        
        HashTable t = new HashTable(100000);
        int v[] = new int[100000];
        
        int c = 0;
        
        while(sc.hasNextInt()) {
            int x = sc.nextInt();
            t.put(x,x);
            v[c++] = x;
        }
        
        int [] buscados = new int[] { 8017, 5347563, 1373, 7485216, 312, 1812378, 1787331, 27361, 2131373 };
        
        int i,j;
        for (j = 0; j < buscados.length; j++) {
            for (i = 0; i < v.length; i++) {
                if (t.contains(buscados[j]-v[i])) {
                    System.out.print("1");
                    break;
                }
            }
            if (i == v.length) System.out.print("0");
        }
   
    }
}
