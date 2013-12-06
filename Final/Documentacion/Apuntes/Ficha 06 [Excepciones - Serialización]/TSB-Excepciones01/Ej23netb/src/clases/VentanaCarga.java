package clases;

/**
 * Clase para representar una ventana para cargar datos en un Listado. Framework: Swing.
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VentanaCarga extends JFrame
{
    private JButton jbAgregar;    
    private JTextField jtfNumero;
    private JLabel jlMensaje;
    
    private Listado listado;
    
    /**
     * Crea el JFrame, ajusta sus valores, y le agrega los componentes 
     */
    public VentanaCarga(Listado lis)
    {
        listado = lis;
        jbAgregar = new JButton("Agregar");
        jtfNumero = new JTextField(60);
        jlMensaje = new JLabel("Ingrese un n�mero entero: ", SwingConstants.LEFT);
    
        jbAgregar.addActionListener(
                                     new ActionListener()
                                     {
                                        public void actionPerformed (ActionEvent evt)
                                        {
                                           jbAgregarActionPerformed(evt);   
                                        }
                                     }
                                   );
    
        setTitle ("Ventana de Carga");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        setBackground(new Color(153, 153, 255));
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Fijamos el ancho, el alto y las coordenadas de arranque para mostrarla centrada
        int jfAncho = ancho / 2;
        int jfAlto  = alto  / 3;
        
        setSize (jfAncho, jfAlto);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un �cono para la ventana
        Image img = kit.getImage("exclam.gif");
        setIconImage(img);

        getContentPane().setLayout(null);
        
        jlMensaje.setBounds(jfAncho / 2 - 110, jfAlto / 4, 160, 30);
        getContentPane().add(jlMensaje);
        
        jtfNumero.setBounds(jfAncho / 2 + 60, jfAlto / 4, 60, 30 );
        getContentPane().add(jtfNumero);
        
        jbAgregar.setBounds(jfAncho / 2 - 40, jfAlto / 2, 80, 30 );
        getContentPane().add(jbAgregar);
    }

    /**
     * Gestiona el evento de presionar el bot�n jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbAgregarActionPerformed(ActionEvent evt)
    {
        /*
        try
        {
          Integer num = Integer.valueOf(jtfNumero.getText());
          listado.add(num);
          jtfNumero.setText("");
        }
        catch(NumberFormatException e)
        {
           JOptionPane.showMessageDialog(VentanaCarga.this, "Tipo incorrecto");   
        }
        //*/
        // Si reemplaza todo el c�digo anterior por el que sigue, la clase sigue compilando sin problemas, pero al producirse un error de 
        // conversi�n de n�meros el programa lanzar� una excepci�n mostrando mensajes de error en la consola est�ndar. Si el c�digo en 
        // cuesti�n estuviera en el m�todo main, el programa finalizar�a su ejecuci�n.
        //*        
          Integer num = Integer.valueOf(jtfNumero.getText());
          listado.add(num);
          jtfNumero.setText("");
        //*/
    }
}

