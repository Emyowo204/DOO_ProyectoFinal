package Vistas.Utils;

import javax.swing.*;
import javax.swing.border.Border;
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
    public CuadroTexto(String texto, Color bg, Color color, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(bg);
        this.setForeground(color);
        this.setFont(new Font(fuente, estilo, 15));
    }

    public CuadroTexto(String texto, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }

    public CuadroTexto(String texto, String fuente, int estilo, boolean opaco) {
        super(texto);
        this.setOpaque(opaco);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }
}
