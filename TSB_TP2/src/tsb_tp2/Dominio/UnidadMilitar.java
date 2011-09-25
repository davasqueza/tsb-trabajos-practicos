/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp2.Dominio;

/**
 *
 * @author Burgos
 */
public class UnidadMilitar implements Comparable{
    private int poderDeFuego;
    private int numero;
    private String nombre;

    /**
     * @return the poderDeFuego
     */
    public int getPoderDeFuego() {
        return poderDeFuego;
    }

    /**
     * @param poderDeFuego the poderDeFuego to set
     */
    public void setPoderDeFuego(int poderDeFuego) {
        this.poderDeFuego = poderDeFuego;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Object o) {
        UnidadMilitar um=(UnidadMilitar)o;
        return (this.poderDeFuego-um.poderDeFuego);
    }
    
    public String toString()
    {
        String aux="";
        aux+="Numero: "+numero+"\n";
        aux+="Unidad: "+nombre+"\n";
        aux+="Poder: "+poderDeFuego+"\n";
        aux+="----------------------------------------------";
        return aux;
    }
}
