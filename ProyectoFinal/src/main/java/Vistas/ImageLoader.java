package Vistas;

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

    /** Imágenes de los Productos */
    private static BufferedImage[] imagenAnimal;
    private static BufferedImage[] imagenAnimalFlipped;


    /** Constructor privado donde se cargan las Imágenes */
    private ImageLoader() {

        int cantidadAnimales = 36;

        imagenAnimal = new BufferedImage[cantidadAnimales];
        imagenAnimalFlipped = new BufferedImage[cantidadAnimales];

        for(int i=0; i<cantidadAnimales; i++){
            try{
            imagenAnimal[i] = ImageIO.read(getClass().getClassLoader().getResource("Animales/imgAnimal"+ i +".png"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
            transform.translate(-imagenAnimal[i].getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            imagenAnimalFlipped[i] = op.filter(imagenAnimal[i], null);
        }
    }

    /** Método para devolver la instancia unica de ImageLoader */
    public static ImageLoader getInstancia(){
        if(imageLoader == null){
            imageLoader = new ImageLoader();
        }
        return imageLoader;
    }

    /** Método para devolver las imágenes de los Productos */
    public BufferedImage getImagenAnimal(int index){
        return imagenAnimal[index];
    }
    public BufferedImage getImagenAnimalFlipped(int index){
        return imagenAnimalFlipped[index];
    }


}
