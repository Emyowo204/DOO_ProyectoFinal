package Vistas.Utils;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
}