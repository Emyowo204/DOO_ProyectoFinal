package Modelos;

import Vistas.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Delfin extends Animal {

    private int moveTime;
    private int moveSpeed = 2;

    public Delfin(String nombre, TipoAnimal delfin) {
        super(nombre, TipoAnimal.Delfin);
        super.setImage(ImageLoader.getInstancia().getImagenAnimal(getNumImg()));
        Random random = new Random();
        moveTime = random.nextInt(200);
    }

    @Override
    public int getNumImg() {
        return 0;
    }

    public void moveInPath(){
        if(moveTime>200||moveTime<0){
            moveSpeed=-moveSpeed;
        }

        moveTime+=moveSpeed;
        this.setPosition(moveTime,20 - (int) ((Math.sin((double) moveTime /(2*Math.PI)))*20));
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        moveInPath();
        super.paintComponent(g,observer);
    }
}
