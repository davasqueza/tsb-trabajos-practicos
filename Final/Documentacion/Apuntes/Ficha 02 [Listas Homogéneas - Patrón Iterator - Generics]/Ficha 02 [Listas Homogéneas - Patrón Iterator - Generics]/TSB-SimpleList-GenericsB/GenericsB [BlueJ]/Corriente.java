/**
 * Representa una Cuenta Corriente sencilla en un Banco. Estas cuentas no generan interés, pero permiten librar cheques y eventualmente
 * girar en descubierto
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public class Corriente extends Cuenta
{
    private boolean descubierto;  // true si se autoriza girar en descubierto - false si no. 

	/**
	 * Constructor por defecto
	 */
	public Corriente()
	{
	}
	
    /**
     * Constructor con parámetros para CADA atributo. 
     */
	public Corriente(int num, float sal, boolean des)
	{
	    super(num, sal);   // invoca al constructor de la super clase con dos parámetros
	    descubierto = des;
	}
	
    /**
     *  Método de consulta para la autorización de giro en rojo...
     *  @return el estado de la autorización de giro en descubierto:  true: es válido el giro - false: no es válido
     */
    public boolean getDescubierto()
    {
       /* 
        * Cuando el atributo es boolean, se suele recomendar también que el método de acceso se designe como "is" en lugar de "get" 
        * para mejorar la legibilidad del código de llamada
        */
       return descubierto;   
    }
    
    /**
     *  Método modificador para la autorización de giro en rojo...
     *  @param des true: se autoriza giro en descubierto - false: no se autoriza
     */
    public void setDescubierto( boolean des )
    {
       descubierto = des;   
    }

    /**
     *  Redefinición del método retirar heredado desde Cuenta. Si el importe a retirar es mayor que el saldo, aún podría ser válido el 
     *  retiro si la cuenta tiene autorización de sobregiro.
     *  @param imp monto que será retirado de la cuenta
     */
    public void retirar (float imp)
    {
      float s = getSaldo();
      if (s >= imp || getDescubierto())
      {
         setSaldo(s - imp);   
      }
    }


    /** 
     *  Redefinición del método toString
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado
     */
    public String toString()
    { 
       // observar la forma de invocar a un método de la super clase
       return super.toString() + " - Autorización de giro en rojo: " + descubierto;
    }
}
