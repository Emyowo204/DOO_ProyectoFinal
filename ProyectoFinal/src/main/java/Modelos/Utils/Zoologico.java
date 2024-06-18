package Modelos.Utils;

import Modelos.Enumeration.*;

public class Zoologico {
    private Habitat[] listaHabitat;
    private int dinero;
    private int ganancia;
    private int penalizacion;
    private boolean[] tiendas;
    private int multTiendas;

    public Zoologico() {
        listaHabitat = new Habitat[6];
        tiendas = new boolean[4];
        dinero = 10000;
        ganancia = 0;
        penalizacion = 0;
        multTiendas = 0;
        for(int i=0; i<6; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i], ListaAnimales.values()[i]);
        }
        for(int i=0; i<4; i++) {
            tiendas[i] = false;
        }
    }

    public void comprarTienda(int index) {
        if(transaccion(1500+(1500*multTiendas/4),0)) {
            tiendas[index] = true;
            multTiendas++;
        }
    }

    public void comprarHabitat(int index) {
        if(transaccion(listaHabitat[index].getTipo().getPrecio(),20))
            listaHabitat[index].desbloquear();
   }

    public void comprarRecinto(Recinto recinto) {
        if(transaccion(recinto.getHabitat().getTipo().getPrecioRecinto(),10))
            recinto.desbloquear();
    }

    public void comprarAnimal(Recinto recinto, String nombre) {
        if(recinto.getCantidadAnimal()<10) {
            if (transaccion(recinto.getTipo().getPrecio(), recinto.getTipo().getPrecio()*5/100))
                recinto.comprarAnimal(nombre);
        }
    }

    public boolean transaccion(int precio, int add) {
        if(dinero >= precio) {
            dinero -= precio;
            ganancia += add;
            return true;
        } else {
            System.out.println("No hay plata xd");
            return false;
        }
    }
    public int getGanancia() {
        return ganancia+(ganancia*multTiendas/4)-penalizacion;
    }

    public void getPaga(){
        dinero += ganancia+(ganancia*multTiendas/4)-penalizacion;
    }

    public void setPenalizacion(int x){
        penalizacion = x;
    }
    public int getDinero() { return dinero; }
    public Habitat getHabitat(int index) { return listaHabitat[index]; }
    public boolean getTienda(int index) { return tiendas[index]; }

    public void addPaga(int pago) { dinero+=pago; }


}
