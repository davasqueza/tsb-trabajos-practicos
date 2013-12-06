package clases;

/**
 * Una ventana creada con componentes del paquete swing, usada como ventana de arranque en una aplicaci�n que carga 
 * datos en un objeto de la clase Listado. Incluimos ahora un men� de opciones como complemento a los botones.
 * 
 * @author  Ing. Valerio Frittelli
 * @cersion Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VentanaInicial extends JFrame
{
    private JButton jbCargar, jbMostrar;  
    private JMenuBar  barra; // la barra de men�
    private JMenu     file, acciones; // los dos men�es a insertar en la barra
    private JMenuItem about, salir, cargar, mostrar; // items de men� a incluir en cada men�

    private Listado listado;
    
    /**
     * Crea una nueva ventana
     */
    public VentanaInicial()
    {
        listado = new Listado();  // aqu� cargaremos los datos de los clientes en forma secuencial
        
        // proceso de creaci�n del men�... es simple
        // primero la barra del men� general
        barra = new JMenuBar();
        this.setJMenuBar(barra);  // indicamos que el frame debe activar el men�... 
        
        // las opciones horizontales del men�...
        file = new JMenu("Archivo");
        acciones = new JMenu("Acciones");
        barra.add(file);
        barra.add(acciones);
        
        // los �tems a incluir en cada men�...
        about = new JMenuItem ("Acerca de...");
        salir = new JMenuItem ("Salir");
        cargar = new JMenuItem ("Cargar");
        mostrar = new JMenuItem ("Mostrar");
        
        file.add(about);
        file.addSeparator(); // una l�nea separadora horizontal...
        file.add(salir);
        
        acciones.add(cargar);
        acciones.add(mostrar);
                       
        jbCargar  = new JButton("Cargar");
        jbMostrar = new JButton("Mostrar");

        setDefaultCloseOperation(EXIT_ON_CLOSE);  // equivale a implementar windowClosing de WindowListener, con System.exit(0)
        setTitle("Lista de Clientes");
        setBackground(new Color(153, 153, 255));
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Fijamos el ancho, el alto y las coordenadas de arranque 
        int jfAncho  = ancho / 2;
        int jfAlto   = alto  / 3;
        setSize (jfAncho, jfAlto);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un �cono para la ventana
        Image img = kit.getImage("exclam.gif");
        setIconImage(img);

        getContentPane().setLayout(null);
        
        jbCargar.setBounds(jfAncho / 2 - 100, jfAlto / 2, 80, 30);
        getContentPane().add(jbCargar);
        jbCargar.addActionListener(
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           jbCargarActionPerformed(evt);   
                                        }
                                     }
                                  );

        jbMostrar.setBounds(jfAncho / 2 + 20, jfAlto / 2, 80, 30);
        getContentPane().add(jbMostrar);
        jbMostrar.addActionListener(
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           jbMostrarActionPerformed(evt);   
                                        }
                                     }
                                  );

        salir.addActionListener    (
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           salirActionPerformed(evt);   
                                        }
                                     }
                                  );

        about.addActionListener   (
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           aboutActionPerformed(evt);   
                                        }
                                     }
                                  );

        cargar.addActionListener  (
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           cargarActionPerformed(evt);   
                                        }
                                     }
                                  );

        mostrar.addActionListener (
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           mostrarActionPerformed(evt);   
                                        }
                                     }
                                  );
    }
    
    /**
     * Gestiona el evento de presionar el bot�n jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbCargarActionPerformed(ActionEvent evt)
    {
        cargar(evt);
    }
    
    /**
     * Gestiona el evento de presionar el bot�n jbMostrar
     * @param evt objeto que representa el evento generado
     */
    private void jbMostrarActionPerformed(ActionEvent evt)
    {
        mostrar(evt);
    }

    /**
     * Gestiona el evento de seleccionar el �tem "Cargar"
     * @param evt objeto que representa el evento generado
     */
    private void cargarActionPerformed(ActionEvent evt)
    {
        cargar(evt);
    }
    
    /**
     * Gestiona el evento de seleccionar el �tem "Mostrar"
     * @param evt objeto que representa el evento generado
     */
    private void mostrarActionPerformed(ActionEvent evt)
    {
        mostrar(evt);
    }

    private void cargar (ActionEvent evt)
    {
        // El dise�o de la clase VentanaCarga fue hecho "a mano", con BlueJ
        VentanaCarga vc = new VentanaCarga(listado);
        vc.setVisible(true);
    }
    
    private void mostrar (ActionEvent evt)
    {
        // El dise�o de la clase VentanaMostrar fue hecho con NetBeans, mediante el dise�ador de formularios 
        VentanaMostrar vm = new VentanaMostrar(listado);
        vm.setVisible(true);
    }
    

    /**
     * Gestiona el evento de seleccionar el item "Salir"
     * @param evt objeto que representa el evento generado
     */
    private void salirActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }

    /**
     * Gestiona el evento de seleccionar el item "Acerca de"
     * @param evt objeto que representa el evento generado
     */
    private void aboutActionPerformed(ActionEvent evt)
    {
        JOptionPane.showMessageDialog(VentanaInicial.this, "Programado por Ing. Valerio Frittelli");
    }
}
