/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import tsb_tp3.dominio.Usuario;

/**
 *
 * @author Burgos
 */
public class DaoUsuario implements IDao<Usuario> {

    @Override
    public Usuario guardar(Usuario t) {
       String sql = "INSERT INTO T_USUARIO (NOMBRE,PASSWORD,ID_PERSONA)  VALUES ('"+t.getNombre()+"','"+t.getPassword()+"',"+t.getPersona().getId()+");";
       return null;
    }

    @Override
    public boolean eliminar(int id) {
        String sql= "DELETE FROM T_USUARIO WHERE id="+id+";";
       return false;
    }

    @Override
    public Usuario actualizar(Usuario t) {
         String sql="UPDATE T_USUARIO SET NOMBRE='"+t.getNombre()+"',PASSWORD='"+t.getPassword()+"',ID_PERSONA='"+t.getPersona().getId()+"' WHERE id='"+t.getId()+"'";
        return null;
    }

    @Override
    public Usuario obtener(int idT) {
         String sql="SELECT * FROM T_USUARIO WHERE id="+idT;
        return null;
    }
    
}
