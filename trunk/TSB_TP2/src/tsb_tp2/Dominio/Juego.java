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
}
