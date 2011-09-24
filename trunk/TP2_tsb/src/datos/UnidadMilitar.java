package datos;

public class UnidadMilitar {
    private int numero, poder;
    String nombre;

    public UnidadMilitar(int numero, int poder, String nombre) {
        this.numero = numero;
        this.poder = poder;
        this.nombre = nombre;
    }
    
    public UnidadMilitar()
    {}

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

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
    
    
}
