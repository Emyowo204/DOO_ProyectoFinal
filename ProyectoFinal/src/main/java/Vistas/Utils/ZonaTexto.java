package Vistas.Utils;

import javax.swing.*;
import java.awt.*;

/** Una zona para escribir un texto desde el teclado del usuario
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class ZonaTexto extends JTextField {

    /** Constructor donde se crea una de texto opaca con tamaño fijo 15
     * @param texto El String con el texto inicial del cuadro
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto */
    public ZonaTexto(String texto, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }
}
