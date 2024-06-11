package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupSelect extends CuadroTexto {

    private JPopupMenu popupSelect;
    private String fuente;

    public PopupSelect(String texto, Color bg, Color color, String fuente) {
        super(texto, bg, color, fuente);
        this.fuente = fuente;
        this.addMouseListener(new LabelListener());
        popupSelect = new JPopupMenu();
    }

    public void addMenuItem(JMenuItem menuItem) {
        menuItem.setFont(new Font(fuente, Font.PLAIN, 15));
        popupSelect.add(menuItem);
    }

    private class LabelListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {}

        @Override
        public void mouseEntered(MouseEvent event) {}

        @Override
        public void mouseExited(MouseEvent event) {}

        @Override
        public void mousePressed(MouseEvent event) {
            popupSelect.setVisible(true);
            popupSelect.show(event.getComponent(), 0, 20);
        }
        @Override
        public void mouseReleased(MouseEvent event) {}
    }
}
