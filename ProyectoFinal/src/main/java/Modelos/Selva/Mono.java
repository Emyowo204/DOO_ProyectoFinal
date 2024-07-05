package Modelos.Selva;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.ImageLoader;

import java.awt.*;
import java.util.Random;

/** Los es un grupo de animales primates con 705 especies y subespecies actualmente, vive en la selva (en este caso) y se puede adoptar
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Mono extends Animal {
    private int moveTime;
    private int moveSpeed;

    Random random = new Random();
    private final float randomizer;

    /** Constructor ue genera los números pseudoaleatorios para el movimiento y le entrega el tipo animal Mono a la clase
     * @param nombre Nombre del animal tipo Mono */
    public Mono(String nombre) {
        super(nombre, TipoAnimal.Mono);
        moveSpeed = 1;
        randomizer = random.nextFloat(1,2);
        moveTime = random.nextInt(150);

    }

    /** Método para obtener la probabilidad de obtener el animal con su imagen alterna
     * @return Número entero que indica una probabilidad de 1 en 10 (10%) */
    @Override
    public int getRandBound() {
        return 10;
    }

    /** Método para generar la siguiente posición del animal en un plano cartesiano, utilizando una función seno girada 90° */
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

    /** Método para dibujar la imagen del animal en un componente de Swing
     * @param g El objeto grafico que dibuja los componentes
     * @param observer El componente donde se dibujaran los otros componentes */
    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
