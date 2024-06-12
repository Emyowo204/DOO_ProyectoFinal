package Modelos.Bosque;

import Modelos.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Pudu extends Animal {
    private int moveTime;
    private int moveSpeed = 1;

    public Pudu(String nombre) {
        super(nombre, TipoAnimal.Pudu);
        setImage(ImageLoader.getInstancia().getImagenAnimal(getNumImg()));
        setFlippedImage(ImageLoader.getInstancia().getImagenAnimalFlipped(getNumImg()));
        Random random = new Random();
        moveTime = random.nextInt(200);
    }

    @Override
    public int getNumImg() {
        return 3;
    }

    public void moveInPath(){
        if(moveTime>200||moveTime<0){
            moveSpeed=-moveSpeed;
            swapFlipped();
        }

        moveTime+=moveSpeed;
        this.setPosition(moveTime,70 - (int) ((Math.sin((double) moveTime /(4*Math.PI)))*70));
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
