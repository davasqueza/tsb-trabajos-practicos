package clases;

/**
 * Clase para representar un Arbol Binario de B�squeda.
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008 
 */
public class TreeSearch
{
    private NodeTree raiz;
        
    /**
      Constructor. Garantiza que el �rbol arranca vac�o
    */
    public TreeSearch ()
    {
       raiz = null;
    }

    /**
     * Retorna la direcci�n del nodo raiz.
     * @return un referencia al nodo raiz.
     */
    public NodeTree getRaiz()
    {
        return raiz;   
    }
    
    /**
     * Cambia la direcci�n del nodo raiz.
     * @param r la referencia al nuevo nodo raiz.
     */
    public void setRaiz(NodeTree r)
    {
        raiz = r;
    }
    
    /**
      Busca un objeto en el �rbol y retorna la direcci�n del nodo que lo contiene,
      o null si no lo encuentra. Se considera que el �rbol es de b�squeda, y por lo
      tanto no es heterog�neo. Se supone que el m�todo de inserci�n usado para
      crear el �rbol es el provisto por esta clase, el cual verifica que el �rbol se
      mantenga homog�neo.
      @param x el objeto a buscar
      @return la direcci�n del objeto encontrado que coincide con x, o null si x no se 
              encuentra. Tambi�n sale con null si se detecta que el objeto x no es 
              compatible con el tipo del info en los nodos del �rbol.
    */
    public Comparable search (Comparable x)
    {
       if(x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) return null;
        
       NodeTree p = raiz;
       while (p != null)
       {
              Comparable y = p.getInfo();
              if (x.compareTo(y) == 0) { break; }
              if (x.compareTo(y) <  0) { p = p.getIzquierdo(); }
              else { p = p.getDerecho(); }
       }
       return (p != null)? p.getInfo() : null;
    }
    
    public int searchCount (Comparable x)
    {
       if(x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) return -1;
       int c = 0;
       NodeTree p = raiz;
       while (p != null)
       {
              c++;
              Comparable y = p.getInfo();
              if (x.compareTo(y) == 0) { break; }
              if (x.compareTo(y) <  0) { p = p.getIzquierdo(); }
              else { p = p.getDerecho(); }
       }
       return (p != null)? c: -1;
    }
    
    private int h = 0;
    public int height() {
        h = 0;
        calcHeight(raiz, 1);
        return h;
    }
    
    private void calcHeight(NodeTree p, int l) 
    {
      if (p != null) 
      {
        if (l > h) h = l;
        calcHeight (p.getIzquierdo(), l+1);
        calcHeight (p.getDerecho(), l+1);
      }
    }
    
    /**
      Inserta un objeto en el �rbol. Si el objeto a insertar ya exist�a, no lo inserta y sale
      retornando false. Si no exist�a, lo inserta y retorna true. El m�todo cuida que el �rbol 
      se mantenga homog�neo, retornando false sin hacer nada si se intenta insertar un objeto 
      cuya clase no coincida con la de los que ya est�n en el �rbol.
      @return true si el objeto pudo insertarse - false en caso contrario
      @param x el objeto a insertar
    */
    public boolean add (Comparable x)
    {

       if(x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) return false;

       NodeTree p = raiz, q = null;
       while (p != null)
       {
            Comparable y = p.getInfo();
            if( x.compareTo(y) == 0 ) { break; }
            
            q = p;
            if ( x.compareTo(y) < 0 ) { p = p.getIzquierdo(); }
            else { p = p.getDerecho(); }
       }
       
       // si ya exist�a... retorne false.
       if (p != null) return false;
       
       // si no exist�a... hay que insertarlo.
       NodeTree nuevo = new NodeTree(x, null, null);
       if (q == null) { raiz = nuevo; }
       else 
       {
          if ( x.compareTo(q.getInfo() ) < 0) { q.setIzquierdo(nuevo); }
          else { q.setDerecho(nuevo); }
       }
       return true;
    }

    /**
      Borra el nodo del Arbol que contiene al objeto x. Si el objeto x no es compatible con la
      clase de los nodos del �rbol, el m�todo sale sin hacer nada y retorna false.
      @param x el objeto a borrar.
      @return true si la eliminaci�n pudo hacerse, o false en caso contrario.
    */
    public boolean remove (Comparable x)
    {
       if(x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) return false;
       
       raiz = eliminar (raiz, x);
       return true;
    }

