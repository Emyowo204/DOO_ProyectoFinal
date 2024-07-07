package Modelos.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoologicoDineroExtraTest {

    @Test
    void transaccion() throws Exception {
        Zoologico zoo = new Zoologico();
        int expectedMoney = zoo.getDinero()+500;
        zoo.addPaga(2000);
        zoo.transaccion(1500,0);
        assertEquals(expectedMoney, zoo.getDinero());
    }
}