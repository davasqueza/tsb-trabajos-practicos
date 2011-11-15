/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import tsb_tp3.dominio.Pedido;

/**
 *
 * @author Burgos
 */
public class DaoPedido implements IDao<Pedido>{

    @Override
    public Pedido guardar(Pedido t) {
        String sql = "INSERT INTO T_PEDIDO (ID_CLIENTE,FECHA)  VALUES ('"+t.getCliente().getId()+"','"+t.getFecha()+"');";
       return null;
    }

    @Override
    public boolean eliminar(int id) {
       String sql= "DELETE FROM T_PEDIDO WHERE id="+id+";";
       return false;
    }

    @Override
    public Pedido actualizar(Pedido t) {
        String sql="UPDATE T_PEDIDO SET ID_CLIENTE='"+t.getCliente().getId()+"',FECHA='"+t.getFecha()+"' WHERE id='"+t.getId()+"'";
        return null;
    }

    @Override
    public Pedido obtener(int idT) {
         String sql="SELECT * FROM T_PEDIDO WHERE id="+idT;
        return null;
    }
    
}
