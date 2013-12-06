/**
 * Clase para representar una ventana para cargar datos en un Listado
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VentanaCarga extends JFrame
{
    /*
     * 1.) Si esta ventana se cierra, la aplicación no debe terminar. Por lo tanto, el método "setDefaultCloseOperation" toma como 
     * parámetro la constante DISPOSE_ON_CLOSE, que provocará que al cerrar la ventana, está se oculte y se liberen los recursos que 
     * estaba usando, pero sin lanzar un "exit()" para la aplicación.
     * 
     * 2.) En Java, un error en tiempo de ejecución provocado por circunstancias anormales (división por cero, índices fuera de rango, 
     * casting imposible de realizar, puntero nulo invocando a un método, etc.) se representa como un objeto (!...¡) Así como la JVM crea
     * automáticamente objetos que representan a los eventos producidos por el usuario sobre los componentes de la IGU, también genera
     * automáticamente objetos que representan a un error en tiempo de ejecución, permitiendo que el programador pueda (si lo desea) 
     * intervenir en esa situación y eventualmente recuperarse de ella, incluso sin que la aplicación finalice de forma abrupta. Esos 
     * objetos que representan errores de ejecución se llaman "excepciones", y forman parte de una jerarquía de clases cuya clase base es
     * la clase "Throwable" (o sea: "lanzable"):
     * 
     *      Throwable <--- Exception <--- RuntimeException  (UNCHECKED)
     *                |              <--- IOException       (CHECKED)
     *                |              <--- (Excepciones definidas por el programador)  (CHECKED)
     *                |               
     *                <--- Error  (UNCHECKED)
     *                
     * 3.) Los errores representados por la clase Error son errores graves de hardware o de sistema frente a los cuales no se espera que
     * el programador pueda hacer nada más que darse por notificado del hecho. Son manejados automáticamente por la JVM. Los errores 
     * representados por la clase Exception son errores comunes de programación, algunos más graves que otros, que pueden requerir que el
     * programador se vea obligado a escribir código de respuesta de esas excepciones, pues de lo contrario el programa no compilará. En 
     * ese sentido, las excepciones pueden clasificarse en "chequeadas" (checked) y en "no chequeadas" (unchecked). El gráfico anterior 
     * muestra cuáles son de cada tipo.
     * 
     * 4.) Si un segmento de código puede llegar a lanzar una excepción del tipo "checked", entonces el compilador obliga a que el programador
     * tenga eso en cuenta, escribiendo código para tratar esa posible excepción, aunque luego en la práctica la misma no llegue a lanzarse.
     * En general, todas las clases de excepción que derivan de la clase Exception son "chequeadas" (salvo las que derivan a su vez de la
     * clase RunTimeException). Por ejemplo, las excepciones de IO que pueden producirse al trabajar con entrada de datos desde distintos 
     * dispositivos, derivan todas de la clase IOException, que a su vez baja desde Exception, y todas ellas son chequeadas: debemos escribir
     * código para tratar las posibles excepciones de IO provocadas por nuestro código. Ese es el motivo por el cual cuando se trabajó con el
     * método System.read() para cargar caracteres desde teclado. debía incluirse algo así al declarar el método main donde se usaba la carga:
     * 
     *                             public static void main (String args[]) throws Exception
     *                             
     * 5.) Si la excepción es "no chequeada", el compilador NO OBLIGA a escribir código alguno de respuesta, y es decisión del programador el
     * hacerlo o no. Todas las clases de excepción derivadas desde RuntimeException son no chequeadas, y también las derivadas de Error. Si el
     * programador no incluye ningún código de tratamiento para estas clases de excepciones y alguna llega a producirse, simplemente el 
     * programa finalizará mostrando un mensaje de error acorde a la excepción producida, pero no habrá problemas de compilación previa. Las
     * clases de excepción más comunes derivadas de RunTimeException y de IOException se ven en el siguiente gráfico ampliado:
     * 
     *      Throwable <--- Exception <--- RuntimeException  (UNCHECKED)  <--- NullPointerException
     *                |              |                                   <--- ArithmeticException
     *                |              |                                   <--- IndexOutBoundsException
     *                |              |                                   <--- NegativeArraySizeException
     *                |              |
     *                |              <--- IOException       (CHECKED) <--- EOFException
     *                |              |                                <--- FileNotFoundException
     *                |              |                                <--- InterruptedIOException
     *                |              |                                <--- ObjectStreamException
     *                |              |
     *                |              <--- (Excepciones definidas por el programador)  (CHECKED)
     *                |               
     *                <--- Error  (UNCHECKED)
     * 
     * 6.) Existen dos formas básicas de responder a una excepción. Si la excepción es chequeada, el programador está obligado a decidirse
     * por alguna de las dos que indicaremos. Si la excpeión es no chequeada, el programador puede optar por no usar ninguna y simplemente
     * ignorarla, o puede tratarla con cualquiera de las dos formas.
     * 
     *      i.) Lo más sencillo, es simplemente declarar la posibilidad de lanzamiento de excepción en la cabecera del método que posea el 
     *      bloque de código sospechoso:
     *      
     *             public char leer () throws IOException  // o cualquiera que polimórficamente pueda representar a la excepción lanzada
     *             {
     *                System.out.print("Cargue un caracter: ");
     *                char r = (char) System.in.read();
     *                return r;
     *             }
     *             
     *      Si el código sospechoso pudiera lanzar más de una clase de excepción, se pueden declarar todas en la cabecera:
     *      
     *             public char leer () throws IOException, Exception
     *             {
     *                System.out.print("Cargue un caracter: ");
     *                char r = (char) System.in.read();
     *                return r;
     *             }
     *      
     *             
     *      ii.) Lo anterior hace que el programador obligue a quien invoque al método "leer" a tratar a su vez la excepción lanzada por él.
     *      En otras palabras, el programador de "leer" se "saca el problema de encima" y lo transfiere a su "cliente". La forma más natural
     *      (y posiblemente más comprometida!!!) de tratar una excepción (sobre todo si es chequeda), consiste en "capturarla" con un bloque
     *      "try - catch":
     *      
     *             public char leer ()
     *             {
     *                char r = '';
     *                try
     *                {
     *                   System.out.print("Cargue un caracter: ");
     *                   char r = (char) System.in.read();
     *                }
     *                catch(IOException ex)
     *                {
     *                   JOptionPane.showMessageDialog(null, "Se produjo un error de IO");   
     *                }
     *                return r;
     *             }
     *      
     *      Si el bloque encerrado entre las llaves de "try" llega a disparar una excepción de tipo IOException, automáticamente la JVM creará
     *      un objeto de esa clase y buscará el bloque "catch" que tenga un parámetro IOException. Si lo encuentra, pasará el objeto creado a
     *      ese bloque, y se ejecutará el código encerrado entra las llaves de "catch". Luego de ello, el programa seguirá ejecutando las 
     *      instrucciones que se encuentran debajo del bloque "catch" (a menos que dentro del catch se haya lanzado un "exit()"). Como se ve,
     *      no necesariamente el programa termina si una excepción se produce y la misma es capturada. La decisión de terminarlo es del 
     *      programador. El objeto generado por la JVM para representar la excepción dispone de una serie de métodos que permiten que el 
     *      programador tenga mayor conocimiento del error producido. Uno de esos métodos es "getMessage" (heredado desde Throwable) que 
     *      retorna un String con una descripción del error que provocó la excepción. El mismo puede usarse para mostrar un mensaje más claro:
     *      
     *             public char leer ()
     *             {
     *                char r = '';
     *                try
     *                {
     *                   System.out.print("Cargue un caracter: ");
     *                   char r = (char) System.in.read();
     *                }
     *                catch(IOException ex)
     *                {
     *                   JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());   
     *                }
     *                return r;
     *             }
     *      
     *      Si el bloque try puede llegar a lanzar excepciones de varias clases diferentes (aunque obviamente, sólo una en un momento dado), 
     *      se pueden escribir varios bloques catch, cada uno con un parámetro que represente a la excepción esperada. Sólo debe tenerse en 
     *      cuenta que la JVM recorre las definiciones catch por orden de escritura en el código, y al primero cuyo parámetro coincida con la
     *      excepción generada (incluidas las referencias polimórficas), lo aceptará. Por lo tanto, escriba los diversos catch comenzando por 
     *      los MENOS POLIMORFICOS, y siga con los MAS POLIMORFICOS:
     *      
     *             public char leer ()
     *             {
     *                char r = '';
     *                
     *                try
     *                {
     *                   System.out.print("Cargue un caracter: ");
     *                   char r = (char) System.in.read();
     *                }
     *                
     *                catch(IOException ex)
     *                {
     *                   JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());   
     *                }
     *                
     *                // Si este bloque estuviera antes que el anterior, no dejaría pasar ninguna excepción derivada de ella...
     *                catch(Exception ex)
     *                {
     *                   JOptionPane.showMessageDialog(null, "Error: Inesperado: " + ex.getMessage());
     *                   System.exit(0);
     *                }
     *                return r;
     *             }
     *                           
     */
    
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
        jlMensaje = new JLabel("Ingrese un número entero: ", SwingConstants.LEFT);
    
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
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
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
        
        // Proveemos un ícono para la ventana
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
     * Gestiona el evento de presionar el botón jbCargar
     * @param evt objeto que representa el evento generado
     */
    private void jbAgregarActionPerformed(ActionEvent evt)
    {
        //*
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
        // Si reemplaza todo el código anterior por el que sigue, la clase sigue compilando sin problemas, pero al producirse un error de 
        // conversión de números el programa lanzará una excepción mostrando mensajes de error en la consola estándar. Si el código en 
        // cuestión estuviera en el método main, el programa finalizaría su ejecución.
        /*        
          Integer num = Integer.valueOf(jtfNumero.getText());
          listado.add(num);
          jtfNumero.setText("");
        //*/
    }
}

