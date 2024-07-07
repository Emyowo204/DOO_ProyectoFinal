package Vistas.Utils;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ImageLoaderTest {

    @Test
    void getInstancia() {
        assertNotEquals(null, ImageLoader.getInstancia());
    }

    @Test
    void getImagenAnimal() {
        int expectedCantidadDeImg = 36;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenAnimal(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }

    @Test
    void getImagenAnimalFlipped() {
        int expectedCantidadDeImg = 36;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenAnimalFlipped(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }

    @Test
    void getImagenAnimalAlterno() {
        int expectedCantidadDeImg = 36;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenAnimalAlterno(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }

    @Test
    void getImagenAnimalAlternoFlipped() {
        int expectedCantidadDeImg = 36;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenAnimalAlternoFlipped(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }

    @Test
    void getImagenFondoZoo(){
        int expectedCantidadDeImg = 8;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenFondoZoo(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }

    @Test
    void getImagenFondoInfo(){
        int expectedCantidadDeImg = 36;
        int cantidadImgCargadas = 0;

        for(int i=0;i<expectedCantidadDeImg;i++){
            BufferedImage img = ImageLoader.getInstancia().getImagenFondoInfo(i);
            if(img != null){
                cantidadImgCargadas++;
            }
        }
        assertEquals(expectedCantidadDeImg,cantidadImgCargadas);
    }
}