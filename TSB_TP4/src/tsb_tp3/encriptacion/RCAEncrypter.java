/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.encriptacion;

import java.math.BigInteger;

/**
 *
 * @author Ale
 */
public class RCAEncrypter extends Encrypter{

    
    private long[] clavePublica;
    private long[] clavePrivada;
    private long[] clavePublicaReceptor;
    
    
    public RCAEncrypter(String mensaje, long[] claveReceptor)
    {
        super(mensaje);
        clavePublica = new long[2];
        clavePrivada = new long[2];
        clavePublicaReceptor = new long[2];
        clavePrivada[0]=35;
        clavePrivada[1]=29;
        clavePublica[0]=35;
        clavePublica[1]=5;
        clavePublicaReceptor[0]=claveReceptor[0];
        clavePublicaReceptor[1]=claveReceptor[1];
    }  
    
    public RCAEncrypter(String mensaje)
    {
        super(mensaje);
        clavePublica = new long[2];
        clavePrivada = new long[2];
        clavePublicaReceptor = new long[2];
        clavePrivada[0]=35;
        clavePrivada[1]=29;
        clavePublica[0]=35;
        clavePublica[1]=5;
        clavePublicaReceptor[0]=35;
        clavePublicaReceptor[1]=5;
    }      
           
    @Override
    public String code() {
        // "mensaje" y "encriptado" son atributos protected de la clase Encrypter
      if ( ! isOk( mensaje ) ) return null;
      
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        for(i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        encriptado="";
        for(i=0; i<bigdigitos.length; i++)
            encriptado += bigdigitos[i].modPow(BigInteger.valueOf(clavePublicaReceptor[1]),BigInteger.valueOf(clavePublicaReceptor[0]));       
        System.out.println(encriptado.toString());
        return encriptado;
        
    }

    @Override
    public String decode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
      
      
     

    
    
    
}
