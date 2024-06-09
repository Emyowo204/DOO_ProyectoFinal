package Vistas;

import Modelos.Habitat;
import Modelos.TipoHabitat;
import Modelos.Zoologico;

import javax.swing.JPanel;
import java.awt.*;

/** Un panel principal de la ventana que contiene todos los sub paneles del programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelPrincipal extends JPanel {

    PanelZoologico panelZoo;

    public PanelPrincipal() {
        super(new BorderLayout());
        this.setOpaque(true);
        panelZoo = new PanelZoologico(new Zoologico());
        this.add(panelZoo, BorderLayout.CENTER);
        PanelMenu panelMenu = new PanelMenu();
        panelMenu.setPreferredSize(new Dimension(200, 720));
        this.add(panelMenu, BorderLayout.EAST);
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
