package clases;

import java.util.Iterator;

public class ListaIndexada <C extends Comparable, V extends Comparable> {
    private SimpleList lista;
    private HashTable tabla;
    
    public ListaIndexada() {
        lista = new SimpleList();
        tabla = new HashTable();
    }
    
    public void add(C clave, V valor) {
        Node nodo = lista.addFirst(valor);
        tabla.put(clave, nodo);
    }
    
    public V search(C clave) 
    {
        Comparable resultado = tabla.get(clave);
        if (resultado != null) {
            Node n = (Node)((Pair)resultado).valor;
            return (V)n.getInfo();
        }
        return null;
    }

}
