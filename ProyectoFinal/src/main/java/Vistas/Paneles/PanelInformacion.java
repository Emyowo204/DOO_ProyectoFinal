package Vistas.Paneles;

import Modelos.Enumeration.TipoAnimal;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private boolean showing;
    private JLabel info;
    public PanelInformacion(){
        super();
        this.setBackground(Color.LIGHT_GRAY);
        showing = false;
        info = new JLabel();
        this.add(info);
    }

    public void setInfo(String info){
        this.info.setText(info);
        repaint();
    }

    public void toggleShowing(){
        showing = !showing;
    }

    public boolean getShowing(){
        return showing;
    }
}
