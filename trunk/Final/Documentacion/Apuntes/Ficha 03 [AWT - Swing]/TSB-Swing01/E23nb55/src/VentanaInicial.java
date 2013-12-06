/**
 * Una ventana creada con componentes del paquete swing, usada como ventana de arranque en una aplicaci�n que carga datos en un Listado.
 * La clase Listado es la misma que se present� oportunamente en el Encuentro 2 (ver Ejemplo14) 
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
     * 1.) El paquete AWT incorporado por Java desde sus inicios para dise�o de IGUs, trabaja de forma que al incluir un componente en una
     * ventana (tal como un Button o un TextField), lo �nico que hace el programa es indicar d�nde colocar el mismo y su comportamiento 
     * b�sico, y luego se delega en el kit de recursos del sistema operativo hu�sped la forma de visualizar y controlar ese componente. Por
     * caso, si un programa pide incluir un bot�n en la interfaz, es en realidad un bot�n "oculto" del kit de recursos del SO el que maneja
     * a ese bot�n. De esta manera, se pretendi� que la interfaz de usuario de cada aplicaci�n "luzca y se sienta" ("look and feel") tal y 
     * como "lucen y se sienten" las aplicaciones nativas de cada plataforma, y a�n m�s importante: en teor�a, un programa as� escrito 
     * deber�a correr sin problemas en forma portable en cualquier plataforma.
     * 
     * 2.) Pero en la pr�ctica esto ha funcionado bien s�lo con programas simples e interfaces sencillas. Hay varios problemas que hacen 
     * que esta aproximaci�n de gestionar la interfaz de usuario a trav�s de componentes ocultos o "compa�eros" del SO nativo, no funcione
     * del todo como se hab�a planeado:
     *       i.) No todos los componentes se comportan igual en todas las plataformas, y resulta entonces complicado proveer una interfaz 
     *           consistente a los usuarios finales.
     *           
     *       ii.) No todas las plataformas proveen un entorno rico en componentes como s� lo hacen otras como Windows o Macintosh. Por esta
     *            raz�n el AWT debi� limitarse s�lo a un conjunto de componentes que conforman lo que llamar�amos "el com�n denominador", 
     *            y de esta forma las interfaces de usuario no "lucen ni se sienten" como uno esperar�a al correrlas en plataformas como
     *            Windows o Mac. Simplemente, lucen poco y se sienten pobres.
     *            
     *       iii.) Y finalmente, existen "bugs" (fallas) de comportamiento de componentes nativos diferentes en distintas plataformas. Esto
     *             termina haciendo que los prgramadores escriban el programa una vez, y lo corran una vez cuando ya est� testeado, pero 
     *             para testearlo deben realizar sesiones de "debug" en cada plataforma...
     *         
     * 3.) Un enfoque diferente fue planteado en 1996 por NetScape al introducir su paquete "Internet Foundation Classes" o IFC, y estas
     * ideas fueron a�n mejoradas al trabajar en forma conjunta con Sun Corporation para lanzar el paquete "Java Foundation Classes" o
     * JFC, del cual a su vez forma parte el paquete Swing para desarrollo de interfaces de usuario. En esta nueva aproximaci�n, los 
     * componentes son dibujados en forma directa en ventanas "blancas", y el �nico soporte que se requiere del kit de recursos nativos del
     * SO es la forma de desplegar ventanas y "pintar" sobre ellas. As�, las IGUs realmente lucen y se sienten como el programador dispuso
     * que luzcan y se sientan.
     * 
     * 4.) Sin embargo, Swing no reemplaza a AWT: b�sicamente el modelo de dise�o y de control de eventos es el mismo, y de hecho, las 
     * clases del paquete swing heredan desde las clases del paquete AWT. Swing provee mejores capacidades en la forma de desarrollar 
     * interfaces, y mayor control de la misma por parte del programador. Un detalle: el nombre Swing es el nombre en c�digo que ten�a el 
     * equipo de desarrollo dentro de Sun, encargado de incorporar a las interfaces Java la tecnolog�a de NetScape, y ese nombre se termin�
     * generalizando para designar al paquete por ellos producido.
     * 
     * 5.) En el paquete javax.swing, una ventana de alto nivel no contenida dentro de otra (lo que en AWT era un Frame), se modela a 
     * partir de la clase JFrame, que deriva de Frame. En general esto ser� cierto para todos los componentes AWT y Swing: cada componente
     * AWT tendr� su equivalente Swing, y el nombre de este �ltimo comenzar� con "J": Button para AWT --> JButton en Swing, etc. Un JFrame
     * es uno de los pocos componentes de Swing que se dibuja con ayuda del kit de recursos del SO, por lo cual la barra de t�tulos, los 
     * botones de control y los bordes lucir�n diferentes en distintas plataformas (como era de esperarse).
     * 
     * 6.) Un JFrame representa una ventana de alto nivel con una estructura m�s compleja que un Frame AWT. Por empezar, un JFrame est� 
     * dividido en varios contenedores internos, usados para gestionar componentes en forma m�s eficiente que un Frame. Uno de esos 
     * contenedores es el llamado "Content Pane", que es el que realmente contiene a los elementos que el programador agrega al JFrame. Si
     * se est� usando un JFrame, para a�adir componentes no se usa en forma directa el m�todo "add" (que us�bamos con un Frame com�n): se
     * accede al Content Pane y se a�aden elementos a �l. El acceso al Content Pane se logra con el m�todo "getContentPane" de JFrame, el 
     * cual retorna una referencia al Content Pane, y mediante esa referencia se invoca al m�todo "add" para a�adir componentes. El Layout
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
     * 7.) Con un JFrame es m�s simple el control de eventos de ventana, tales como cerrar la ventana, ocultarla, u ocultarla y destruirla.
     * El m�todo "setDefaultCloseOperation" de JFrame permite indicar en una s�la instrucci�n lo que debe hacer la apliaci�n si el usuario
     * presion� el bot�n de cierre de la ventana. Ese m�todo puede recibir uno de los siguientes cuatro par�metros, y en funci�n del mismo
     * indicar� a la JVM la respuesta que debe dar al evento de cierre, sin tener que implementar WindowListener. Los valores de los 
     * par�metros se manejan con constantes, declaradas en la clase JFrame o en la clase WindowConstants:
     *                     DO_NOTHING_ON_CLOSE   (definida en WindowConstants): No lleva a cabo ninguna acci�n, y requiere que el programa
     *                                           implemente WindowListener. Si se pasa este par�metro, el JFrame se comportar� como un 
     *                                           Frame.
     *                                           
     *                     HIDE_ON_CLOSE         (definida en WindowConstants): Cierra autom�ticamente el frame al pedir el cierre.
     *                     
     *                     DISPOSE_ON_CLOSE      (definida en WindowConstants): Cierra y destruye autom�ticamente el frame.
     *                     
     *                     EXIT_ON_CLOSE         (definida en JFrame):  Termina la aplicaci�n usando el m�todo System.exit.
     *                     
     * El valor por defecto es HIDE_ON_CLOSE: a�n cuando no se indique qu� hacer al cerrar un JFrame, este se cerrar� pero quedar� activo 
     * en memoria.
     * 
     * 8.) El truco de crear una clase an�nima que implemente el m�todo de respuesta a eventos necesitado, pero de forma que ese m�todo a 
     * su vez invoque a otro cuyo nombre contiene el nomnbre del objeto al cual se responde, es muy usado por los entornos de desarrollo
     * visual en Java (JBuilder, J++, NetBeans, Visual Caf�, etc.), aunque muchos consideran que esa forma de plantear el modelo de eventos
     * "oscurece" el c�digo.
     */
 
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
        vc.show();
    }
    
    /**
     * Gestiona el evento de presionar el bot�n jbMostrar
     * @param evt objeto que representa el evento generado
     */
    private void jbMostrarActionPerformed(ActionEvent evt)
    {
        // El dise�o de la clase VentanaMostrar fue hecho con NetBeans, mediante el dise�ador de formularios 
        VentanaMostrar vm = new VentanaMostrar(listado);
        vm.show();
    }
}
