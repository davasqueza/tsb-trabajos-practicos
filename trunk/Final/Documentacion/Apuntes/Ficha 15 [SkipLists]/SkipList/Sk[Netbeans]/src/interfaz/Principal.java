package interfaz;

import estructuras.SkipList;
import java.io.File;
import java.io.IOException;
import modelo.Persona;
public class Principal
{
  public static void main(String[] args) throws IOException
  {
//    SkipList s = new SkipList();
//    s.add(new Persona(23, "Sergio Martinez", 20));
//    s.add(new Persona(51, "Juan Perez", 33));
//    s.add(new Persona(11, "Kirk Hammett", 30));
//    s.add(new Persona(32, "James Hetfield", 50));
//    s.add(new Persona(65, "Jason Newsted", 10));
//    s.add(new Persona(15, "Lars Ulrich", 35));
//    s.add(new Persona(13, "Kurt Cobain", 30));
//    System.out.println("Cantidad de nodos: " + s.size());
//    System.out.println("Contenido: " + s);
//    
//    s.remove(new Persona(23));
//    System.out.println("\nCantidad de nodos: (luego de borrar): " + s.size());
//    System.out.println("Contenido (luego de borrar): " + s);
//    
//    Persona p = (Persona) s.search(new Persona(13));
//    System.out.println("\nDatos: " + p);
      
      File f = new File(".");
      System.out.println(f.getCanonicalPath());
      
      
      
  }
}