package clases;

/**
 * Representa una cuenta bancaria como base de una jerarqu�a de clases.
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public class Cuenta
{
    /*
     */
    
    private int numero;
    private float saldo;
    
    /**
     * Constructor por defecto o nulo. Al incluirlo, facilitamos el proceso de creaci�n de instancias, como se ver� 
     */
    public Cuenta()
    {
    }

    /**
     * Constructor sobrecargado. Inicializa el numero de cuenta y el saldo de acuerdo a los par�metros
     */
    public Cuenta(int num, float sal)
    {
      numero = num;
      saldo  = sal;
    }
    
    /**
     *  M�todo de consulta para el n�mero de cuenta
     *  @return el n�mero de la cuenta
     */
    public int getNumero()
    {
       return numero;   
    }

    /**
     *  M�todo de consulta para el saldo de la cuenta
     *  @return el saldo de la cuenta
     */
    public float getSaldo()
    {
       return saldo;   
    }
    
    /**
     *  M�todo modificador para el n�mero de cuenta
     *  @param num el nuevo n�mero de la cuenta
     */
    public void setNumero( int num )
    {
       numero = num;   
    }

    /**
     *  M�todo modificador para el saldo de cuenta
     *  @param sal el nuevo saldo de la cuenta
     */
    public void setSaldo( float sal )
    {
       saldo = sal;   
    }

    /**
     *  Retiro de cierto monto del saldo de la cuenta. Se asume una operatoria muy general, pero las clases derivadas podr�an necesitar
     *  modificar este algoritmo
     *  @param imp monto que ser� retirado de la cuenta
     */
    public void retirar (float imp)
    {
      if (saldo - imp >= 0)
      {
         saldo -= imp;   
      }
    }
    
    /**
     *  Dep�sito de cierto monto en la cuenta. Se asume una operaroria muy general, dejando que las clases derivadas puedan cambiar la
     *  forma de depositar
     *  @param imp monto que ser� depositado en la cuenta
     */
    public void depositar (float imp)
    {
         saldo += imp;   
    }

    /** 
     *  Redefinici�n del m�todo toString
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado
     */
    public String toString()
    {
       return "Cuenta n�mero: " + numero +  " - Saldo: " + saldo;
    }
}