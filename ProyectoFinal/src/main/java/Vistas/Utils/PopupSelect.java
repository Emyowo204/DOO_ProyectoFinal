package Vistas.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Un cuadro de texto con varios popups, los cuales se les pueden añadir items seleccionables
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PopupSelect extends CuadroTexto {

    /** Arreglo de distintos popups seleccionables */
    private JPopupMenu[] popupSelect;

    /** Arreglo de números enteros con la cantidad de items seleccionables de cada popup */
    private int[] cantidadMenus;

    /** String con la fuente de texto del cuadro */
    private String fuente;

    /** Número entero con el número del popup actual del arreglo de popups */
    private int index;

    /** Boolean con el caso de habilitación del cuadro seleccionable, activado(true) o desactivado (false) */
    private boolean usable;

    /** Constructor donde se crea un cuadro de texto con popups seleccionables, el cual es opaco y de tamaño fijo 15
     * @param texto El String con el texto escrito en el cuadro de texto
     * @param bg El color del fondo del cuadro de texto
     * @param color El color de las letras, primer plano, del texto
     * @param fuente El String con la fuente del texto
     * @param estilo El número entero con el tipo de estilo de la fuente del texto */
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

    /** Método para añadir un item seleccionable a un popup en específico
     * @param menuItem El item seleccionable a añadir a un popup
     * @param index El número entero con el número del popup, al que se le quiere agregar el item, en el arreglo */
    public void addMenuItem(JMenuItem menuItem, int index) {
        this.index = index;
        menuItem.setFont(new Font(fuente, Font.PLAIN, 15));
        popupSelect[this.index].add(menuItem);
        cantidadMenus[this.index]++;
    }

    /** Método para establecer el número entero, index, con el número del popup actual en el arreglo
     * @param index El número entero que se le quiere asignar a index */
    public void setIndex(int index) { this.index=index; }

    /** Método para establecer la habilitación del cuadro seleccionable
     * @param usable El booleano con el caso a establecer, activado (true) o desactivado (false) */
    public void setUse(boolean usable) {
        setEnabled(usable);
        this.usable=usable;
    }

    /** Clase que escucha las interacciones del mouse con los items seleccionables del popup activado */
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
