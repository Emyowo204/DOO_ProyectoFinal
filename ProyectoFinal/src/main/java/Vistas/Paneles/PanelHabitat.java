package Vistas.Paneles;

import Modelos.Habitat;

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
    private BufferedImage ImgBackground;

    public PanelHabitat(Habitat habitat, int index) {
        super(null);
        this.habitat = habitat;
        visible = false;
        this.setBackground(Color.BLACK);
        this.setBounds(50,100,900,520);
        listaPanelRecinto = new PanelRecinto[6];
        int j=0;
        for(int i=0; i<6; i++) {
            listaPanelRecinto[i] = new PanelRecinto(habitat.getRecinto(i));
            listaPanelRecinto[i].setBounds(50+275*(i%3),45+j,250,200);
            this.add(listaPanelRecinto[i]);
            if(i==2)
                j=230;
        }
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgHabitat"+index+".png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void toggleVisible() { visible=!visible; }
    public boolean getVisible() { return visible; }
    public Habitat getHabitat() { return habitat; }


    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}