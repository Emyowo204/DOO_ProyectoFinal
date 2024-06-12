package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Utils.*;
import Vistas.Utils.*;
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
    private ZonaTexto insertText;

    public PanelMenu(Zoologico zoo) {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.zoologico = zoo;
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        for(int i=0; i<6; i++)
            selectAnimal.add(new ArrayList<>());
        CuadroTexto cuadroAnimal = new CuadroTexto(" v Seleccione Animal:", Color.WHITE, Color.BLACK, "Arial", 1);
        cuadroAnimal.setBounds(20,20,240,20);
        addAnimal = new PopupSelect(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial", 0);
        addAnimal.setUse(false);
        addAnimal.setBounds(20,45,240,20);
        comprarAnimal = new Boton(Color.BLACK, true, "imgComprarRecinto.png");
        comprarAnimal.setBounds(20,200,100,50);
        comprarAnimal.addActionListener(new MenuOptions());
        CuadroTexto cuadroNombre = new CuadroTexto(" v Inserte Nombre:", Color.WHITE, Color.BLACK, "Arial", 1);
        cuadroNombre.setBounds(20,90,240,20);
        insertText = new ZonaTexto(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial", 0);
        insertText.setBounds(20,115,240,20);
        insertText.setEnabled(false);
        this.add(cuadroAnimal);
        this.add(comprarAnimal);
        this.add(addAnimal);
        this.add(cuadroNombre);
        this.add(insertText);
    }

    public void changeHabitat(Habitat habitat) {
        this.habitat = habitat;
        tipoAnimal = null;
        addAnimal.setUse(true);
        insertText.setText("");
        insertText.setEnabled(true);
        addAnimal.setText(" > Presione Panel <");
        addAnimal.setIndex(habitat.getTipo().getValue());
        updatePopup();
    }
    public void exitHabitat() {
        this.habitat = null;
        addAnimal.setText(" Seleccione un Habitat");
        addAnimal.setUse(false);
        insertText.setText(" Seleccione un Habitat");
        insertText.setEnabled(false);
    }
    public void updatePopup() {
        int index = habitat.getTipo().getValue();
        for(int i=selectAnimal.get(index).size(); i<habitat.getUnlocked().size(); i++) {
            selectAnimal.get(index).add(new JMenuItem(habitat.getUnlocked().get(i).getNombre()));
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
                    addAnimal.setText(" "+tipoAnimal.getNombre());
                    insertText.setText(tipoAnimal.getNombre());
                }
            }
        }
    }
    private class MenuOptions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(insertText.getText().isEmpty())
                return;
            for(int i=0; i<6; i++) {
                if(habitat.getRecinto(i).getTipo() != null && habitat.getRecinto(i).getTipo() == tipoAnimal) {
                    zoologico.comprarAnimal(habitat.getRecinto(i), insertText.getText());
                    insertText.setText(tipoAnimal.getNombre());
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
