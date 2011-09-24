/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp2;

import tsb_tp2.vista.Principal;



/**
 *
 * @author Burgos
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
