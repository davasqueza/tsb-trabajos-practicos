package clases;

/**
 * Clase para representar un Arbol AVL.
 * @author Ing. Valerio Frittelli.
 * @version Septiembre de 2008.
 */
public class AVLTreeSearch extends TreeSearch
{
    private boolean h;   // usada como auxiliar en algunos m�todos recursivos

    /**
     * Constructor por default. 
     */
    public AVLTreeSearch ()
    {
    }
    
    /**
      Inserta un objeto x en el arbol, rebalanceando en caso de desequilibrio. Si el objeto ya existia, no lo inserta.
      @param x el objeto a insertar.
      @return true si la insercion pudo hacerse.
    */
    public boolean add (Comparable x)
    {
      if (x != null)
      {
          // controlamos que la insercion sea homogenea
          if (getRaiz() != null && x.getClass()!= getRaiz().getInfo().getClass()) return false;
          
          h = false; // h = false significa: la altura no ha crecido
          setRaiz( insAvl(getRaiz(), x) );
          return true;
      }
      return false;
    }

    /**
     * Borra un nodo del TreeSearchTreeSearch, rebalanceando.
     * @param x el objeto a borrar
     * @return true si el borrado tuvo exito.
     */
    public boolean remove(Comparable x)
    {
      if (x != null)
      {
          // controlamos que la operacion sea homogenea
          if (getRaiz() != null && x.getClass() != getRaiz().getInfo().getClass()) return false;
    
          h = false; // usamos h del mismo modo que en la insercion
          setRaiz( sacar (getRaiz(), x) );
          return true;
      }
      return false;
    }

    /**
     * Recorre el arbol en forma recursiva, inserta y rebalancea
     * @param p direccion del nodo actual
     * @param x clave a insertar
     */
    private NodeTree insAvl (NodeTree p, Comparable x)
    {
      NodeTree p1, p2;
      if (p == null) 
      {
        // la clave no existe... insertarla
        p = new AVLNodeTree (x, null, null);
        h = true;  // la altura del subarbol crecio
      }
      else
      {
       if (x.compareTo(p.getInfo()) < 0) 
       {
        p.setIzquierdo( insAvl(p.getIzquierdo(), x) );
        if (h == true) 
        {
         // la rama izquierda crecio
         switch( ((AVLNodeTree)p).getEquilibrio() )
         {
           case  1: ((AVLNodeTree)p).setEquilibrio(0);
                    h = false;
                    break;

           case  0: ((AVLNodeTree)p).setEquilibrio(-1);
                    break;

           case -1: //reequilibrar
                    p1 = p.getIzquierdo();
                    if ( ((AVLNodeTree)p1).getEquilibrio() == -1 )
                    {
                      p.setIzquierdo(p1.getDerecho());
                      p1.setDerecho(p);
                      ((AVLNodeTree)p).setEquilibrio(0);
                      p = p1;
                    }
                    else
                    {
                      p2 = p1.getDerecho();
                      p1.setDerecho(p2.getIzquierdo());
                      p2.setIzquierdo(p1);
                      p.setIzquierdo(p2.getDerecho());
                      p2.setDerecho(p);
                      if (((AVLNodeTree)p2).getEquilibrio() == -1)((AVLNodeTree)p).setEquilibrio(1); else ((AVLNodeTree)p).setEquilibrio(0);
                      if (((AVLNodeTree)p2).getEquilibrio() == 1) ((AVLNodeTree)p1).setEquilibrio(-1); else ((AVLNodeTree)p1).setEquilibrio(0);
                      p = p2;
                    }
                    ((AVLNodeTree)p).setEquilibrio(0);
                    h = false;
                    break;
         }// fin switch...
        }// fin if (h == true)
       }// fin rama true del if (x < p.cod)...
       else 
       { 
        if (x.compareTo(p.getInfo()) > 0) 
        {
          p.setDerecho( insAvl (p.getDerecho(), x) );
          if (h == true) 
          {
           // la rama derecha crecio...
           switch (((AVLNodeTree)p).getEquilibrio()) 
           {
               case -1: ((AVLNodeTree)p).setEquilibrio(0);
                        h = false;
                        break;

               case  0: ((AVLNodeTree)p).setEquilibrio(1);
                        break;

               case  1: //reequilibrar..
                        p1 = p.getDerecho();
                        if (((AVLNodeTree)p1).getEquilibrio() == 1) 
                        {
                          p.setDerecho(p1.getIzquierdo());
                          p1.setIzquierdo(p);
                          ((AVLNodeTree)p).setEquilibrio(0);
                          p = p1;
                        }
                        else 
                        {
                          p2 = p1.getIzquierdo();
                          p1.setIzquierdo(p2.getDerecho());
                          p2.setDerecho(p1);
                          p.setDerecho(p2.getIzquierdo());
                          p2.setIzquierdo(p);
                          if (((AVLNodeTree)p2).getEquilibrio() ==  1) ((AVLNodeTree)p).setEquilibrio(-1); else ((AVLNodeTree)p).setEquilibrio(0);
                          if (((AVLNodeTree)p2).getEquilibrio() == -1) ((AVLNodeTree)p1).setEquilibrio(1); else ((AVLNodeTree)p1).setEquilibrio(0);
                          p = p2;
                        }
                        ((AVLNodeTree)p).setEquilibrio(0);
                        h = false;
                        break;
           }// fin switch...
          }// fin del true de if (h == true)...
        } // fin rama true de if (x > p.cod)...
        else 
        {   // la clave ya existe... 
            h = false;   // pues la altura no cambia...
        } // fin del else de if (x > p.cod)...
       }// fin del else de if (x < p.info)...
      }// fin del else de if (p == NULL)...
      return p;
    }

