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
    private Habitat habitat;
    private PopupSelect addAnimal;
    private ArrayList<ArrayList<JMenuItem>> selectAnimal;
    private Boton comprarAnimal;
    private TipoAnimal tipoAnimal;
    private SelectAnimal listenerAnimal;
    private ZonaTexto insertText;
    private CuadroTexto[] cuadroDinero;

    public PanelMenu() {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        cuadroDinero = new CuadroTexto[2];
        for(int i=0; i<6; i++)
            selectAnimal.add(new ArrayList<>());

        cuadroDinero[0] = new CuadroTexto(" Dinero: "+new Zoologico().getDinero()+ "$", "Arial", 1);
        cuadroDinero[1] = new CuadroTexto("", "Arial", 1);
        addComp(cuadroDinero[0],20,20,240,20);
        addComp(new CuadroTexto(" v Seleccione Animal:", "Arial", 1), 20,60,240,20);
        addAnimal = new PopupSelect(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial", 0);
        addComp(addAnimal,20,85,240,20);
        addComp(new CuadroTexto(" v Inserte Nombre:","Arial", 1), 20,130,240,20);
        insertText = new ZonaTexto(" Seleccione un Habitat","Arial", 0);
        addComp(insertText,20,155,240,20);
        addComp(cuadroDinero[1],  20,200,240,20);
        comprarAnimal = new Boton(Color.BLACK, true, "imgAdoptar.png");
        addComp(comprarAnimal,20,225,240,50);
        comprarAnimal.addActionListener(new MenuOptions());
        addAnimal.setUse(false);
        comprarAnimal.setEnabled(false);
        insertText.setEnabled(false);
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }
    public void updateDinero(int dinero) {
        cuadroDinero[0].setText(" Dinero: "+dinero+" $");
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
        cuadroDinero[1].setText("");
        comprarAnimal.setEnabled(false);
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
                    cuadroDinero[1].setText(" Precio: "+tipoAnimal.getPrecio()+" $");
                    comprarAnimal.setEnabled(true);
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
                    PanelLinker.getPanelPrincipal().getZoologico().comprarAnimal(habitat.getRecinto(i), insertText.getText()) ;
                    updateDinero(PanelLinker.getPanelPrincipal().getZoologico().getDinero());
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
