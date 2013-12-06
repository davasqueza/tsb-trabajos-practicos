/**
 * Una ventana creada con componentes del paquete swing, usada como ventana de arranque en una aplicación que carga datos en un Listado.
 * La clase Listado es la misma que se presentó oportunamente en el Encuentro 2 (ver Ejemplo14). Incluimos ahora un menú de opciones como
 * complemento a los botones
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
    private JMenuBar  barra; // la barra de menú
    private JMenu     file, acciones; // los dos menúes a insertar en la barra
    private JMenuItem about, salir, cargar, mostrar; // items de menú a incluir en cada menú

    private Listado listado;
    
    /**
     * Crea una nueva ventana
     */
    public VentanaInicial()
    {
        listado = new Listado();  // aquí cargaremos los datos de los clientes en forma secuencial
        
        // proceso de creación del menú... es simple
        // primero la barra del menú general
        barra = new JMenuBar();
        this.setJMenuBar(barra);  // indicamos que el frame debe activar el menú con lo indicado en la variable "barra"
        
        // las opciones horizontales del menú
        file = new JMenu("Archivo");
        acciones = new JMenu("Acciones");
        barra.add(file);
        barra.add(acciones);
        
        // los ítems a incluir en cada menú
        about = new JMenuItem ("Acerca de...");
        salir = new JMenuItem ("Salir");
        cargar = new JMenuItem ("Cargar");
        mostrar = new JMenuItem ("Mostrar");
        
        file.add(about);
        file.addSeparator();
        file.add(salir);
        
        acciones.add(cargar);
        acciones.add(mostrar);
        file.add(salir);
               
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
        
        // Proveemos un ícono para la ventana
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
     * Gestiona el evento de presionar el botón jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbCargarActionPerformed(ActionEvent evt)
    {
        cargar(evt);
    }
    
    /**
     * Gestiona el evento de presionar el botón jbMostrar
     * @param evt objeto que representa el evento generado
     */
    private void jbMostrarActionPerformed(ActionEvent evt)
    {
        mostrar(evt);
    }

    /**
     * Gestiona el evento de seleccionar el ítem "Cargar"
     * @param evt objeto que representa el evento generado
     */
    private void cargarActionPerformed(ActionEvent evt)
    {
        cargar(evt);
    }
    
    /**
     * Gestiona el evento de seleccionar el ítem "Mostrar"
     * @param evt objeto que representa el evento generado
     */
    private void mostrarActionPerformed(ActionEvent evt)
    {
        mostrar(evt);
    }

    private void cargar (ActionEvent evt)
    {
        // El diseño de la clase VentanaCarga fue hecho "a mano", con BlueJ
        VentanaCarga vc = new VentanaCarga(listado);
        vc.show();
    }
    
    private void mostrar (ActionEvent evt)
    {
        // El diseño de la clase VentanaMostrar fue hecho con NetBeans, mediante el diseñador de formularios 
        VentanaMostrar vm = new VentanaMostrar(listado);
        vm.show();
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
