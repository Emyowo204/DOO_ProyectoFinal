package Vistas.Paneles;

import Modelos.*;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Boton;
import Vistas.PopupSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMenu extends JPanel {
    private Zoologico zoologico;
    private Habitat habitat;
    private PopupSelect addAnimal;
    private ArrayList<ArrayList<JMenuItem>> selectAnimal;
    private Boton comprarAnimal;
    private TipoAnimal tipoAnimal;
    private SelectAnimal listenerAnimal;

    public PanelMenu(Zoologico zoo) {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.zoologico = zoo;
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        for(int i=0; i<6; i++)
            selectAnimal.add(new ArrayList<>());
        addAnimal = new PopupSelect(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial");
        addAnimal.setUse(false);
        addAnimal.setBounds(20,20,240,20);
        comprarAnimal = new Boton(Color.BLACK, true, "Animales/imgAnimal0.png");
        comprarAnimal.setBounds(20,200,50,50);
        comprarAnimal.addActionListener(new MenuOptions());
        this.add(comprarAnimal);
        this.add(addAnimal);
    }

    public void changeHabitat(Habitat habitat) {
        this.habitat = habitat;
        addAnimal.setUse(true);
        addAnimal.setText(" Seleccione un Animal:");
        addAnimal.setIndex(habitat.getTipo().getValue());
        updatePopup();
    }
    public void exitHabitat() {
        this.habitat = null;
        addAnimal.setText(" Seleccione un Habitat");
        addAnimal.setUse(false);
    }
    public void updatePopup() {
        int index = habitat.getTipo().getValue();
        for(int i=selectAnimal.get(index).size(); i<habitat.getUnlocked().size(); i++) {
            selectAnimal.get(index).add(new JMenuItem(habitat.getUnlocked().get(i).toString()));
            addAnimal.addMenuItem(selectAnimal.get(index).get(i), index);
            selectAnimal.get(index).get(i).addActionListener(listenerAnimal);
        }
    }

    private class SelectAnimal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int index = habitat.getTipo().getValue();
            for(int i=0; i<selectAnimal.get(index).size(); i++) {
                if(event.getSource() == selectAnimal.get(index).get(i)) {
                    tipoAnimal = habitat.getUnlocked().get(i);
                    addAnimal.setText(" "+tipoAnimal.toString());
                }
            }
        }
    }
    private class MenuOptions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<6; i++) {
                if(habitat.getRecinto(i).getTipo() != null && habitat.getRecinto(i).getTipo() == tipoAnimal) {
                    zoologico.comprarAnimal(habitat.getTipo().getValue(), i, "Juan");
                    return;
                }
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
