/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NuevoCliente.java
 *
 * Created on 12-oct-2011, 19:15:30
 */
package interfaces;

import dominio.Cliente;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author a1
 */
public class NuevoCliente extends javax.swing.JDialog {

    /** Creates new form NuevoCliente */
    Principal parent;
    public NuevoCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent=(Principal) parent;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jtfSaldo = new javax.swing.JTextField();
        btnNuevoCliente = new javax.swing.JButton();
        jtfNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Apellido: ");

        jLabel3.setText("Saldo Inicial del Cliente Nuevo:");

        btnNuevoCliente.setText("Agregar Nuevo Cliente");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Numero del Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnNuevoCliente)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnNuevoCliente)
                .addGap(76, 76, 76))
        );

        jLabel4.getAccessibleContext().setAccessibleName("Numero de Cliente:");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
if(this.validarCampos())
{
    if(this.parent.agregarCliente(new Cliente(Long.parseLong(this.jtfNumero.getText()), this.jtfNombre.getText()+ " "+this.jtfApellido.getText(), Float.parseFloat(this.jtfSaldo.getText()))))
        JOptionPane.showMessageDialog(null,"Se agregó el cliente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    else
        JOptionPane.showMessageDialog(null,"No se agregó el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
    this.setVisible(false);
    this.limpiarCampos();
}


}//GEN-LAST:event_btnNuevoClienteActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfSaldo;
    // End of variables declaration//GEN-END:variables

    public void limpiarCampos()
    {
        jtfNumero.setText("");
        jtfNombre.setText("");
        jtfApellido.setText("");
        jtfSaldo.setText("");
    }
    
    public boolean validarCampos()
    {
        if(this.isNombre()==false)
        {
            
            return false;
        }
        if(this.isApellido()==false)
        {
            
            return false;
        }
        if(this.isNumero()==false)
        {
            
            return false;
        }
        if(this.isSaldo()==false)
        {
            
            return false;
        }
        return true;
    }
    public boolean isNombre()
    {
        char c=' ';
        if(jtfNombre.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfNombre.getText().length();i++)
            {
                c=jtfNombre.getText().charAt(i);
                if(Character.isDigit(c))
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es un nombre valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean isApellido()
    {
        char c=' ';
        if(jtfApellido.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfApellido.getText().length();i++)
            {
                c=jtfApellido.getText().charAt(i);
                if(Character.isDigit(c))
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es un apellido valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un apellido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean isNumero()
    {
        char c=' ';
        if(jtfNumero.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfNumero.getText().length();i++)
            {
                c=jtfNumero.getText().charAt(i);
                if(Character.isDigit(c)==false)
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un numero de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean isSaldo()
    {
        char c=' ';
        if(jtfSaldo.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfSaldo.getText().length();i++)
            {
                c=jtfSaldo.getText().charAt(i);
                if(Character.isDigit(c)==false)
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es un salgo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un saldo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
