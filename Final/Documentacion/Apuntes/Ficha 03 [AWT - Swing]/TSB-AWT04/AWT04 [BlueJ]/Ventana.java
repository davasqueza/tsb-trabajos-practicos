/**
 * Clase para representar una Ventana. Incluye una clase anónima para el control de eventos WindowEvent.
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame
{
    private Button b1, b2, b3;   // tres botones para incluir en el Frame

    /**
     * Clase auxiliar interna para control de eventos sobre botones en el Frame.
     * Se define con parámetro en su constructor para hacer más simple el método actionPerformed
     * @author Ing. Valerio Frittelli
     * @version Mayo de 2004
     */
    private class ControladorDeBotones implements ActionListener
    {
        private Color backColor;
     
        /**
         *  Ajusta el valor del color de background según el parámetro
         */
        public ControladorDeBotones (Color cb)
        {
           backColor = cb;   
        }
        /**
         * Implementacion del metodo pedido por la interfaz ActionListener.
         * Responde a eventos de presión de botones
         * @param  evt objeto que representa al evento producido
         */
        public void actionPerformed (ActionEvent evt)
        {
           setBackground(backColor);  // equivale a: Ventana.this.setBackground(backColor);
        }
    }   

    /**
     * Contructor por defecto. Crea el Frame y ajusta sus propiedades iniciales
     */
    public Ventana ()
    {
        super ("Un Frame AWT...");   // sería lo mismo que:  setTitle("Un Frame AWT...");
        
        //El Frame notifica dónde están los métodos de WindowListener: y en este caso están en una clase anónima
        this.addWindowListener( new WindowAdapter()
                                {
                                        public void windowClosing (WindowEvent evt)
                                        {
                                            System.exit(0);    
                                        }
                                }
                              ); 
        
        // Creamos los tres botones
        b1 = new Button("Rojo");
        b2 = new Button("Verde");
        b3 = new Button("Azul");
        
        // creamos objetos de la clase que contiene al método actionPerformed, pero uno para cada botón, ya con su color puesto!!!
        ControladorDeBotones cbRojo  = new ControladorDeBotones(Color.red);
        ControladorDeBotones cbVerde = new ControladorDeBotones(Color.green);
        ControladorDeBotones cbAzul  = new ControladorDeBotones(Color.blue);
        ControladorDeBotones cb  = new ControladorDeBotones(Color.yellow);
        
        // CADA botón notifica dónde está programado el método de respuesta "actionPerformed" pedido por ActionListener
        b1.addActionListener(cbRojo);  
        b2.addActionListener(cbVerde);
        b3.addActionListener(cbAzul);

        // Cambiamos el layout del Frame a null
        setLayout(null); 
        
        // ajustamos las posiciones y el tamaño de cada botón
        b1.setBounds(20, 50, 80, 30);
        b2.setBounds(20, 100, 80, 30);
        b3.setBounds(20, 150, 80, 30);
        
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

