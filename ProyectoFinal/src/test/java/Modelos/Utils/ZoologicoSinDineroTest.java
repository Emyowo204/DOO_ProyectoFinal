package Modelos.Utils;

import Modelos.Enumeration.ListaAnimales;
import Modelos.Enumeration.TipoComida;
import Modelos.Enumeration.TipoHabitat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class ZoologicoSinDineroTest {

    static Zoologico zoo;
    @BeforeAll
    static void Zoologico(){
        zoo = new Zoologico();
        zoo.addPaga(-4000);
    }

    @Test
    void comprarTienda() {
        try {
            zoo.comprarTienda(0);
        } catch (Exception e){
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void comprarAlimento() {
        try {
            zoo.comprarAlimento(TipoComida.Pescado,1);
        } catch (Exception e){
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void alimentar() {
    }

    @Test
    void comprarHabitat() {
        try {
            zoo.comprarHabitat(0);
        } catch (Exception e){
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void comprarRecinto() {
        try {
            zoo.comprarRecinto(new Recinto(new Habitat(TipoHabitat.Acuario, ListaAnimales.Acuario)));
        } catch (Exception e) {
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void comprarAnimal() {
        try {
            zoo.comprarAnimal(new Recinto(new Habitat(TipoHabitat.Acuario, ListaAnimales.Acuario)), "nombre");
        } catch (Exception e) {
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void comprarTemperatura() {
        try {
            zoo.comprarTemperatura(0);
        } catch (Exception e){
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }

    @Test
    void transaccion() {
        try{
            zoo.transaccion(1,0);
        } catch (Exception e) {
            String expectedMessage = "Pago Insuficiente";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage,actualMessage);
        }
    }





}