package Vistas.Utils;

import javax.swing.*;
import java.awt.*;

public class ZonaTexto extends JTextField {
    public ZonaTexto(String texto, Color bg, Color color, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(bg);
        this.setForeground(color);
        this.setFont(new Font(fuente, estilo, 15));
    }
}
