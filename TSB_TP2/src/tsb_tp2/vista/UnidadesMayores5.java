/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UnidadesMayores5.java
 *
 * Created on 24-sep-2011, 22:29:26
 */
package tsb_tp2.vista;

import javax.swing.DefaultListModel;
import tsb_tp1.LinkedList;
import tsb_tp2.Dominio.UnidadMilitar;

/**
 *
 * @author Franco
 */
public class UnidadesMayores5 extends javax.swing.JDialog {

   DefaultListModel modeloLista;
   
   Principal parent;
    public UnidadesMayores5(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent=(Principal) parent;
         modeloLista= new DefaultListModel();
         listaUnidadesMayores.setModel(modeloLista);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaUnidadesMayores = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 400));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        listaUnidadesMayores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaUnidadesMayores);

        jButton1.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

LinkedList lista= this.parent.getJuego().obtenerUnidadesConPoderDeFuegoSuperiorA5().size()>0?this.parent.getJuego().obtenerUnidadesConPoderDeFuegoSuperiorA5():new LinkedList();

for(int i=0;i<lista.size();i++){
modeloLista.addElement((UnidadMilitar)lista.get(i));
}

}//GEN-LAST:event_formWindowGainedFocus

private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
modeloLista.clear();
}//GEN-LAST:event_formWindowLostFocus

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaUnidadesMayores;
    // End of variables declaration//GEN-END:variables
}
