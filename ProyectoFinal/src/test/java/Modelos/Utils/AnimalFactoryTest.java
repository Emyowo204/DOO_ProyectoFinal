package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalFactoryTest {

    @Test
    void crearAnimal() {
        assertSame(TipoAnimal.Carpintero, new AnimalFactory().crearAnimal(TipoAnimal.Carpintero,"").getTipo());
    }
}