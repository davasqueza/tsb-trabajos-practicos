package clases;

/**
 *  Representa un alumno para usarse en estructuras de datos genericas
 *  @author Ing. Valerio Frittelli,
 *  @version Abril 200.
 */
public class Alumno implements Comparable
{
   private int legajo;
   private String nombre;
   
   /**
    * Constructor por defecto
    */
   public Alumno ()
   {
   }
   
   /**
    * Inicializa el legajo con el valor del parametro
    */
   public Alumno(int leg)
   {
      legajo = leg;
      nombre = "";
   }
   
   /**
    * Inicializa todos los atributos
    */
   public Alumno(int leg, String nom)
   {
      legajo = leg;
      nombre = nom;
   }
   
   /**
    * Acceso al Legajo
    * @return valor del legajo
    */
   public int getLegajo()
   {
      return legajo;
   }
   
   /**
    * Acceso al nombre
    * @return valor del nombre
    */
   public String getNombre()
   {
      return nombre;
   }
   
   /**
    * Modifica el legajo
    * @param leg nuevo legajo
    */
   public void setLegajo(int leg)
   {
      legajo = leg;
   }
   
   /**
    * Modifica el nombre
    * @param nom nuevo nombre
    */
   public void setNombre(String nom)
   {
      nombre = nom;
   }
   
   /**
    *  Redefinicion de toString
    *  @return el contenido del nodo en forma de String
    */
   public String toString()
   {
     return "\r\nLegajo: " + legajo + "\tNombre: " + nombre; 
   }
   
   /**
    * Permite comparar el contenido de informaci�n de un Alumno con el de otro
    * @param o el objeto a comparar
    * @return un valor int:  0 si eran iguales, >0 si el implicito era mayor, <0 si el implicito era menor
    * @throws ClassCastException si se intenta moldear a una clase incompatible
    */
    public int compareTo(Object o)
   {
     Alumno otro = (Alumno) o;
     if (legajo == otro.getLegajo()) return 0;
     else if (legajo > otro.getLegajo()) return 1;
	      else return -1; 
   }
}
