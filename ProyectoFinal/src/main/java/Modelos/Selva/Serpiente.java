package Modelos.Selva;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import java.awt.*;
import java.util.Random;

/** Las Serpentes son un suborden de animales saurópsidos diápsidos que no cuentan patas y tienen un cuerpo muy alargado, vive en la selva (en este caso) y se puede adoptar
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Serpiente extends Animal {

    /** Número de un momento en el movimiento continuo del animal */
    private int moveTime;

    /** Número del cambio de un momento a otro del movimiento continuo del animal */
    private int moveSpeed;

    /** Número pseudoaleatorio que crea una variación en el movimiento continuo del animal */
    private final float randomizer;

    /** Constructor ue genera los números pseudoaleatorios para el movimiento y le entrega el tipo animal Serpiente a la clase
     * @param nombre Nombre del animal tipo Serpiente */
    public Serpiente(String nombre) {
        super(nombre, TipoAnimal.Serpiente);
        Random random = new Random();
        moveSpeed=1;
        randomizer = random.nextFloat(1,2);
        moveTime = random.nextInt(200);
    }

    /** Método para obtener la probabilidad de obtener el animal con su imagen alterna
     * @return Número entero que indica una probabilidad de 1 en 3 (33,3%) */
    @Override
    public int getRandBound() {
        return 3;
    }

    /** Método para generar la siguiente posición del animal en un plano cartesiano, utilizando una función seno */
    public void moveInPath(){
        if(moveTime>200||moveTime<0){
            moveSpeed=-moveSpeed;
            swapFlipped();
        }
        moveTime+=moveSpeed;
        this.setPosition(moveTime,70 - (int) ((Math.sin((double) moveTime*randomizer /(4*Math.PI)))*70));
    }

    /** Método para dibujar la imagen del animal en un componente de Swing
     * @param g El objeto gráfico que dibuja los componentes
     * @param observer El componente donde se dibujaran los otros componentes */
    @Override
    public void paintComponent(Graphics g, Component observer) {
        super.paintComponent(g,observer);
    }
}
