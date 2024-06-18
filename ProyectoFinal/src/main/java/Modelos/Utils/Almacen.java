package Modelos.Utils;

import Modelos.Enumeration.TipoComida;

public class Almacen {
    private int[] cantidad;

    public Almacen() {
        cantidad = new int[7];
        for(int i=0; i<7; i++) {
            cantidad[i] = 0;
        }
    }

    public void addComida(TipoComida comida) {
        cantidad[comida.getValue()] += 1;
    }
    public void removeComida(TipoComida comida) {
        cantidad[comida.getValue()] -= 1;
    }
    public int getCantidad(TipoComida comida) {
        return cantidad[comida.getValue()];
    }
    public int getCantidad(int index) {
        return cantidad[index];
    }

}
