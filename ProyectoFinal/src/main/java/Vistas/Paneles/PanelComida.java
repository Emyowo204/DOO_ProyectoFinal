package Vistas.Paneles;

import Modelos.Enumeration.TipoComida;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Panel para comprar alimento para el zoológico */
public class PanelComida extends JPanel {

    /** Botones para comprar 1 alimento */
    private Boton[] bComprar;

    /** Botones para comprar 10 alimentos */
    private Boton[] bComprarx10;

    /** Cuadros de texto con la cantidad de alimentos en el depósito del zoológico */
    private CuadroTexto[] cTexto;

    /** Constructor de PanelComida */
    public PanelComida() {
        super(null);
        this.setOpaque(false);
        bComprar = new Boton[7];
        bComprarx10 = new Boton[7];
        cTexto = new CuadroTexto[7];
        ComprarComida comprarComida = new ComprarComida();
        ComparComidax10 comprarComidax10 = new ComparComidax10();

        CuadroTexto titulo =  new CuadroTexto("Comprar Alimento:", "Arial", 1, false);
        titulo.setBounds(0,0,240,20);
        this.add(titulo);

        for(int i=0; i<7; i++) {
            bComprar[i] = new Boton(Color.BLACK, true, "Comida/imgCompra"+i+".png");
            bComprar[i].addActionListener(comprarComida);
            bComprarx10[i] = new Boton(Color.BLACK, true, "Comida/img10xCompra"+i+".png");
            bComprarx10[i].addActionListener(comprarComidax10);
            cTexto[i] = new CuadroTexto(TipoComida.values()[i].getNombre()+": 0", "Arial", 0, false);
            addComp(bComprar[i],0,30+50*i,40,40);
            addComp(bComprarx10[i],50,30+50*i,40,40);
            addComp(cTexto[i],100,30+50*i,140,20);
            addComp(new CuadroTexto(TipoComida.values()[i].getPrecio()+" $ x1", "Arial", 1, false),100,50+50*i,140,20);
        }
    }

    /** Método para añadir un componente
     * @param comp Componente a agregar
     * @param x Posición en el eje X
     * @param y Posición en el eje Y
     * @param width Ancho
     * @param height Alto
     */
    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    /** Método para actualizar el texto de la comida
     * @param comida Comida a actualizar texto */
    public void updateTexto(TipoComida comida) {
        cTexto[comida.getValue()].setText(comida.getNombre()+": "+PanelLinker.getPanelPrincipal().getZoologico().getAlmacen().getCantidad(comida));
    }

    /** Clase que escucha las compras de 1 comida */
    private class ComprarComida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprar[i]) {
                    try {
                        Zoologico zoo = PanelLinker.getPanelPrincipal().getZoologico();
                        zoo.comprarAlimento(TipoComida.values()[i],1);
                        updateTexto(TipoComida.values()[i]);
                        PanelLinker.getPanelMenu().updateDinero(zoo);
                    } catch (Exception exception) {
                        PanelLinker.getPanelZoo().setTextInfo(exception.getMessage());
                    }
                }
            }
        }
    }
    /** Clase que escucha las compras de 10 comida */
    private class ComparComidax10 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprarx10[i]) {
                    try {
                        Zoologico zoo = PanelLinker.getPanelPrincipal().getZoologico();
                        zoo.comprarAlimento(TipoComida.values()[i],10);
                        updateTexto(TipoComida.values()[i]);
                        PanelLinker.getPanelMenu().updateDinero(zoo);
                    } catch (Exception exception) {
                        PanelLinker.getPanelZoo().setTextInfo(exception.getMessage());
                    }
                }
            }
        }
    }
}
