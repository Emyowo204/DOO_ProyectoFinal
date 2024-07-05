package Modelos.Utils;

import Modelos.Enumeration.*;
import Modelos.Exceptions.*;

public class Zoologico {
    private Habitat[] listaHabitat;
    private int dinero;
    private int gananciaTotal;
    private int[] gananciaEsp;
    private int multas;
    private boolean[] tiendas;
    private Almacen almacen;
    private int precioTienda;

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

    public void comprarTienda(int index) throws Exception {
        if (transaccion(precioTienda, 5)) {
            tiendas[index] = true;
            gananciaEsp[3]++;
            precioTienda = precioTienda + (1500 * gananciaEsp[3] / 4);
        }
    }

    public void comprarAlimento(TipoComida comida, int index) throws Exception {
        if(transaccion(comida.getPrecio()*index,0)) {
            for (int i = 0; i < index; i++)
                almacen.addComida(comida);
        }
    }

    public void alimentar(Recinto recinto, int index) {
        TipoComida comida = recinto.getTipo().getComida();
        if(almacen.getCantidad(comida) >= index) {
            for (int i = 0; i < index; i++) {
                almacen.removeComida(comida);
                recinto.alimentarAnimales();
            }
        }
    }

    public void comprarHabitat(int index) throws Exception {
        if(transaccion(listaHabitat[index].getTipo().getPrecio(),listaHabitat[index].getTipo().getPrecio()/100)) {
            gananciaEsp[0] += listaHabitat[index].getTipo().getPrecio()/100;
            listaHabitat[index].desbloquear();
        }
   }

    public void comprarRecinto(Recinto recinto) throws Exception {
        int mult = 1;
        if(listaHabitat[recinto.getHabitat().getTipo().getValue()].getTemperatura())
            mult = 2;
        if(transaccion(recinto.getHabitat().getTipo().getPrecioRecinto(),10*mult)) {
            gananciaEsp[1] += 10*mult;
            recinto.desbloquear();
        }
    }

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


    public boolean transaccion(int precio, int bonus) throws Exception {
        if(dinero >= precio) {
            dinero -= precio;
            gananciaTotal += bonus;
            return true;
        } else {
            throw new PagoInsuficienteException("Pago Insuficiente");
        }
    }

    public void rescateAnimal(int hab, int rec) {
        int mult = listaHabitat[hab].getRecinto(rec).getTipo().getPrecio()*5/100;
        int desc = listaHabitat[hab].getRecinto(rec).getCantidadAnimal()*mult;
        gananciaEsp[2] -= desc;
        gananciaTotal -=desc;
        listaHabitat[hab].getRecinto(rec).rescateAnimal();
    }

    public int getGanancia() {
        return gananciaTotal+(gananciaTotal*gananciaEsp[3]/4)-multas;
    }

    public void recibirPaga(){
        dinero += gananciaTotal+(gananciaTotal*gananciaEsp[3]/4)-multas;
    }

    public void setPenalizacion(int x){
        multas = x;
    }
    public int getDinero() { return dinero; }
    public Habitat getHabitat(int index) { return listaHabitat[index]; }
    public boolean getTienda(int index) { return tiendas[index]; }
    public void addPaga(int pago) { dinero+=pago; }
    public Almacen getAlmacen() { return almacen; }
    public int getPrecioTienda() { return precioTienda; }
    public int getGananciaEsp(int index) { return gananciaEsp[index]; }
    public int getMultas() { return multas; }


}
