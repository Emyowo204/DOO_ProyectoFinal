package Vistas;

import Modelos.TipoAnimal;
import Modelos.Zoologico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {
    private Zoologico zoologico;
    private Boton addAnimal;
    public PanelMenu(Zoologico zoo) {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.zoologico = zoo;
        InteraccionMenu listenerMenu = new InteraccionMenu();
        addAnimal = new Boton(Color.BLACK, true, "imgBack.png");
        addAnimal.addActionListener(listenerMenu);
        addAnimal.setBounds(10,10,50,50);
        this.add(addAnimal);
    }

    private class InteraccionMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            zoologico.comprarRecinto(3,0, TipoAnimal.Delfin);
            zoologico.comprarAnimal(3,0, "Juan");
            repaint();
        }
    }
}
