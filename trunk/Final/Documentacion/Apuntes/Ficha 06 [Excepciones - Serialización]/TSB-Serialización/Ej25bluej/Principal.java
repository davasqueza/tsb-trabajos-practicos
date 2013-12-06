/**
 *  Incluye un main para probar la forma de grabar y levantar objetos directamente desde un stream.
 *  @author Ing. Valerio Frittelli
 *  @version Junio de 2004
 */
import java.io.*;
import java.util.*;
public class Principal
{
   private static SimpleList sl;

   /**
    *  Graba un objeto de tipo Listado en disco
    *  @throws FileNotFoundException - IOException si el archivo no puede abrirse
    */
   static public void grabar() 
   {
       sl = new SimpleList();
       Persona a,b,c;
       a = new Persona("Juan", 20);
       b = new Persona("Luis", 30);
       c = new Persona("Ana", 40);
       sl.addFirst(a);
       sl.addFirst(b);
       sl.addFirst(c);
       System.out.println(sl);
       
       try
       {
           SimpleListWriter slw = new SimpleListWriter();
           slw.write( sl );
       }
       catch(SimpleListIOException e)
       {
            System.out.println("Error: " + e.getMessage());    
       }
   }

   /**
    *  Lee un objeto de tipo Listado desde disco
    *  @throws FileNotFoundException - IOException si el archivo no puede abrirse
    *  @throws ClassNotFoundException si hay un error de moldeo al levantar el objeto
    */
   static public void leer()
   {
       try
       {
           SimpleListReader slr = new SimpleListReader();
           sl = slr.read();
           
           System.out.println(sl);
        }
        catch( SimpleListIOException e)
        {
            System.out.println("Error: " + e.getMessage());    
        }
   }
  

   public static void main(String [] args) 
   {
       int op;
       do
       {
          System.out.println("1. Grabar");
          System.out.println("2. Recuperar");
          System.out.println("3. Probar");
          System.out.println("4. Salir");
          System.out.print("Ingrese: ");
          op = Consola.readInt();
          switch(op)
          {
             case 1:   grabar();  
                       break;

             case 2:   leer();
                       break;

             case 3:   System.out.println(sl);
          }
       }
       while(op != 4);
   }
}

