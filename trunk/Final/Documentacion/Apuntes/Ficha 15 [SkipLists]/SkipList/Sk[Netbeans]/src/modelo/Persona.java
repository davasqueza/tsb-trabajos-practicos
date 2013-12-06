package modelo;

public class Persona implements Comparable
{
  private int dni;
  private String nombre;
  private int edad;

  public Persona(int doc)
  {
     dni = doc;
  }
  
  public Persona(int doc, String nom, int e)
  {
     dni = doc;
     nombre = nom;
     edad = e;
  }
  
  public String toString()
  {
     return "Dni: " + dni +  " - Nombre: " + nombre + " - Edad: " + edad;
  }


  public int compareTo(Object x)
  {
     Persona c = (Persona) x;
     return this.dni - c.dni; 
  }
}