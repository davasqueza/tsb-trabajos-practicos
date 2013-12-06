package clases;

/**
 * Una estructura de datos gen�rica: la idea es poder almacenar referencias a "cualquier" clase de objeto, en forma secuencial, 
 * sin tener que redefinir la clase cuando cambia el tipo de objeto a almacenar. La clase definida aqu�, admitir� s�lo inserciones 
 * homog�neas:  no se admitir�n objetos de distinta clase en la misma estructura.
 * 
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
public final class Listado
{
   /*
    * 1.) Incluimos en esta versi�n de la clase el tratamiento de excepciones. El m�todo get de la clase, controla de forma "natural" que
    * el �ndice pedido est� en el rango de �ndices v�lidos del arreglo, usando un bloque try - catch. Si el lenguaje sabe hacerlo, deje
    * que lo haga �l... La excepci�n tratada es de la clase IndexOutOfBoundsException (que deriva de RuntimeException, y es NO CHEQUEADA:
    * podr�amos no haber escrito nada para tratarla, y compilar�a igual. En este caso, si se invoca al m�todo con un valor negativo se
    * lanzar�a la excepci�n mostrando mensajes de error en la consola est�ndar).
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
    *  se crea de tama�o 10
    */
   public Listado(int n)
   {
      if (n <= 0) { n = 10; }
      largo = n;
      libre = 0;
      v = new Comparable[largo];
   }
   
   /**
    *  M�todo de acceso para el tama�o del Listado. Provisto en lugar de "getLargo" por razones de claridad
    *  @return el tama�o del Listado
    */
   public int length()
   {
      return largo;   
   }
   
   /**
    *  M�todo de acceso al �ndice de la primera casilla libre en el Listado. 
    *  @return el tama�o del Listado
    */
   public int getPrimeraLibre()
   {
      return libre;   
   }
      
   /**
    *  Redefinici�n del m�todo toString heredado desde Object
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
    * Agrega un elemento al Listado, en la primera casilla libre. El m�todo supone que el atributo "libre" indica el �ndice de la primera
    * casilla que est� desocupada en el arreglo, complet�ndose de izquierda a derecha
    * @param x el objeto Comparable a a�adir al Listado
    * @return true si el a�adido tuvo �xito - false si el objeto no pudo a�adirse (por falta de lugar).
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
    * Devuelve una referencia al objeto ubicado en la posici�n i del Listado, sin removerlo del mismo.
    * @param i el �ndice de la casilla con el objeto a retornar
    * @return la referencia al objeto, o null si el �ndice estaba fuera de rango
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
              // si lleg� ac�, el �ndice "i" era negativo... Mostramos una ventana y retornamos null
              javax.swing.JOptionPane.showMessageDialog(null, "Indice negativo: verifique!!!"); 
          }
     }
     return x;
   }

   /**
    * Busca un objeto en el Listado
    * @param x el objeto a buscar
    * @return el �ndice la casilla que contiene a x, si existe. Si x no existe en el Listado, retorna -1
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
    * Ordena el Listado con el m�todo Quick Sort
    */
   public void ordenar ()
   {
      // el m�todo "quick" es privado, pues es un m�todo auxiliar del m�todo "ordenar"  
      quick (0, libre - 1);
   }

   private void quick (int izq, int der)
   {
       // m�todo recursivo para ordenar el vector aplicando la t�cnica de partir en sub-vectores y ordenar a cada uno
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
