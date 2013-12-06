package clases;


/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejemplo
{
    public static void main (String[] args) throws InsercionHeterogeneaException
    {
	   Listado a = new Listado();
	   String x = "casa";
	   Integer y = new Integer(23);
	   a.add(x);
	   a.add(y);
    } 
}
