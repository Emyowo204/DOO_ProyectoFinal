package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Panel que permite la selección del tipo de animal en un recinto
 *  @author Chloe Yañez Lavin
 *  @author Emily Osvaldo Gaete Bobadilla */
public class PanelSelect extends JPanel {

    /** Lista con los tipos de animales disponibles */
    private ArrayList<TipoAnimal> animales;

    /** Botones para seleccionar el tipo de animal */
    private Boton[] botones;

    /** Panel con los botones de selección */
    private JPanel downPanel;

    /** Constructor de PanelSelect */
    public PanelSelect(int x, int y, int width, int height, ArrayList<TipoAnimal> animales) {
        super(null);
        JPanel upPanel = new JPanel(null);
        upPanel.setBounds(0,0,200,20);
        upPanel.setOpaque(false);
        downPanel = new JPanel(new GridLayout(2,3,5,5));
        downPanel.setBounds(0,25,200,115);
        downPanel.setOpaque(false);
        this.animales = animales;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        CuadroTexto cText =  new CuadroTexto( "Seleccione un Animal: ", new Color(38,120,206), Color.WHITE, "Arial", 1);
        cText.setBounds(0,0,200,20);
        cText.setHorizontalAlignment(JLabel.CENTER);
        upPanel.add(cText);
        this.add(upPanel);
        this.add(downPanel);
    }

    /** Método para añadir los botones al panel */
    public void addBotones(Boton[] botones, int offset) {
        for(int i=0; i<6; i++) {
            botones[i] = new Boton(new Color(38,120,206), true,"Seleccion/imgAnimal"+(i+offset)+".png");
            downPanel.add(botones[i]);
        }
        this.botones = botones;
    }

    /** Método para actualizar el panel */
    public void updatePanel(ArrayList<TipoAnimal> newAnimales) {
        for(int i=0; i<newAnimales.size(); i++) {
            for(int j=0; j<animales.size(); j++){
                if(newAnimales.get(i) == animales.get(j))
                    downPanel.remove(botones[j]);
            }
        }
    }
}
