package Vistas.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/** Un cuadro de texto que puede ser agregado a una interfaz GUI
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class CuadroTexto extends JLabel {

    /** Constructor donde se crea un cuadro de texto opaco y de tamaño fijo 15
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param bg El color del fondo del cuadro de texto
     * @param color El color de las letras, primer plano, del texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto */
    public CuadroTexto(String texto, Color bg, Color color, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(bg);
        this.setForeground(color);
        this.setFont(new Font(fuente, estilo, 15));
    }

    /** Constructor donde se crea un cuadro de texto opaco y de tamaño variable
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param bg El color del fondo del cuadro de texto
     * @param color El color de las letras, primer plano, del texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto
     * @param size El número entero con el tamaño del texto */
    public CuadroTexto(String texto, Color bg, Color color, String fuente, int estilo, int size) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(bg);
        this.setForeground(color);
        this.setFont(new Font(fuente, estilo, size));
    }

    /** Constructor donde se crea un cuadro de texto opaco, con fondo blanco, texto negro y de tamaño fijo 15
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto */
    public CuadroTexto(String texto, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }

    /** Constructor donde se crea un cuadro de texto con opacidad variable, texto negro y de tamaño fijo 15
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto
     * @param opaco El booleano con la opacidad del texto */
    public CuadroTexto(String texto, String fuente, int estilo, boolean opaco) {
        super(texto);
        this.setOpaque(opaco);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }

    /** Constructor donde se crea un cuadro de texto con texto negro y de tamaño variable
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto
     * @param size El número entero con el tamaño del texto */
    public CuadroTexto(String texto, String fuente, int estilo, int size) {
        super(texto);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, size));
    }
}
