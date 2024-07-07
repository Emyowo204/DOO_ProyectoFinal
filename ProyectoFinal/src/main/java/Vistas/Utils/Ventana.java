package Vistas.Utils;

import Vistas.Paneles.PanelPrincipal;

import javax.swing.*;
import java.awt.*;

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
        PanelPrincipal panel = new PanelPrincipal();
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
