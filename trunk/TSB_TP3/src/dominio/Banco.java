/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Franco
 */
public class Banco {
    
    private HashTable clientes;
    private TreeSearch arbol;

    public Banco() {
        this.clientes = new HashTable();
        this.arbol= new TreeSearch ();
    }

    public TreeSearch getArbol() {
        return arbol;
    }

    public void setArbol(TreeSearch arbol) {
        this.arbol = arbol;
    }

    public HashTable getClientes() {
        return clientes;
    }

    public void setClientes(HashTable clientes) {
        this.clientes = clientes;
    }
    
    public void agregarCliente(Cliente c){
        this.clientes.put(c);
        this.arbol.add(c);
    }
    
    public void eliminarCliente(Cliente c){
        this.clientes.remove(c);
        this.arbol.remove(c);
    }
    
    public boolean esCliente(Comparable c)
    {
        return clientes.contains(c);
    }
    
    public Cliente buscarCliente(Comparable c)
    {
        return (Cliente)clientes.get(c);
    }
    
    public String mostrarClientes(int n)
    {
        if(n==1)
            return arbol.toPostOrdenString();
        else
            return arbol.toPreOrdenString();
    }
   
}
