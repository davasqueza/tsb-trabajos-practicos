package soporte;

/**
 *  Una cola gen�rica
 *  @author  Ing. Valerio Frittelli
 *  @version Septiembre de 2007
 */
public class Cola
{
      private Nodo frente;
      private Nodo fondo;
      
      /** 
       * Constructor por defecto
       */
      public Cola ()
      {
        frente = null;
        fondo  = null;
      }
      
      /**
       *  Acceso a la direcci�n del primer Nodo
       *  @return direcci�n del primer Nodo
       */
      public Nodo getFrente()
      {
         return frente;   
      }
      
      /**
       *  Acceso a la direcci�n del �ltimo Nodo
       *  @return direcci�n del �ltimo Nodo
       */
      public Nodo getFondo()
      {
         return fondo;   
      }

      /**
       * Determina si la cola est� vac�a
       * @return true: est� vac�a  -  false: no est� vac�a
       */
      public boolean vacia()
      {
         return (frente == null);    
      }
      
      /**
       *  Inserta un nodo al final de la cola
       *  @param x el objeto a almacenar en el nuevo nodo
       */
      public void insertar(Comparable x)
      {
        if (x!=null)
        {
           if(frente!=null && x.getClass()!=frente.getInfo().getClass()) return;
           
           Nodo p = new Nodo(x, null);
           if(fondo == null) { frente = p; }
           else { fondo.setNext(p); } 
           fondo = p;
        }
      } 
      
      /**
       *  Elimina el primer nodo
       *  @return una referencia al info del nodo eliminado, o null la cola estaba vac�a
       */
      public Comparable borrar() 
      {
        Comparable p = null;
        if(frente != null)
        {
           p = frente.getInfo();
           frente = frente.getNext();
           if(frente == null) { fondo = null; }
        }  
        return p;
      } 
      

      /**
       *  Redefine el m�todo toString
       *  @return el contenido de la lista convertido a String
       */
      public String toString()
      {
         Nodo p = frente;
         StringBuffer res = new StringBuffer("Contenido: ");
         while(p != null)
         {
            res.append( p.toString() );
            p = p.getNext();
         }
         return res.toString();
      }
}
