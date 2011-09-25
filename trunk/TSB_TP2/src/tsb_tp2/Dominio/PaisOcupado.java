/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp2.Dominio;

/**
 *
 * @author Burgos
 */
public class PaisOcupado implements Comparable{
    private Pais pais;
    private UnidadMilitar unidadMilitar;
    
    public PaisOcupado(Pais pais,UnidadMilitar unidadMilitar){
    this.pais=pais;
    this.unidadMilitar =unidadMilitar;
    }

    PaisOcupado(Comparable pais, Comparable unidadMilitar) {
        this.pais=(Pais) pais;
        this.unidadMilitar =(UnidadMilitar) unidadMilitar;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String toString()
    {
        String aux="";
        aux+=pais.toString()+"\nesta ocupado por: \n"+unidadMilitar.toString();
        return aux;
    }
}
