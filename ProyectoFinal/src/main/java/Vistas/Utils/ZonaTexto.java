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
    public ZonaTexto(String texto, String fuente, int estilo) {
        super(texto);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(fuente, estilo, 15));
    }
}
