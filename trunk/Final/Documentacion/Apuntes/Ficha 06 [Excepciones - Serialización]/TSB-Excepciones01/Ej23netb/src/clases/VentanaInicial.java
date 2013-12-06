package clases;

/**
 * Una ventana creada con componentes del paquete javax.swing, usada como ventana de arranque en una aplicaci�n que 
 * carga datos en un objeto de la clase Listado.
 * La clase Listado incluye un arreglo de objetos Comparable y m�todos para acceder a �l.
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
    private Listado listado;
    
    /**
     * Crea una nueva ventana
     */
    public VentanaInicial()
    {
        listado = new Listado();  // aqu� cargaremos los datos de los clientes en forma secuencial
        
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
    }
    
    /**
     * Gestiona el evento de presionar el bot�n jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbCargarActionPerformed(ActionEvent evt)
    {
        // El dise�o de la clase VentanaCarga fue hecho "a mano", con BlueJ
        VentanaCarga vc = new VentanaCarga(listado);
        vc.setVisible(true);
    }
    
    /**
     * Gestiona el evento de presionar el bot�n jbMostrar
     * @param evt objeto que representa el evento generado
     */
    private void jbMostrarActionPerformed(ActionEvent evt)
    {
        // El dise�o de la clase VentanaMostrar fue hecho con NetBeans, mediante el dise�ador de formularios 
        VentanaMostrar vm = new VentanaMostrar(listado);
        vm.setVisible(true);
    }
}
