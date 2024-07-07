package Modelos.Utils;

import Modelos.Enumeration.*;
import Vistas.Utils.ImageLoader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/** Un ser vivo que constituyen un reino que reúne un amplio grupo de organismos, viven en habitats, tienen comida propia y se pueden adoptar
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public abstract class Animal implements Visible {

    /** Nombre del animal específico */
    private String nombre;

    /** Tipo de animal específico */
    private TipoAnimal tipo;

    /** Tipo de habitat donde vive el animal */
    private TipoHabitat habitat;

    /** Tipo de comida que come el animal */
    private TipoComida comida;

    /** Coordenada del animal en el eje X */
    private int x;

    /** Coordenada del animal en el eje Y */
    private int y;

    /** Imagen del animal */
    private BufferedImage img;

    /** Imagen volteada del animal */
    private BufferedImage imgFlipped;


    /** Constructor que crea un animal de un tipo específico y guarda su habitat, comida y nombre
     * @param nombre Nombre del animal
     * @param tipo El tipo específico del animal */
    public Animal(String nombre, TipoAnimal tipo){
        this.tipo = tipo;
        habitat = tipo.getHabitat();
        comida = tipo.getComida();
        this.nombre = nombre;
        int numImg = tipo.getValue();
        setImage(ImageLoader.getInstancia().getImagenAnimal(numImg));
        setFlippedImage(ImageLoader.getInstancia().getImagenAnimalFlipped(numImg));
        if(new Random().nextInt(getRandBound())<1) {
            setImage(ImageLoader.getInstancia().getImagenAnimalAlterno(numImg));
            setFlippedImage(ImageLoader.getInstancia().getImagenAnimalAlternoFlipped(numImg));
        }
    }

    /** Método para generar la siguiente posición del animal en un plano cartesiano */
    public abstract void moveInPath();

    /** Método para entregarle una imagen al animal
     * @param image La imagen la cúal se va a utilizar como la imagen del animal */
    @Override
    public void setImage(BufferedImage image) {
        img = image;
    }

    /** Método para entregarle una imagen volteada al animal
     * @param image La imagen la cúal se va a utilizar como la imagen volteada del animal */
    public void setFlippedImage(BufferedImage image) {
        imgFlipped = image;
    }

    /** Método para intercambiar las imágenes, volviendo la imagen volteada la derecha y la imagen derecha la volteada */
    public void swapFlipped(){
        BufferedImage aux = img;
        img = imgFlipped;
        imgFlipped = aux;
    }

    /** Método para obtener el nombre del animal
     * @return String de contiene el nombre asignado al animal */
    public String getNombre() {
        return nombre;
    }

    /** Método para obtener el tipo de animal específico
     * @return El tipo animal específico del animal */
    public TipoAnimal getTipo() {
        return tipo;
    }

    /** Método para obtener el habitat del animal
     * @return El tipo de habitat del animal */
    public TipoHabitat getHabitat() {
        return habitat;
    }

    /** Método para obtener la comida del animal
     * @return El tipo de comida del animal */
    public TipoComida getComida() {
        return comida;
    }

    /** Método para asignarle las coordenadas X e Y al animal en un plano cartesiano
     * @param x Número entero que va a ser la coordenada X del animal
     * @param y Número entero que va a ser la coordenada Y del animal*/
    @Override
    public void setPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }

    /** Método para dibujar la imagen del animal en un componente de Swing
     * @param g El objeto gráfico que dibuja los componentes
     * @param observer El componente donde se dibujaran los otros componentes */
    @Override
    public void paintComponent(Graphics g, Component observer) {
        g.drawImage(img,x,y,observer);
    }
}
