package Vistas.Paneles;

import Modelos.Enumeration.TipoComida;
import Modelos.Utils.Habitat;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Un panel que contiene paneles y botones que muestran visualmente un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelHabitat extends JPanel {
    private Habitat habitat;
    private PanelRecinto[] listaPanelRecinto;
    private Boton temperatura;
    private boolean visible;
    private int value;
    private ComprarTemperatura comprarTemperatura;

    public PanelHabitat(Habitat habitat) {
        super(null);
        this.habitat = habitat;
        visible = false;
        this.setOpaque(false);
        listaPanelRecinto = new PanelRecinto[6];
        int j=0;
        for(int i=0; i<6; i++) {
            listaPanelRecinto[i] = new PanelRecinto(habitat.getRecinto(i));
            listaPanelRecinto[i].setBounds(51+279*(i%3),46+j,254,200);
            this.add(listaPanelRecinto[i]);
            if(i==2)
                j=230;
        }
        value = habitat.getTipo().getValue();
        temperatura = new Boton(Color.BLACK,true,"imgTemp"+habitat.getTipo().getValue()+".png");
        temperatura.setBounds(402,500,110,40);
        comprarTemperatura = new ComprarTemperatura();
        temperatura.addActionListener(comprarTemperatura);
        temperatura.setOpaque(false);
        this.add(temperatura);
    }
    public void removeBoton(Boton boton) {
        this.remove(boton);
        repaint();
    }
    public void toggleVisible() {
        visible=!visible;
    }
    public boolean getVisible() { return visible; }
    public Habitat getHabitat() { return habitat; }
    public int getValue() { return value; }
    public PanelRecinto getPanelRecinto(int index) {
        return listaPanelRecinto[index];
    }

    private class ComprarTemperatura implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                PanelLinker.getPanelPrincipal().getZoologico().comprarTemperatura(habitat.getTipo().getValue());
                if(habitat.getTemperatura()) {
                    PanelLinker.getPanelMenu().updateDinero(PanelLinker.getPanelPrincipal().getZoologico());
                    removeBoton(temperatura);
                }
            } catch (Exception exception) {
                PanelLinker.getPanelZoo().setTextInfo(exception.getMessage());
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}