    /**
     * Recorre el arbol recursivamente, borra el nodo con el objeto x (si existe) y rebalancea si es necesario
     * @param p direccion del nodo actual
     * @param x objeto a borrar
     * @return direccion de la nueva raiz del arbol
     */
    private NodeTree sacar (NodeTree p, Comparable x)
    {
      if (p == null) 
      {
        // x no existe... no hace nada
        h = false;
      }
      else
      {
       if (x.compareTo(p.getInfo()) < 0)
       {
         p.setIzquierdo( sacar (p.getIzquierdo(), x) );
         if (h == true) p = equilibrar1 (p);
       }
       else 
       {
         if (x.compareTo(p.getInfo()) > 0) 
         {
           p.setDerecho( sacar (p.getDerecho(), x) );
           if (h == true) p = equilibrar2 (p);
         }
         else 
         {
          // nodo encontrado... borrarlo
          if (p.getDerecho() == null) 
          {
            p = p.getIzquierdo();
            h = true;
          }
          else 
          {
            if (p.getIzquierdo() == null) 
            {
              p = p.getDerecho();
              h = true;
            }
            else 
            {
              // tiene dos hijos!!!
              p.setIzquierdo( bor (p.getIzquierdo(), p) );
              if (h == true) p = equilibrar1 (p);
            }
          }
         }
       }
      }
      return p;
    }

    /**
      Metodo auxiliar para eliminar el nodo si tiene dos hijos
      @param d nodo actual
      @param q nodo original a borrar
      @return direcci�n de la nueva raiz del arbol
    */
    private NodeTree bor (NodeTree d, NodeTree q)
    {
      if (d.getDerecho() != null) 
      {
        d.setDerecho( bor (d.getDerecho(), q) );
        if (h == true) d = equilibrar2 (d);
      }
      else
      {
           q.setInfo(d.getInfo());
           d = d.getIzquierdo();
           h = true;
      }
      return d;
    }

