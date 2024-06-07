package Vistas;

import Modelos.Habitat;
import Modelos.TipoHabitat;

import javax.swing.JPanel;
import java.awt.*;

/** Un panel principal de la ventana que contiene todos los sub paneles del programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelPrincipal extends JPanel {

    private PanelHabitat[] listaPanelHabitat;

    public PanelPrincipal() {
        super(null);
        listaPanelHabitat = new PanelHabitat[6];
        this.setBackground(new Color(99,155, 255));
        int j=0;
        for(int i=0; i<6; i++) {
            listaPanelHabitat[i] = new PanelHabitat(new Habitat(TipoHabitat.Sabana));
            listaPanelHabitat[i].setBounds(10+150*(i%2),10+150*j,100,100);
            this.add(listaPanelHabitat[i]);
            if(i%2==1)
                j++;
        }
        int i=0;
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
