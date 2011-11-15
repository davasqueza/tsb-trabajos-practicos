/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3;

import tsb_tp3.dao.BaseDatos;
import tsb_tp3.vista.Principal;



/**
 *
 * @author Burgos
 */
public class TSB_TP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal() {                  
                }.setVisible(true);
            }
        });
        
    }
}
