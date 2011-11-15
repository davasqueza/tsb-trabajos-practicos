/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import tsb_tp3.dominio.Persona;

/**
 *
 * @author Burgos
 */
public class DaoPersona implements IDao<Persona> {

    @Override
    public Persona guardar(Persona t) {
      String sql = "INSERT INTO T_PERSONA (NOMBRE,APELLIDO,FECHANACIMIENTO)  VALUES ('alejandor','Burgos','02/05/1988');";
        
        return null;
    }

    @Override
    public boolean eliminar(int id) {
       String sql= "DELETE FROM T_PERSONA WHERE id="+id+";";
       return false;
    }

    @Override
    public Persona actualizar(Persona t) {
        String sql="UPDATE T_PERSONA SET NOMBRE='"+t.getNombre()+"',APELLIDO='"+t.getApellido()+"' WHERE id='"+t.getId()+"'";
        return null;
    }

    @Override
    public Persona obtener(int idT) {
        String sql="SELECT * FROM T_PERSONA WHERE id="+idT;
        return null;
    }
    
}
