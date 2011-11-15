/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import tsb_tp3.dominio.Servicio;

/**
 *
 * @author Burgos
 */
public class DaoServicio implements IDao<Servicio>{

    @Override
    public Servicio guardar(Servicio t) {
       String sql = "INSERT INTO T_SERVICIO (NOMBRE,PASSWORD,ID_PERSONA)  VALUES ('"+t.getNombre()+"')";
       return null;
    }

    @Override
    public boolean eliminar(int id) {
           String sql= "DELETE FROM T_SERVICIO WHERE id="+id+";";
       return false;
    }

    @Override
    public Servicio actualizar(Servicio t) {
      String sql="UPDATE T_SERVICIO SET NOMBRE='"+t.getNombre()+"' WHERE id='"+t.getId()+"'";
        return null;
    }

    @Override
    public Servicio obtener(int idT) {
         String sql="SELECT * FROM T_SERVICIO WHERE id="+idT;
        return null;
    }
    
}
