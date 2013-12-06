/**
 * Clase para representar un Arbol Binario de Búsqueda.
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008 
 */
public class TreeSearch
{
    private NodeTree raiz;
        
    /**
      Constructor. Garantiza que el árbol arranca vacío
    */
    public TreeSearch ()
    {
       raiz = null;
    }
    
    /**
      Busca un objeto en el árbol y retorna la dirección del nodo que lo contiene,
      o null si no lo encuentra. Se considera que el árbol es de búsqueda, y por lo
      tanto no es heterogéneo. Se supone que el método de inserción usado para
      crear el árbol es el provisto por esta clase, el cual verifica que el árbol se
      mantenga homogéneo.
      @param x el objeto a buscar
      @return la dirección del objeto encontrado que coincide con x, o null si x no se 
              encuentra. También sale con null si se detecta que el objeto x no es 
              compatible con el tipo del info en los nodos del árbol.
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
    

    /**
      Inserta un objeto en el árbol. Si el objeto a insertar ya existía, no lo inserta y sale
      retornando false. Si no existía, lo inserta y retorna true. El método cuida que el árbol 
      se mantenga homogéneo, retornando false sin hacer nada si se intenta insertar un objeto 
      cuya clase no coincida con la de los que ya están en el árbol.
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
       
       // si ya existía... retorne false.
       if (p != null) return false;
       
       // si no existía... hay que insertarlo.
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
      Redefinición de toString
      @return el contenido del arbol, en secuencia de entre orden, como un String
    */
    public String toString()
    {
       StringBuffer cad = new StringBuffer("");
       armarEntreOrden(raiz, cad);
       return cad.toString();       
    }

    /*
      // Notar que esto no es javadoc... 
      Recorre en entre orden el arbol, y va armando una cadena con todos los códigos
      @param p referencia al nodo que se está procesando
      @param cad el StringBuffer que se está generando, en el cual queda la cadena final
    */
    private void armarEntreOrden (NodeTree p, StringBuffer cad)
    {
      if (p != null) 
      {
        armarEntreOrden (p.getIzquierdo(), cad);
        cad = cad.append(p.getInfo().toString() + " ");         
        armarEntreOrden (p.getDerecho(), cad);
      }
    }
}
