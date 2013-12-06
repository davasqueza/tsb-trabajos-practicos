public class Principal
{
    public static void main(String args[])
    {
        // creamos una lista para guardar cuentas de Inversion
        SimpleList c = new SimpleList();
        c.addInOrder( new Inversion (101, 2000, 2.1f) );
        c.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        c.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + c );
        
        // ahora recorremos la lista para calcular el saldo promedio...
        // ...usamos nuestra implementación liviana del patrón Iterator
        float a = 0;
        int b = 0;
        c.startIterator();  // inicializamos el mecanismo de recorrido
        while( c.hasNext() )
        {
            Inversion x = (Inversion) c.next();   
            a += x.getSaldo();
            b++;
        }
        float prom = 0;
        if( b != 0 ) prom = a / b;
        System.out.println("Saldo Promedio: " + prom);
        
        // para recorrer la lista otra vez, reinicializamos el mecanismo iterador...
        c.startIterator();
        int s = 0;
        while( c.hasNext() )
        {
            Inversion y = (Inversion) c.next();
            if ( y.getSaldo() > prom ) s++;
        }
        System.out.println("Cantidad de cuentas con saldo mayor al promedio: " + s);
    }
}
