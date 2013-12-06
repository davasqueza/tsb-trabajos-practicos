package clases;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase para representar un Arbol Binario de B�squeda.
 *
 * @author Ing. Valerio Frittelli
 * @version Septiembre de 2008
 */
public class TreeSearch implements Iterable {

    private NodeTree raiz;

    /**
     * Constructor. Garantiza que el �rbol arranca vac�o
     */
    public TreeSearch() {
        raiz = null;
    }

    /**
     * Busca un objeto en el �rbol y retorna la direcci�n del nodo que lo
     * contiene, o null si no lo encuentra. Se considera que el �rbol es de
     * b�squeda, y por lo tanto no es heterog�neo. Se supone que el m�todo de
     * inserci�n usado para crear el �rbol es el provisto por esta clase, el
     * cual verifica que el �rbol se mantenga homog�neo.
     *
     * @param x el objeto a buscar
     * @return la direcci�n del objeto encontrado que coincide con x, o null si
     * x no se encuentra. Tambi�n sale con null si se detecta que el objeto x no
     * es compatible con el tipo del info en los nodos del �rbol.
     */
    public Comparable search(Comparable x) {
        if (x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) {
            return null;
        }

        NodeTree p = raiz;
        while (p != null) {
            Comparable y = p.getInfo();
            if (x.compareTo(y) == 0) {
                break;
            }
            if (x.compareTo(y) < 0) {
                p = p.getIzquierdo();
            } else {
                p = p.getDerecho();
            }
        }
        return (p != null) ? p.getInfo() : null;
    }

    /**
     * Inserta un objeto en el �rbol. Si el objeto a insertar ya exist�a, no lo
     * inserta y sale retornando false. Si no exist�a, lo inserta y retorna
     * true. El m�todo cuida que el �rbol se mantenga homog�neo, retornando
     * false sin hacer nada si se intenta insertar un objeto cuya clase no
     * coincida con la de los que ya est�n en el �rbol.
     *
     * @return true si el objeto pudo insertarse - false en caso contrario
     * @param x el objeto a insertar
     */
    public boolean add(Comparable x) {

        if (x == null || (raiz != null && x.getClass() != raiz.getInfo().getClass())) {
            return false;
        }

        NodeTree p = raiz, q = null;
        while (p != null) {
            Comparable y = p.getInfo();
            if (x.compareTo(y) == 0) {
                break;
            }

            q = p;
            if (x.compareTo(y) < 0) {
                p = p.getIzquierdo();
            } else {
                p = p.getDerecho();
            }
        }

        // si ya exist�a... retorne false.
        if (p != null) {
            return false;
        }

        // si no exist�a... hay que insertarlo.
        NodeTree nuevo = new NodeTree(x, null, null);
        if (q == null) {
            raiz = nuevo;
        } else {
            if (x.compareTo(q.getInfo()) < 0) {
                q.setIzquierdo(nuevo);
            } else {
                q.setDerecho(nuevo);
            }
        }
        return true;
    }

    /**
     * Redefinici�n de toString
     *
     * @return el contenido del arbol, en secuencia de entre orden, como un
     * String
     */
    public String toString() {
        StringBuffer cad = new StringBuffer("");
        armarEntreOrden(raiz, cad);
        return cad.toString();
    }

    /*
     * // Notar que esto no es javadoc... Recorre en entre orden el arbol, y va
     * armando una cadena con todos los c�digos @param p referencia al nodo que
     * se est� procesando @param cad el StringBuffer que se est� generando, en
     * el cual queda la cadena final
     */
    private void armarEntreOrden(NodeTree p, StringBuffer cad) {
        if (p != null) {
            armarEntreOrden(p.getIzquierdo(), cad);
            cad = cad.append(p.getInfo().toString() + " ");
            armarEntreOrden(p.getDerecho(), cad);
        }
    }

    public void imprimir() {
        recorrer(raiz);
    }

    private void recorrer(NodeTree raiz) {
        if (raiz != null) {
            recorrer(raiz.getIzquierdo());
            System.out.println(raiz.getInfo());
            recorrer(raiz.getDerecho());
        }
    }

    
    
    
    private void recorrerInsertar(NodeTree raiz, LinkedList lista) {
        if (raiz != null) {
            recorrerInsertar(raiz.getIzquierdo(), lista);
            lista.add(raiz.getInfo());
            recorrerInsertar(raiz.getDerecho(), lista);
        }
    }

    
    public Iterator iterator() {
        LinkedList lista = new LinkedList();
        
        recorrerInsertar(raiz, lista);
        
        return lista.iterator();
    }
    
    private void recorrerInsertarDecreciente(NodeTree raiz, LinkedList lista) {
        if (raiz != null) {
            recorrerInsertarDecreciente(raiz.getDerecho(), lista);
            lista.add(raiz.getInfo());
            recorrerInsertarDecreciente(raiz.getIzquierdo(), lista);
        }
    }

    
    public Iterator iteratorDecreciente() {
        LinkedList lista = new LinkedList();
        recorrerInsertarDecreciente(raiz, lista);
        return lista.iterator();
    }
        
}
