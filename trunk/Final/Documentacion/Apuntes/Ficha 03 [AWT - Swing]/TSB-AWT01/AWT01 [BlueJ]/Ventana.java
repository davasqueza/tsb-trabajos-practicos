/**
 * Clase para mostrar la forma de manejar eventos de ventana al estilo Java 1.1
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame implements WindowListener , MouseListener
{
    /**
     * Contructor por defecto. Crea el Frame y ajusta sus propiedades iniciales
     */
    public Ventana ()
    {
        super ("Un Frame AWT...");   // sería lo mismo que:  setTitle("Un Frame AWT...");
        
        /*
         * informamos que los métodos para control de eventos de ventana están en la clase del mismo 
         * objeto que se está creando. El método addWindowListener es lo que se conoce como un "método notificador". 
         * Se hereda desde la clase Window. Si no se invoca al método notificador, los eventos serán ignorados aún
         * cuando se implementen los métodos de respuesta pedidos por WindowListener.
         */
        this.addWindowListener(this);  // o también: this.addWindowListener(this); 
        this.addMouseListener(this);

        /*
         * Tomamos las dimensiones de la pantalla.
         * La clase Toolkit permite acceder a propiedades que dependen del Sistema Operativo huésped
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Creamos un color y lo fijamos como color de fondo "de arraque"
        Color nuevo = new Color(200, 50, 150); // 200 de "red", 50 de "green", 150 de "blue": combinación "RGB"
        setBackground(nuevo);
        
        // Fijamos el ancho, el alto y las coordenadas de arranque para mostrarla centrada
        setSize (ancho / 2, alto / 2);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un ícono para la ventana
        Image img = kit.getImage("garfield.gif");
        setIconImage(img);
    } 

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se pidió activar la ventana.
     * @param  evt objeto que representa al evento producido.
     */
    public void windowActivated (WindowEvent evt)
    {   
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * La ventana fue cerrada... 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowClosed (WindowEvent evt)
    {
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener.
     * Cierra la aplicación si el evento capturado fue "cerrar la ventana".
     * @param  evt objeto que representa al evento producido.
     */
    public void windowClosing (WindowEvent evt)
    {
       System.exit(0);    
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se activó el evento "desactivar" la ventana. 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowDeactivated (WindowEvent evt)
    {
         setBackground(Color.red);       
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se trajo la ventana desde el ícono en la barra de tareas 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowDeiconified (WindowEvent evt)
    {
        setBackground(Color.blue);
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se llevó la ventana al ícono en la barra de tareas. 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowIconified (WindowEvent evt)
    {
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener.
     * Se acaba de abrir la ventana por primera vez.
     * @param  evt objeto que representa al evento producido.
     */
    public void windowOpened (WindowEvent evt)
    {
        setBackground(Color.orange);
    }
    
    //*
    public void mouseClicked (MouseEvent evt)
    {
    }
    
    public void mouseEntered (MouseEvent evt)
    {
        setBackground(Color.green);   
    }
    
    public void mouseExited (MouseEvent evt)
    {
        setBackground(Color.yellow);   
    }
    
    public void mousePressed (MouseEvent evt)
    {
    }
    
    public void mouseReleased (MouseEvent evt)
    {
    }
    //*/
}
