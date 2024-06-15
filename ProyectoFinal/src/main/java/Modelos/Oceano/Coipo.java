package Modelos.Oceano;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.ImageLoader;
import java.awt.*;
import java.util.Random;

public class Coipo extends Animal {
    private int moveTime;
    private int moveSpeed = 1;

    public Coipo(String nombre) {
        super(nombre, TipoAnimal.Coipo);
        setImage(ImageLoader.getInstancia().getImagenAnimal(getNumImg()));
        setFlippedImage(ImageLoader.getInstancia().getImagenAnimalFlipped(getNumImg()));
        Random random = new Random();
        moveTime = random.nextInt(200);
    }

    @Override
    public int getNumImg() {
        return 18;
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
