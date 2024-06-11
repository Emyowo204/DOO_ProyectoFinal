package Vistas;

import Modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMenu extends JPanel {
    private Zoologico zoologico;
    private Habitat habitat;
    private PopupSelect addAnimal;
    private ArrayList<JMenuItem> selectAnimal;
    private Boton comprarAnimal;
    private TipoAnimal tipoAnimal;
    private SelectAnimal listenerAnimal;

    public PanelMenu(Zoologico zoo) {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.zoologico = zoo;
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        addAnimal = new PopupSelect(" Animal:", Color.WHITE, Color.BLACK, "Arial");
        addAnimal.setBounds(10,80,150,20);
        comprarAnimal = new Boton(Color.BLACK, true, "animal0.png");
        comprarAnimal.setBounds(10,10,50,50);
        comprarAnimal.addActionListener(new MenuOptions());
        this.add(comprarAnimal);
        this.add(addAnimal);
    }

    public void changeHabitat(Habitat habitat) {
        this.habitat = habitat;
        updatePopup();
    }
    public void updatePopup() {
        for(int i=selectAnimal.size(); i<habitat.getUnlocked().size(); i++) {
            selectAnimal.add(new JMenuItem(habitat.getUnlocked().get(i).toString()));
            addAnimal.addMenuItem(selectAnimal.get(i));
            selectAnimal.get(i).addActionListener(listenerAnimal);
        }
    }

    private class SelectAnimal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<selectAnimal.size(); i++) {
                if(event.getSource() == selectAnimal.get(i)) {
                    tipoAnimal = habitat.getUnlocked().get(i);
                    addAnimal.setText(tipoAnimal.toString());
                }
            }
        }
    }
    private class MenuOptions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<6; i++) {
                if(habitat.getRecinto(i).getTipo() == tipoAnimal)
                    zoologico.comprarAnimal(habitat.getTipo().getValue(),i, "Juan");
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
