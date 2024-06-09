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

        int j=0;
        for(int i=0; i<6; i++) {
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i));
            selectHabitat[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            selectHabitat[i].setBounds(20+80*(i%3),20+80*j,40,40);
            this.add(selectHabitat[i]);
            if(i==2)
                j++;
        }
    }

    private class InteraccionHabitat implements ActionListener {

        /** Método para realizar una acción al presionarse uno de los botones NumPad
         * @param event El evento realizado a uno de los botones */
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelHabitat panelhabitat;
            if(event.getSource()==selectHabitat[0]) {
                panelhabitat = listaPanelHabitat[0];
            }
            else if(event.getSource()==selectHabitat[1]) {
                panelhabitat = listaPanelHabitat[1];
            }
            else if(event.getSource()==selectHabitat[2]) {
                panelhabitat = listaPanelHabitat[2];
            }
            else if(event.getSource()==selectHabitat[3]) {
                panelhabitat = listaPanelHabitat[3];
            }
            else if(event.getSource()==selectHabitat[4]) {
                panelhabitat = listaPanelHabitat[4];
            }
            else {
                panelhabitat = listaPanelHabitat[5];
            }
            PanelLinker.getPanelPrincipal().toggleHabitat(panelhabitat, true);
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
