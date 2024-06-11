package Vistas;

import Modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/** Un panel que muestra las monedas guardadas en un deposito y sus series
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelRecinto extends JPanel implements Runnable{
    private BufferedImage ImgBackground;
    private boolean visible;
    private Recinto recinto;
    private Thread thread;
    private ArrayList<Animal> animales;

    /** Constructor se crea el panel, su fondo y sus cuadros de texto */
    public PanelRecinto(Recinto recinto) {

        super(null);


        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        visible = false;
        this.setBackground(Color.WHITE);
        thread = new Thread(this);
        thread.start();

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
    public void run() {
        boolean running = true;

        while(running) {
            long startTime = System.currentTimeMillis();

            for(int i=0; i< animales.size(); i++){
                animales.get(i).moveInPath();
            }
            repaint();

            long endTime = System.currentTimeMillis();
            long deltaTime = (1000/60) - (endTime - startTime);
            if(deltaTime > 0){
                try {
                    Thread.sleep(deltaTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
