package Modelos.Acuario;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.ImageLoader;
import java.awt.*;
import java.util.Random;

public class Tiburon extends Animal {
    private int moveTime;
    private int moveSpeed;
    private final float randomizer;

    public Tiburon(String nombre) {
        super(nombre, TipoAnimal.Tiburon);
        moveSpeed=1;
        Random random = new Random();
        randomizer = random.nextFloat(1,2);
        moveTime = random.nextInt(200);
    }

    @Override
    public int getRandBound() {
        return 4;
    }

    public void moveInPath(){
        if(moveTime>200||moveTime<0){
            moveSpeed=-moveSpeed;
            swapFlipped();
        }

        moveTime+=moveSpeed;
        this.setPosition(moveTime,70 - (int) ((Math.sin((double) moveTime*randomizer /(4*Math.PI)))*70));
    }

    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
