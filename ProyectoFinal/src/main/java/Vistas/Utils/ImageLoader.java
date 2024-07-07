package Vistas.Utils;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un Singleton que carga, guarda y devuelve Imágenes
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class ImageLoader {

    /** Puntero a la instancia única de ImageLoader */
    private static ImageLoader imageLoader;

    /** Arreglo de imágenes de los animales */
    private static BufferedImage[] imagenAnimal;

    /** Arreglo de imágenes volteadas de los animales */
    private static BufferedImage[] imagenAnimalFlipped;

    /** Arreglo de imágenes alternativas de los animales */
    private static BufferedImage[] imagenAnimalAlterno;

    /** Arreglo de imágenes alternativas volteadas de los animales */
    private static BufferedImage[] imagenAnimalAlternoFlipped;

    /** Arreglo de imágenes de los distintos fondos del zoológico */
    private static BufferedImage[] fondosZoologico;

    /** Arreglo de imágenes de los distintos fondos con información de animales */
    private static BufferedImage[] fondosInformacion;

    /** Constructor privado donde se cargan las Imágenes */
    private ImageLoader() {

        int cantidadAnimales = 36;
        int cantidadHabitats = 8;

        imagenAnimal = new BufferedImage[cantidadAnimales];
        imagenAnimalFlipped = new BufferedImage[cantidadAnimales];
        imagenAnimalAlterno = new BufferedImage[cantidadAnimales];
        imagenAnimalAlternoFlipped = new BufferedImage[cantidadAnimales];
        fondosZoologico = new BufferedImage[cantidadHabitats];
        fondosInformacion = new BufferedImage[cantidadAnimales];

        for(int i=0; i<cantidadAnimales; i++){
            try{
                imagenAnimal[i] = ImageIO.read(getClass().getClassLoader().getResource("Animales/imgAnimal"+ i +".png"));
                imagenAnimalAlterno[i] = ImageIO.read(getClass().getClassLoader().getResource("Alternos/imgAnimal"+ i +".png"));
                fondosInformacion[i] = ImageIO.read(getClass().getClassLoader().getResource("Informacion/imgAnimal"+ i +".png"));
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
            AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
            transform.translate(-imagenAnimal[i].getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            imagenAnimalFlipped[i] = op.filter(imagenAnimal[i], null);

            AffineTransform transform_1 = AffineTransform.getScaleInstance(-1, 1);
            transform_1.translate(-imagenAnimalAlterno[i].getWidth(null), 0);
            AffineTransformOp op_1 = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            imagenAnimalAlternoFlipped[i] = op_1.filter(imagenAnimalAlterno[i], null);
        }
        for(int i=0; i<cantidadHabitats; i++) {
            try{
                fondosZoologico[i] = ImageIO.read(getClass().getClassLoader().getResource("imgFondoZoo"+ i +".png"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }

    /** Método para devolver la instancia única de ImageLoader */
    public static ImageLoader getInstancia(){
        if(imageLoader == null){
            imageLoader = new ImageLoader();
        }
        return imageLoader;
    }

    /** Método para devolver una imagen del arreglo de imágenes de animales
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen del animal correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenAnimal(int index){
        return imagenAnimal[index];
    }

    /** Método para devolver una imagen volteada del arreglo de imágenes de animales
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen volteada del animal correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenAnimalFlipped(int index){
        return imagenAnimalFlipped[index];
    }

    /** Método para devolver una imagen del arreglo de imágenes de animales alternativos
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen alternativa del animal correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenAnimalAlterno(int index){
        return imagenAnimalAlterno[index];
    }

    /** Método para devolver una imagen volteada del arreglo de imágenes de animales alternativos
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen alternativa volteada del animal correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenAnimalAlternoFlipped(int index){
        return imagenAnimalAlternoFlipped[index];
    }

    /** Método para devolver una imagen del arreglo de imágenes de fondos del zoológico
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen del fondo correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenFondoZoo(int index){
        return fondosZoologico[index];
    }

    /** Método para devolver una imagen del arreglo de imágenes de información de animales
     * @param index El número entero con el número de la imagen en el arreglo
     * @return La imagen con información correspondiente al arreglo y al número entregado */
    public BufferedImage getImagenFondoInfo(int index){
        return fondosInformacion[index];
    }
}
