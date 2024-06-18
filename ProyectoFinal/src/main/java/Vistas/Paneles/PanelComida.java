package Vistas.Paneles;

import Modelos.Enumeration.TipoComida;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComida extends JPanel {
    private Boton[] bComprar;
    private CuadroTexto[] cTexto;
    public PanelComida() {
        super(null);
        this.setOpaque(false);
        bComprar = new Boton[7];
        cTexto = new CuadroTexto[7];
        ComparComida comprarComida = new ComparComida();
        for(int i=0; i<7; i++) {
            bComprar[i] = new Boton(Color.BLACK, true, "Animales/imgAnimal"+ i +".png");
            bComprar[i].setBounds(0,10+50*i,40,40);
            bComprar[i].addActionListener(comprarComida);
            this.add(bComprar[i]);
            cTexto[i] = new CuadroTexto(TipoComida.values()[i].name()+": 0", "Arial", 1);
            cTexto[i].setBounds(50,20+50*i,190,20);
            this.add(cTexto[i]);
        }
    }

    public void updateTexto(TipoComida comida) {
        int index = comida.getValue();
        cTexto[index].setText(comida.name()+": "+PanelLinker.getPanelPrincipal().getZoologico().getAlmacen().getCantidad(index));
    }

    private class ComparComida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprar[i]) {
                    PanelLinker.getPanelPrincipal().getZoologico().comprarAlimento(TipoComida.values()[i]);
                    cTexto[i].setText(TipoComida.values()[i].name()+": "+PanelLinker.getPanelPrincipal().getZoologico().getAlmacen().getCantidad(i));
                }
            }
        }
    }
}
