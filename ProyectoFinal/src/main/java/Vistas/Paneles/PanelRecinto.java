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

/** Un panel que muestra las monedas guardadas en un deposito y sus series
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelRecinto extends JPanel implements Runnable{
    private Recinto recinto;
    private Thread thread;
    private ArrayList<Animal> animales;
    private PanelSelect panelSelect;
    private Boton[] selectButtons;
    private Boton botonComprar;
    private Boton botonInfo;
    private Boton[] bAlimento;
    private CuadroTexto cantidadComida;

    public PanelRecinto(Recinto recinto) {
        super(null);
        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        this.setOpaque(false);
        InteraccionRecinto listenerRecinto = new InteraccionRecinto();
        OpcionesAnimal listenerOpciones = new OpcionesAnimal();
        botonComprar = new Boton(Color.BLACK, true, "imgComprarRecinto.png");
        botonComprar.addActionListener(listenerRecinto);
        addComp(botonComprar,25,50,200,100);
        botonInfo = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        botonInfo.addActionListener(listenerOpciones);
        bAlimento = new Boton[2];
        bAlimento[0] = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        bAlimento[1] = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        cantidadComida = new CuadroTexto("N° Comida: 0", "Arial", 1, 12);
        for(int i=0; i<2; i++) {
            bAlimento[i].setOpaque(false);
            bAlimento[i].addActionListener(listenerOpciones);
        }
        panelSelect = new PanelSelect(25,50,200,100,recinto.getHabitat().getTotal());
        panelSelect.addBotones(selectButtons = new Boton[6], recinto.getHabitat().getTipo().getValue()*6);
        for(int i=0; i<6; i++)
            selectButtons[i].addActionListener(listenerRecinto);
        panelSelect.setVisible(false);
        this.add(panelSelect);
        thread = new Thread(this);
        thread.start();
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

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

    public void updateCantidad() {
        cantidadComida.setText("N° Comida: "+recinto.getCantidadComida());
    }

    private class OpcionesAnimal implements ActionListener {

        Boolean showingInfo = false;
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonInfo) {
                PanelLinker.getPanelPrincipal().getPanelZoo().setInformation(recinto.getTipo().getInfo());
                PanelLinker.getPanelPrincipal().getPanelZoo().toggleInfo();
            }
            else {
                int index = 1;
                if(event.getSource() == bAlimento[1])
                    index=10;
                PanelLinker.getPanelPrincipal().getZoologico().alimentar(recinto,index);
                updateCantidad();
                PanelLinker.getPanelPrincipal().getMenu().getPanelComida().updateTexto(recinto.getTipo().getComida());
                setAlertHambre(recinto.getPenalizacion()>0);
            }
        }
    }

    private class InteraccionRecinto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonComprar && !(recinto.getHabitat().isComprando())){
                PanelLinker.getPanelPrincipal().getZoologico().comprarRecinto(recinto);
                if(recinto.getAdquirido()) {
                    PanelPrincipal panelP = PanelLinker.getPanelPrincipal();
                    panelP.getMenu().updateDinero(panelP.getZoologico());
                    togglePanelSelect();
                }
                return;
            }
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectButtons[i]) {
                    recinto.asignarAnimal(recinto.getHabitat().getTotal().get(i));
                    bAlimento[0].changeImage("Comida/imgAlimento"+recinto.getTipo().getComida().getValue()+".png");
                    bAlimento[1].changeImage("Comida/img10xAlimento"+recinto.getTipo().getComida().getValue()+".png");
                    PanelLinker.getPanelPrincipal().getMenu().updatePopup();
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
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<animales.size(); i++)
            animales.get(i).paintComponent(g, this);
    }

    @Override
    public void run() {
        while(true) {
            long startTime = System.currentTimeMillis();

            for(int i=0; i< animales.size(); i++){
                animales.get(i).moveInPath();
            }
            repaint();

            long endTime = System.currentTimeMillis();
            long deltaTime = (1000/60) - (endTime - startTime);
            if(deltaTime > 0){
                try {
                    Thread.sleep(deltaTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
