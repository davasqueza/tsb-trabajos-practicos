package clases;

/**
 * Representa una palabra, asociada con un significado, como para armar un diccionario.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Octubre de 2008
 */

import java.io.*;
public class Termino implements Comparable, Serializable
{
    private String palabra;     
    private String significado;  
    
    /**
     * Constructor por defecto. Asigna frecuencia 1 al objeto creado
     */
    public Termino()
    {
    }

    /**
     * Inicializa con el par�metro, y pone frecuencia igual a 1
     */
    public Termino (String p)
    {
       palabra = p;
       significado = "";
    }


    /**
     * Inicializa con los par�metros, y pone frecuencia igual a 1
     */
    public Termino (String p, String s)
    {
       palabra = p;
       significado = s;
    }

    /**
     * M�todo de acceso al valor de la palabra
     * @return el valor de la palabra
     */
    public String getPalabra()
    {
       return palabra;
    }

    /**
     * M�todo de acceso al valor del significado
     * @return el valor del significado
     */
    public String getSignificado()
    {
       return significado;
    }


    /**
     * M�todo modificador de la palabra
     * @param c el valor a almacenar como palabra 
     */
    public void setPalabra(String c)
    {
       palabra = c;
    }

    /**
     * M�todo modificador del significado
     * @param c el valor a almacenar como significado 
     */
    public void setSignificado(String c)
    {
       significado = c;
    }

    /**
     * M�todo para redefinir el m�todo toString heredado desde Object
     * @return  una cadena representando los valores contenidos
     */
    public String toString()
    {
       return "\n\tPalabra: " + palabra + "\tsignificado: " + significado;
    }

    /**
     * Redefine al m�todo hashCode heredado desde Object. El que viene desde Object, retorna la 
     * direcci�n de memoria del objeto, convertida a un integer. En la mayor parte de las aplicaciones,
     * es conveniente que hashCode retorne el valor de lo que llamar�amos el "campo clave" del objeto: 
     * el campo que permite distinguirlo de forma un�voca. Si el objeto se env�a de forma polim�rfica a 
     * una estructura de datos que necesite "ver" la clave del objeto (por ejemplo, una tabla hash), 
     * hashCode soluciona el problema. Ver la documentaci�n de Sun para m�s detalles acerca de lo que se 
     * espera respecto del m�todo. Si el atributo clave es un String, se puede retornar el hashCode de ese 
     * String...
     * 
     * @return el valor del atributo "clave", para ser usado como hashCode en una tabla hash o en donde sea 
     * que se requiera esa clave.
     */
    public int hashCode()
    {
      return Math.abs(palabra.hashCode()); 
    }
    
   
    /**
     * Redefine al m�todo equals heredado desde Object. El que viene desde Object compara las direcciones de 
     * memoria de los dos objetos, y retorna true si ambas referencias apuntan al mismo objeto, o false en 
     * caso contrario. Siempre que se redefina hashCode, deber�a redefinirse equals, para mantener la consistencia 
     * en cuanto a la especificaci�n te�rica de cada uno de ellos. La idea general es que si equals dice que dos 
     * objetos son iguales, entonces hashCode deber�a devolver el mismo valor int para los dos.
     * 
     * @param obj el objeto contra el cual se compara.
     * @return true si se considera que los objetos son iguales.
     */
    public boolean equals (Object obj)
    {
      if( obj == null ) return false;
      
      Termino x = null;
      try
      {
         x = (Termino) obj;
      }
      catch(ClassCastException e)
      {
         return false;    
      }
      
      return palabra.equals(x.palabra);
    }

    /**
     * Permite comparar el contenido de informaci�n de un objeto  con el de otro que viene como par�metro.
     * @param o el objeto a comparar.
     * @return un valor int:  0 si eran iguales, >0 si el impl�cito era mayor, <0 si el impl�cito era menor.
     * @throws ClassCastException si se intenta moldear a una clase incompatible.
     */
     public int compareTo(Object o)
     {
       Termino otro = (Termino) o;
       return palabra.compareTo(otro.palabra);
     }
}
