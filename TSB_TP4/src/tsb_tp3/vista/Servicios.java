package tsb_tp3.vista;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import tsb_tp3.dominio.DetallePedido;
import tsb_tp3.dominio.Pedido;
import tsb_tp3.dominio.Persona;

public class Servicios extends javax.swing.JFrame {

    
    public Servicios() {
        initComponents();
    }
    private String aux="";
    private int contador=0;
    private int numeroPedido=0;

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNumero = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jcbServicios = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jbAdquirir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jtfTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfidPedido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfNumero.setFocusable(false);
        jtfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumeroActionPerformed(evt);
            }
        });

        jtfApellido.setFocusable(false);

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Apellido: ");

        jtfNombre.setFocusable(false);
        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero");

        jcbServicios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servicio1", "Servicio2", "Servicio3", "Servicio4", "Servicio5", "Servicio6" }));
        jcbServicios.setToolTipText("");
        jcbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbServiciosActionPerformed(evt);
            }
        });

        jLabel4.setText("Servicios: ");

        jLabel5.setText("Cantidad: ");

        jbAdquirir.setText("Adquirir");
        jbAdquirir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdquirirActionPerformed(evt);
            }
        });

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        jtfTotal.setFocusable(false);
        jtfTotal.setSelectedTextColor(new java.awt.Color(192, 192, 192));
        jtfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTotalActionPerformed(evt);
            }
        });

        jLabel6.setText("Pedido Numero: ");

        jtfidPedido.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbAdquirir)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jtfidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdquirir)
                    .addComponent(jLabel5)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jtfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumeroActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfNumeroActionPerformed

private void jcbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbServiciosActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbServiciosActionPerformed

private void jbAdquirirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdquirirActionPerformed
    if(this.validarCampos())
    {
        contador=contador+Integer.parseInt(jtfCantidad.getText());
        this.areaTexto();
    }
    
    

}//GEN-LAST:event_jbAdquirirActionPerformed

private void jtfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTotalActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfTotalActionPerformed

private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfNombreActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAdquirir;
    private javax.swing.JComboBox jcbServicios;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfTotal;
    private javax.swing.JTextField jtfidPedido;
    // End of variables declaration//GEN-END:variables

    public void areaTexto()
    {       
        aux+="Usted adquirio el servicio: ";
        aux+=""+jcbServicios.getSelectedItem().toString()+"\n";
        aux+="en una cantidad: "+jtfCantidad.getText()+"\n";                  
        jtaDescripcion.setText(aux);
        jtfTotal.setText("Usted adquierio una cantidad de servicios de: "+contador);
    }
    public void limpiarCampos()
    {
        jtfNombre.setText("");
        jtfNumero.setText("");
        jtfCantidad.setText("");
        jtfApellido.setText("");
        jtaDescripcion.setText("");
    }
    public boolean validarCampos()
    {
        if(this.isCantidad()==false)
        {           
            return false;
        } 
        return true;
    }
    public boolean isCantidad()
    {
        char c=' ';
        if(jtfCantidad.getText().isEmpty()==false)
        {
            for(int i=0;i<jtfCantidad.getText().length();i++)
            {
                c=jtfCantidad.getText().charAt(i);
                if(Character.isDigit(c)==false)
                {
                    JOptionPane.showMessageDialog(null,"Lo ingresado no es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
            }
            if(jtfCantidad.getText().length()>2)
            {
                JOptionPane.showMessageDialog(null,"Ingreso un numero mayor a dos diguitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if(this.valor()>26)
            {
                JOptionPane.showMessageDialog(null,"Ingreso una cantidad mayor a 25.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }      
        else
        {
            JOptionPane.showMessageDialog(null,"No ingreso un numero de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public int valor()
    {
        int auxi=0;
        if(jtfCantidad.getText().length()==1)
        {
            return auxi=auxi+Integer.parseInt(jtfCantidad.getText()); 
        }
        else
        {
            if(jtfCantidad.getText().length()>=2)
            {
                return Integer.parseInt(jtfCantidad.getText());
            }
        }
        return auxi;
    }
    
    public Pedido cargarPedido(int id,List<DetallePedido> detalle,Persona p, Date fecha)
    {
        Pedido pe=new Pedido();
        pe.setCliente(p);
        pe.setFecha(fecha);
        pe.setId(id);
        pe.setPedidos(detalle);
        return pe;
    }
    public DetallePedido cargarDetallePedido(int id,int cantidad)
    {
        DetallePedido dp=new DetallePedido();
        dp.setCantidad(cantidad);
        dp.setId(id);
        return dp;
    }
    public int numeroPedido()
    {
        int i=this.numeroPedido++;
        jtfidPedido.setText(""+i);
        return i;
    }
    
}
