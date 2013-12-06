/**
 * Una ventana creada con componentes del paquete swing, usada como ventana de arranque en una aplicación que carga datos en un Listado.
 * La clase Listado es la misma que se presentó oportunamente en el Encuentro 2 (ver Ejemplo14) 
 * 
 * @author  Ing. Valerio Frittelli
 * @cersion Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VentanaInicial extends JFrame
{
    /*
     * 1.) El paquete AWT incorporado por Java desde sus inicios para diseño de IGUs, trabaja de forma que al incluir un componente en una
     * ventana (tal como un Button o un TextField), lo único que hace el programa es indicar dónde colocar el mismo y su comportamiento 
     * básico, y luego se delega en el kit de recursos del sistema operativo huésped la forma de visualizar y controlar ese componente. Por
     * caso, si un programa pide incluir un botón en la interfaz, es en realidad un botón "oculto" del kit de recursos del SO el que maneja
     * a ese botón. De esta manera, se pretendió que la interfaz de usuario de cada aplicación "luzca y se sienta" ("look and feel") tal y 
     * como "lucen y se sienten" las aplicaciones nativas de cada plataforma, y aún más importante: en teoría, un programa así escrito 
     * debería correr sin problemas en forma portable en cualquier plataforma.
     * 
     * 2.) Pero en la práctica esto ha funcionado bien sólo con programas simples e interfaces sencillas. Hay varios problemas que hacen 
     * que esta aproximación de gestionar la interfaz de usuario a través de componentes ocultos o "compañeros" del SO nativo, no funcione
     * del todo como se había planeado:
     *       i.) No todos los componentes se comportan igual en todas las plataformas, y resulta entonces complicado proveer una interfaz 
     *           consistente a los usuarios finales.
     *           
     *       ii.) No todas las plataformas proveen un entorno rico en componentes como sí lo hacen otras como Windows o Macintosh. Por esta
     *            razón el AWT debió limitarse sólo a un conjunto de componentes que conforman lo que llamaríamos "el común denominador", 
     *            y de esta forma las interfaces de usuario no "lucen ni se sienten" como uno esperaría al correrlas en plataformas como
     *            Windows o Mac. Simplemente, lucen poco y se sienten pobres.
     *            
     *       iii.) Y finalmente, existen "bugs" (fallas) de comportamiento de componentes nativos diferentes en distintas plataformas. Esto
     *             termina haciendo que los prgramadores escriban el programa una vez, y lo corran una vez cuando ya esté testeado, pero 
     *             para testearlo deben realizar sesiones de "debug" en cada plataforma...
     *         
     * 3.) Un enfoque diferente fue planteado en 1996 por NetScape al introducir su paquete "Internet Foundation Classes" o IFC, y estas
     * ideas fueron aún mejoradas al trabajar en forma conjunta con Sun Corporation para lanzar el paquete "Java Foundation Classes" o
     * JFC, del cual a su vez forma parte el paquete Swing para desarrollo de interfaces de usuario. En esta nueva aproximación, los 
     * componentes son dibujados en forma directa en ventanas "blancas", y el único soporte que se requiere del kit de recursos nativos del
     * SO es la forma de desplegar ventanas y "pintar" sobre ellas. Así, las IGUs realmente lucen y se sienten como el programador dispuso
     * que luzcan y se sientan.
     * 
     * 4.) Sin embargo, Swing no reemplaza a AWT: básicamente el modelo de diseño y de control de eventos es el mismo, y de hecho, las 
     * clases del paquete swing heredan desde las clases del paquete AWT. Swing provee mejores capacidades en la forma de desarrollar 
     * interfaces, y mayor control de la misma por parte del programador. Un detalle: el nombre Swing es el nombre en código que tenía el 
     * equipo de desarrollo dentro de Sun, encargado de incorporar a las interfaces Java la tecnología de NetScape, y ese nombre se terminó
     * generalizando para designar al paquete por ellos producido.
     * 
     * 5.) En el paquete javax.swing, una ventana de alto nivel no contenida dentro de otra (lo que en AWT era un Frame), se modela a 
     * partir de la clase JFrame, que deriva de Frame. En general esto será cierto para todos los componentes AWT y Swing: cada componente
     * AWT tendrá su equivalente Swing, y el nombre de este último comenzará con "J": Button para AWT --> JButton en Swing, etc. Un JFrame
     * es uno de los pocos componentes de Swing que se dibuja con ayuda del kit de recursos del SO, por lo cual la barra de títulos, los 
     * botones de control y los bordes lucirán diferentes en distintas plataformas (como era de esperarse).
     * 
     * 6.) Un JFrame representa una ventana de alto nivel con una estructura más compleja que un Frame AWT. Por empezar, un JFrame está 
     * dividido en varios contenedores internos, usados para gestionar componentes en forma más eficiente que un Frame. Uno de esos 
     * contenedores es el llamado "Content Pane", que es el que realmente contiene a los elementos que el programador agrega al JFrame. Si
     * se está usando un JFrame, para añadir componentes no se usa en forma directa el método "add" (que usábamos con un Frame común): se
     * accede al Content Pane y se añaden elementos a él. El acceso al Content Pane se logra con el método "getContentPane" de JFrame, el 
     * cual retorna una referencia al Content Pane, y mediante esa referencia se invoca al método "add" para añadir componentes. El Layout
     * por default del Content Pane es BorderLayout, pero puede cambiarse con setLayout en la forma conocida:
     * 
     *                              public class Ventana extends JFrame
     *                              {
     *                                 private JButton b;
     *                                 
     *                                 public Ventana()
     *                                 {
     *                                    b = new JButton("Ok");
     *                                    Container c = getContentPane();
     *                                    c.setLayout(new FlowLayout());
     *                                    c.add(b);
     *                                    
     *                                    // o directamente:
     *                                    // getContentPane().setLayout(new FlowLayout());
     *                                    // getContentPane().add(b);
     *                                 }
     *                              }
     *
     * 7.) Con un JFrame es más simple el control de eventos de ventana, tales como cerrar la ventana, ocultarla, u ocultarla y destruirla.
     * El método "setDefaultCloseOperation" de JFrame permite indicar en una sóla instrucción lo que debe hacer la apliación si el usuario
     * presionó el botón de cierre de la ventana. Ese método puede recibir uno de los siguientes cuatro parámetros, y en función del mismo
     * indicará a la JVM la respuesta que debe dar al evento de cierre, sin tener que implementar WindowListener. Los valores de los 
     * parámetros se manejan con constantes, declaradas en la clase JFrame o en la clase WindowConstants:
     *                     DO_NOTHING_ON_CLOSE   (definida en WindowConstants): No lleva a cabo ninguna acción, y requiere que el programa
     *                                           implemente WindowListener. Si se pasa este parámetro, el JFrame se comportará como un 
     *                                           Frame.
     *                                           
     *                     HIDE_ON_CLOSE         (definida en WindowConstants): Cierra automáticamente el frame al pedir el cierre.
     *                     
     *                     DISPOSE_ON_CLOSE      (definida en WindowConstants): Cierra y destruye automáticamente el frame.
     *                     
     *                     EXIT_ON_CLOSE         (definida en JFrame):  Termina la aplicación usando el método System.exit.
     *                     
     * El valor por defecto es HIDE_ON_CLOSE: aún cuando no se indique qué hacer al cerrar un JFrame, este se cerrará pero quedará activo 
     * en memoria.
     * 
     * 8.) El truco de crear una clase anónima que implemente el método de respuesta a eventos necesitado, pero de forma que ese método a 
     * su vez invoque a otro cuyo nombre contiene el nomnbre del objeto al cual se responde, es muy usado por los entornos de desarrollo
     * visual en Java (JBuilder, J++, NetBeans, Visual Café, etc.), aunque muchos consideran que esa forma de plantear el modelo de eventos
     * "oscurece" el código.
     */
 
    private JButton jbCargar, jbMostrar;  

    private Listado listado;
    
    /**
     * Crea una nueva ventana
     */
    public VentanaInicial()
    {
        listado = new Listado();  // aquí cargaremos los datos de los clientes en forma secuencial
        
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
    }
    
    /**
     * Gestiona el evento de presionar el botón jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbCargarActionPerformed(ActionEvent evt)
    {
        // El diseño de la clase VentanaCarga fue hecho "a mano", con BlueJ
        VentanaCarga vc = new VentanaCarga(listado);
        vc.show();
    }
    
    /**
     * Gestiona el evento de presionar el botón jbMostrar
     * @param evt objeto que representa el evento generado
     */
    private void jbMostrarActionPerformed(ActionEvent evt)
    {
        // El diseño de la clase VentanaMostrar fue hecho con NetBeans, mediante el diseñador de formularios 
        VentanaMostrar vm = new VentanaMostrar(listado);
        vm.show();
    }
}
