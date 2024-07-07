package Modelos.Utils;

import Modelos.Enumeration.*;
import Modelos.Exceptions.*;

/** Un zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public class Zoologico {

    /** Arreglo con los hábitat dentro del zoológico */
    private Habitat[] listaHabitat;

    /** Cantidad de dinero del zoológico */
    private int dinero;

    /** Ganancias totales del zoológico */
    private int gananciaTotal;

    /** Arreglo con las ganancias especiales del zoológico */
    private int[] gananciaEsp;

    /** Dinero que debe el zoológico por multas */
    private int multas;

    /** Estados de las tiendas del zoológico */
    private boolean[] tiendas;

    /** Almacen del zoológico */
    private Almacen almacen;

    /** Precio de las tiendas */
    private int precioTienda;

    /** Constructor del zoológico */
    public Zoologico() {
        listaHabitat = new Habitat[6];
        tiendas = new boolean[4];
        almacen = new Almacen();
        dinero = 4000;
        gananciaTotal = 0;
        multas = 0;
        gananciaEsp = new int[4];
        precioTienda = 1500;
        for(int i=0; i<6; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i], ListaAnimales.values()[i]);
        }
        for(int i=0; i<4; i++) {
            tiendas[i] = false;
        }
    }

    /** Método para comprar las tiendas del zoológico */
    public void comprarTienda(int index) throws Exception {
        if (transaccion(precioTienda, 5)) {
            tiendas[index] = true;
            gananciaEsp[3]++;
            precioTienda = precioTienda + (1500 * gananciaEsp[3] / 4);
        }
    }

    /** Método para comprar alimento de cierto tipo
     * @param comida Tipo de comida a comprar
     * @param index cantidad de comida a comprar */
    public void comprarAlimento(TipoComida comida, int index) throws Exception {
        if(transaccion(comida.getPrecio()*index,0)) {
            for (int i = 0; i < index; i++)
                almacen.addComida(comida);
        }
    }

    /** Método para alimentar un recinto
     * @param recinto Recinto a alimentar
     * @param index Cantidad de comida a dar*/
    public void alimentar(Recinto recinto, int index) {
        TipoComida comida = recinto.getTipo().getComida();
        if(almacen.getCantidad(comida) >= index) {
            for (int i = 0; i < index; i++) {
                almacen.removeComida(comida);
                recinto.alimentarAnimales();
            }
        }
    }

    /** Método para comprar los hábitat del zoológico */
    public void comprarHabitat(int index) throws Exception {
        if(transaccion(listaHabitat[index].getTipo().getPrecio(),listaHabitat[index].getTipo().getPrecio()/100)) {
            gananciaEsp[0] += listaHabitat[index].getTipo().getPrecio()/100;
            listaHabitat[index].desbloquear();
        }
   }

   /** Método para comprar los recintos de los hábitat
    * @param recinto Recinto a comprar*/
    public void comprarRecinto(Recinto recinto) throws Exception {
        int mult = 1;
        if(listaHabitat[recinto.getHabitat().getTipo().getValue()].getTemperatura())
            mult = 2;
        if(transaccion(recinto.getHabitat().getTipo().getPrecioRecinto(),10*mult)) {
            gananciaEsp[1] += 10*mult;
            recinto.desbloquear();
        }
    }

    /** Método para comprar los animales para un recinto
     * @param recinto Recinto al cual se compran los animales
     * @param nombre Nombre del animal*/
    public void comprarAnimal(Recinto recinto, String nombre) throws Exception {
        if(recinto.getCantidadAnimal()<10) {
            if (transaccion(recinto.getTipo().getPrecio(), recinto.getTipo().getPrecio()*5/100)) {
                gananciaEsp[2] += recinto.getTipo().getPrecio()*5/100;
                recinto.comprarAnimal(nombre);
            }
        } else {
            throw new MaximoAnimalesRecintoException("Cantidad Máxima de Animales [10]");
        }

    }

    /** Método para comprar los animales para un recinto
     * @param index Recinto al cual se compran los animales */
    public void comprarTemperatura(int index) throws Exception {
        if(transaccion(listaHabitat[index].getTipo().getprecioTemperatura(),0)) {
            listaHabitat[index].desblTemperatura();
            for(int i=0; i<6; i++) {
              if(listaHabitat[index].getRecinto(i).isAdquirido()) {
                  gananciaTotal += 10;
                  gananciaEsp[1] += 10;
              }
            }
        }
    }

    /** Método para realizar una transacción
     * @param precio valor de la transacción
     * @param bonus ganancias agregadas por realizar la compra
     * @return Booleano que indica si se realiza con exito la transacción
     * @throws Exception PagoInsuficienteException
     */
    public boolean transaccion(int precio, int bonus) throws Exception {
        if(dinero >= precio) {
            dinero -= precio;
            gananciaTotal += bonus;
            return true;
        } else {
            throw new PagoInsuficienteException("Pago Insuficiente");
        }
    }

    /** Método para accionar el rescate animal en el zoológico
     * @param hab Número del habitat en el cual se realiza el rescate
     * @param rec Número del recinto en el cual se realiza el rescate
     */
    public void rescateAnimal(int hab, int rec) {
        int mult = listaHabitat[hab].getRecinto(rec).getTipo().getPrecio()*5/100;
        int desc = listaHabitat[hab].getRecinto(rec).getCantidadAnimal()*mult;
        gananciaEsp[2] -= desc;
        gananciaTotal -=desc;
        listaHabitat[hab].getRecinto(rec).rescateAnimal();
    }

    /** Método que devuelve las ganancias del zoológico
     * @return ganancias del zoológico
     */
    public int getGanancia() {
        return gananciaTotal+(gananciaTotal*gananciaEsp[3]/4)-multas;
    }

    /** Método para hacer que el zoológico reciba las ganancias */
    public void recibirPaga(){
        dinero += gananciaTotal+(gananciaTotal*gananciaEsp[3]/4)-multas;
    }

    /** Método para asignar la penalización del zoológico */
    public void setPenalizacion(int x){
        multas = x;
    }

    /** Método que devuelve la cantidad de dinero del zoológico
     * @return cantidad de dinero del zoológico */
    public int getDinero() { return dinero; }

    /** Método para obtener un hábitat del zoológico
     * @param index Indica el número correspondiente al hábitat a obtener
     * @return Hábitat en la posición de index del zoológico */
    public Habitat getHabitat(int index) { return listaHabitat[index]; }

    /** Método para obtener el estado de una tienda del zoológico
     * @param index Indica el número correspondiente a la tienda a obtener
     * @return Estado de la tienda en la posición de index del zoológico */
    public boolean getTienda(int index) { return tiendas[index]; }

    /** Método para añadir dinero al zoológico
     * @param pago cantidad de dinero a añadir */
    public void addPaga(int pago) { dinero+=pago; }

    /** Método para obtener el almacen del zoológico
     * @return Almacen del zoológico */
    public Almacen getAlmacen() { return almacen; }

    /** Método para obtener el valor de las tiendas
     * @return valor de las tiendas */
    public int getPrecioTienda() { return precioTienda; }

    /** Métódo para obtener las ganancias especiales del zoológico
     * @param index ganancias especiales a obtener
     * @return cantidad de las ganancias especiales en la posición de index
     */
    public int getGananciaEsp(int index) { return gananciaEsp[index]; }

    /** Método para obtener la cantidad de multas
     * @return valor de las multas a pagar */
    public int getMultas() { return multas; }


}
