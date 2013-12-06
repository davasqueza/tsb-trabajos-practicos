/**
 * Clase sencilla, usada para representar Clientes del Banco. 
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public class Cliente //implements Comparable
{
    private int dni;
    private String nombre;
    
    /**
     * Constructor por defecto o nulo.  
     */
    public Cliente()
    {
    }

    /**
     * Constructor sobrecargado. Inicializa el dni y el nombre de acuerdo a los parámetros
     */
    public Cliente(int d, String nom)
    {
      dni = d;
      nombre = nom;
    }
    
    /*
     *  Método de consulta para el número de dni
     *  @return el número de dni
     */
    public int getDni()
    {
       return dni;   
    }

    /*
     *  Método de consulta para el nombre del cliente
     *  @return el nombre del cliente
     */
    public String getNombre()
    {
       return nombre;   
    }
    
    /*
     *  Método modificador para el número de dni
     *  @param num el nuevo dni
     */
    public void setDni( int num )
    {
       dni = num;   
    }

    /*
     *  Método modificador para el nombre del cliente
     *  @param nom el nuevo nombre
     */
    public void setNombre( String nom )
    {
       nombre = nom;   
    }

    /** 
     *  Redefinición del método toString
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado
     */
    public String toString()
    {
       return "Dni del cliente: " + dni +  " - Nombre: " + nombre;
    }

    /**
     * Redefinición del método pedido por la interfaz Comparable
     * El criterio de comparación será en base al dni del cliente.
     * @param x El objeto a comparar contra el parámetro implícito
     * @return 0 si los dni de ambos objetos son iguales, negativo si el dni del implícito es menor, positivo si es mayor.
     */
    public int compareTo(Object x)
    {
       // moldeamos x para que el compilador "vea" un objeto Cliente y no un Object, 
       // pues el método getDni() no está en Object...
       Cliente c = (Cliente) x;
       return this.getDni() - c.getDni(); 
    }
}
