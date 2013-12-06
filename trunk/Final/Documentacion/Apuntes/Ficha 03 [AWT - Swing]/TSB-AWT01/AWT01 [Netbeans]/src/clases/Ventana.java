package clases;

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
        super ("Un Frame AWT...");   // ser�a lo mismo que:  setTitle("Un Frame AWT...");
        
        /*
         * informamos que los m�todos para control de eventos de ventana est�n en la clase del mismo 
         * objeto que se est� creando. El m�todo addWindowListener es lo que se conoce como un "m�todo notificador". 
         * Se hereda desde la clase Window. Si no se invoca al m�todo notificador, los eventos ser�n ignorados a�n
         * cuando se implementen los m�todos de respuesta pedidos por WindowListener.
         */
        this.addWindowListener(this);  // o tambien: this.addWindowListener(this);
        this.addMouseListener(this);

        /*
         * Tomamos las dimensiones de la pantalla.
         * La clase Toolkit permite acceder a propiedades que dependen del Sistema Operativo hu�sped
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Creamos un color y lo fijamos como color de fondo "de arraque"
        Color nuevo = new Color(200, 50, 150); // 200 de "red", 50 de "green", 150 de "blue": combinaci�n "RGB"
        setBackground(nuevo);
        
        // Fijamos el ancho, el alto y las coordenadas de arranque para mostrarla centrada
        setSize (ancho / 2, alto / 2);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un �cono para la ventana
        Image img = kit.getImage("garfield.gif");
        setIconImage(img);
    } 

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se pidi� activar la ventana.
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
     * Cierra la aplicaci�n si el evento capturado fue "cerrar la ventana".
     * @param  evt objeto que representa al evento producido.
     */
    public void windowClosing (WindowEvent evt)
    {
       System.exit(0);    
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se activ� el evento "desactivar" la ventana. 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowDeactivated (WindowEvent evt)
    {
         setBackground(Color.red);       
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se trajo la ventana desde el �cono en la barra de tareas 
     * @param  evt objeto que representa al evento producido.
     */
    public void windowDeiconified (WindowEvent evt)
    {
        setBackground(Color.blue);
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se llev� la ventana al �cono en la barra de tareas. 
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
