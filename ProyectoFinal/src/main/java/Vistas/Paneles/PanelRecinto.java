package Vistas.Paneles;

import Modelos.*;
import Vistas.Boton;

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
    private BufferedImage ImgBackground;
    private Recinto recinto;
    private Thread thread;
    private ArrayList<Animal> animales;
    private PanelSelect panelSelect;
    private JButton[] selectButtons;
    private Boton botonComprar;

    public PanelRecinto(Recinto recinto) {
        super(null);
        this.recinto = recinto;
        animales = this.recinto.getListaAnimales();
        this.setBackground(Color.WHITE);
        InteraccionRecinto listenerRecinto = new InteraccionRecinto();
        botonComprar = new Boton(Color.BLACK, true, "imgComprarRecinto.png");
        botonComprar.setBounds(25,50,200,100);
        botonComprar.addActionListener(listenerRecinto);
        this.add(botonComprar);
        panelSelect = new PanelSelect(25,50,200,100,recinto.getHabitat().getTotal());
        panelSelect.addBotones(selectButtons = new JButton[6]);
        for(int i=0; i<6; i++)
            selectButtons[i].addActionListener(listenerRecinto);
        panelSelect.setVisible(false);
        this.add(panelSelect);
        thread = new Thread(this);
        thread.start();
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

    private class InteraccionRecinto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == botonComprar && !(recinto.getHabitat().isComprando())){
                togglePanelSelect();
                recinto.desbloquear();
                return;
            }
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectButtons[i]) {
                    recinto.asignarAnimal(recinto.getHabitat().getTotal().get(i));
                    PanelLinker.getPanelPrincipal().getMenu().updatePopup();
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
        boolean running = true;

        while(running) {
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
