package Modelos;

import Vistas.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Delfin extends Animal {

    private int moveTime;
    private int moveSpeed = 1;

    public Delfin(String nombre) {
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
        this.setPosition(moveTime,50 - (int) ((Math.sin((double) moveTime /(2*Math.PI)))*50));
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
