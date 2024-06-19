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
    private CuadroTexto[] cTexto;
    public PanelComida() {
        super(null);
        this.setOpaque(false);
        bComprar = new Boton[7];
        cTexto = new CuadroTexto[7];
        ComparComida comprarComida = new ComparComida();

        CuadroTexto titulo =  new CuadroTexto(" Comprar Alimento:", "Arial", 1);
        titulo.setBounds(0,0,240,20);
        this.add(titulo);

        for(int i=0; i<7; i++) {
            bComprar[i] = new Boton(Color.BLACK, true, "Comida/imgAlimento"+i+".png");
            bComprar[i].setBounds(0,30+50*i,40,40);
            bComprar[i].addActionListener(comprarComida);
            this.add(bComprar[i]);
            cTexto[i] = new CuadroTexto(" "+TipoComida.values()[i].getNombre()+": 0", "Arial", 0, false);
            cTexto[i].setBounds(50,40+50*i,190,20);
            this.add(cTexto[i]);
        }
    }

    public void updateTexto(TipoComida comida) {
        int index = comida.getValue();
        cTexto[index].setText(" "+comida.getNombre()+": "+PanelLinker.getPanelPrincipal().getZoologico().getAlmacen().getCantidad(index));
    }


    private class ComparComida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<7; i++) {
                if(event.getSource() == bComprar[i]) {
                    Zoologico zoo = PanelLinker.getPanelPrincipal().getZoologico();
                    zoo.comprarAlimento(TipoComida.values()[i]);
                    updateTexto(TipoComida.values()[i]);
                    PanelLinker.getPanelPrincipal().getMenu().updateDinero(zoo.getDinero());
                }
            }
        }
    }
}
