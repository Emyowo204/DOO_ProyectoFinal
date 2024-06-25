package Vistas.Paneles;

import Modelos.Utils.Recinto;
import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;
import Vistas.Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PanelZoologico extends JPanel {
    private Timer timer;
    private Zoologico zoologico;
    private PanelHabitat[] listaPanelHabitat;
    private PanelHabitat openPanelHabitat;
    private Boton[] selectHabitat;
    private Boton[] bTiendas;
    private Boton[] bOpciones;
    private CuadroTexto[] cuadroInfo;
    private BufferedImage ImgBackground;
    private PanelInformacion panelInformacion;

    public PanelZoologico(Zoologico zoo) {
        super(null);
        timer = new Timer(1000,new EscucharTiempo());
        timer.start();
        panelInformacion = new PanelInformacion();
        panelInformacion.setBounds(100,90,800,600);
        listaPanelHabitat = new PanelHabitat[6];
        zoologico = zoo;
        this.setBackground(new Color(25,155,57));
        selectHabitat = new Boton[6];
        bTiendas = new Boton[4];
        bOpciones = new Boton[2];
        InteraccionHabitat listenerHabitat = new InteraccionHabitat();
        InteraccionTienda listenerTienda = new InteraccionTienda();
        ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(6);
        bOpciones[0] = new Boton(Color.BLACK,true,"imgBack.png");
        bOpciones[1] = new Boton(Color.BLACK,true,"imgOpDinero.png");
        bOpciones[0].addActionListener(listenerHabitat);
        bOpciones[1].addActionListener(listenerTienda);
        bOpciones[0].setVisible(false);
        int[] yPos = new int[]{250,450,50,50,450,250};
        for(int i=0; i<6; i++) {
            int x = 50+100*i;
            if(i>2)
                x += 205;
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i));
            selectHabitat[i] = new Boton(Color.BLACK,true,"imgHabitatLock"+i+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            addComp(selectHabitat[i],x,yPos[i],180,120);
        }

        int[] yTPos = new int[]{217,353,353,217};
        for(int i=0; i<4; i++) {
            if(i<2)
                addComp(bOpciones[i],43+813*i,25,100,50);
            bTiendas[i] = new Boton(Color.BLACK, true, "Tienda/imgTiendaLock" + i + ".png");
            bTiendas[i].addActionListener(listenerTienda);
            addComp(bTiendas[i],400+136*(i%2),yTPos[i],50,50);
        }
        cuadroInfo = new CuadroTexto[4];
        cuadroInfo[0] = new CuadroTexto("- Precio Tiendas: "+zoologico.getPrecioTienda()+" $","Arial",1,13);
        cuadroInfo[0].setOpaque(false);
        addComp(cuadroInfo[0],650,615,240,20);
        for(int i=1; i<4; i++) {
            cuadroInfo[i] = new CuadroTexto("-", "Arial", 1,13);
            cuadroInfo[i].setOpaque(false);
            addComp(cuadroInfo[i], 650, 615+25*i, 240, 20);
        }
    }

    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    public void toggleHabitat() {
        openPanelHabitat.toggleVisible();
        bOpciones[0].setVisible(openPanelHabitat.getVisible());
        for(int i=0; i<6; i++) {
            selectHabitat[i].setVisible(!openPanelHabitat.getVisible());
            if(i<4) {
                cuadroInfo[i].setVisible(!openPanelHabitat.getVisible());
                bTiendas[i].setVisible(!openPanelHabitat.getVisible());
            }
        }
        if(openPanelHabitat.getVisible()) {
            PanelLinker.getPanelMenu().enterHabitat(openPanelHabitat.getHabitat());
            ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(openPanelHabitat.getValue());
            add(openPanelHabitat);
        } else {
            PanelLinker.getPanelMenu().exitHabitat();
            ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(6);
            remove(openPanelHabitat);
            if(panelInformacion.getShowing()){
                toggleInfo(-2, null);
            }
        }
    }

    public void toggleInfo(int index, Recinto recinto) {
        if(panelInformacion.getShowing()) {
            panelInformacion.toggleShowing();
            remove(panelInformacion);
            if(index == -1)
                add(openPanelHabitat);
            repaint();
        }else{
            panelInformacion.toggleShowing();
            remove(openPanelHabitat);
            add(panelInformacion);
            if(index>=0 && recinto!=null)
                panelInformacion.openInfo(index, recinto.getListaAnimales());
            repaint();
        }
    }


    public void setAlertHambre(int index, boolean alert) {
        if(alert) {
            cuadroInfo[1].setText("- Animales con hambre");
            selectHabitat[index].changeImage("imgHabitatAlert" + index + ".png");
        } else {
            cuadroInfo[1].setText("- ");
            selectHabitat[index].changeImage("imgHabitat" + index + ".png");
        }
    }

    private class InteraccionHabitat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectHabitat[i]) {
                    if(!listaPanelHabitat[i].getHabitat().isAdquirido()) {
                        zoologico.comprarHabitat(i);
                        if(listaPanelHabitat[i].getHabitat().isAdquirido()) {
                            PanelLinker.getPanelMenu().updateDinero(zoologico);
                            PanelLinker.getPanelMenu().addPanelComida();
                            selectHabitat[i].changeImage("imgHabitat" + i + ".png");
                        }
                        return;
                    }
                    openPanelHabitat = listaPanelHabitat[i];
                    break;
                }
            }
            toggleHabitat();
            repaint();
        }
    }
    private class InteraccionTienda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource()==bOpciones[1]){
                zoologico.addPaga(1000);
                PanelLinker.getPanelMenu().updateDinero(zoologico);
                return;
            }
            for(int i=0; i<4; i++) {
                if(event.getSource() == bTiendas[i] && !zoologico.getTienda(i)) {
                    zoologico.comprarTienda(i);
                    PanelLinker.getPanelMenu().updateDinero(zoologico);
                    if(zoologico.getTienda(i)) {
                        bTiendas[i].changeImage("Tienda/imgTienda" + i + ".png");
                        cuadroInfo[0].setText("- Precio Tiendas: "+zoologico.getPrecioTienda()+" $");
                        if(zoologico.getGananciaEsp(3)==4)
                            cuadroInfo[0].setText("Tiendas compradas");
                    }
                }
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }

    private class EscucharTiempo implements ActionListener {
        private int second;
        public EscucharTiempo() { second = 0; }

        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
            int penalizacion = 0;
            for (int i = 0; i < 6; i++) {
                if(zoologico.getHabitat(i).isAdquirido()) {
                    for (int j = 0; j < 6; j++) {
                        if (zoologico.getHabitat(i).getRecinto(j).getAdquirido()) {
                            Recinto recinto = zoologico.getHabitat(i).getRecinto(j);
                            recinto.addHambre();
                            listaPanelHabitat[i].getPanelRecinto(j).updateCantidad();
                            if(recinto.getPenalizacion() == 5)
                                listaPanelHabitat[i].getPanelRecinto(j).setAlertHambre(true);
                            if(recinto.getPenalizacion() == 100) {
                                zoologico.rescateAnimal(i,j);
                                cuadroInfo[2].setText("- El Recinto '"+recinto.getTipo().getNombre()+"' fue vaciado");
                                cuadroInfo[3].setText("- Los animales fueron rescatado");
                                listaPanelHabitat[i].getPanelRecinto(j).setAlertHambre(false);
                            }
                        }
                    }
                    setAlertHambre(i,zoologico.getHabitat(i).getPenalizacionHabitat()>0);
                    penalizacion += zoologico.getHabitat(i).getPenalizacionHabitat();
                }
            }
            zoologico.setPenalizacion(penalizacion);
            if(second==5) {
                zoologico.getPaga();
                second = 0;
            }
            if(PanelLinker.getPanelPrincipal()!=null)
                PanelLinker.getPanelMenu().updateDinero(zoologico);
        }
    }
}
