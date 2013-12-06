/**
 * Clase para mostrar el funcionamiento de un árbol de búsqueda genérico.
 * @author Ing. Valerio Frittelli.
 * @version Septiembre de 2008 - versión completa.
 */
public class Principal
{
    private static TreeSearch a; 
    
    public static void main (String args[])
    {
      Alumno x, alu;
      int leg, op;
      String nom;
      
      a = new TreeSearch ();

      do
      {
        System.out.println ("Prueba de un Arbol de Búsqueda Genérico (datos de Alumnos)");
        System.out.println ("1. Insertar datos");
        System.out.println ("2. Eliminar datos");
        System.out.println ("3. Buscar un elemento");
        System.out.println ("4. Mostrar en Preorden");
        System.out.println ("5. Mostrar en Entreorden");
        System.out.println ("6. Mostrar en Postorden");
        System.out.println ("7. Salir");
        System.out.print ("Ingrese opción: ");
        op = Consola.readInt();
        switch (op)
        {
            case 1:  
                 System.out.print ("Legajo: "); 
                 leg = Consola.readInt();
                 System.out.print ("Nombre: ");
                 nom = Consola.readLine();
                 x = new Alumno(leg, nom); 
                 if(a.add(x))System.out.print("Hecho...");
                 else System.out.print("No se agregó el alumno... posible repetición");
                 break;   
            
            case 2:
                 System.out.print("Ingrese el legajo del alumno a borrar: ");
                 leg = Consola.readInt();
                 x = new Alumno (leg);
                 if(a.remove(x))System.out.print("Hecho...");
                 else System.out.print("No se borró el alumno... posiblemente no existía");
                 break;
    
            case 3:
                 System.out.print("Ingrese el legajo del alumno a buscar: ");
                 leg = Consola.readInt();
                 x = new Alumno(leg);
                 alu = (Alumno) a.search(x);
                 if (alu != null)
                 {
                    System.out.println("Encontrado: " + alu);
                 }
                 else
                 {
                    System.out.println("No encontrado...");
                 }
                 break;
    
            case 4:  
                 System.out.println("Frecuencias (en preorden)... " + a.toPreOrdenString());
                 break;
    
            case 5:  
                 System.out.println("Frecuencias (en entreorden)... " + a.toEntreOrdenString());
                 //System.out.println("Frecuencias (en entreorden)... " + a.toString());
                 break;
    
            case 6:  
                 System.out.println("Frecuencias (en postorden)... " + a.toPostOrdenString());
                 break;
            
            case 7: ;
        }
      }
      while (op != 7);
    }
}