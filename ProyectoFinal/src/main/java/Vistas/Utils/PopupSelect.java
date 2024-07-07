package Vistas.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Un Popup al cual se le pueden añadir items */
public class PopupSelect extends CuadroTexto {
    private JPopupMenu[] popupSelect;
    private int[] cantidadMenus;
    private String fuente;
    private int index;
    private boolean usable;

    public PopupSelect(String texto, Color bg, Color color, String fuente, int estilo) {
        super(texto, bg, color, fuente, estilo);
        this.fuente = fuente;
        this.addMouseListener(new LabelListener());
        usable = true;
        popupSelect = new JPopupMenu[6];
        cantidadMenus = new int[6];
        for(int i=0; i<6; i++) {
            popupSelect[i] = new JPopupMenu();
            cantidadMenus[i] = 0;
        }
    }

    public void addMenuItem(JMenuItem menuItem, int index) {
        this.index = index;
        menuItem.setFont(new Font(fuente, Font.PLAIN, 15));
        popupSelect[this.index].add(menuItem);
        cantidadMenus[this.index]++;
    }

    public void setIndex(int index) { this.index=index; }

    public void setUse(boolean usable) {
        setEnabled(usable);
        this.usable=usable;
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
            if(usable) {
                if(cantidadMenus[index]==0)
                    setText(" -- Selección Vacia --");
                popupSelect[index].show(event.getComponent(), 0, 20);
            }
        }
        @Override
        public void mouseReleased(MouseEvent event) {}
    }
}
