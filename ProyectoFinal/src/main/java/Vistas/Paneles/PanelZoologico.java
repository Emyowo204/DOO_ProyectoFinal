package Vistas.Paneles;

import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;

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
    private Boton bVolver;
    private BufferedImage ImgBackground;

    public PanelZoologico(Zoologico zoo) {
        super(null);
        listaPanelHabitat = new PanelHabitat[6];
        zoologico = zoo;
        this.setBackground(new Color(25,155,57));
        selectHabitat = new Boton[6];
        InteraccionHabitat listenerHabitat = new InteraccionHabitat();
        bVolver = new Boton(Color.BLACK,true,"imgBack.png");
        bVolver.setBounds(50,25,100,50);
        bVolver.addActionListener(listenerHabitat);
        bVolver.setVisible(false);
        this.add(bVolver);

        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgFondoZoo.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        for(int i=0; i<6; i++) {
            int x = 50+100*i;
            int y = 250+200*i;
            if(i>2)
                x += 205;
            if(i==2 || i==3)
                y = 50;
            if(i==4)
                y =  450;
            if(i==5)
                y = 250;
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i), i);
            selectHabitat[i] = new Boton(Color.BLACK,true,"imgHabitatLock"+i+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            selectHabitat[i].setBounds(x,y,180,120);
            this.add(selectHabitat[i]);
        }
    }

    public void toggleHabitat() {
        openPanelHabitat.toggleVisible();
        if(openPanelHabitat.getVisible()) {
            PanelLinker.getPanelPrincipal().getMenu().changeHabitat(openPanelHabitat.getHabitat());
            this.add(openPanelHabitat);
            bVolver.setVisible(true);
            for(int i=0; i<6; i++)
                selectHabitat[i].setVisible(false);
        } else {
            PanelLinker.getPanelPrincipal().getMenu().exitHabitat();
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

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(!bVolver.isVisible())
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
