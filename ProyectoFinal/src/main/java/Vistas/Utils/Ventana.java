package Vistas.Utils;

import Vistas.Paneles.PanelLinker;
import Vistas.Paneles.PanelPrincipal;
import javax.swing.JFrame;
import java.awt.BorderLayout;

/** Una ventana donde se crean paneles para mostrarlos en una interfaz GUI
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Ventana extends JFrame {

    /** Constructor se crea una ventana de 1280x757 con título "Zoologico" */
    public Ventana() {
        super();
        this.setLayout((new BorderLayout()));
        this.setTitle("Zoologico");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1280,757);
        this.setResizable(false);
        PanelLinker.newPanelLinker();
        PanelPrincipal panel = PanelLinker.getPanelPrincipal();
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
