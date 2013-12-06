/**
 * Una estructura de datos genérica: la idea es poder almacenar referencias a "cualquier" clase de objeto, en forma secuencial, 
 * sin tener que redefinir la clase cuando cambia el tipo de objeto a almacenar. La clase definida aquí, admitirá sólo inserciones 
 * homogéneas:  no se admitirán objetos de distinta clase en la misma estructura.
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public final class Listado
{
   /*
    * 1.) Incluimos en esta versión de la clase el tratamiento de excepciones. El método get de la clase, controla de forma "natural" que
    * el índice pedido esté en el rango de índices válidos del arreglo, usando un bloque try - catch. Si el lenguaje sabe hacerlo, deje
    * que lo haga él... La excepción tratada es de la clase IndexOutOfBoundsException (que deriva de RuntimeException, y es NO CHEQUEADA:
    * podríamos no haber escrito nada para tratarla, y compilaría igual. En este caso, si se invoca al método con un valor negativo se
    * lanzaría la excepción mostrando mensajes de error en la consola estándar).
    */
   
   private Comparable v[]; 
   private int largo;       
   private int libre;       
  
   /**
    *  Por default, se crea un Listado de 10 elementos de largo, con referencias nulas
    */
   public Listado()
   {
      this(10);
   }
   
   /**
    *  Crea un Listado de n elementos de largo, con referencias nulas, siempre y cuando n sea mayor a cero. De lo contrario, el Listado
    *  se crea de tamaño 10
    */
   public Listado(int n)
   {
      if (n <= 0) { n = 10; }
      largo = n;
      libre = 0;
      v = new Comparable[largo];
   }
   
   /**
    *  Método de acceso para el tamaño del Listado. Provisto en lugar de "getLargo" por razones de claridad
    *  @return el tamaño del Listado
    */
   public int length()
   {
      return largo;   
   }
   
   /**
    *  Método de acceso al índice de la primera casilla libre en el Listado. 
    *  @return el tamaño del Listado
    */
   public int getPrimeraLibre()
   {
      return libre;   
   }
      
   /**
    *  Redefinición del método toString heredado desde Object
    *  @return una cadena con el contenido del Listado para ser visualizado
    */
   public String toString()
   {
      StringBuffer cad = new StringBuffer("Contenido:\n");
      int i;
      for(i=0; i<libre; i++)
      {
        cad.append(v[i].toString() + "; ");   
      }
      return cad.toString();
   }
   
   /**
    * Agrega un elemento al Listado, en la primera casilla libre. El método supone que el atributo "libre" indica el índice de la primera
    * casilla que está desocupada en el arreglo, completándose de izquierda a derecha
    * @param x el objeto Comparable a añadir al Listado
    * @return true si el añadido tuvo éxito - false si el objeto no pudo añadirse (por falta de lugar).
    */
   public boolean add (Comparable x)
   {
      boolean res = false;
      if (libre == 0 || (libre > 0 && libre < largo && x.getClass() == v[0].getClass())) 
      {
         v[libre] = x;
         libre++;
         res = true;
      }
      return res;
   }
   
   /**
    * Devuelve una referencia al objeto ubicado en la posición i del Listado, sin removerlo del mismo.
    * @param i el índice de la casilla con el objeto a retornar
    * @return la referencia al objeto, o null si el índice estaba fuera de rango
    */
   public Comparable get (int i)
   {
     Comparable x = null;
     if (i < libre)
     {
          try
          {
             x = v[i];
          }
          catch(ArrayIndexOutOfBoundsException ex)
          {
              // si llegó acá, el índice "i" era negativo... Mostramos una ventana y retornamos null
              javax.swing.JOptionPane.showMessageDialog(null, "Indice negativo: verifique!!!"); 
          }
     }
     return x;
   }

   /**
    * Busca un objeto en el Listado
    * @param x el objeto a buscar
    * @return el índice la casilla que contiene a x, si existe. Si x no existe en el Listado, retorna -1
    */
   public int buscar (Comparable x)
   {
     int i, ind = -1;
     for (i=0; i<libre; i++)
     {
        if (x.compareTo(v[i]) == 0)
        {
           ind = i;
           break;   
        }
     }
     return ind;
   }

   /** 
    * Ordena el Listado con el método Quick Sort
    */
   public void ordenar ()
   {
      // el método "quick" es privado, pues es un método auxiliar del método "ordenar"  
      quick (0, libre - 1);
   }

   private void quick (int izq, int der)
   {
       // método recursivo para ordenar el vector aplicando la técnica de partir en sub-vectores y ordenar a cada uno
       Comparable x, y;
       int i, j;
       i = izq;
       j = der;
       x = v[(izq + der) / 2];
       do 
       {
            while (v[i].compareTo(x) < 0 && i < der) i++;
            while (x.compareTo(v[j]) < 0 && j > izq) j--;
            if (i<=j)
            {
                  y = v[i];
                  v[i] = v[j];
                  v[j] = y;
                  i++;
                  j--;
            }
       }
       while (i <= j);
       if (izq < j) { quick (izq, j); }
       if (i < der) { quick (i, der); }
   }
}
