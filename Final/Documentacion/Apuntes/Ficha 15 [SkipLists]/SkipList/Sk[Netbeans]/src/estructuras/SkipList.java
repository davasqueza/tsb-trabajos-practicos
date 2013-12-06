package estructuras;

/**
 * Implementa el concepto de SkipList (Lista de Saltos).
 *
 * @author Ing. Bett - Ing. Frittelli - Catedra de TSB.
 * @version Agosto de 2012.
 */
public class SkipList {

    /**
     * El numero maximo de niveles que por defecto tendra una SkipList.
     */
    public static final int MAX_LEVEL = 18;
    private final Node frente;
    private int cantidad;
    private int level;

    /**
     * Crea una SkipList vacia, con MAX_LEVEL niveles de capacidad.
     */
    public SkipList() {
        this(MAX_LEVEL);
    }

    /**
     * Crea una SkipList vacia, con ml niveles de capacidad. En general, la
     * cantidad de niveles optima que deberia tener una SkipList, puede
     * calcularse como ml = log2(N), siendo N una cota superior para la cantidad
     * de datos n que se espera almacenar.
     *
     * @param ml la cantidad maxima de niveles que tendra la SkipList.
     */
    public SkipList(int ml) {
        frente = new Node(ml, null);
        cantidad = 0;
        level = 0;
    }

    /**
     * Inserta un nuevo objeto en la SkipList. Recuerde que en esencia una
     * SkipList es una lista ordenada, por lo que el objeto data se insertara de
     * forma que la SkipList permanezca ordenada. Si el objeto data a insertar
     * ya existe en la SkipList, entonces el objeto data reemplazar� al que
     * exist�a previamente (en otras palabras: la SkipList no contendr� dos
     * nodos con objetos iguales). Tiempo de ejecuci�n esperado: O(log(n)).
     *
     * @param data el objeto a insertar en la SkipList.
     */
    public void add(Comparable data) {
        if (!isHomogeneus(data)) {
            return;
        }

        int i, newLevel;
        Node x = frente;
        Node[] update = new Node[MAX_LEVEL + 1];
        for (i = level; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).getInfo().compareTo(data) < 0) {
                x = x.getNext(i);
            }
            update[i] = x;
        }

        x = x.getNext(0);
        if (x != null && x.getInfo().compareTo(data) == 0) {
            // esta repetido
            x.setInfo(data);
        } else { // no esta repetido
            newLevel = randomLevel();
            if (newLevel > level) {
                for (i = level + 1; i <= newLevel; i++) {
                    update[i] = frente;
                }
                level = newLevel;
            }
            x = new Node(newLevel, data);
            for (i = 0; i <= newLevel; i++) {
                x.setNext(update[i].getNext(i), i);
                update[i].setNext(x, i);
            }
            cantidad++;
        }
    }

    /**
     * Remueve todos los elementos de la SkipList y la deja vacia. Se mantiene
     * el numero maximo de niveles que se uso para crear la SkipList.
     */
    public void clear() {
        for (int i = 0; i <= MAX_LEVEL; i++) {
            frente.setNext(null, i);
        }
        cantidad = 0;
        level = 0;
    }

    /**
     * Determina si el objeto data esta en la SkipList (o sea: realiza un test
     * de pertenencia).
     *
     * @param data el objeto a buscar.
     * @return true si data esta en la SkipList - false en caso contrario.
     */
    public boolean contains(Comparable data) {
        return (this.search(data) != null);
    }

    /**
     * Permite determinar la SkipList esta vacia.
     *
     * @return true si la SkipList esta vacia.
     */
    public boolean isEmpty() {
        return (cantidad == 0);
    }

    /**
     * Elimina el objeto data de la SkipList. Tiempo de ejecuci�n esperado:
     * O(log(n)).
     *
     * @param data el objeto a eliminar.
     */
    public void remove(Comparable data) {
        if (!isHomogeneus(data)) {
            return;
        }

        int i;
        Node x = frente;
        Node[] update = new Node[MAX_LEVEL];
        for (i = level; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).getInfo().compareTo(data) < 0) {
                x = x.getNext(i);
            }
            update[i] = x;
        }

        x = x.getNext(0);
        if (x != null && x.getInfo().compareTo(data) == 0) {
            for (i = 0; i <= level; i++) {
                if (update[i].getNext(i) != x) {
                    break;
                }
                update[i].setNext(x.getNext(i), i);
            }
            x = null;
            while (level > 0 && frente.getNext(level) == null) {
                level--;
            }
            cantidad--;
        }
    }

    /**
     * Busca el objeto data en la SkipList. Si lo encuentra, retorna el objeto
     * que estaba en la SkipList (que segun compareTo era igual a data). Si no
     * lo encuentra, retorna null.
     *
     * @param data el objeto a buscar.
     * @return el objeto que estaba en la SkipList y era igual a data (si data
     * estaba en la SkipList, o null si data no estaba.
     */
    public Comparable search(Comparable data) {
        if (!isHomogeneus(data)) {
            return null;
        }

        Node x = frente;
        int i;
        for (i = level; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).getInfo().compareTo(data) < 0) {
                x = x.getNext(i);
            }
        }
        x = x.getNext(0);
        if (x != null && x.getInfo().compareTo(data) == 0) {
            return x.getInfo();
        }
        return null;
    }

    /**
     * Retorna la cantidad de elementos contenidos en la SkipList.
     *
     * @return el tama�o de la SkipList.
     */
    public int size() {
        return cantidad;
    }

    /**
     * Retorna una cadena con la conversion a String de la SkipList completa, en
     * orden de menor a mayor.
     *
     * @return la conversion a String de la SkipList.
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder r = new StringBuilder("[ ");
        Node p = frente.getNext(0);
        while (p != null) {
            r.append(p.toString());
            if (p.getNext(0) != null) {
                r.append(" - ");
            }
            p = p.getNext(0);
        }
        r.append(" ]");
        return r.toString();
    }

    private boolean isHomogeneus(Comparable x) {
        if (x == null) {
            return false;
        }
        if (frente.getInfo() != null && x.getClass() != frente.getInfo().getClass()) {
            return false;
        }
        return true;
    }

    private int randomLevel() {
        float p = 0.5f;
        int newLevel = 0;
        while (Math.random() < p) {
            newLevel++;
        }
        if (newLevel < MAX_LEVEL) {
            return newLevel;
        }
        return MAX_LEVEL;
    }
}
