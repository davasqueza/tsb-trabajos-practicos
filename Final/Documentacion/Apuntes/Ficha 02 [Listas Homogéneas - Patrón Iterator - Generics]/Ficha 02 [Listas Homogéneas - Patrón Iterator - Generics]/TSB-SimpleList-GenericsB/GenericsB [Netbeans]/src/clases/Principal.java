package clases;

public class Principal
{
    public static void main(String args[])
    {
        // creamos una lista para guardar cuentas de Inversion y Corrientes, mezcladas... 
        // ...sin parametrizar se comporta como una lista gen�rica heterog�nea... 
        SimpleList c = new SimpleList();
        c.addInOrder( new Inversion (101, 2000, 2.1f) );
        c.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        c.addInOrder( new Corriente (140, 2030, true) );  // ok...
        c.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + c );
        
        // creamos otra lista pero parametrizada, para guardar cuentas de Inversion...
        // si intentamos guardar algo que NO sea Inversion, no compila...
        // ... est� parametrizada, se comporta como homog�nea.
        SimpleList <Inversion> d = new SimpleList < Inversion > ();
        d.addInOrder( new Inversion (101, 2000, 2.1f) );
        d.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        //d.addInOrder( new Cliente () );  // esto no compila!!!
        d.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + d );
    }
}
