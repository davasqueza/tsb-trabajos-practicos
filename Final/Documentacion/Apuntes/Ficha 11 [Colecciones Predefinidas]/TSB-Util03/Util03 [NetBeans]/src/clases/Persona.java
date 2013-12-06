package clases;

/**
 *  Representa una Persona con datos b�sicos. Los objetos de esta clase pueden compararse (pues la clase implementa Comparable).
 *  
 *  @author Ing. Valerio Frittelli
 *  @version Junio de 2004
 */
import java.io.*;
class  Persona implements Comparable
{
   private String nombre;
   private int edad;

   /**
    *   Crea un objeto con valores por default
    */
   public Persona()
   {
   }

   /**
    *   Crea un objeto con los valores tomados como par�metro
    */
   public Persona(String nom, int ed)
   {
     nombre = nom;
     edad   = ed;
   }

   /**
    *   Crea un objeto con el nombre tomado como par�metro
    */
   public Persona(String nom)
   {
     nombre = nom;
   }


   /**
    *  Acceso al nombre
    *  @return el nombre de la persona
    */
   public String getNombre()
   {
     return nombre;
   }

   /**
    *  Acceso a la edad
    *  @return el valor de la edad
    */
   public int getEdad()
   {
     return edad;
   }

   /**
    *  Cambia el nombre
    *  @param nom el nuevo nombre
    */
   public void setNombre(String nom)
   {
     nombre = nom;
   }

   /**
    *  Cambia la edad
    *  @param ed la nueva edad
    */
   public void setEdad(int ed)
   {
     edad = ed;
   }

   /**
    *  Redefinici�n del m�todo que se hereda de Object
    *  @return la representaci�n como String del contenido del objeto
    */
   public String toString()
   {
     return "\n\tNombre: " + nombre + "\tEdad: " + edad;
   }

    /**
     * Redefinici�n del m�todo pedido por la interfaz Comparable
     * @param x El objeto a comparar contra el par�metro impl�cito
     * @return 0 si los nombres son iguales, negativo si el nombre del impl�cito es menor, positivo si es mayor.
     */
    public int compareTo(Object x)
    {
       Persona p = (Persona) x;
       return nombre.compareTo(p.getNombre());
    }
    
    /**
     * Redefine al m�todo heredado desde Object
     * @param obj el objeto con el cual se compara
     * @return true si el nombre de ambos objetos es igual - false en caso contrario
     */
    public boolean equals(Object obj)
    {  
       if(obj == null) return false;
       Persona p = (Persona) obj;
       if(nombre.compareTo(p.getNombre())==0) return true;
       else return false;
    }
    
    /**
     * Redefine al m�todo tomado desde Object
     * @return un valor int que representa en forma un�voca al objeto
     */
    public int hashCode()
    {
       return nombre.hashCode();   
    }
}
