package Modelos;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public abstract class Animal implements Visible {
    private String nombre;
    private TipoAnimal tipo;
    private TipoHabitat habitat;
    private TipoComida comida;

    private int x;
    private int y;
    private BufferedImage img;
    private BufferedImage imgFlipped;

    public Animal(String nombre, TipoAnimal tipo){
        habitat = tipo.getHabitat();
        comida = tipo.getComida();
    }

    public abstract void moveInPath();
    public String getNombre() { return nombre; }

    @Override
    public void setImage(BufferedImage image) {
        img = image;
    }

    public void setFlippedImage(BufferedImage image) {
        imgFlipped = image;
    }

    public void swapFlipped(){
        BufferedImage aux = img;
        img = imgFlipped;
        imgFlipped = aux;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        g.drawImage(img,x,y,observer);
    }
}
