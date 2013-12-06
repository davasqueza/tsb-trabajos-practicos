package clases;

/**
 * Clase para mostrar los datos cargados en la ventana principal
 * @author Ing. Valerio Frittelli
 * @version Mayo de 2004
*/

import java.awt.*;
import java.awt.event.*;
public class Receptor extends Frame 
{
    private Label  lab[];
    private Button bVolver;

    private class Cierre extends WindowAdapter
    {
       public void windowClosing(WindowEvent evt)
       {
          setVisible(false);
       }
    }

    public Receptor (String valores[])
    {
    	super ("Los datos recibidos son: "); 

    	// el cierre de ventana lo gestiona una clase interna
    	Cierre e = new Cierre();
    	this.addWindowListener(e);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit. getScreenSize();
        int alto = dim.height;
        int ancho = dim.width;
        
        setSize (ancho / 2, alto / 2);       
        setLocation(ancho / 4, alto / 4);
        
        Image img = kit.getImage("exclam.gif");
        setIconImage(img);

        setBackground(Color.lightGray);
        
        agregar(valores);
    } 
    
    /*
     * Crea y agrega los componentes
     */
    public void agregar(String valores[])
    {
        // creamos un vector de etiquetas con los strings tomados como par�metro
    	lab = new Label[5];
    	for (int i = 0; i<5; i++)
    	{
    	   lab[i] = new Label(valores[i], Label.CENTER);
    	}
    	
    	bVolver = new Button("Volver");
    	
    	// una clase an�nima para actionPerformed...
    	bVolver.addActionListener( new ActionListener ()
    	                           { 
    	                               public void actionPerformed(ActionEvent evt)
                                       {
                                          if(evt.getSource() == bVolver)
                                          { 
	                                         setVisible(false);
                                          }
                                       }  
                                   }    
    	                         );

        
    	
    	// creamos dos paneles para distribuir mejor en el Frame
    	Panel pNorte, pSur;
    	
    	// en el norte todas las Label
    	pNorte = new Panel (new GridLayout(5,1,20,20));
    	for(int j = 0; j<5; j++)
    	{
    	   pNorte.add(lab[j]);
    	}  
    	
    	// en el sur el bot�n
    	pSur = new Panel(new FlowLayout());
    	pSur.add(bVolver);
    	
    	this.setLayout(new BorderLayout());
    	this.add(pNorte,"North");
    	this.add(pSur,  "South");
    }
}

