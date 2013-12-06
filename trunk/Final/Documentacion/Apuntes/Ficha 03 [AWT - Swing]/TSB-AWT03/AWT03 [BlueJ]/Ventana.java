/**
 * Clase para representar una Ventana, con una clase interna para controlar los botones.
 * @author Ing. Valerio Frittelli.
 * @version Mayo de 2004.
 */
import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame
{           
            private Button b1, b2, b3;   // tres botones para incluir en el Frame
            
            class ControladorDeBotones implements ActionListener
            { 
                 private Button b;
                 public void actionPerformed (ActionEvent evt)
                 {
                   // determinamos cuál de los tres botones fue el que provocó el evento
                   b = (Button) evt.getSource();  
                   
                   // cambiamos el color de fondo del Frame de acuerdo al botón presionado...
                   if(b == b1){ setBackground(Color.red); }
                   else
                   {
                     if(b == b2) { setBackground(Color.green); }
                     else { setBackground(Color.blue); }
                   }
                }
            }   

    /**
     * Contructor por defecto. Crea el Frame y ajusta sus propiedades iniciales
     */
    public Ventana ()
    {
        super ("Un Frame AWT...");   // sería lo mismo que:  setTitle("Un Frame AWT...");
        
        // creamos un objeto de la clase que contiene a los métodos de respuesta para ventanas
        ControladorDeVentana cv = new ControladorDeVentana();
        
        //El Frame notifica dónde están los métodos de WindowListener
        this.addWindowListener(cv);  // ¡...!
        
        // Creamos los tres botones
        b1 = new Button("Rojo");
        b2 = new Button("Verde");
        b3 = new Button("Azul");
        
        // creamos un objeto de la clase que contiene al método actionPerformed
        ControladorDeBotones cb = new ControladorDeBotones();
        
        // CADA botón notifica dónde está programado el método de respuesta "actionPerformed" pedido por ActionListener
        b1.addActionListener(cb);  // el método está en el objeto cb (ya no en "this" como en el modelo anterior)
        b2.addActionListener(cb);
        b3.addActionListener(cb);

        // Cambiamos el layout del Frame (es BorderLayout por default) a FlowLayout
        setLayout(new FlowLayout());  // o sea: this.setLayout(new FlowLayout());
        
        // Agregamos los tres botones al Frame (quedarán uno al lado del otro...)
        add(b1);  
        add(b2);
        add(b3);
        
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
}



/**
 * Clase auxiliar para control de eventos de ventana. En lugar de implementar WindowListener, hereda de WindowAdapter
 * y con ello no es necesario definir los 7 métodos...
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
class ControladorDeVentana extends WindowAdapter
{
    /**
     * Redefinición del método heredado desde WindowAdapter
     * Cierra la aplicación si el evento capturado fue "cerrar la ventana"
     * @param  evt objeto que representa al evento producido
     */
    public void windowClosing (WindowEvent evt)
    {
       System.exit(0);    
    }
}

