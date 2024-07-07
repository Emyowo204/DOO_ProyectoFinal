package Modelos.Utils;

import Modelos.Enumeration.TipoComida;

/** Un almacen de comida que guarda la cantidad de comidas correspondientes a cada tioo de comida
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Almacen {

    /** Arreglo de números enteros con la cantidad de comida de cada tipo */
    private int[] cantidad;

    /** Constructor que crea un almacen con una cantidad de 0 para cada comida */
    public Almacen() {
        int cantidadDeComida =  TipoComida.values().length;
        cantidad = new int[cantidadDeComida];
        for(int i=0; i<cantidadDeComida; i++) {
            cantidad[i] = 0;
        }
    }

    /** Método para agregarle uno a la cantidad de comida seleccionada
     * @param comida El tipo de comida que se va a aumentar de cantidad */
    public void addComida(TipoComida comida) {
        cantidad[comida.getValue()] += 1;
    }

    /** Método para quitar uno a la cantidad de comida seleccionada
     * @param comida El tipo de comida que se va a disminuir de cantidad */
    public void removeComida(TipoComida comida) {
        cantidad[comida.getValue()] -= 1;
    }

    /** Método para obtener la cantidad de comida seleccionada
     * @param comida El tipo de comida que se quiere conocer su cantidad
     * @return El número entero con la cantidad de comida */
    public int getCantidad(TipoComida comida) {
        return cantidad[comida.getValue()];
    }
}
