package Vistas;

import Modelos.Animal;
import Modelos.Delfin;
import Modelos.Recinto;
import Modelos.TipoAnimal;

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
        animales = new ArrayList<>();
        animales.add(new Delfin("Juan", TipoAnimal.Delfin));
        visible = false;
        this.recinto = recinto;
        this.setBounds(30, 80,603,550);
        this.setBackground(Color.WHITE);


    }

    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        animales.get(0).paintComponent(g,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

}
