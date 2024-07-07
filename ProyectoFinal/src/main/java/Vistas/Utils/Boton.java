package Vistas.Utils;

import javax.swing.*;
import java.awt.*;

/** Un botón que puede ser agregado a una interfaz GUI
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Boton extends JButton {

    /** Nombre de la imagen utilizada como el icono del botón */
    private String filename;

    /** Constructor donde se crea un botón con un icono
     * @param color Color del fondo del botón
     * @param border Booleano que activa o desactiva el borde del botón
     * @param filename Nombre de la imagen guardada en la carpeta de "resources" */
    public Boton(Color color, boolean border, String filename) {
        super();
        this.setBackground(color);
        this.setBorderPainted(border);
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
        this.filename = filename;
    }

    /** Método para cambiar la imagen de un botón
     * @param filename Nombre de la nueva imagen guardada en la carpeta de "resources"  */
    public void changeImage(String filename) {
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
        this.filename = filename;
    }
}
