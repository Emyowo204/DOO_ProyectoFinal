package Vistas.Paneles;


import Vistas.Utils.Boton;
import Vistas.Utils.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelInformacion extends JPanel {
    private boolean showing;
    private Boton bCerrar;
    private BufferedImage ImgBackground;

    public PanelInformacion(){
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        showing = false;
        CerrarPanel cerrarPanel = new CerrarPanel();
        bCerrar = new Boton(Color.BLACK,true,"imgCerrar.png");
        bCerrar.setBounds(10,10,100,38);
        bCerrar.addActionListener(cerrarPanel);
        this.add(bCerrar);
        ImgBackground = null;
    }

    public void setFondo(int index) {
        ImgBackground = ImageLoader.getInstancia().getImagenFondoInfo(index);
    }


    public void toggleShowing() {
        showing = !showing;
    }

    public boolean getShowing(){
        return showing;
    }

    private class CerrarPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelZoo().toggleInfo(-1);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(getShowing())
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