    /**
      Auxiliar de reequilibrado
      @param p direccion del nodo a reequilibrar
      @return nueva raiz del �rbol
    */
    private NodeTree equilibrar1 (NodeTree p)
    {
      NodeTree p1, p2;
      int e1, e2;
      switch ( ((AVLNodeTree)p).getEquilibrio() )
      {
       case -1:  ((AVLNodeTree)p).setEquilibrio(0);
                 break;

       case  0:  ((AVLNodeTree)p).setEquilibrio(1);
                 h = false;
                 break;

       case  1:  p1 = p.getDerecho();
                 e1 = ((AVLNodeTree)p1).getEquilibrio();
                 if (e1 >= 0) 
                 {
                   p.setDerecho(p1.getIzquierdo());
                   p1.setIzquierdo(p);
                   if (e1 == 0) 
                   {
                     ((AVLNodeTree)p).setEquilibrio(1);
                     ((AVLNodeTree)p1).setEquilibrio(-1);
                     h = false;
                   }
                   else 
                   {
                     ((AVLNodeTree)p).setEquilibrio(0);
                     ((AVLNodeTree)p1).setEquilibrio(0);
                   }
                   p = p1;
                 }
                 else 
                 {
                   p2 = p1.getIzquierdo();
                   e2 = ((AVLNodeTree)p2).getEquilibrio();
                   p1.setIzquierdo(p2.getDerecho());
                   p2.setDerecho(p1);
                   p.setDerecho(p2.getIzquierdo());
                   p2.setIzquierdo(p);
                   if (e2 ==  1) ((AVLNodeTree)p).setEquilibrio(-1); else ((AVLNodeTree)p).setEquilibrio(0);
                   if (e2 == -1) ((AVLNodeTree)p1).setEquilibrio(1); else ((AVLNodeTree)p1).setEquilibrio(0);
                   p = p2;
                   ((AVLNodeTree)p2).setEquilibrio(0);
                 }
                 break;
        } // fin switch...
        return p;
    }

    /**
     * Auxiliar de reequilibrado
     * @param p direccion del nodo a reequilibrar
     * @return nueva raiz del arbol
     */
    private NodeTree equilibrar2 (NodeTree p)
    {
      NodeTree p1, p2;
      int e1, e2;
      switch (((AVLNodeTree)p).getEquilibrio())
      {
       case  1:  ((AVLNodeTree)p).setEquilibrio(0);
                 break;

       case  0:  ((AVLNodeTree)p).setEquilibrio(-1);
                 h = false;
                 break;

       case -1:  p1 = p.getIzquierdo();
                 e1 = ((AVLNodeTree)p1).getEquilibrio();
                 if (e1 <= 0) 
                 {
                    p.setIzquierdo(p1.getDerecho());
                    p1.setDerecho(p);
                    if (e1 == 0) 
                    {
                        ((AVLNodeTree)p).setEquilibrio(-1);
                        ((AVLNodeTree)p1).setEquilibrio(1);
                        h = false;
                    }
                    else 
                    {
                        ((AVLNodeTree)p).setEquilibrio(0);
                        ((AVLNodeTree)p1).setEquilibrio(0);
                    }
                    p = p1;
                 }
                 else 
                 {
                    p2 = p1.getDerecho();
                    e2 = ((AVLNodeTree)p2).getEquilibrio();
                    p1.setDerecho(p2.getIzquierdo());
                    p2.setIzquierdo(p1);
                    p.setIzquierdo(p2.getDerecho());
                    p2.setDerecho(p);
                    if (e2 == -1) ((AVLNodeTree)p).setEquilibrio(1); else ((AVLNodeTree)p).setEquilibrio(0);
                    if (e2 ==  1) ((AVLNodeTree)p1).setEquilibrio(-1); else ((AVLNodeTree)p1).setEquilibrio(0);
                    p = p2;
                    ((AVLNodeTree)p2).setEquilibrio(0);
                 }
                 break;
      } // fin switch...
      return p;
    }
}
