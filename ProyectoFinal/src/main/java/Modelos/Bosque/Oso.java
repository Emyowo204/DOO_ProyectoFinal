package Modelos.Bosque;

import Modelos.Animal;
import Modelos.TipoAnimal;
import Vistas.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Oso extends Animal {
    private int moveTime;
    private int moveSpeed = 1;

    public Oso(String nombre) {
        super(nombre, TipoAnimal.Oso);
        super.setImage(ImageLoader.getInstancia().getImagenAnimal(getNumImg()));
        Random random = new Random();
        moveTime = random.nextInt(200);
    }

    @Override
    public int getNumImg() {
        return 2;
    }

    public void moveInPath(){
        if(moveTime>200||moveTime<0){
            moveSpeed=-moveSpeed;
        }

        moveTime+=moveSpeed;
        this.setPosition(moveTime,70 - (int) ((Math.sin((double) moveTime /(4*Math.PI)))*70));
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
