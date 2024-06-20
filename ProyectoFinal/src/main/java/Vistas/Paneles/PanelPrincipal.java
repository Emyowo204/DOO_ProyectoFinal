package Vistas.Paneles;

import Modelos.Utils.Zoologico;
import javax.swing.JPanel;
import java.awt.*;

/** Un panel principal de la ventana que contiene todos los sub paneles del programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelPrincipal extends JPanel {

    Zoologico zoologico;
    PanelZoologico panelZoo;
    PanelMenu panelMenu;

    public PanelPrincipal() {
        super(new BorderLayout());
        this.setOpaque(true);
        zoologico = new Zoologico();
        panelZoo = new PanelZoologico(zoologico);
        panelZoo.setPreferredSize(new Dimension(1000, 720));
        this.add(panelZoo, BorderLayout.CENTER);
        panelMenu = new PanelMenu();
        panelMenu.setPreferredSize(new Dimension(280, 720));
        this.add(panelMenu, BorderLayout.EAST);
    }
    public PanelZoologico getPanelZoo() { return panelZoo; }
    public PanelMenu getMenu() { return panelMenu; }
    public Zoologico getZoologico() { return zoologico; }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