    /**
      Redefinici�n de toString
      @return el contenido del arbol, en secuencia de entre orden, como un String
    */
    public String toString()
    {
       StringBuffer cad = new StringBuffer("");
       armarEntreOrden(raiz, cad);
       return cad.toString();       
    }

    /**
      Genera un String con el contenido del arbol en pre orden 
      @return el contenido del arbol, en secuencia de pre orden, como un String
    */
    public String toPreOrdenString()
    {
       StringBuffer cad = new StringBuffer("");
       armarPreOrden(raiz, cad);
       return cad.toString();       
    }

    /**
      Genera un String con el contenido del arbol en entre orden. Genera el mismo String que el 
      m�todo toString() redefinido en la clase
      @return el contenido del arbol, en secuencia de entre orden, como un String
    */
    public String toEntreOrdenString()
    {
       return this.toString();
    }

    /**
      Genera un String con el contenido del arbol en post orden 
      @return el contenido del arbol, en secuencia de post orden, como un String
    */
    public String toPostOrdenString()
    {
       StringBuffer cad = new StringBuffer("");
       armarPostOrden(raiz, cad);
       return cad.toString();       
    }

    private void armarPreOrden (NodeTree p, StringBuffer cad)
    {
      if (p != null) 
      {
        cad = cad.append(p.getInfo().toString() + " ");         
        armarPreOrden (p.getIzquierdo(), cad);
        armarPreOrden (p.getDerecho(), cad);
      }
    }

    private void armarEntreOrden (NodeTree p, StringBuffer cad)
    {
      if (p != null) 
      {
        armarEntreOrden (p.getIzquierdo(), cad);
        cad = cad.append(p.getInfo().toString() + " ");         
        armarEntreOrden (p.getDerecho(), cad);
      }
    }

    private void armarPostOrden (NodeTree p, StringBuffer cad)
    {
      if (p != null) 
      {
        armarPostOrden (p.getIzquierdo(), cad);
        armarPostOrden (p.getDerecho(), cad);
        cad = cad.append(p.getInfo().toString() + " ");         
      }
    }

    /*
      Auxiliar del m�todo de borrado. Borra un nodo que contenga al objeto x si el mismo 
      tiene un hijo o ninguno.
      @param p nodo que est� siendo procesado
      @param x Objeto a borrar
      @return direcci�n del nodo que qued� en lugar del que ven�a en "p" al comenzar el proceso
    */
    private NodeTree eliminar (NodeTree p, Comparable x)
    {
       if (p != null)
       {
         Comparable y = p.getInfo();
         if ( x.compareTo(y) < 0 ) 
         { 
             NodeTree  menor = eliminar(p.getIzquierdo(), x);
             p.setIzquierdo(menor);   
         }
         else
         {
              if ( x.compareTo(y) > 0 ) 
              { 
                 NodeTree mayor = eliminar (p.getDerecho(), x);
                 p.setDerecho(mayor); 
              } 
              else
              {  
                 // Objeto encontrado... debe borrarlo.
                 if (p.getIzquierdo() == null) { p = p.getDerecho(); }
                 else
                 {
                    if (p.getDerecho() == null) { p = p.getIzquierdo(); }
                    else 
                    {
                        // Tiene dos hijos... que lo haga otra!!!
                        NodeTree dos = dosHijos(p.getIzquierdo(), p);
                        p.setIzquierdo(dos);
                    }
                 }
              }
         }
       }
       return p;
    }
    
    /*
      Auxiliar del m�todo de borrado. Reemplaza al nodo que ven�a en "p" por su mayor descendiente izquierdo "d", 
      y luego borra a "d" de su posici�n original
      @param d nodo que est� siendo procesado
      @param p nodo a reemplazar por d
      @return direcci�n del nodo que qued� en lugar del que ven�a en "d" al comenzar el proceso.
    */    
    private NodeTree dosHijos (NodeTree d, NodeTree p)
    {
       if (d.getDerecho() != null) 
       { 
         NodeTree der = dosHijos(d.getDerecho(), p);
         d.setDerecho(der); 
       }
       else 
       {
         p.setInfo(d.getInfo());
         d = d.getIzquierdo();
       }
       return d;
    }
}
