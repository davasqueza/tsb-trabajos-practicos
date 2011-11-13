/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

/**
 *
 * @author Burgos
 */
public interface IDao<T> {
    public T guardar(T t);
    public boolean eliminar(int id);
    public T actualizar(T t);
    public T obtener(int idT);
}
