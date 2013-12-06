package clases;

import java.io.Serializable;

public class CP implements Serializable, Comparable {
    private char provincia;
    private int codigo;
    private String nombre;

    public CP() {
    }

    public CP(char provincia, int codigo, String nombre) {
        this.provincia = provincia;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CP{" + "provincia=" + provincia + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

    
    /**
     * @return the provincia
     */
    public char getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(char provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int compareTo(Object o) {
        CP p = (CP)o;
        return this.codigo - p.codigo;
    }
    
    
}
