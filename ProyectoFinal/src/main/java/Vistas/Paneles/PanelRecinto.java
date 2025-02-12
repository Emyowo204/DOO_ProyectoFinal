package Vistas.Paneles;

import Modelos.Utils.Animal;
import Modelos.Utils.Recinto;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** Un panel que muéstra un recinto de animales
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelRecinto extends JPanel{

    /** Recinto asociado al panelRecinto */
    private Recinto recinto;

    /** Lista de animales del recinto */
    private ArrayList<Animal> animales;

    /** Panel de selección del tipo de recinto */
    private PanelSelect panelSelect;

    /** Botones de los animales a seleccionar */
    private Boton[] selectButtons;

    /** Botón para comprar el recinto */
    private Boton botonComprar;

    /** Botón para mostrar la información de los animales del recinto */
    private Boton botonInfo;

    /** Botones para alimentar a los animales */
    private Boton[] bAlimento;

    /** Cuadro de texto con cantidad de comida en el recinto */
    private CuadroTexto cantidadComida;


    /** Constructor de PanelRecinto, donde se crean sus componentes correspondientes
     * @param recinto El recinto asociado al panel recinto */
    public PanelRecinto(Recinto recinto) {
        super(null);
        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        this.setOpaque(false);
        InteraccionRecinto listenerRecinto = new InteraccionRecinto();
        OpcionesAnimal listenerOpciones = new OpcionesAnimal();
        botonComprar = new Boton(Color.BLACK, true, "imgRecinto"+recinto.getHabitat().getTipo().getPrecioRecinto()+".png");
        botonComprar.addActionListener(listenerRecinto);
        addComp(botonComprar,25,50,200,100);
        botonInfo = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        botonInfo.addActionListener(listenerOpciones);
        botonInfo.setOpaque(false);
        bAlimento = new Boton[2];
        bAlimento[0] = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        bAlimento[1] = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        cantidadComida = new CuadroTexto("N° Comida: 0", "Arial", 1, 12);
        for(int i=0; i<2; i++) {
            bAlimento[i].setOpaque(false);
            bAlimento[i].addActionListener(listenerOpciones);
        }
        panelSelect = new PanelSelect(25,30,200,140,recinto.getHabitat().getTotal());
        panelSelect.addBotones(selectButtons = new Boton[6], recinto.getHabitat().getTipo().getValue()*6);
        for(int i=0; i<6; i++)
            selectButtons[i].addActionListener(listenerRecinto);
        panelSelect.setVisible(false);
        this.add(panelSelect);

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

    /** Método para activar/desactivar el panel de selección de animal */
    public void togglePanelSelect() {
        if(recinto.getTipo() == null) {
            recinto.getHabitat().setComprando(true);
            panelSelect.setVisible(true);
            panelSelect.updatePanel(recinto.getHabitat().getUnlocked());
            this.remove(botonComprar);
        } else {
            recinto.getHabitat().setComprando(false);
            this.remove(panelSelect);
        }
    }

    /** Método para alertar que el recinto tiene hambre */
    public void setAlertHambre(boolean alert) {
        if(alert) {
            cantidadComida.setText("¡Con Hambre!");
            bAlimento[0].changeImage("Comida/imgAliAlert"+recinto.getTipo().getComida().getValue()+".png");
            bAlimento[1].changeImage("Comida/img10xAliAlert"+recinto.getTipo().getComida().getValue()+".png");
        }
        else {
            bAlimento[0].changeImage("Comida/imgAlimento"+recinto.getTipo().getComida().getValue() +".png");
            bAlimento[1].changeImage("Comida/img10xAlimento"+recinto.getTipo().getComida().getValue()+".png");
        }
    }

    /** Método para actualizar la cantidad de comida */
    public void updateCantidad() {
        cantidadComida.setText("N° Comida: "+recinto.getCantidadComida());
    }

    /** Clase que escucha los botones de información y de alimentar */
    private class OpcionesAnimal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonInfo) {
                PanelLinker.getPanelZoo().setEnableInfo(true,recinto.getTipo().getValue(), recinto);
            }
            else {
                int index = 1;
                if(event.getSource() == bAlimento[1])
                    index=10;
                PanelLinker.getPanelPrincipal().getZoologico().alimentar(recinto,index);
                updateCantidad();
                PanelLinker.getPanelMenu().getPanelComida().updateTexto(recinto.getTipo().getComida());
                setAlertHambre(recinto.getPenalizacion()>0);
            }
        }
    }

    /** Clase que escucha la selección y compra del recinto */
    private class InteraccionRecinto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonComprar && !(recinto.getHabitat().isComprando())){
                try {
                    PanelLinker.getPanelPrincipal().getZoologico().comprarRecinto(recinto);
                } catch (Exception exception) {
                    PanelLinker.getPanelZoo().setTextMessage(exception.getMessage());
                }
                if(recinto.isAdquirido()) {
                    PanelLinker.getPanelMenu().updateDinero(PanelLinker.getPanelPrincipal().getZoologico());
                    PanelLinker.getPanelMenu().resetCompraAnimal();
                    togglePanelSelect();
                }
                return;
            }
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectButtons[i]) {
                    recinto.asignarAnimal(recinto.getHabitat().getTotal().get(i));
                    bAlimento[0].changeImage("Comida/imgAlimento"+recinto.getTipo().getComida().getValue()+".png");
                    bAlimento[1].changeImage("Comida/img10xAlimento"+recinto.getTipo().getComida().getValue()+".png");
                    PanelLinker.getPanelMenu().updatePopup();
                    addComp(botonInfo,209,155,40,40);
                    addComp(bAlimento[0],5,5,40,40);
                    addComp(bAlimento[1],50,5,40,40);
                    addComp(cantidadComida,95,5,100,20);
                    togglePanelSelect();
                    break;
                }
            }
        }
    }


    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto gráfico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<animales.size(); i++)
            animales.get(i).paintComponent(g, this);
    }

    /** Método para mover los animales en el recinto*/
    public void moveAnimals() {
        for(int i=0; i< animales.size(); i++){
            animales.get(i).moveInPath();
        }
        repaint();
    }

}
