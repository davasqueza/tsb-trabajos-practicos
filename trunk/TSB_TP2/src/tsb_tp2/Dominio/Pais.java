/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp2.Dominio;

/**
 *
 * @author Burgos
 */
public class Pais implements Comparable{
    private int numero;
    private String nombre;
    private Continente continente;

    public Pais(int numero, String nombre, Continente continente) {
        this.numero = numero;
        this.nombre = nombre;
        this.continente = continente;
    }

        public Pais(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        
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

    /**
     * @return the continente
     */
    public Continente getContinente() {
        return continente;
    }

    /**
     * @param continente the continente to set
     */
    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
