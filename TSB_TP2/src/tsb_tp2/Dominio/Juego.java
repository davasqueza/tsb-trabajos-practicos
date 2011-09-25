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
    private static int numeroPais=0;
    private static int numeroUnidadMilitar=0;
    public Juego(){
    this.unidadesMilitares=new LinkedList();
    this.paises=new LinkedList();
    }
    
    public void AgregarPais(Pais p){
        this.paises.addFirst(p);
          Juego.numeroPais++;
    }
    
    public void AgregarUnidadMilitar(UnidadMilitar u){
        this.unidadesMilitares.addFirst(u);
        Juego.numeroUnidadMilitar++;
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
        int cont=0;
        int size=this.unidadesMilitares.size();
        LinkedList lista=new LinkedList();
        do
        {
            UnidadMilitar um = (UnidadMilitar)this.unidadesMilitares.getNode(cont).getInfo();
            if(um.getPoderDeFuego()>5)
                lista.add(um);
            cont++;
        }while(cont<size);
        return lista;
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
    
    public int getNumeroPais(){
    return Juego.numeroPais;
    }
    public int getNumeroUnidadMilitar(){
    return Juego.numeroUnidadMilitar;
    }
    
}
   

