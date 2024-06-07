package Vistas;

import Modelos.Recinto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/** Un panel que muestra las monedas guardadas en un deposito y sus series
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelRecinto extends JPanel {
    private BufferedImage ImgBackground;
    private boolean visible;
    private Recinto recinto;
    private PanelInteractivo interact;

    /** Constructor se crea el panel, su fondo y sus cuadros de texto */
    public PanelRecinto(Recinto recinto) {
        super(null);
        visible = false;
        interact = new PanelInteractivo();
        this.recinto = recinto;
        this.setBounds(30, 80,603,550);
        this.setBackground(new Color(0,0,0,0));

        //try {
        //    ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        //} catch (IOException ex) {
        //    System.out.println(ex.getMessage());
        //}
    }

    public void closeInfo(int index) {
        if(interact.getVisible()) {
            interact.togglePanel();
            repaint();
        }
    }

    private class OpenPanel implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
        }

        @Override
        public void mouseReleased(MouseEvent event) {}

    }
    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //if(visible)
            //g.drawImage(ImgBackground, 0, 0, this);
    }
}
