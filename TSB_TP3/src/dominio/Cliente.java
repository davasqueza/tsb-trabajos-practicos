/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Franco
 */
public class Cliente {
    private long numero;
    private String nombre;
    private float saldo;

    public Cliente(long numero, String nombre, float saldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.numero ^ (this.numero >>> 32));
        hash = 53 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 53 * hash + Float.floatToIntBits(this.saldo);
        return hash;
    }

    public int compareTo(Object o)
     {
       Cliente otro = (Cliente) o;
       if(otro.getNumero()<this.numero)
           return 1;
       else
       {if(otro.getNumero()>this.numero)
           return 1;
       else
           return 0;
       }
     }
}
