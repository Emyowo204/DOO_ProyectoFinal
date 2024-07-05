package Modelos.Artico;

import Modelos.Utils.Animal;
import Modelos.Enumeration.TipoAnimal;
import Vistas.Utils.ImageLoader;

import java.awt.*;
import java.util.Random;

/** Una Odobenus rosmarus es un animal mamífero pinnípedo de la familia de los odobénidos que habita en los mares árticos, se puede adoptar
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Morsa extends Animal {
    private int moveTime;
    private int moveSpeed;
    private final float randomizer;

    /** Constructor ue genera los números pseudoaleatorios para el movimiento y le entrega el tipo animal Morsa a la clase
     * @param nombre Nombre del animal tipo Morsa */
    public Morsa(String nombre) {
        super(nombre, TipoAnimal.Morsa);
        moveSpeed=1;
        Random random = new Random();
        randomizer = random.nextFloat(1,2);
        moveTime = random.nextInt(200);
    }

    /** Método para obtener la probabilidad de obtener el animal con su imagen alterna
     * @return Número entero que indica una probabilidad de 1 en 2 (50%) */
    @Override
    public int getRandBound() {
        return 2;
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
