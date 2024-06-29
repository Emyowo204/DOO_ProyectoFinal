package Vistas.Paneles;


import Modelos.Utils.Animal;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;
import Vistas.Utils.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelInformacion extends JPanel {
    private final Boton bCerrar;
    private BufferedImage ImgBackground;
    private BufferedImage ImgInfoZoo;
    private CuadroTexto[] cNombres;
    private int casoInfo;

    public PanelInformacion(){
        super(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setEnabled(false);
        this.setVisible(false);
        CerrarPanel cerrarPanel = new CerrarPanel();
        bCerrar = new Boton(Color.BLACK,true,"imgCerrar.png");
        bCerrar.setBounds(10,10,100,38);
        bCerrar.addActionListener(cerrarPanel);
        this.add(bCerrar);
        cNombres = new CuadroTexto[5];
        for(int i=0; i<5; i++) {
            cNombres[i] = new CuadroTexto("", "Arial", 0, 18);
            cNombres[i].setBounds(20, 470+23*i, 480, 20);
            this.add(cNombres[i]);
        }
        ImgBackground = null;
        casoInfo=0;
        try{
            ImgInfoZoo = ImageIO.read(getClass().getClassLoader().getResource("Informacion/imgInfoZoo.png"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
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
        casoInfo = -1;
    }

    public void openInfoZoo() {
        for(int i=0; i<5; i++)
            cNombres[i].setText("");
        ImgBackground = ImgInfoZoo;
        casoInfo = -2;
    }

    public void setVisibleInfo(boolean caso) {
        this.setEnabled(caso);
        this.setVisible(caso);
    }

    private class CerrarPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelZoo().toggleInfo(false,casoInfo, null);
            if(casoInfo==-2)
                PanelLinker.getPanelZoo().toggleBotones();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.isVisible())
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
