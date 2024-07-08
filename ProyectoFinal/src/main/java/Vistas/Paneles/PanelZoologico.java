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
import java.awt.image.BufferedImage;

/** Panel que permite la visualización de un zoológico
 *  @author Chloe Yañez Lavin
 *  @author Emily Osvaldo Gaete Bobadilla */
public class PanelZoologico extends JPanel implements Runnable {

    /** Hilo en el que se ejecutan los eventos del programa */
    private Thread thread;

    /** Zoológico asociado a panelZoologico */
    private Zoologico zoologico;

    /** Arreglo de panelesHabitat y cada panel con un habitat asociado  */
    private PanelHabitat[] listaPanelHabitat;

    /** Número entero con el número del panelHabitat actualmente abierto del arreglo */
    private int openPanelHabitatIndex;

    /** Arreglo de botones para comprar y/o seleccionar un habitat */
    private Boton[] selectHabitat;

    /** Arreglo de botones para comprar una tienda */
    private Boton[] bTiendas;

    /** Arreglo de botones para realizar una acción en el panelZoologico */
    private Boton[] bOpciones;

    /** Arreglo de cuadros de texto con mensajes de panelZoologico */
    private CuadroTexto[] textMessage;

    /** Booleano con el caso del mensaje de texto (activado o desactivado) */
    private boolean textMessageCase;

    /** Imagen con el fondo del panelZoologico */
    private BufferedImage ImgBackground;

    /** Panel con información de distintos recintos de animales */
    private PanelInformacion panelInformacion;

    /** Constructor de PanelZoologico, donde se crean sus componentes correspondientes
     * @param zoo La instancia del zoológico asociado al panelZoologico */
    public PanelZoologico(Zoologico zoo) {
        super(null);
        thread = new Thread(this);

        panelInformacion = new PanelInformacion();
        addComp(panelInformacion,100,90,800,600);
        listaPanelHabitat = new PanelHabitat[6];
        zoologico = zoo;
        openPanelHabitatIndex = 0;
        textMessageCase = false;
        this.setBackground(new Color(25,155,57));
        selectHabitat = new Boton[6];
        bTiendas = new Boton[4];
        bOpciones = new Boton[3];
        textMessage =  new CuadroTexto[2];
        textMessage[0] = new CuadroTexto("", new Color(0,0,0,0), Color.BLACK,"Arial",1,16);
        textMessage[0].setBorder(BorderFactory.createLineBorder( new Color(0,0,0,0), 5));
        addComp(textMessage[0],10, 654,100, 30);
        textMessage[1] = new CuadroTexto("Precio Tiendas: "+zoologico.getPrecioTienda()+" $","Arial",1,13);
        textMessage[1].setOpaque(false);
        addComp(textMessage[1],773,654,200,30);
        InteraccionHabitat listenerHabitat = new InteraccionHabitat();
        InteraccionTienda listenerTienda = new InteraccionTienda();
        ImgBackground = ImageLoader.getInstancia().getImagenFondoZoo(6);
        bOpciones[0] = new Boton(Color.BLACK,true,"imgBack.png");
        bOpciones[1] = new Boton(Color.BLACK,true,"imgOpDinero.png");
        bOpciones[2] = new Boton(Color.BLACK,true,"imgInfoZoo.png");
        bOpciones[0].addActionListener(listenerHabitat);
        bOpciones[1].addActionListener(listenerTienda);
        bOpciones[2].addActionListener(listenerTienda);
        addComp(bOpciones[2],624,644,100,50);
        bOpciones[0].setVisible(false);
        int[] habPos = new int[]{50,150,250,555,655,755,250,450,50,50,450,250};
        for(int i=0; i<6; i++) {
            listaPanelHabitat[i] = new PanelHabitat(zoologico.getHabitat(i));
            listaPanelHabitat[i].setBounds(43,100,914,550);
            selectHabitat[i] = new Boton(Color.BLACK,true,"Habitat/imgHabitatLock"+i+".png");
            selectHabitat[i].addActionListener(listenerHabitat);
            addComp(selectHabitat[i],habPos[i],habPos[i+6],180,120);
        }
        int[] yTPos = new int[]{217,353,353,217};
        for(int i=0; i<4; i++) {
            if(i<2)
                addComp(bOpciones[i],43+813*i,25,100,50);
            bTiendas[i] = new Boton(Color.BLACK, true, "Tienda/imgTiendaLock" + i + ".png");
            bTiendas[i].addActionListener(listenerTienda);
            addComp(bTiendas[i],400+136*(i%2),yTPos[i],50,50);
        }

        thread.start();
    }

