package Vistas.Paneles;

import Modelos.Enumeration.TipoComida;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComida extends JPanel {
    private Boton[] bComprar;
    private Boton[] bComprarx10;
    private CuadroTexto[] cTexto;

    public PanelComida() {
        super(null);
        this.setOpaque(false);
        bComprar = new Boton[7];
        bComprarx10 = new Boton[7];
        cTexto = new CuadroTexto[7];
        ComparComida comprarComida = new ComparComida();
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
            addComp(new CuadroTexto(TipoComida.values()[i].getPrecio()+" $", "Arial", 1, false),100,50+50*i,140,20);
        }
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    public void updateTexto(TipoComida comida) {
        int index = comida.getValue();
        cTexto[index].setText(comida.getNombre()+": "+PanelLinker.getPanelPrincipal().getZoologico().getAlmacen().getCantidad(index));
    }

    private class ComparComida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprar[i]) {
                    Zoologico zoo = PanelLinker.getPanelPrincipal().getZoologico();
                    zoo.comprarAlimento(TipoComida.values()[i],1);
                    updateTexto(TipoComida.values()[i]);
                    PanelLinker.getPanelMenu().updateDinero(zoo);
                }
            }
        }
    }
    private class ComparComidax10 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprarx10[i]) {
                    Zoologico zoo = PanelLinker.getPanelPrincipal().getZoologico();
                    zoo.comprarAlimento(TipoComida.values()[i],10);
                    updateTexto(TipoComida.values()[i]);
                    PanelLinker.getPanelMenu().updateDinero(zoo);
                }
            }
        }
    }
}
