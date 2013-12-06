/**
 * Clase para representar una Ventana para cargar datos diversos usando componentes de distintos tipos
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
 */
import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame
{
    private Button bEnviar;    
    private Button bSalir;
    private Label lLegajo, lNombre, lEdad;
    private TextField tfLegajo,tfNombre,tfEdad;
    private CheckboxGroup cbgSexos;
    private Checkbox  cbMujer, cbVaron;
    private List  lEstado;
    
    private Panel pNorte, pCentro, pSur;
    
    private String valores[];
    
    
    // Clase auxiliar interna para control de eventos sobre botones en el Frame
    private class ControladorDeBotones implements ActionListener
    {
        public void actionPerformed (ActionEvent evt)
        {
               if(evt.getSource() == bEnviar)
               {
                 if(cbVaron.getState() == true) { valores[0] = "Sexo: Varon" ; }
                 else { valores[0] = "Sexo: Mujer"; }
                 valores[1] = "Estado: " + lEstado.getSelectedItem();
                 valores[2] = "Legajo: " + tfLegajo.getText();
                 valores[3] = "Nombre: " + tfNombre.getText();
                 valores[4] = "Edad:   " + tfEdad.getText();
                 
                 Receptor rec = new Receptor(valores);
                 rec.setVisible(true);
               }
               else
               {
                  if(evt.getSource() == bSalir)
                  {
                    System.exit(0);
                  }
               }
        }
    }
        
    // Clase auxiliar interna para control de eventos sobre componentes seleccionables.
    private class ControladorDeItems implements ItemListener
    {
            public void itemStateChanged (ItemEvent evt)
            {
                  Checkbox cb = (Checkbox)evt.getSource();
                  if( cb == cbVaron)
                  {
                     tfEdad.setEnabled(true);
                  }
                  else
                  {
                    if(cb == cbMujer)
                    {
                      tfEdad.setText("");
                      tfEdad.setEnabled(false);
                    } 
                  }
            }
    }
    

    /**
     * Crea el Frame, ajusta sus valores, y le agrega los componentes 
     */
    public Ventana()
    {
        super ("Ventana de Carga");

        this.addWindowListener( new WindowAdapter()
                                { 
                                   public void windowClosing(WindowEvent e)
                                   { 
                                     System.exit(0);
                                   }
                                }
                              );

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit. getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        // Fijamos el ancho, el alto y las coordenadas de arranque para mostrarla centrada
        setSize (ancho / 2, alto / 3);       
        setLocation(ancho / 4, alto / 4);
        
        // Proveemos un ícono para la ventana
        Image img = kit.getImage("exclam.gif");
        setIconImage(img);

        setBackground(Color.lightGray);
            
        crearComponentes();     
        agregarComponentes();        
        
        ControladorDeBotones cb = new ControladorDeBotones();
        ControladorDeItems   ci = new ControladorDeItems();
        
        // todo el mundo a notificar el lugar de sus métodos de respuesta
        bEnviar.addActionListener(cb);
        bSalir.addActionListener(cb);

        cbMujer.addItemListener(ci);
        cbVaron.addItemListener(ci);
    } 
    
    /**
     * Crea los componentes a incluir en la ventana
     */
    public void crearComponentes()
    {
        // creamos los componentes
        cbgSexos  = new CheckboxGroup();
        cbMujer   = new Checkbox("Mujer", cbgSexos, false);
        cbVaron   = new Checkbox("Varon", cbgSexos, true);
        
        lLegajo = new Label("Legajo: ", Label.LEFT);
        lNombre = new Label("Nombre: ", Label.LEFT);
        lEdad   = new Label("Edad:   ", Label.LEFT);
        tfLegajo= new TextField("",20);
        tfNombre= new TextField("",20);
        tfEdad  = new TextField("",20);
    
        lEstado = new List(1);
        lEstado.add("Casado");
        lEstado.add("Viudo");
        lEstado.add("Separado");
        lEstado.add("Solterito");
         
        bEnviar = new Button("Enviar");
        bSalir  = new Button("Terminar");
        
        valores = new String[5];
        
        // creamos tres paneles para usarlos como auxuliares en el Frame
        pNorte  = new Panel(new FlowLayout());
        
        pCentro = new Panel();
        pCentro.setLayout(null);
        
        pSur    = new Panel(new FlowLayout());
    }

    /*
     *  Agrega los componentes a la ventana
     */
    public void agregarComponentes()
    {
        // agregamos componentes en el panel norte
        pNorte.add(cbVaron);
        pNorte.add(cbMujer);
        pNorte.add(lEstado);
        
        // agregamos componentes en el panel centro
        lLegajo.setBounds(130,20,60,20);
        pCentro.add(lLegajo);
        
        tfLegajo.setBounds(230,20,150,20);
        pCentro.add(tfLegajo);
        
        lNombre.setBounds(130,70,60,20);
        pCentro.add(lNombre);
        
        tfNombre.setBounds(230,70,150,20);
        pCentro.add(tfNombre);
        
        lEdad.setBounds(130,120,60,20);
        pCentro.add(lEdad);
        
        tfEdad.setBounds(230,120,150,20);
        pCentro.add(tfEdad);
        
        // agregamos componentes en el panel sur
        pSur.add(bEnviar);
        pSur.add(bSalir);
        
        this.setLayout(new BorderLayout());
        this.add(pNorte, "North");
        this.add(pCentro, "Center");
        this.add(pSur, "South");
    }
}

