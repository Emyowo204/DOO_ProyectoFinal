package Vistas;

import Modelos.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/** Un panel que contiene paneles y botones que muestran visualmente un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelHabitat extends JPanel {
    private Habitat habitat;
    private PanelRecinto[] listaPanelRecinto;
    private BufferedImage ImgBackground;

    public PanelHabitat(Habitat habitat) {
        super(null);
        this.habitat = habitat;
        this.setBackground(Color.GREEN);
        listaPanelRecinto = new PanelRecinto[6];
        for(int i=0; i<6; i++) {
            listaPanelRecinto[i] = new PanelRecinto(habitat.getRecinto(i));
        }
    }



    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(ImgBackground, 0, 0, this);
    }
}