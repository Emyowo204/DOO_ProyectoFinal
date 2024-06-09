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
    private static BufferedImage[] imagenProducto;

    /** Imágenes especiales de los Productos */
    private static BufferedImage[] imagenProductoEspecial;

    /** Imágen de las Monedas */
    private static BufferedImage[] imagenMoneda;

    /** Constructor privado donde se cargan las Imágenes */
    private ImageLoader() {

        int cantidadProd = 16;
        int cantidadProdEsp = 3;
        int cantidadMon = 3;

        imagenProducto = new BufferedImage[cantidadProd];
        imagenProductoEspecial = new BufferedImage[cantidadProdEsp];
        imagenMoneda = new BufferedImage[cantidadMon];
        for(int i=0; i<cantidadProd; i++){
            try{
            imagenProducto[i] = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+ i +".png"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        for(int i=0; i<cantidadProdEsp; i++){
            try{
                imagenProductoEspecial[i] = ImageIO.read(getClass().getClassLoader().getResource("imgProductoEspecial"+ i +".png"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        for(int i = 0; i<cantidadMon; i++){
            try{
                imagenMoneda[i] = ImageIO.read(getClass().getClassLoader().getResource("imgMoneda"+ i +".png"));
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
    public BufferedImage getImagenProducto(int index){
        return imagenProducto[index];
    }

    /** Método para devolver las imágenes especiales de los Productos */
    public BufferedImage getImagenProductoEspecial(int index){
        return imagenProductoEspecial[index];
    }

    /** Método para devolver las imágenes de las Monedas */
    public BufferedImage getImagenMoneda(int index){
        return imagenMoneda[index];
    }

}
