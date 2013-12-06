/**
 * Representa una cuenta bancaria como base de una jerarquía de clases, pero como clase abstracta.
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public abstract class Cuenta
{
    
    private int numero;
    private float saldo;
    
    /**
     * Constructor por defecto o nulo. Al incluirlo, facilitamos el proceso de creación de instancias, como se verá 
     */
    public Cuenta()
    {
    }

    /**
     * Constructor sobrecargado. Inicializa el numero de cuenta y el saldo de acuerdo a los parámetros
     */
    public Cuenta(int num, float sal)
    {
      numero = num;
      saldo  = sal;
    }
    
    /**
     *  Método de consulta para el número de cuenta
     *  @return el número de la cuenta
     */
    public int getNumero()
    {
       return numero;   
    }

    /**
     *  Método de consulta para el saldo de la cuenta
     *  @return el saldo de la cuenta
     */
    public float getSaldo()
    {
       return saldo;   
    }
    
    /**
     *  Método modificador para el número de cuenta
     *  @param num el nuevo número de la cuenta
     */
    public void setNumero( int num )
    {
       numero = num;   
    }

    /**
     *  Método modificador para el saldo de cuenta
     *  @param sal el nuevo saldo de la cuenta
     */
    public void setSaldo( float sal )
    {
       saldo = sal;   
    }

    /**
     *  Retiro de cierto monto del saldo de la cuenta. 
     *  @param imp monto que será retirado de la cuenta
     */
    public abstract void retirar (float imp);
    
    /**
     *  Depósito de cierto monto en la cuenta. Se asume una operaroria muy general, dejando que las clases derivadas puedan cambiar la
     *  forma de depositar
     *  @param imp monto que será depositado en la cuenta
     */
    public void depositar (float imp)
    {
         saldo += imp;   
    }

    /** 
     *  Redefinición del método toString
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado
     */
    public String toString()
    {
       return "Cuenta número: " + numero +  " - Saldo: " + saldo;
    }
}