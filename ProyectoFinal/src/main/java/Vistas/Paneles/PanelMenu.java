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

/** Panel donde se alojan paneles de información y compra de un zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public class PanelMenu extends JPanel {

    /** Panel para comprar comida */
    private PanelComida panelComida;

    /** Panel de información económica */
    private PanelDinero panelDinero;

    /** Hábitat de un zoological */
    private Habitat habitat;

    /** Tipo de animal a comprar */
    private TipoAnimal tipoAnimal;

    /** Popup para seleccionar animal a comprar */
    private PopupSelect addAnimal;

    /** Animales disponibles en el Popup */
    private ArrayList<ArrayList<JMenuItem>> selectAnimal;

    /** Botón para comprar el animal */
    private Boton comprarAnimal;

    /** Listener de compra animal */
    private SelectAnimal listenerAnimal;

    /** Zona de texto de selección animal */
    private ZonaTexto insertText;

    /** Zona de texto con el precio del animal */
    private CuadroTexto cuadroPrecio;

    /** Fondo del panel */
    private BufferedImage ImgBackground;

    /** Constructor de PanelMenu */
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

    /** Método para añadir un componente de swing al panel
     * @param comp El componente de swing a agregar al panel
     * @param x El número entero con la posición en el panel del componente en el eje X
     * @param y El número entero con la posición en el panel del componente en el eje Y
     * @param width El número entero con el ancho del componente
     * @param height El número entero con el alto del componente */
    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    /** Método para actualizar el panel de información económica
     * @param zoo Zoológico */
    public void updateDinero(Zoologico zoo) {
        panelDinero.updatePanelDinero(zoo);
    }

    /** Método para agregar PanelComida */
    public void addPanelComida() {
        if(panelComida==null) {
            panelComida = new PanelComida();
            addComp(panelComida, 20, 325, 240, 400);
            repaint();
        }
    }

    /** Método que actualiza el panel cuando se entra a un hábitat
     * @param habitat Hábitat al cual se entra */
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

    /** Método que actualiza el panel cuando se sale de un hábitat */
    public void exitHabitat() {
        this.habitat = null;
        addAnimal.setText(" Seleccione un Habitat");
        addAnimal.setUse(false);
        insertText.setText(" Seleccione un Habitat");
        insertText.setEnabled(false);
        cuadroPrecio.setText("");
        comprarAnimal.setEnabled(false);
    }

    /** Método para actualizar el Popup de compra animal */
    public void updatePopup() {
        int index = habitat.getTipo().getValue();
        for(int i=selectAnimal.get(index).size(); i<habitat.getUnlocked().size(); i++) {
            selectAnimal.get(index).add(new JMenuItem(habitat.getUnlocked().get(i).getNombre()));
            addAnimal.addMenuItem(selectAnimal.get(index).get(i), index);
            selectAnimal.get(index).get(i).addActionListener(listenerAnimal);
        }
    }

    /** Método para reiniciar el panel de compra animal */
    public void resetCompraAnimal() {
        tipoAnimal = null;
        addAnimal.setText(" > Presione Aquí <");
        insertText.setText("");
        comprarAnimal.setEnabled(false);
    }

    /** Método para obtener el panel de comida */
    public PanelComida getPanelComida() { return panelComida; }

    /** Clase que escucha la selección de un animal */
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

    /** Clase que escucha la compra animal */
    private class MenuOptions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelZoo().setEnableInfo(false,-1,null);
            for(int i=0; i<6; i++) {
                if(habitat.getRecinto(i).getTipo() != null && habitat.getRecinto(i).getTipo() == tipoAnimal) {
                    try {
                        PanelLinker.getPanelPrincipal().getZoologico().comprarAnimal(habitat.getRecinto(i), insertText.getText()) ;
                        updateDinero(PanelLinker.getPanelPrincipal().getZoologico());
                        insertText.setText(tipoAnimal.getNombre());
                    } catch (Exception exception) {
                        PanelLinker.getPanelZoo().setTextMessage(exception.getMessage());
                    }
                    return;
                }
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto gráfico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
