/**
 *  Clase que permite recuperar desde un archivo externo un objeto de
 *  la clase SimpleList que haya sido grabado por Serialización.
 *  @author Ing. Valerio Frittelli.
 *  @version Septiembre de 2008.
 */
import java.io.*;
public class SimpleListReader 
{
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListReader. Asume que el nombre del archivo desde el 
       * cual se recupera es "lista.dat".
       */
      public SimpleListReader()
      {
      }
      
      /**
       * Crea un objeto SimpleListReader. Fija el nombre del archivo desde el cual 
       * se recupera con el nombre tomado como parámetro.
       * @param nom el nombre del archivo a abrir para iniciar la recuperación.
       */
      public SimpleListReader(String nom)
      {
          arch = nom;
      }
      
      
      /**
       * Recupera una SimpleList desde un archivo serializado.
       * @throws SimpleListIOException si se encuentra un error de IO.
       * @return una referencia al objeto recuperado.
       */
      public SimpleList read() throws SimpleListIOException
      {
           SimpleList sl = null;
           
           try
           {
                 FileInputStream istream = new FileInputStream(arch);
                 ObjectInputStream p = new ObjectInputStream(istream);
          
                 sl = ( SimpleList ) p.readObject();
                 
                 p.close();
                 istream.close();
           }
           catch (Exception e)
           {
             throw new SimpleListIOException("No se pudo recuperar la lista");
           }
           
           return sl;
       }
}