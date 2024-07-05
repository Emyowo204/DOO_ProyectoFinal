package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Enumeration.TipoComida;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoologicoDineroExcactoTest {

    static Zoologico zoo;
    @BeforeAll
    static void Zoologico(){
        zoo = new Zoologico();
        zoo.addPaga(-4000);
    }

    @Test
    void comprarTienda() throws Exception {
        zoo.addPaga(1500);
        try {
            zoo.comprarTienda(0);
        } finally {
            assertTrue(zoo.getTienda(0));
        }
    }

    @Test
    void comprarAlimento() throws Exception {
        zoo.addPaga(150);

        zoo.comprarAlimento(TipoComida.Pescado,1);

        assertEquals(0,zoo.getDinero());

    }

    @Test
    void alimentar() {
    }

    @Test
    void comprarHabitat() throws Exception {
        zoo.addPaga(1000);
        zoo.comprarHabitat(0);
        assertTrue(zoo.getHabitat(0).isAdquirido());

    }

    @Test
    void comprarRecinto() throws Exception {
        zoo.addPaga(1000);
        zoo.comprarRecinto(zoo.getHabitat(0).getRecinto(0));
        assertTrue(zoo.getHabitat(0).getRecinto(0).isAdquirido());
    }

    @Test
    void comprarAnimal() throws Exception {
        zoo.addPaga(100);
        zoo.getHabitat(0).getRecinto(0).asignarAnimal(TipoAnimal.Carpintero);
        zoo.comprarAnimal(zoo.getHabitat(0).getRecinto(0),"Carpintero");
        assertEquals(1,zoo.getHabitat(0).getRecinto(0).getCantidadAnimal());
    }

    @Test
    void comprarTemperatura() throws Exception {
        zoo.addPaga(1500);
        zoo.comprarTemperatura(0);
        assertTrue(zoo.getHabitat(0).getTemperatura());

    }

    @Test
    void transaccion() throws Exception {
        zoo.addPaga(100);
        zoo.transaccion(100,0);
        assertEquals(0,zoo.getDinero());
    }
}