package Vistas;

import javax.imageio.ImageIO;
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


    /** Constructor privado donde se cargan las Imágenes */
    private ImageLoader() {

        int cantidadAnimales = 3;

        imagenAnimal = new BufferedImage[cantidadAnimales];

        for(int i=0; i<cantidadAnimales; i++){
            try{
            imagenAnimal[i] = ImageIO.read(getClass().getClassLoader().getResource("animal"+ i +".png"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
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

}
