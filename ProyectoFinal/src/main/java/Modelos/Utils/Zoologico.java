package Modelos.Utils;

import Modelos.Enumeration.*;

public class Zoologico {
    private Habitat[] listaHabitat;
    private int dinero;

    public Zoologico() {
        listaHabitat = new Habitat[6];
        dinero = 5000;
        for(int i=0; i<6; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i], ListaAnimales.values()[i]);
        }
    }

    public void comprarHabitat(int index) {
        if(transaccion(listaHabitat[index].getTipo().getPrecio()))
            listaHabitat[index].desbloquear();
   }

    public void comprarRecinto(Recinto recinto) {
        if(transaccion(recinto.getHabitat().getTipo().getPrecioRecinto()))
            recinto.desbloquear();
    }

    public void comprarAnimal(Recinto recinto, String nombre) {
        if(transaccion(recinto.getTipo().getPrecio()))
            recinto.comprarAnimal(nombre);
    }

    public boolean transaccion(int precio) {
        if(dinero >= precio) {
            dinero -= precio;
            return true;
        } else {
            System.out.println("No hay plata xd");
            return false;
        }
    }

    public Habitat getHabitat(int index) { return listaHabitat[index]; }
}
