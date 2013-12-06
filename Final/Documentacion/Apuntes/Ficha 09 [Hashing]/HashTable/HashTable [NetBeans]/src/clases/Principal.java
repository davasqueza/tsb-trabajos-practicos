package clases;

/**
  Clase principal para contener el main
  @author Ing. Valerio Frittelli
  @version 2.0 - Octubre de 2005
*/  
public class Principal
{
    public static void main (String[] args)
    {
        int n, op;
        String pal, sig;
        Termino ter;
        HashTable t = new HashTable(2);       
        do
        {
            System.out.println ("Opciones de Manejo de un Diccionario [usa Tabla Hash]");
            System.out.println ("1. Insertar una palabra");
            System.out.println ("2. Buscar y mostrar una palabra");
            System.out.println ("3. Mostrar todo el diccionario");
            System.out.println ("4. Salir");
            System.out.print ("Ingrese opcion: ");
            op = Consola.readInt();
            switch (op)
            {
            case 1: 
                 System.out.print("Ingrese una palabra: ");
                 pal = Consola.readLine();
                 System.out.print("Ingrese el significado: ");
                 sig = Consola.readLine();
                 ter = new Termino(pal, sig);
                 t.put(ter);
                 System.out.print("\nPalabra agregada...");
                 break;   
    
            case 2:  
                 System.out.print("Ingrese la palabra a buscar: ");
                 pal = Consola.readLine();
                 ter = new Termino(pal);
                 Termino t2 = (Termino) t.get(ter);
                 if (t2 != null)
                 {  System.out.println("Encontrada... ");
                    System.out.println("Palabra:     " + t2.getPalabra());
                    System.out.println("Significado: " + t2.getSignificado());
                 }
                 else System.out.print("\nNo encontrada...");
                 break;
    
            case 3:
                 System.out.println(t.toString());
                 System.out.print("\n...Pulse una tecla");
                 break;
            
            case 4: ;
            }
         }
         while (op != 4);
    }
} 
