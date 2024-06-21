package Vistas.Paneles;


import Modelos.Utils.Animal;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;
import Vistas.Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelInformacion extends JPanel {
    private boolean showing;
    private final Boton bCerrar;
    private BufferedImage ImgBackground;
    private CuadroTexto[] cNombres;

    public PanelInformacion(){
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        showing = false;
        CerrarPanel cerrarPanel = new CerrarPanel();
        bCerrar = new Boton(Color.BLACK,true,"imgCerrar.png");
        bCerrar.setBounds(10,10,100,38);
        bCerrar.addActionListener(cerrarPanel);
        this.add(bCerrar);
        cNombres = new CuadroTexto[5];
        for(int i=0; i<5; i++) {
            cNombres[i] = new CuadroTexto("", "Arial", 1, 18);
            cNombres[i].setBounds(20, 470+23*i, 480, 20);
            this.add(cNombres[i]);
        }
        ImgBackground = null;
    }

    public void openInfo(int index, ArrayList<Animal> animales) {
        ImgBackground = ImageLoader.getInstancia().getImagenFondoInfo(index);
        for(int i=0; i<5; i++)
            cNombres[i].setText("");
        int numCuadro = 0;
        int var = 0;
        String nombres = "";
        for(int i=0; i<animales.size(); i++) {
            var = animales.get(i).getNombre().length();
            if((nombres.length()+var)>=50 && numCuadro<4) {
                cNombres[numCuadro].setText(nombres);
                numCuadro++;
                nombres = "";
            }
            nombres = nombres + (animales.get(i).getNombre());
            if(i < animales.size()-1)
                nombres = nombres + ", ";
        }
        cNombres[numCuadro].setText(nombres);
    }


    public void toggleShowing() {
        showing = !showing;
    }

    public boolean getShowing(){
        return showing;
    }

    private class CerrarPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelZoo().toggleInfo(-1, null);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(getShowing())
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
