package Modelos;

import java.awt.event.HierarchyBoundsAdapter;

public class Zoologico {
    private Habitat[] listaHabitat;

    public Zoologico() {
        listaHabitat = new Habitat[6];
        for(int i=0; i<6; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i]);
        }
    }

   public void comprarHabitat(int index) {
       listaHabitat[index].desbloquear();
   }

    public void comprarRecinto(int index, int recinto, TipoAnimal animal) {
        listaHabitat[index].desbloquearRecinto(recinto, animal);
    }

    public void comprarAnimal(int index, int recinto, String nombre) {
        listaHabitat[index].comprarAnimal(recinto, nombre);
    }

    public Habitat getHabitat(int index) { return listaHabitat[index]; }
}
