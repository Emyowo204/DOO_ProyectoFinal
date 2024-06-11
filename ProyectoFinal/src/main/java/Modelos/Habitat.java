package Modelos;

import java.util.ArrayList;

public class Habitat {
    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private ArrayList<TipoAnimal> animalesDesbl;
    private boolean adquirido;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        adquirido = false;
        listaRecintos = new Recinto[6];
        animalesDesbl = new ArrayList<>();
        for(int i=0; i<6; i++)
            listaRecintos[i] = new Recinto(this);
    }

    public void desbloquear() {
        adquirido = true;
    }

    public void desbloquearRecinto(int index, TipoAnimal animal) {
        listaRecintos[index].desbloquear(animal);
        animalesDesbl.add(animal);
    }
    public void addAnimal(TipoAnimal animal) { animalesDesbl.add(animal); }

    public void comprarAnimal(int index, String nombre) {
        listaRecintos[index].comprarAnimal(nombre);
    }

    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }
    public ArrayList<TipoAnimal> getUnlocked() {
        return animalesDesbl;
    }
    public TipoHabitat getTipo() {
        return tipo;
    }
}
