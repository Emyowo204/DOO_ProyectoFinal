package Modelos.Desierto;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Coyote extends Animal {
    private int moveTime;
    private int moveSpeed = 1;

    public Coyote(String nombre) {
        super(nombre, TipoAnimal.Coyote);
        setImage(ImageLoader.getInstancia().getImagenAnimal(getNumImg()));
        setFlippedImage(ImageLoader.getInstancia().getImagenAnimalFlipped(getNumImg()));
        Random random = new Random();
        moveTime = random.nextInt(200);
    }

    @Override
    public int getNumImg() {
        return 27;
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
