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
        
        // remueve y retorna la primera cadena
        String cad1 = (String) a.removeFirst(); 
        System.out.println("La primera cadena era: " + cad1);
        
        // retorna la primera cadena sin removerla
        String cad2 = (String) a.getFirst();  
        System.out.println("La primera cadena es ahora: " + cad2);
        
        System.out.println("Lista de cadenas (luego del borrado): " + a.toString());
        
        // ahora una lista heterogénea...
        SimpleList b = new SimpleList();
        b.addFirst( new Cuenta (23, 2000) );
        b.addFirst( "juan" );
        b.addFirst( new Integer(5) );
        System.out.println( "\nLista heterogénea: " + b );
    }
}
