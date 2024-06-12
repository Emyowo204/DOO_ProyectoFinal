package Modelos.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Visible {

    /** Método para guardar la posición en el eje x y eje Y de un Objeto */
    public void setPosition(int x, int y);

    /** Metodo para dibujar en un Component de Swing un Objeto */
    public void paintComponent(Graphics g, Component observer);

    /** Metodo para obtener el número de la imagen un Objeto
     * @return int con el número asociado a la imagen del Objeto */
    public int getNumImg();

    public void setImage(BufferedImage image);
}
