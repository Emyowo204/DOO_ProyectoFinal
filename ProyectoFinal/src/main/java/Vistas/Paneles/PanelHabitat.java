package Vistas.Paneles;

import Modelos.Enumeration.TipoComida;
import Modelos.Utils.Habitat;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Un panel que contiene a los paneles de recinto de un zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelHabitat extends JPanel {

    /** Habitat asociado al panelHabitat */
    private Habitat habitat;

    /** Arreglo con los paneles de los recintos */
    private PanelRecinto[] listaPanelRecinto;

    /** Botón para comprar la mejora de temperatura */
    private Boton temperatura;

    /** Estado de visibilidad del panel */
    private boolean visible;

    /** Valor del habitat */
    private int value;


    /** Constructor del PanelHabitat, donde se crean sus componentes correspondientes
     * @param habitat La instancia del habitat asociado al panelHabitat */
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
        ComprarTemperatura comprarTemperatura = new ComprarTemperatura();
        temperatura.addActionListener(comprarTemperatura);
        temperatura.setOpaque(false);
        this.add(temperatura);
    }

    /** Método para quitar un bóton del panel */
    public void removeBoton(Boton boton) {
        this.remove(boton);
        repaint();
    }

    /** Método para cambiar el estado de visibilidad del panel */
    public void toggleVisible() {
        visible=!visible;
    }

    /** Método para obtener el estado de visibilidad del panel */
    public boolean getVisible() { return visible; }

    /** Método para obtener el hábitat */
    public Habitat getHabitat() { return habitat; }

    /** Método para obtener el valor del hábitat */
    public int getValue() { return value; }

    /** Método para obtener un panel de recinto
     * @param index Número del panel recinto a obtener
     * @return Panel recinto */
    public PanelRecinto getPanelRecinto(int index) {
        return listaPanelRecinto[index];
    }

    /** Clase para escuchar la compra de la mejora de temperatura */
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
                PanelLinker.getPanelZoo().setTextMessage(exception.getMessage());
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