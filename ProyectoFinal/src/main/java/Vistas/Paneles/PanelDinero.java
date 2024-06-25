package Vistas.Paneles;

import Modelos.Utils.Zoologico;
import Vistas.Utils.Boton;
import Vistas.Utils.CuadroTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelDinero extends JPanel {
    private CuadroTexto cuadroDinero;
    private CuadroTexto cuadroGanancia;
    private JPopupMenu popUpInfo;
    private JMenuItem[] mItemInfo;
    public PanelDinero() {
        super(null);
        this.setOpaque(false);
        cuadroDinero = new CuadroTexto(" Dinero: "+new Zoologico().getDinero()+" $", "Arial", 1);
        cuadroGanancia = new CuadroTexto(" Ganancias: +0 $ /5 seg", "Arial", 1);
        cuadroDinero.setBounds(20,0,240,20);
        this.add(cuadroDinero);
        cuadroGanancia.setBounds(20,25,240,20);
        this.add(cuadroGanancia);
        cuadroGanancia.addMouseListener(new OpenInfo());
        popUpInfo = new JPopupMenu();
        mItemInfo = new JMenuItem[6];
        popUpInfo.add("Ganancias Especificas:");
        for(int i=0; i<6; i++) {
            mItemInfo[i] = new JMenuItem("Cargando...");
            mItemInfo[i].setFont(new Font("Arial", Font.PLAIN, 10));
            popUpInfo.add(mItemInfo[i]);
        }
        popUpInfo.setVisible(false);
    }

    public void updatePanelDinero(Zoologico zoo) {
        cuadroDinero.setText(" Dinero: "+zoo.getDinero()+" $");
        cuadroGanancia.setText(" Ganancias: +"+zoo.getGanancia()+" $ /5 seg");
        if(popUpInfo.isVisible()) {
            mItemInfo[0].setText("Habitats: +" + zoo.getGananciaEsp(0));
            mItemInfo[1].setText("Recintos: +" + zoo.getGananciaEsp(1));
            mItemInfo[2].setText("Animales: +" + zoo.getGananciaEsp(2));
            mItemInfo[3].setText("Tiendas: +" + zoo.getGananciaEsp(3) * 5);
            mItemInfo[4].setText("Multiplicador: x" + (1 + zoo.getGananciaEsp(3) * 0.25));
            mItemInfo[5].setText("Multas: -" + zoo.getMultas());
        }
    }

    private class OpenInfo implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {}

        @Override
        public void mouseEntered(MouseEvent event) {}

        @Override
        public void mouseExited(MouseEvent event) {}

        @Override
        public void mousePressed(MouseEvent event) {
            popUpInfo.show(event.getComponent(), 0, 20);
        }
        @Override
        public void mouseReleased(MouseEvent event) {}
    }
    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
