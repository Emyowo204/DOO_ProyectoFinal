package Modelos.Utils;

import Modelos.Enumeration.*;
import Vistas.Utils.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

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
        this.tipo = tipo;
        habitat = tipo.getHabitat();
        comida = tipo.getComida();
        this.nombre = nombre;
        int numImg = tipo.getValue();
        setImage(ImageLoader.getInstancia().getImagenAnimal(numImg));
        setFlippedImage(ImageLoader.getInstancia().getImagenAnimalFlipped(numImg));
        if(new Random().nextInt(getRandBound())<1) {
            setImage(ImageLoader.getInstancia().getImagenAnimalAlterno(numImg));
            setFlippedImage(ImageLoader.getInstancia().getImagenAnimalAlternoFlipped(numImg));
        }
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
