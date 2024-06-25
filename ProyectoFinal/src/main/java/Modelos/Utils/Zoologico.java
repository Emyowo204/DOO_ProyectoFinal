package Modelos.Utils;

import Modelos.Enumeration.*;

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
        dinero = 3000;
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

    public void comprarTienda(int index) {
        if (transaccion(precioTienda, 5)) {
            tiendas[index] = true;
            gananciaEsp[3]++;
            precioTienda = precioTienda + (1500 * gananciaEsp[3] / 4);
        }
    }

    public void comprarAlimento(TipoComida comida, int index) {
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

    public void comprarHabitat(int index) {
        if(transaccion(listaHabitat[index].getTipo().getPrecio(),listaHabitat[index].getTipo().getPrecio()/100)) {
            gananciaEsp[0] += 20;
            listaHabitat[index].desbloquear();
        }
   }

    public void comprarRecinto(Recinto recinto) {
        if(transaccion(recinto.getHabitat().getTipo().getPrecioRecinto(),10)) {
            gananciaEsp[1] += 10;
            recinto.desbloquear();
        }
    }

    public void comprarAnimal(Recinto recinto, String nombre) {
        if(recinto.getCantidadAnimal()<10) {
            if (transaccion(recinto.getTipo().getPrecio(), recinto.getTipo().getPrecio()*5/100)) {
                gananciaEsp[2] += recinto.getTipo().getPrecio()*5/100;
                recinto.comprarAnimal(nombre);
            }
        }
    }

    public boolean transaccion(int precio, int bonus) {
        if(dinero >= precio) {
            dinero -= precio;
            gananciaTotal += bonus;
            return true;
        } else {
            return false;
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

    public void getPaga(){
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
