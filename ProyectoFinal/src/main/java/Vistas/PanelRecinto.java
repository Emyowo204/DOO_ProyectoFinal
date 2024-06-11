package Vistas;

import Modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/** Un panel que muestra las monedas guardadas en un deposito y sus series
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelRecinto extends JPanel implements ActionListener {
    private BufferedImage ImgBackground;
    private boolean visible;
    private Recinto recinto;
    private Timer timer;
    private ArrayList<Animal> animales;

    /** Constructor se crea el panel, su fondo y sus cuadros de texto */
    public PanelRecinto(Recinto recinto) {

        super(null);

        timer = new Timer(0,this);
        timer.start();
        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        visible = false;
        this.setBounds(30, 80,603,550);
        this.setBackground(Color.WHITE);
    }

    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<animales.size(); i++)
            animales.get(i).paintComponent(g,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

}
