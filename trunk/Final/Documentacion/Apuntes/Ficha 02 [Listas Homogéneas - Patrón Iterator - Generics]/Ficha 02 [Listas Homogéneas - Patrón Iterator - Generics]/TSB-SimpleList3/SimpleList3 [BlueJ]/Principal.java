public class Principal
{
    public static void main(String args[])
    {
        // una lista de cadenas...
        SimpleList a = new SimpleList();
        a.addFirst("casa");
        a.addFirst("perro");
        a.addFirst("sol");
        System.out.println("Lista de cadenas: " + a.toString());
        if (a.contains("sol")) System.out.println ("La cadena: sol  - está en la lista");
        else System.out.println ("La cadena: sol  - no está en la lista");
        
        SimpleList b = new SimpleList();
        b.addLast( new Cliente (23, "Juan") );
        b.addLast( new Cliente (2, "Ana") );
        b.addLast( new Cliente (5, "Luis") );
        System.out.println( "\nLista de Clientes: " + b );
        
        SimpleList c = new SimpleList();
        c.addInOrder( new Inversion (101, 2000, 2.1f) );
        c.addInOrder( new Corriente (212, 1000, true) ); // no la va a insertar...
        c.addInOrder( new Inversion (511, 2300, 3) );
        
        c.addInOrder( new Cliente(40, "Carlos") );  // no lo va a insertar...
        c.addInOrder( "Cadena" );  // no la va a insertar...
        
        System.out.println( "\nLista de Cuentas: " + c );
    }
}
