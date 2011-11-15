/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 13-nov-2011, 15:09:08
 */
package tsb_tp3.vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Burgos
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form Principal */
    public Principal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbIniciar = new javax.swing.JButton();
        jtfPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtfUsuario = new javax.swing.JTextField();
        jbReguistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbIniciar.setText("Iniciar");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        jLabel2.setText("Contraseña: ");

        jLabel3.setText("Si no esta registrado lo puede hacer haciendo clic en el siguiente boton. ");

        jLabel1.setText("Usuario");

        jbReguistrarse.setText("Registrarse");
        jbReguistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReguistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPass)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jbIniciar)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jbReguistrarse)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jbIniciar)))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(jbReguistrarse)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbReguistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReguistrarseActionPerformed

    Registrarse re=new Registrarse();
    re.limpiarCampos();
    re.setVisible(true);
}//GEN-LAST:event_jbReguistrarseActionPerformed

private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed
    if(this.validarCampos())
    {
        Servicios s=new Servicios();
        s.limpiarCampos();
        s.numeroPedido();
        s.setVisible(true);
    }   
}//GEN-LAST:event_jbIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JButton jbReguistrarse;
    private javax.swing.JTextField jtfPass;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

    public void limpiarCampos()
    {
        jtfUsuario.setText("");
        jtfPass.setText("");
    }
    
    public boolean validarCampos()
    {
        if(this.isUsuario()==false)
        {           
            return false;
        }
        if(this.isPass()==false)
        {
            return false;
        }
        return true;
    }
    public boolean isUsuario()
    {
        char c=' ';
        if(jtfUsuario.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfUsuario.getText().length();i++)
            {
                c=jtfUsuario.getText().charAt(i);
                if(Character.isDigit(c))
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es un usuario valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean isPass()
    {
        if(jtfPass.getText().isEmpty()==false)
        {
            return false;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
