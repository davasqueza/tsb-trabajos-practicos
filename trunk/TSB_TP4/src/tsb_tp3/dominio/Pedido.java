/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Burgos
 */
public class Pedido {
    private int id;
    private List<DetallePedido> pedidos;
    private Date fecha;
    private Persona cliente;

    
    public Pedido(){
    pedidos=new ArrayList<DetallePedido>();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pedidos
     */
    public List<DetallePedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<DetallePedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Persona getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    public void addDetallePedido(DetallePedido dp){
    this.pedidos.add(dp);
    }
}
