package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.Boton;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSelect extends JPanel {
    private ArrayList<TipoAnimal> animales;
    private Boton[] botones;
    public PanelSelect(int x, int y, int width, int height, ArrayList<TipoAnimal> animales) {
        super(new GridLayout(2,3,5,5));
        this.animales = animales;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
    }
    public void addBotones(Boton[] botones, int offset) {
        for(int i=0; i<6; i++) {
            botones[i] = new Boton(new Color(38,120,206), true,"Seleccion/imgAnimal"+(i+offset)+".png");
            this.add(botones[i]);
        }
        this.botones = botones;
    }
    public void updatePanel(ArrayList<TipoAnimal> newAnimales) {
        for(int i=0; i<newAnimales.size(); i++) {
            for(int j=0; j<animales.size(); j++){
                if(newAnimales.get(i) == animales.get(j))
                    this.remove(botones[j]);
            }
        }
    }
}
