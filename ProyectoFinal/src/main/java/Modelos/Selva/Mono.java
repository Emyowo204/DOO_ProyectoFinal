package Modelos.Selva;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Mono extends Animal {
    private int moveTime;
    private int moveSpeed;

    Random random = new Random();
    private final float randomizer;

    public Mono(String nombre) {
        super(nombre, TipoAnimal.Mono);
        moveSpeed = 1;
        randomizer = random.nextFloat(1,2);
        moveTime = random.nextInt(150);

    }

    @Override
    public int getRandBound() {
        return 10;
    }

    public void moveInPath(){

        double x =  Math.sin( (double) moveTime*randomizer /(4*Math.PI));
        int y = moveTime;

        if(y>150||y<0){
            moveSpeed=-moveSpeed;
            swapFlipped();
        }

        moveTime+=moveSpeed;
        this.setPosition( (int) (x*20+(randomizer-1)*200) , y);
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
