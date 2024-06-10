package Vistas;

import Modelos.Zoologico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelZoologico extends JPanel {
    private Zoologico zoologico;
    private PanelHabitat[] listaPanelHabitat;
    private Boton[] selectHabitat;

    public PanelZoologico(Zoologico zoo) {
        super(null);
        listaPanelHabitat = new PanelHabitat[6];
        zoologico = zoo;
        this.setBackground(Color.BLUE);
        selectHabitat = new Boton[6];
        InteraccionHabitat listenerHabitat = new InteraccionHabitat();

        for(int i=0; i<6; i++) {
            int x = 60+100*i;
            int y = 250+200*i;
            if(i>2)
                x += 200;
            if(i==2 || i==3)
                y = 50;
            if(i==4)
                y =  450;
            if(i==5)
                y = 250;
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i));
            selectHabitat[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            selectHabitat[i].setBounds(x,y,180,120);
            this.add(selectHabitat[i]);
        }
    }

    public void toggleHabitat(PanelHabitat panelHabitat, boolean toggle) {
        if(toggle) {
            this.add(panelHabitat);
            for(int i=0; i<6; i++)
                this.remove(selectHabitat[i]);
        } else {
            for(int i=0; i<6; i++)
                this.add(selectHabitat[i]);
            this.remove(panelHabitat);
        }
    }

    private class InteraccionHabitat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource()==selectHabitat[0]) {
                toggleHabitat(listaPanelHabitat[0], true);
            }
            else if(event.getSource()==selectHabitat[1]) {
                toggleHabitat(listaPanelHabitat[1], true);
            }
            else if(event.getSource()==selectHabitat[2]) {
                toggleHabitat(listaPanelHabitat[2], true);
            }
            else if(event.getSource()==selectHabitat[3]) {
                toggleHabitat(listaPanelHabitat[3], true);
            }
            else if(event.getSource()==selectHabitat[4]) {
                toggleHabitat(listaPanelHabitat[4], true);
            }
            else {
                toggleHabitat(listaPanelHabitat[5], true);
            }
            repaint();
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
