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

    public Banco() {
        this.clientes = new HashTable();
    }

    public HashTable getClientes() {
        return clientes;
    }

    public void setClientes(HashTable clientes) {
        this.clientes = clientes;
    }
    
    public void agregarCliente(Cliente c){
        this.clientes.put(c);
    }
    
    public void eliminarCliente(Cliente c){
        this.clientes.remove(c);
    }
    
    public boolean esCliente(Cliente c)
    {
        if(clientes.contains(c))
            return true;
        else      
            return false;
    }
   
}
