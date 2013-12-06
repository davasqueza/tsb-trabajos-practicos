/**
 * Una clase usada para grabar objetos de la clase SimpleList 
 * mediante Serialización.
 * 
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008.
 */
import java.io.*;
public class SimpleListWriter
{
      // nombre del archivo serializado...
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListWriter. Supone que el nombre del archivo a grabar 
       * será "lista.dat"
       */
      public SimpleListWriter()
      {
      }
      
      /**
       * Crea un objeto SimpleListWriter. Fija el nombre del archivo que se graba con 
       * el nombre tomado como parámetro.
       * @param nom el nombre del archivo a grabar.
       */
      public SimpleListWriter(String nom)
      {
            arch = nom;
      }
      
      /**
       * Graba la lista tomada como parámetro.
       * @throws SimpleListIOException si se encuentra un error de IO.
       */
      public void write ( SimpleList sl ) throws SimpleListIOException
      {
           try
           {
             FileOutputStream ostream = new FileOutputStream(arch);
             ObjectOutputStream p = new ObjectOutputStream(ostream);
      
             p.writeObject(sl);
      
             p.flush(); 
             ostream.close();
           }
           catch ( Exception e )
           {
             throw new SimpleListIOException("No se pudo grabar la lista...");
           }
      }
}
