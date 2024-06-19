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
    private Habitat habitat;
    private PopupSelect addAnimal;
    private ArrayList<ArrayList<JMenuItem>> selectAnimal;
    private Boton comprarAnimal;
    private TipoAnimal tipoAnimal;
    private SelectAnimal listenerAnimal;
    private ZonaTexto insertText;
    private CuadroTexto[] cuadroDinero;
    private PanelComida panelComida;
    private BufferedImage ImgBackground;

    public PanelMenu() {
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        listenerAnimal = new SelectAnimal();
        selectAnimal = new ArrayList<>();
        cuadroDinero = new CuadroTexto[3];
        for(int i=0; i<6; i++)
            selectAnimal.add(new ArrayList<>());

        panelComida = null;
        cuadroDinero[0] = new CuadroTexto(" Dinero: "+new Zoologico().getDinero()+" $", "Arial", 1);
        cuadroDinero[1] = new CuadroTexto(" Ganancias: +0 $ /5 seg", "Arial", 1);
        cuadroDinero[2] = new CuadroTexto("", "Arial", 1);
        addComp(cuadroDinero[0],20,20,240,20);
        addComp(cuadroDinero[1],20,45,240,20);
        addComp(new CuadroTexto("Seleccione Animal:", "Arial", 1, false), 20,95,240,20);
        addAnimal = new PopupSelect(" Seleccione un Habitat", Color.WHITE, Color.BLACK, "Arial", 0);
        addComp(addAnimal,20,120,240,20);
        addComp(new CuadroTexto("Inserte Nombre:","Arial", 1, false), 20,150,240,20);
        insertText = new ZonaTexto(" Seleccione un Habitat","Arial", 0);
        addComp(insertText,20,175,240,20);
        addComp(cuadroDinero[2],20,220,240,20);
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
        cuadroDinero[0].setText(" Dinero: "+zoo.getDinero()+" $");
        cuadroDinero[1].setText(" Ganancias: +"+zoo.getGanancia() + " $ /5 seg");
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
        cuadroDinero[2].setText("");
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
                    cuadroDinero[2].setText(" Precio: "+tipoAnimal.getPrecio()+" $");
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
