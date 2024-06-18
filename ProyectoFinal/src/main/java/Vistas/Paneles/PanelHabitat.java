package Vistas.Paneles;

import Modelos.Utils.Habitat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un panel que contiene paneles y botones que muestran visualmente un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelHabitat extends JPanel {
    private Habitat habitat;
    private PanelRecinto[] listaPanelRecinto;
    private boolean visible;

    public PanelHabitat(Habitat habitat) {
        super(null);
        this.habitat = habitat;
        visible = false;
        this.setOpaque(false);
        this.setBounds(43,100,914,522);
        listaPanelRecinto = new PanelRecinto[6];
        int j=0;
        for(int i=0; i<6; i++) {
            listaPanelRecinto[i] = new PanelRecinto(habitat.getRecinto(i));
            listaPanelRecinto[i].setBounds(51+279*(i%3),46+j,254,200);
            this.add(listaPanelRecinto[i]);
            if(i==2)
                j=230;
        }
    }

    public void toggleVisible() {
        visible=!visible;
    }
    public boolean getVisible() { return visible; }
    public Habitat getHabitat() { return habitat; }


    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}