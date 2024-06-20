package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {

    private JLabel info;
    public PanelInformacion(){
        super();
        this.setBackground(Color.LIGHT_GRAY);
        info = new JLabel();
        this.add(info);
    }

    public void setInfo(String info){
        this.info.setText(info);
        repaint();
    }
}
