/**
 * Clase para representar una Ventana. Incorporamos botones para controlar con actionPerformed(),
 * y mostramos control de layout.
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame implements WindowListener, ActionListener
{
    private Button b1, b2, b3;   // tres botones para incluir en el Frame

    /**
     * Contructor por defecto. Crea el Frame y ajusta sus propiedades iniciales
     */
    public Ventana ()
    {
        super ("Un Frame AWT...");   // sería lo mismo que:  setTitle("Un Frame AWT...");
        
        //El Frame notifica dónde están los métodos de WindowListener
        this.addWindowListener(this);  // o también: this.addWindowListener(this);
        
        // Creamos los tres botones
        b1 = new Button("Rojo");
        b2 = new Button("Verde");
        b3 = new Button("Azul");
        
        // CADA botón notifica dónde está programado el método de respuesta "actionPerformed" pedido por ActionListener
        b1.addActionListener(this);  // el método está en el Frame que se está creando: this
        b2.addActionListener(this);
        b3.addActionListener(this);

        // Cambiamos el layout del Frame (es BorderLayout por default) a FlowLayout
        //this.setLayout(new FlowLayout());  // o sea: this.setLayout(new FlowLayout());
        
        // Agregamos los tres botones al Frame (quedarán uno al lado del otro...)
        //add(b1);  //o sea:  this.add(b1);
        //add(b2);
        //add(b3);
        //add(b2);
                
        /*
         * El siguiente código puede usarse para reemplazar las 4 instrucciones anteriores y probar lo que pasa con 
         * BorderLayout... Notarán que no queda muy bonito que digamos:  BorderLayout hace que cada componente ocupe TODA el área
         * donde está ubicado, y en principio no permite más de un componente por área...
         */
        
         Panel p = new Panel();
         p.add (b1);
         p.add (b2);
         p.add (b3);
         this.add(p, "South");
        
        //Tomamos las dimensiones de la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit. getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Creamos un color y lo fijamos como color de fondo "de arraque"
        Color nuevo = new Color(200, 50, 150);
        setBackground(nuevo);
        
        // Fijamos el ancho, el alto y las coordenadas de arranque para mostrarla centrada
        setSize (ancho / 2, alto / 2);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un ícono para la ventana
        Image img = kit.getImage("exclam.gif");
        setIconImage(img);
    } 

    /**
     * Implementacion del metodo pedido por la interfaz ActionListener.
     * Responde a eventos de presión de botones
     * @param  evt objeto que representa al evento producido
     */
    public void actionPerformed (ActionEvent evt)
    {
       // determinamos cuál de los tres botones fue el que provocó el evento
       Button b = (Button) evt.getSource();  // retorna una referencia al objeto que provocó el evento (una referencia a un Object)
       
       // cambiamos el color de fondo del Frame de acuerdo al botón presionado...
       if(b == b1){ setBackground(Color.red); setTitle("Rojo"); }
       else
       {
         if(b == b2) { setBackground(Color.green); setTitle("Verde");}
         else { setBackground(Color.blue); setTitle("Azul");}
       }
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se pidió activar la ventana 
     * @param  evt objeto que representa al evento producido
     */
    public void windowActivated (WindowEvent evt)
    {
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * La ventana fue cerrada... 
     * @param  evt objeto que representa al evento producido
     */
    public void windowClosed (WindowEvent evt)
    {
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener.
     * Cierra la aplicación si el evento capturado fue "cerrar la ventana"
     * @param  evt objeto que representa al evento producido
     */
    public void windowClosing (WindowEvent evt)
    {
       System.exit(0);    
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se activó el evento "desactivar" la ventana 
     * @param  evt objeto que representa al evento producido
     */
    public void windowDeactivated (WindowEvent evt)
    {
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se trajo la ventana desde el ícono en la barra de tareas 
     * @param  evt objeto que representa al evento producido
     */
    public void windowDeiconified (WindowEvent evt)
    {
    }

    /** 
     * Implementacion del metodo pedido por la interfaz WindowListener. 
     * Se llevó la ventana al ícono en la barra de tareas 
     * @param  evt objeto que representa al evento producido
     */
    public void windowIconified (WindowEvent evt)
    {
    }

    /**
     * Implementacion del metodo pedido por la interfaz WindowListener.
     * Se acaba de abrir la ventana por primera vez
     * @param  evt objeto que representa al evento producido
     */
    public void windowOpened (WindowEvent evt)
    {
    }
}
