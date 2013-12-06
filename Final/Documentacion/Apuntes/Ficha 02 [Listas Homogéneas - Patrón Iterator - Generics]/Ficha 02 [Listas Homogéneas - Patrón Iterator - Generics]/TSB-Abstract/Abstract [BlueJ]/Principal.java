/**
 * Clase para contener al método main y testear la jerarquía de clases de cuentas bancarias, usando polimorfismo
 * 
 * @author Ing. Valerio Frittelli
 * @version Abril de 2004
 */
public class Principal
{
    public static void main(String args[])
    {
       //Cuenta a = new Cuenta(1, 1000);  // no compila: Cuenta es abstracta!!!
       Cuenta b = new Inversion(2, 2000, 2.31f);
       Cuenta c = new Corriente(3, 1500, true);
       
       System.out.println("\nValores: ");
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);
       
       Cuenta v[] = new Cuenta[4];  // un arreglo de referencias polimórficas. Puede representar la cartera de clientes del banco
       
       // ahora llenamos el arreglo con objetos de clases distintas...
       v[0]= new Inversion(1, 3500, 1.23f);
       v[1]= new Corriente(2, 500, false);
       v[2]= new Corriente(3, 700, true);
       v[3]= new Inversion(4, 1500, 2.1f);
       
       int i;
       for(i=0; i<4; i++)
       {
          v[i].retirar(1000);  
       }
       
       for(i=0; i<4; i++)
       {
          if(v[i] instanceof Inversion)
          {
             Inversion inv = (Inversion) v[i];  // moldeamos para guiar al compilador
             inv.actualizar();                 //actualizar() está definido sólo en la clase Inversion 
         }
       }
 
       System.out.println("\nObjetos de la misma clase que el primero");
       Cuenta este = v[0];         
       for(i=0; i<4; i++)
       {
          if(v[i].getClass() == este.getClass())
          {
             System.out.println("v[" + i + "]: " + v[i]);   
          }
       }

       System.out.println("\nTodo el vector:");
       for(i=0; i<4; i++)
       {
             System.out.println("v[" + i + "]: " + v[i]);   
       }
    }
}
