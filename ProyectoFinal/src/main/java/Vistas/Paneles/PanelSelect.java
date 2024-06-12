package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSelect extends JPanel {
    private ArrayList<TipoAnimal> animales;
    private JButton[] botones;
    public PanelSelect(int x, int y, int width, int height, ArrayList<TipoAnimal> animales) {
        super(new GridLayout(2,3,10,10));
        this.animales = animales;
        this.setBounds(x,y,width,height);
    }
    public void addBotones(JButton[] botones) {
        for(int i=0; i<6; i++) {
            botones[i] = new JButton(""+i);
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
