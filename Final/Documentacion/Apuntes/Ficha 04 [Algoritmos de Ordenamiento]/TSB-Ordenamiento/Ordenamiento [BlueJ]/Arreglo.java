/**
 *  Representa un arreglo de elementos int, y plantea diversos métodos de ordenamiento
 *  a través del patrón Strategy.
 *  @author Ing. Valerio Frittelli.
 *  @version Agosto de 2011.
 */
public class Arreglo
{
    public static final int BUBBLE = 0;
    public static final int SELECTION = 1;
    public static final int INSERTION = 2;
    public static final int QUICK = 3;
    public static final int HEAP = 4;
    public static final int SHELL = 5;

    // el arreglo a ordenar
    private int[] v;
    
    // el objeto que contiene el método de ordenamiento a aplicar
    private Ordenable ordenador;

    // clase privada para el patrón Strategy: ordenamiento por intercambio directo
    private class Intercambio implements Ordenable
    {
        // ordenamiento de Intercambio (Burbuja)
        public void ordenar()
        {
              boolean ordenado = false;
              int n = v.length;
              for( int i=0; i<n-1 && !ordenado; i++ )
              {
                    ordenado = true;
                    for( int j=0; j<n-i-1; j++ )
                    {
                         if( v[j] > v[j+1] )
                         {
                         
                               int aux = v[j];
                               v[j] = v[j+1];
                               v[j+1] = aux;
                               ordenado = false;
                         }
                    }
              }           
        }
    }
    
    // clase privada para el patrón Strategy: ordenamiento por selección directa
    private class Seleccion implements Ordenable
    {
        // ordenamiento de Selección
        public void ordenar()
        {
              int n = v.length;
              for(int i = 0; i < n - 1; i++ )
              {
                    for( int j = i + 1; j < n; j++ )
                    {
                         if( v[i] > v[j] )
                         {
                            int aux = v[i];
                            v[i] = v[j];
                            v[j] = aux;
                         }
                    }
              }        
        }
    }

    // clase privada para el patrón Strategy: ordenamiento por inserción directa
    private class Insercion implements Ordenable
    {
        // ordenamiento de Inserción
        public void ordenar()
        {
              int n = v.length;
              for( int j = 1; j < n; j++ )
              {
                    int k, y = v[j];
                    for( k = j-1; k >= 0 && y < v[k]; k-- )
                    {
                        v[k+1]= v[k];
                    }
                    v[k+1]= y;
              }
        }
    }

    // clase privada para el patrón Strategy: ordenamiento Quick Sort
    private class QuickSort implements Ordenable
    {
        // ordenamiento Quick Sort
        public void ordenar()
        {
              ordenar( 0, v.length - 1 );
        }
        
        private void ordenar (int izq, int der)
        {
              int i = izq, j = der, y;
              int x = v[(izq + der) / 2];
              do 
              {
                    while( v[i] < x && i < der ) i++;
                    while( x < v[j] && j > izq ) j--;
                    if( i <= j )
                    {
                          y = v[i];
                          v[i] = v[j];
                          v[j] = y;
                          i++;
                          j--;
                    }
              }
              while( i <= j );
              if( izq < j ) ordenar( izq, j );
              if( i < der ) ordenar( i, der );
        }        
    }
    
    // clase privada para el patrón Strategy: ordenamiento Heap Sort
    private class HeapSort implements Ordenable
    {
        // ordenamiento Heap Sort
        public void ordenar()
        {
               int n = v.length;
        
               // crear el grupo inicial...
               for( int i = 1; i < n; i++ )
               {
                    int e = v[i];
                    int s = i;
                    int f = (s-1)/2;
                    while( s>0 && v[f] < e )
                    {
                          v[s] = v[f];
                          s = f;
                          f = (s-1)/2;
                    }
                    v[s] = e;
               }
        
               // se extrae la raiz, y se reordena el vector y el grupo...
               for(int i = n-1; i>0; i-- )
               {
                    int valori = v[i];
                    v[i] = v[0];
                    int f = 0, s;
                    if( i == 1 ) s = -1; else s = 1;
                    if( i > 2 && v[2] > v[1] )  s = 2;
                    while( s >= 0 && valori < v[s] )
                    {
                          v[f] = v[s];
                          f = s;
                          s = 2*f + 1;
                          if( s + 1 <= i - 1 && v[s] < v[s+1] ) s++;
                          if( s > i - 1 ) s = -1;
                    }
                    v[f] = valori;
               }
        }
    }

    // clase privada para el patrón Strategy: ordenamiento Shell Sort
    private class ShellSort implements Ordenable
    {
        // ordenamiento Shell Sort
        public void ordenar()
        {
               int h, n = v.length;
               for( h = 1; h <= n / 9; h = 3*h + 1 );
               for ( ; h > 0; h /= 3 )
               {
                     for (int j = h; j < n; j++)
                     {
                          int k, y = v[j];
                          for( k = j - h; k >= 0 && y < v[k]; k-=h )
                          {
                                v[k+h] = v[k];
                          }
                          v[k+h] = y;
                     }
               }
        }
    }
    
    /**
     *  Crea un arreglo de tamaño n, y le asigna un ordenador que implementa 
     *  el algoritmo Quick Sort. Si n es menor o igual cero, el arreglo se crea
     *  de tamaño 100.
     *  @param n el tamaño del arreglo a crear.
     */
    public Arreglo( int n )
    {
        if( n <= 0 ) n = 100;
        v = new int[n];
        ordenador = new QuickSort();
    }

    /**
     *  Genera un arreglo con valores aleatorios. 
     */
    public void generar ()
    {
       for( int i=0; i<v.length; i++ )
       {
            v[i] = (int) Math.round(100 * Math.random());
       }
    }

    /**
     *  Verifica si el arreglo está ordenado.
     *  @return true si está ordenado - false si no lo está.
     */
    public boolean verificar ()
    {
       for ( int i=0; i < v.length - 1; i++)
       {
            if (v[i] > v[i+1]) return false;
       }
       return true;
    }
    
    /**
     * Cambia el método de ordenamiento que debe aplicarse sobre el arreglo.
     * @param method un valor que identifica a la versión deseada del método ordenar().
     */
    public void setOrdenador( int method )
    {
        Ordenable ord = null;    
        switch( method )
        {
            case BUBBLE:    ord = new Intercambio(); break;           
            case SELECTION: ord = new Seleccion(); break;
            case INSERTION: ord = new Insercion(); break;
            case QUICK:     ord = new QuickSort(); break;
            case HEAP:      ord = new HeapSort(); break;
            case SHELL:     ord = new ShellSort(); break;
        }
        if( ord != null ) ordenador = ord;
    }
    
    /**
     * Ordena el arreglo.
     */
    public void ordenar()
    {
        ordenador.ordenar();
    }
}
