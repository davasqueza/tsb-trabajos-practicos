package datos;

public class PaisOcupado extends Pais{
    
    private UnidadMilitar unidad;

    public PaisOcupado(int numero, String nombre, String continente, UnidadMilitar unidad) {
        super(numero, nombre, continente);
        this.unidad = unidad;
    }

    
    
    
}
