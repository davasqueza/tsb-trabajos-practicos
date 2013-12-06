package clases;

public class Pair <C extends Comparable, V extends Comparable> implements Comparable {
    public C clave;
    public V valor;
    
    public Pair(C clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public int compareTo(Object o) {
        Pair p = (Pair)o;
        return clave.compareTo(p.clave);
    }
}
