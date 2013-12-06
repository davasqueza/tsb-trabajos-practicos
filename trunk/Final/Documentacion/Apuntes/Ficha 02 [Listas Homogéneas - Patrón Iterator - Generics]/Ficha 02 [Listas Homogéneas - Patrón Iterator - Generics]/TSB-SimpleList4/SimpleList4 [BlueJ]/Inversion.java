/**
 * Representa una cuenta de Inversion, como subclase de la clase Cuenta. Una cuenta de 
 * inversión da cierto monto de interés a su dueño, aunque no permite girar cheques ni es
 * de libre disponibilidad
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public class Inversion extends Cuenta
{
    private float tasa;  // la tasa de interés pactada para la cuenta. Se agrega a los atributos heredados desde Cuenta
    
    /**
     * Constructor por defecto. Si se invoca a este constructor, Java automáticamente invoca primero al constructor por defecto de la super
     * clase...
     */
	public Inversion()
	{
	}
	
    /**
     * Constructor con parámetros para CADA atributo. 
     */
	public Inversion(int num, float sal, float tas)
	{
	    super(num, sal);   // invoca al constructor de la super clase con dos parámetros
	    tasa = tas;
	}
	
    /**
     *  Método de consulta para la tasa de interés
     *  @return la tasa de interés pactada para la cuenta
     */
    public float getTasa()
    {
       return tasa;   
    }
    
    /**
     *  Método modificador para la tasa de interés
     *  @param tas la nueva tasa de interés de la cuenta
     */
    public void setTasa( float tas )
    {
       tasa = tas;   
    }

    /**
     * Actualiza el saldo de la cuenta en base a la tasa de interés pactada
     */
    public void actualizar ()
    {
       float monto = getSaldo() * tasa / 100;
       depositar(monto);
    }

   /**
    *  Retiro de cierto monto del saldo de la cuenta. 
    *  @param imp monto que será retirado de la cuenta
    */
    //*
    public void retirar (float imp)
    {
      float s = getSaldo();
      if (s - imp >= 0)
      {
         setSaldo(s - imp);   
      }
    }
    //*/

   
    /** 
     *  Redefinición del método toString
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado
     */
    public String toString()
    { 
       // observar la forma de invocar a un método de la super clase
       return super.toString() + " - Tasa: " + tasa;
    }
}
