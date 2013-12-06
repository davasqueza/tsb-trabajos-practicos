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
     * 1.) Si esta ventana se cierra, la aplicaci�n no debe terminar. Por lo tanto, el m�todo "setDefaultCloseOperation" toma como 
     * par�metro la constante DISPOSE_ON_CLOSE, que provocar� que al cerrar la ventana, est� se oculte y se liberen los recursos que 
     * estaba usando, pero sin lanzar un "exit()" para la aplicaci�n.
     * 
     * 2.) En Java, un error en tiempo de ejecuci�n provocado por circunstancias anormales (divisi�n por cero, �ndices fuera de rango, 
     * casting imposible de realizar, puntero nulo invocando a un m�todo, etc.) se representa como un objeto (!...�) As� como la JVM crea
     * autom�ticamente objetos que representan a los eventos producidos por el usuario sobre los componentes de la IGU, tambi�n genera
     * autom�ticamente objetos que representan a un error en tiempo de ejecuci�n, permitiendo que el programador pueda (si lo desea) 
     * intervenir en esa situaci�n y eventualmente recuperarse de ella, incluso sin que la aplicaci�n finalice de forma abrupta. Esos 
     * objetos que representan errores de ejecuci�n se llaman "excepciones", y forman parte de una jerarqu�a de clases cuya clase base es
     * la clase "Throwable" (o sea: "lanzable"):
     * 
     *      Throwable <--- Exception <--- RuntimeException  (UNCHECKED)
     *                |              <--- IOException       (CHECKED)
     *                |              <--- (Excepciones definidas por el programador)  (CHECKED)
     *                |               
     *                <--- Error  (UNCHECKED)
     *                
     * 3.) Los errores representados por la clase Error son errores graves de hardware o de sistema frente a los cuales no se espera que
     * el programador pueda hacer nada m�s que darse por notificado del hecho. Son manejados autom�ticamente por la JVM. Los errores 
     * representados por la clase Exception son errores comunes de programaci�n, algunos m�s graves que otros, que pueden requerir que el
     * programador se vea obligado a escribir c�digo de respuesta de esas excepciones, pues de lo contrario el programa no compilar�. En 
     * ese sentido, las excepciones pueden clasificarse en "chequeadas" (checked) y en "no chequeadas" (unchecked). El gr�fico anterior 
     * muestra cu�les son de cada tipo.
     * 
     * 4.) Si un segmento de c�digo puede llegar a lanzar una excepci�n del tipo "checked", entonces el compilador obliga a que el programador
     * tenga eso en cuenta, escribiendo c�digo para tratar esa posible excepci�n, aunque luego en la pr�ctica la misma no llegue a lanzarse.
     * En general, todas las clases de excepci�n que derivan de la clase Exception son "chequeadas" (salvo las que derivan a su vez de la
     * clase RunTimeException). Por ejemplo, las excepciones de IO que pueden producirse al trabajar con entrada de datos desde distintos 
     * dispositivos, derivan todas de la clase IOException, que a su vez baja desde Exception, y todas ellas son chequeadas: debemos escribir
     * c�digo para tratar las posibles excepciones de IO provocadas por nuestro c�digo. Ese es el motivo por el cual cuando se trabaj� con el
     * m�todo System.read() para cargar caracteres desde teclado. deb�a incluirse algo as� al declarar el m�todo main donde se usaba la carga:
     * 
     *                             public static void main (String args[]) throws Exception
     *                             
     * 5.) Si la excepci�n es "no chequeada", el compilador NO OBLIGA a escribir c�digo alguno de respuesta, y es decisi�n del programador el
     * hacerlo o no. Todas las clases de excepci�n derivadas desde RuntimeException son no chequeadas, y tambi�n las derivadas de Error. Si el
     * programador no incluye ning�n c�digo de tratamiento para estas clases de excepciones y alguna llega a producirse, simplemente el 
     * programa finalizar� mostrando un mensaje de error acorde a la excepci�n producida, pero no habr� problemas de compilaci�n previa. Las
     * clases de excepci�n m�s comunes derivadas de RunTimeException y de IOException se ven en el siguiente gr�fico ampliado:
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
     * 6.) Existen dos formas b�sicas de responder a una excepci�n. Si la excepci�n es chequeada, el programador est� obligado a decidirse
     * por alguna de las dos que indicaremos. Si la excpei�n es no chequeada, el programador puede optar por no usar ninguna y simplemente
     * ignorarla, o puede tratarla con cualquiera de las dos formas.
     * 
     *      i.) Lo m�s sencillo, es simplemente declarar la posibilidad de lanzamiento de excepci�n en la cabecera del m�todo que posea el 
     *      bloque de c�digo sospechoso:
     *      
     *             public char leer () throws IOException  // o cualquiera que polim�rficamente pueda representar a la excepci�n lanzada
     *             {
     *                System.out.print("Cargue un caracter: ");
     *                char r = (char) System.in.read();
     *                return r;
     *             }
     *             
     *      Si el c�digo sospechoso pudiera lanzar m�s de una clase de excepci�n, se pueden declarar todas en la cabecera:
     *      
     *             public char leer () throws IOException, Exception
     *             {
     *                System.out.print("Cargue un caracter: ");
     *                char r = (char) System.in.read();
     *                return r;
     *             }
     *      
     *             
     *      ii.) Lo anterior hace que el programador obligue a quien invoque al m�todo "leer" a tratar a su vez la excepci�n lanzada por �l.
     *      En otras palabras, el programador de "leer" se "saca el problema de encima" y lo transfiere a su "cliente". La forma m�s natural
     *      (y posiblemente m�s comprometida!!!) de tratar una excepci�n (sobre todo si es chequeda), consiste en "capturarla" con un bloque
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
     *      Si el bloque encerrado entre las llaves de "try" llega a disparar una excepci�n de tipo IOException, autom�ticamente la JVM crear�
     *      un objeto de esa clase y buscar� el bloque "catch" que tenga un par�metro IOException. Si lo encuentra, pasar� el objeto creado a
     *      ese bloque, y se ejecutar� el c�digo encerrado entra las llaves de "catch". Luego de ello, el programa seguir� ejecutando las 
     *      instrucciones que se encuentran debajo del bloque "catch" (a menos que dentro del catch se haya lanzado un "exit()"). Como se ve,
     *      no necesariamente el programa termina si una excepci�n se produce y la misma es capturada. La decisi�n de terminarlo es del 
     *      programador. El objeto generado por la JVM para representar la excepci�n dispone de una serie de m�todos que permiten que el 
     *      programador tenga mayor conocimiento del error producido. Uno de esos m�todos es "getMessage" (heredado desde Throwable) que 
     *      retorna un String con una descripci�n del error que provoc� la excepci�n. El mismo puede usarse para mostrar un mensaje m�s claro:
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
     *      Si el bloque try puede llegar a lanzar excepciones de varias clases diferentes (aunque obviamente, s�lo una en un momento dado), 
     *      se pueden escribir varios bloques catch, cada uno con un par�metro que represente a la excepci�n esperada. S�lo debe tenerse en 
     *      cuenta que la JVM recorre las definiciones catch por orden de escritura en el c�digo, y al primero cuyo par�metro coincida con la
     *      excepci�n generada (incluidas las referencias polim�rficas), lo aceptar�. Por lo tanto, escriba los diversos catch comenzando por 
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
     *                // Si este bloque estuviera antes que el anterior, no dejar�a pasar ninguna excepci�n derivada de ella...
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
        // Si reemplaza todo el c�digo anterior por el que sigue, la clase sigue compilando sin problemas, pero al producirse un error de 
        // conversi�n de n�meros el programa lanzar� una excepci�n mostrando mensajes de error en la consola est�ndar. Si el c�digo en 
        // cuesti�n estuviera en el m�todo main, el programa finalizar�a su ejecuci�n.
        /*        
          Integer num = Integer.valueOf(jtfNumero.getText());
          listado.add(num);
          jtfNumero.setText("");
        //*/
    }
}

