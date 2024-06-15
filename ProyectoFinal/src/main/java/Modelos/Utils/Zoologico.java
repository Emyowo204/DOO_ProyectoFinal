package Modelos.Utils;

import Modelos.Enumeration.*;

public class Zoologico {
    private Habitat[] listaHabitat;
    private int dinero;
    private int bonus;

    public Zoologico() {
        listaHabitat = new Habitat[6];
        dinero = 10000;
        bonus = 0;
        for(int i=0; i<6; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i], ListaAnimales.values()[i]);
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
            if (transaccion(recinto.getTipo().getPrecio(), 5))
                recinto.comprarAnimal(nombre);
        }
    }

    public boolean transaccion(int precio, int add) {
        if(dinero >= precio) {
            dinero -= precio;
            bonus += add;
            return true;
        } else {
            System.out.println("No hay plata xd");
            return false;
        }
    }
    public int getBonus() {
        return bonus;
    }

    public void getPaga(){
        dinero+=bonus;
    }
    public int getDinero() { return dinero; }
    public Habitat getHabitat(int index) { return listaHabitat[index]; }


}
