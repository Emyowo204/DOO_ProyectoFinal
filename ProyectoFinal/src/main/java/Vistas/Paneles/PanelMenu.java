package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Utils.*;
import Vistas.Utils.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelMenu extends JPanel {
    private PanelComida panelComida;
    private PanelDinero panelDinero;
    private Habitat habitat;
    private TipoAnimal tipoAnimal;
    private PopupSelect addAnimal;
    private ArrayList<ArrayList<JMenuItem>> selectAnimal;
    private Boton comprarAnimal;
    private SelectAnimal listenerAnimal;
    private ZonaTexto insertText;
    private CuadroTexto cuadroPrecio;
    private BufferedImage ImgBackground;

    public PanelMenu() {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        for(int i=0; i<6; i++)
            selectAnimal.add(new ArrayList<>());

        panelComida = null;
        panelDinero = new PanelDinero();
        addComp(panelDinero,0,20,240,45);
        cuadroPrecio = new CuadroTexto("", "Arial", 1, 14);
        cuadroPrecio.setBackground(Color.WHITE);
        cuadroPrecio.setOpaque(true);
        addComp(new CuadroTexto("Seleccione Animal:", "Arial", 1, false), 20,95,240,20);
        addAnimal = new PopupSelect(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial", 0);
        addComp(addAnimal,20,120,240,20);
        addComp(new CuadroTexto("Inserte Nombre:","Arial", 1, false), 20,150,240,20);
        insertText = new ZonaTexto(" Seleccione un Habitat","Arial", 0);
        addComp(insertText,20,175,240,20);
        addComp(cuadroPrecio,20,220,240,20);
        comprarAnimal = new Boton(Color.BLACK, true, "imgAdoptar.png");
        addComp(comprarAnimal,20,245,240,50);
        comprarAnimal.addActionListener(new MenuOptions());
        addAnimal.setUse(false);
        comprarAnimal.setEnabled(false);
        insertText.setEnabled(false);
        ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(7);
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }
    public void updateDinero(Zoologico zoo) {
        panelDinero.updatePanelDinero(zoo);
    }

    public void addPanelComida() {
        if(panelComida==null) {
            panelComida = new PanelComida();
            addComp(panelComida, 20, 325, 240, 400);
            repaint();
        }
    }

    public void enterHabitat(Habitat habitat) {
        this.habitat = habitat;
        tipoAnimal = null;
        addAnimal.setUse(true);
        insertText.setText("");
        insertText.setEnabled(true);
        addAnimal.setText(" > Presione Aquí <");
        addAnimal.setIndex(habitat.getTipo().getValue());
        updatePopup();
    }
    public void exitHabitat() {
        this.habitat = null;
        addAnimal.setText(" Seleccione un Habitat");
        addAnimal.setUse(false);
        insertText.setText(" Seleccione un Habitat");
        insertText.setEnabled(false);
        cuadroPrecio.setText("");
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

    public PanelComida getPanelComida() { return panelComida; }

    private class SelectAnimal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int index = habitat.getTipo().getValue();
            for(int i=0; i<selectAnimal.get(index).size(); i++) {
                if(event.getSource() == selectAnimal.get(index).get(i)) {
                    tipoAnimal = habitat.getUnlocked().get(i);
                    addAnimal.setText(" "+tipoAnimal.getNombre());
                    insertText.setText(tipoAnimal.getNombre());
                    cuadroPrecio.setText(" Precio: "+tipoAnimal.getPrecio()+" $  |  Ganancia: +"+(tipoAnimal.getPrecio()/20)+" $");
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
                    updateDinero(PanelLinker.getPanelPrincipal().getZoologico());
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
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
