/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp2.Dominio;

import tsb_tp1.LinkedList;
import tsb_tp2.Dominio.Pais;
import tsb_tp2.Dominio.UnidadMilitar;

/**
 *
 * @author Burgos
 */
public class Juego {
    private LinkedList unidadesMilitares;
    private LinkedList paises;
    
    public Juego(){
    this.unidadesMilitares=new LinkedList();
    this.paises=new LinkedList();
    }
    
    public void AgregarPais(Pais p){
        this.paises.addFirst(p);
    }
    
    public void AgregarUnidadMilitar(UnidadMilitar u){
    this.unidadesMilitares.addFirst(u);
    }
    
    public UnidadMilitar elimnarUnidadMilitar(UnidadMilitar u){
    if(this.unidadesMilitares.remove(u))
        return u;
    else return null;
        
    }
    
    public Pais eliminarPais(Pais p){
    if(this.paises.remove(p))
        return p;
    else return null;
    }
    
    public LinkedList obtenerUnidadesConPoderDeFuegoSuperiorA5(){
    return null;
    }
    public LinkedList obtenerListadoDePaisesOcupados(){
    
        LinkedList lista=new LinkedList();
        for(int i=0;this.paises.size()>i;i++){
            if(this.paises.get(i)!=null && this.unidadesMilitares.get(i)!=null)
                lista.add(new PaisOcupado(this.paises.get(i),this.unidadesMilitares.get(i)));
            else break;
        }
        
        return lista;
    }
}
   
