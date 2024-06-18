package Vistas.Paneles;

import Modelos.Utils.Animal;
import Modelos.Utils.Recinto;
import Vistas.Utils.Boton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    private Boton bAlimento;

    public PanelRecinto(Recinto recinto) {
        super(null);
        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        this.setBackground(Color.WHITE);
        InteraccionRecinto listenerRecinto = new InteraccionRecinto();
        OpcionesAnimal listenerOpciones = new OpcionesAnimal();
        botonComprar = new Boton(Color.BLACK, true, "imgComprarRecinto.png");
        botonComprar.addActionListener(listenerRecinto);
        addComp(botonComprar,25,50,200,100);
        botonInfo = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        botonInfo.addActionListener(listenerOpciones);
        bAlimento = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        bAlimento.addActionListener(listenerOpciones);
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

    private class OpcionesAnimal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonInfo)
                System.out.println("Info");
            else {
                PanelLinker.getPanelPrincipal().getZoologico().alimentar(recinto);
                PanelLinker.getPanelPrincipal().getMenu().getPanelComida().updateTexto(recinto.getTipo().getComida());
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
                    panelP.getMenu().updateDinero(panelP.getZoologico().getDinero());
                    togglePanelSelect();
                }
                return;
            }
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectButtons[i]) {
                    recinto.asignarAnimal(recinto.getHabitat().getTotal().get(i));
                    PanelLinker.getPanelPrincipal().getMenu().updatePopup();
                    addComp(botonInfo,5,5,40,40);
                    addComp(bAlimento,209,5,40,40);
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
