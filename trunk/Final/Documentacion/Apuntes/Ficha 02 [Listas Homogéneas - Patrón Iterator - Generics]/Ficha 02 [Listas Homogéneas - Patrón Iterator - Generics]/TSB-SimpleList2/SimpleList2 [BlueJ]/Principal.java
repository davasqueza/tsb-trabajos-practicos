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
        b.addFirst( new Cliente (23, "Juan") );
        b.addFirst( new Cliente (2, "Ana") );
        b.addFirst( new Cliente (5, "Luis") );
        System.out.println( "\nLista de Clientes: " + b );
        
        SimpleList c = new SimpleList();
        c.addFirst( new Inversion (101, 2000, 2.1f) );
        c.addFirst( new Corriente (212, 1000, true) );
        c.addFirst( new Corriente (511, 2300, false) );
        System.out.println( "\nLista de Cuentas: " + c );
    }
}
