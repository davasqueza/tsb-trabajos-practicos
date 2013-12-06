package clases;

/**
 * Clase para contener al m�todo main y testear una Jerarqu�a de clases de cuentas bancarias
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public class Principal
{
    public static void main(String args[])
    {
       Cuenta a = new Cuenta(1, 1000);
       Inversion b = new Inversion(2, 2000, 2.31f);
       Corriente c = new Corriente(3, 1500, true);
       
       System.out.println("\nValores originales: ");
       System.out.println("Cuenta a: " + a);
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);
       
       a.setNumero(4);
       //a.setDescubierto(true);  // no compila: setDescubierto est� definido m�s abajo de la clase Cuenta
       
       b.setNumero(5);
       b.actualizar();
       b.retirar(3000);  // ���podr�??? NO... est� invocando al m�todo definido en la clase Inversion, que controla el saldo
       
       c.setNumero(6);
       //c.actualizar();  // no compila: no est� en la base, ni definido en Corriente.
       c.retirar(2000); // ���podr�??? SI... invoca al definido en Corriente, que permite sobregiro si la cuenta est� autorizada
       
       System.out.println("\nNuevos valores: ");
       System.out.println("Cuenta a: " + a.toString());
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);       
    }
}
