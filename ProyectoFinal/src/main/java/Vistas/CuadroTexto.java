package Vistas;

import javax.swing.*;
import java.awt.*;

/** Un cuadro de texto que puede ser agregado a una interfaz GUI
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class CuadroTexto extends JLabel {

    /** Constructor donde se un cuadro de texto opaco, tamaño 15 y fuente BOLD
     * @param texto El texto escrito en el cuadro de texto
     * @param bg El color del fondo del cuadro de texto
     * @param color El color de las letras, primer plano, del texto
     * @param fuente La fuente del texto del cuadro */
    public CuadroTexto(String texto, Color bg, Color color, String fuente) {
        super();
        this.setOpaque(true);
        this.setBackground(bg);
        this.setText(texto);
        this.setForeground(color);
        this.setFont(new Font(fuente, Font.BOLD, 15));
    }
}
