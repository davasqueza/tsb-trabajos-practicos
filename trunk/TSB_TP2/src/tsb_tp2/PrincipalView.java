/*
 * PrincipalView.java
 */

package tsb_tp2;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class PrincipalView extends FrameView {

    public PrincipalView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = Principal.getApplication().getMainFrame();
            aboutBox = new PrincipalAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        Principal.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlBotones = new javax.swing.JPanel();
        btnAgregarPais = new javax.swing.JButton();
        btnAgregarUnidad = new javax.swing.JButton();
        btnPaisesOcupados = new javax.swing.JButton();
        pnlPestañas = new javax.swing.JTabbedPane();
        pnlPaises = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPaises = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaises = new javax.swing.JTextArea();
        pnlUnidades = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstUnidades = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtUnidades = new javax.swing.JTextArea();
        pnlUnidMay5 = new javax.swing.JSplitPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstUnidMay5 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtUnidMay5 = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        pnlBotones.setName("pnlBotones"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tsb_tp2.Principal.class).getContext().getResourceMap(PrincipalView.class);
        btnAgregarPais.setText(resourceMap.getString("btnAgregarPais.text")); // NOI18N
        btnAgregarPais.setName("btnAgregarPais"); // NOI18N
        btnAgregarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaisActionPerformed(evt);
            }
        });

        btnAgregarUnidad.setText(resourceMap.getString("btnAgregarUnidad.text")); // NOI18N
        btnAgregarUnidad.setName("btnAgregarUnidad"); // NOI18N
        btnAgregarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUnidadActionPerformed(evt);
            }
        });

        btnPaisesOcupados.setText(resourceMap.getString("btnPaisesOcupados.text")); // NOI18N
        btnPaisesOcupados.setName("btnPaisesOcupados"); // NOI18N
        btnPaisesOcupados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaisesOcupadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAgregarPais)
                    .addComponent(btnAgregarUnidad)
                    .addComponent(btnPaisesOcupados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAgregarPais)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarUnidad)
                .addGap(18, 18, 18)
                .addComponent(btnPaisesOcupados)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(pnlBotones);

        pnlPestañas.setName("pnlPestañas"); // NOI18N

        pnlPaises.setName("pnlPaises"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        lstPaises.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstPaises.setName("lstPaises"); // NOI18N
        jScrollPane1.setViewportView(lstPaises);

        pnlPaises.setLeftComponent(jScrollPane1);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtPaises.setColumns(20);
        txtPaises.setRows(5);
        txtPaises.setName("txtPaises"); // NOI18N
        jScrollPane2.setViewportView(txtPaises);

        pnlPaises.setRightComponent(jScrollPane2);

        pnlPestañas.addTab(resourceMap.getString("pnlPaises.TabConstraints.tabTitle"), pnlPaises); // NOI18N

        pnlUnidades.setName("pnlUnidades"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        lstUnidades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstUnidades.setName("lstUnidades"); // NOI18N
        jScrollPane3.setViewportView(lstUnidades);

        pnlUnidades.setLeftComponent(jScrollPane3);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        txtUnidades.setColumns(20);
        txtUnidades.setRows(5);
        txtUnidades.setName("txtUnidades"); // NOI18N
        jScrollPane4.setViewportView(txtUnidades);

        pnlUnidades.setRightComponent(jScrollPane4);

        pnlPestañas.addTab(resourceMap.getString("pnlUnidades.TabConstraints.tabTitle"), pnlUnidades); // NOI18N

        pnlUnidMay5.setName("pnlUnidMay5"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        lstUnidMay5.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstUnidMay5.setName("lstUnidMay5"); // NOI18N
        jScrollPane5.setViewportView(lstUnidMay5);

        pnlUnidMay5.setLeftComponent(jScrollPane5);

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        txtUnidMay5.setColumns(20);
        txtUnidMay5.setRows(5);
        txtUnidMay5.setName("txtUnidMay5"); // NOI18N
        jScrollPane6.setViewportView(txtUnidMay5);

        pnlUnidMay5.setRightComponent(jScrollPane6);

        pnlPestañas.addTab(resourceMap.getString("pnlUnidMay5.TabConstraints.tabTitle"), pnlUnidMay5); // NOI18N

        jSplitPane1.setRightComponent(pnlPestañas);

        mainPanel.add(jSplitPane1);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(tsb_tp2.Principal.class).getContext().getActionMap(PrincipalView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaisActionPerformed
        AgregarPais ap=new AgregarPais(this.getFrame(), true);
        ap.setVisible(true);
        
        
    }//GEN-LAST:event_btnAgregarPaisActionPerformed

    private void btnAgregarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUnidadActionPerformed
       AgregarUnidadMilitar aum=new AgregarUnidadMilitar(this.getFrame(), true);
        aum.setVisible(true);
    }//GEN-LAST:event_btnAgregarUnidadActionPerformed

    private void btnPaisesOcupadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaisesOcupadosActionPerformed
       MostrarPaisesOcupados mpo= new MostrarPaisesOcupados(this.getFrame(), true);
       mpo.setVisible(true);
    }//GEN-LAST:event_btnPaisesOcupadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPais;
    private javax.swing.JButton btnAgregarUnidad;
    private javax.swing.JButton btnPaisesOcupados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList lstPaises;
    private javax.swing.JList lstUnidMay5;
    private javax.swing.JList lstUnidades;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JSplitPane pnlPaises;
    private javax.swing.JTabbedPane pnlPestañas;
    private javax.swing.JSplitPane pnlUnidMay5;
    private javax.swing.JSplitPane pnlUnidades;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea txtPaises;
    private javax.swing.JTextArea txtUnidMay5;
    private javax.swing.JTextArea txtUnidades;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
