package datos;

public class Pais implements Comparable{
    private int numero;
    private String nombre, continente;

    public Pais(int numero, String nombre, String continente) {
        this.numero = numero;
        this.nombre = nombre;
        this.continente = continente;
    }
    
    public Pais()
    {}

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString()
    {
        return "Numero: "+this.numero+"\nNombre: "+this.nombre+"\nContinente: "+this.continente;
    }
    
    
}
