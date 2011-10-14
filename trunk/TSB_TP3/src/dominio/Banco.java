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
    
    public void AgregarCliente(Cliente c){
        this.clientes.put(c);
    }
    
    public void EliminarCliente(Cliente c){
        this.clientes.remove(c);
    }
    
    
    //agregarCLiente eliminarCliente modificarCliente buscarCliente
}
