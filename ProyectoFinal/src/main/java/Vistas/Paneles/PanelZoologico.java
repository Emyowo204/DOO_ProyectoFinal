package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Utils.Habitat;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;
import Vistas.Utils.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelZoologico extends JPanel {
    private Zoologico zoologico;
    private PanelHabitat[] listaPanelHabitat;
    private PanelHabitat openPanelHabitat;
    private Boton[] selectHabitat;
    private Boton[] bTiendas;
    private Boton bVolver;
    private BufferedImage ImgBackground;

    public PanelZoologico(Zoologico zoo) {
        super(null);
        listaPanelHabitat = new PanelHabitat[6];
        zoologico = zoo;
        this.setBackground(new Color(25,155,57));
        selectHabitat = new Boton[6];
        bTiendas = new Boton[4];
        InteraccionHabitat listenerHabitat = new InteraccionHabitat();
        InteraccionTienda listenerTienda = new InteraccionTienda();
        ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(6);
        bVolver = new Boton(Color.BLACK,true,"imgBack.png");
        bVolver.addActionListener(listenerHabitat);
        bVolver.setVisible(false);
        addComp(bVolver,50,25,100,50);

        int[] yPos = new int[]{250,450,50,50,450,250};
        for(int i=0; i<6; i++) {
            int x = 50+100*i;
            if(i>2)
                x += 205;
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i), i);
            selectHabitat[i] = new Boton(Color.BLACK,true,"imgHabitatLock"+i+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            addComp(selectHabitat[i],x,yPos[i],180,120);
        }

        int[] yTPos = new int[]{217,353,353,217};
        for(int i=0; i<4; i++) {
            bTiendas[i] = new Boton(Color.BLACK, true, "imgTienda" + i + ".png");
            bTiendas[i].addActionListener(listenerTienda);
            addComp(bTiendas[i],400+136*(i%2),yTPos[i],50,50);
        }
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    public void toggleHabitat() {
        openPanelHabitat.toggleVisible();
        if(openPanelHabitat.getVisible()) {
            PanelLinker.getPanelPrincipal().getMenu().changeHabitat(openPanelHabitat.getHabitat());
            ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(openPanelHabitat.getHabitat().getTipo().getValue());
            this.add(openPanelHabitat);
            bVolver.setVisible(true);
            for(int i=0; i<6; i++)
                selectHabitat[i].setVisible(false);
        } else {
            PanelLinker.getPanelPrincipal().getMenu().exitHabitat();
            ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(6);
            for(int i=0; i<6; i++)
                selectHabitat[i].setVisible(true);
            bVolver.setVisible(false);
            this.remove(openPanelHabitat);
        }
    }

    private class InteraccionHabitat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectHabitat[i]) {
                    if(!listaPanelHabitat[i].getHabitat().isAdquirido()) {
                        zoologico.comprarHabitat(i);
                        if(listaPanelHabitat[i].getHabitat().isAdquirido()) {
                            PanelLinker.getPanelPrincipal().getMenu().updateDinero(zoologico.getDinero());
                            selectHabitat[i].changeImage("imgHabitat" + i + ".png");
                        }
                        return;
                    }
                    openPanelHabitat = listaPanelHabitat[i];
                    break;
                }
            }
            toggleHabitat();
            repaint();
        }
    }
    private class InteraccionTienda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
