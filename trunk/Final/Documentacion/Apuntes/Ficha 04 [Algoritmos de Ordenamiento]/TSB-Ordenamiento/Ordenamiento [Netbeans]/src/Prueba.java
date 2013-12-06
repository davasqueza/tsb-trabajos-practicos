/** Prueba de la clase Arreglo
 *  @author Ing. Valerio Frittelli
 *  @version Agosto 2004
 */
public class Prueba
{
    private static Arreglo v;
    private static int n, op;
    
    /**
     *  Punto de entrada de la aplicación
     */
    public static void main (String[] args)
    {
    	System.out.print ("Ingrese cantidad del elementos del vector: ");
    	n = Consola.readInt ();
    	v = new Arreglo (n);
    	do
    	{
    	    System.out.println ("\nOpciones de Ordenamiento");
    	    System.out.println ("0. Generar el Arreglo");
    	    System.out.println ("1. Intercambio Directo (Burbuja)");
    	    System.out.println ("2. Seleccion Directa");
    	    System.out.println ("3. Insercion Directa");
    	    System.out.println ("4. Quick Sort");
    	    System.out.println ("5. Heap Sort");
    	    System.out.println ("6. Shell Sort");
    	    System.out.println ("7. Verificar si esta ordenado");
    	    System.out.println ("8. Salir");
    	    System.out.print ("Ingrese opcion: ");
    	    op = Consola.readInt ();
    	    switch (op)
    	    {
    		case 0:  
    		     System.out.print("Se vuelve a generar el vector...");
    			 v.generar();
    			 System.out.print("\nVector generado...");
    			 break;   
    		
    		case 1:
    		     System.out.print("Se ordena el vector por Intercambio...");
    			 v.setOrdenador( Arreglo.BUBBLE );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado...");
    			 break;
    
    		case 2:
    		     System.out.print("Se ordena el vector por Seleccion...");
    			 v.setOrdenador( Arreglo.SELECTION );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado...");
    			 break;
    
    		case 3:  
    		     System.out.print("Se ordena el vector por Insercion... ");
    			 v.setOrdenador( Arreglo.INSERTION );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado... ");
    			 break;
    
    		case 4:  
    		     System.out.print("Se ordena el vector por Quick Sort...");
    			 v.setOrdenador( Arreglo.QUICK );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado...");
    			 break;
    
    		case 5:  
    		     System.out.print("Se ordena el vector por Heap Sort...");
    			 v.setOrdenador( Arreglo.HEAP );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado...");
    			 break;
    
    		case 6:  
    		     System.out.print("Se ordena el vector por Shell Sort...");
    			 v.setOrdenador( Arreglo.SHELL );
    			 v.ordenar();
    			 System.out.print("\nVector ordenado...");
    			 break;
    
    		case 7:  
    		     System.out.println("Se verifica si esta ordenado...");
    			 if(v.verificar()) System.out.println("Esta ordenado...");
    			 else System.out.println ("No esta ordenado...");
    			 break;
    		
    		case 8: ;
    	    }
    	 }
    	 while (op != 8);
        } 
}