    /** Método para añadir un componente de swing al panel
     * @param comp El componente de swing a agregar al panel
     * @param x El número entero con la posición en el panel del componente en el eje X
     * @param y El número entero con la posición en el panel del componente en el eje Y
     * @param width El número entero con el ancho del componente
     * @param height El número entero con el alto del componente */
    public void addComp(Component comp, int x, int y, int width, int height) {
        comp.setBounds(x,y,width,height);
        this.add(comp);
    }

    /** Método para activar (si está desactivado) o desactivar (si está activado) la visualización de los paneles de hábitat */
    public void toggleHabitat() {
        PanelHabitat openPanelHabitat = listaPanelHabitat[openPanelHabitatIndex];
        openPanelHabitat.toggleVisible();
        bOpciones[0].setVisible(openPanelHabitat.getVisible());
        bOpciones[2].setVisible(!openPanelHabitat.getVisible());
        textMessage[1].setVisible(!openPanelHabitat.getVisible());
        for(int i=0; i<6; i++) {
            selectHabitat[i].setVisible(!openPanelHabitat.getVisible());
            if(i<4) {
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
            if(panelInformacion.isVisible()){
                setEnableInfo(false,-2, null);
            }
        }
    }

    /** Método para activar o desactivar la visualización del panel de información
     * @param caso El booleano con el caso de activación (true) o de desactivación (false)
     * @param index El número entero con el número del panelInfo a activar (<0 cuando se desactiva)
     * @param recinto El recinto asociado al panel información */
    public void setEnableInfo(boolean caso, int index, Recinto recinto) {
        panelInformacion.setVisibleInfo(caso);
        if(!panelInformacion.isVisible()) {
            if(index == -1)
                add(listaPanelHabitat[openPanelHabitatIndex]);
        }else{
            remove(listaPanelHabitat[openPanelHabitatIndex]);
            if(index>=0 && recinto!=null) {
                panelInformacion.openInfo(index, recinto.getListaAnimales());
            }
        }
        repaint();
    }

    /** Método para activar (si está desactivado) o desactivar (si está activado) botones de hábitat y tiendas */
    public void toggleBotones() {
        bOpciones[2].setVisible(!bOpciones[2].isVisible());
        for(int i=0; i<6; i++) {
            selectHabitat[i].setVisible(!selectHabitat[i].isVisible());
            if(i<4) {
                bTiendas[i].setVisible(!bTiendas[i].isVisible());
            }
        }
    }

    /** Método para activar o desactivar una alerta de hambre en un habitat
     * @param index El número entero con el número del habitat en la lista de habitats
     * @param alert El booleano con el caso de activación (true) o de desactivación (false) de la alerta */
    public void setAlertHambre(int index, boolean alert) {
        if(alert) {
            selectHabitat[index].changeImage("Habitat/imgHabitatAlert" + index + ".png");
        } else {
            selectHabitat[index].changeImage("Habitat/imgHabitat" + index + ".png");
        }
    }

    /** Método establecer un nuevo texto para el mensaje de texto y comenzar un ciclo del texto
     * @param text El String con el texto que se le va a asignar al mensaje */
    public void setTextMessage(String text) {
        text = "   "+text+"   ";
        textMessage[0].setBackground(new Color(141,141,141));
        textMessage[0].setForeground(Color.BLACK);
        textMessage[0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        textMessage[0].setBounds(10, 654, text.length()*8, 30);
        textMessage[0].setText(text);
        textMessageCase = !textMessageCase;
    }

    /** Clase que escucha las interacciones con los hábitats */
    private class InteraccionHabitat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i<6; i++) {
                if(event.getSource()==selectHabitat[i]) {
                    if(!listaPanelHabitat[i].getHabitat().isAdquirido()) {
                        try {
                            zoologico.comprarHabitat(i);
                        } catch (Exception exception) {
                            PanelLinker.getPanelZoo().setTextMessage(exception.getMessage());
                        }
                        if(listaPanelHabitat[i].getHabitat().isAdquirido()) {
                            PanelLinker.getPanelMenu().updateDinero(zoologico);
                            PanelLinker.getPanelMenu().addPanelComida();
                            selectHabitat[i].changeImage("Habitat/imgHabitat" + i + ".png");
                        }
                        return;
                    }
                    openPanelHabitatIndex = i;
                    break;
                }
            }
            toggleHabitat();
            repaint();
        }
    }

    /** Clase que escucha las interacciones con las tiendas */
    private class InteraccionTienda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource()==bOpciones[1]){
                zoologico.addPaga(1000);
                PanelLinker.getPanelMenu().updateDinero(zoologico);
                return;
            }
            else if(event.getSource()==bOpciones[2]){
                panelInformacion.openInfoZoo();
                setEnableInfo(true,-1,null);
                toggleBotones();
                return;
            }
            for(int i=0; i<4; i++) {
                if(event.getSource() == bTiendas[i] && !zoologico.getTienda(i)) {
                    try {
                        zoologico.comprarTienda(i);
                        PanelLinker.getPanelMenu().updateDinero(zoologico);
                    } catch (Exception exception) {
                        PanelLinker.getPanelZoo().setTextMessage(exception.getMessage());
                    }
                    if(zoologico.getTienda(i)) {
                        bTiendas[i].changeImage("Tienda/imgTienda" + i + ".png");
                        textMessage[1].setText("Precio Tiendas: "+zoologico.getPrecioTienda()+" $");
                        if(zoologico.getGananciaEsp(3)==4)
                            textMessage[1].setText("  Tiendas compradas");
                    }
                }
            }
        }
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto gráfico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }


    @Override
    public void run() {

        float pagaTimer = 0;
        float textTimer = 0;
        float hambreTimer = 0;
        boolean textAux = false;
        long deltaTime = 0;

        while(true) {
            long startTime = System.currentTimeMillis();

            pagaTimer += (float) deltaTime / 1000;
            hambreTimer += (float) deltaTime / 1000;
            int penalizacion = 0;

            for (int i = 0; i < 6; i++) {
                if (zoologico.getHabitat(i).isAdquirido()) {
                    for (int j = 0; j < 6; j++) {
                        if (zoologico.getHabitat(i).getRecinto(j).isAdquirido()) {
                            Recinto recinto = zoologico.getHabitat(i).getRecinto(j);

                            if(hambreTimer>=1){
                                recinto.addHambre();
                                hambreTimer=0;
                            }

                            listaPanelHabitat[i].getPanelRecinto(j).updateCantidad();
                            if(listaPanelHabitat[i].getVisible()) {
                                listaPanelHabitat[i].getPanelRecinto(j).moveAnimals();
                            }
                            if (recinto.getPenalizacion() == 5)
                                listaPanelHabitat[i].getPanelRecinto(j).setAlertHambre(true);
                            if (recinto.getPenalizacion() == 100) {
                                zoologico.rescateAnimal(i, j);
                                listaPanelHabitat[i].getPanelRecinto(j).setAlertHambre(false);
                                setTextMessage("El recinto '" + listaPanelHabitat[i].getHabitat().getRecinto(j).getTipo().getNombre() + "' fue vaciado, y los animales rescatados");
                            }
                        }
                    }
                    setAlertHambre(i, zoologico.getHabitat(i).getPenalizacionHabitat() > 0);
                    penalizacion += zoologico.getHabitat(i).getPenalizacionHabitat();
                }
            }

            zoologico.setPenalizacion(penalizacion);
            if(pagaTimer>=5) {
                zoologico.recibirPaga();
                pagaTimer = 0;
            }
            if(!textMessage[0].getText().isEmpty()) {
                if(textAux != textMessageCase) {
                    textTimer = 0;
                    textAux = textMessageCase;
                }
                textTimer+= (float) deltaTime/1000;
                textMessage[0].setBackground(new Color(141, 141, 141, (int) (250 - 50 * textTimer)));
                textMessage[0].setForeground(new Color(0, 0, 0, (int) (250 -  50 *  textTimer)));
                textMessage[0].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, (int)(250 - 50 * textTimer)), 3));
                if(textTimer>=5) {
                    textTimer = 0;
                    textMessage[0].setText("");
                }
                repaint();
            }
            if(PanelLinker.getPanelPrincipal()!=null)
                PanelLinker.getPanelMenu().updateDinero(zoologico);



            long endTime = System.currentTimeMillis();
            deltaTime = (1000/60) - (endTime - startTime);

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
