package Modelos;

import java.util.ArrayList;

public class Habitat {
    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private ArrayList<TipoAnimal> UnlockAni;
    private ArrayList<TipoAnimal> TotalAni;
    private boolean adquirido;
    private boolean comprando;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        adquirido = false;
        comprando = false;
        listaRecintos = new Recinto[6];
        UnlockAni = new ArrayList<>();
        TotalAni = new ArrayList<>();
        for(int i=0; i<6; i++) {
            listaRecintos[i] = new Recinto(this);
            TotalAni.add(tipo.getAnimales()[i]);
        }
    }

    public void desbloquear() {
        adquirido = true;
    }

    public void desbloquearRecinto(int index) { listaRecintos[index].desbloquear(); }
    public void addAnimal(TipoAnimal animal) { UnlockAni.add(animal); }

    public void comprarAnimal(int index, String nombre) {
        listaRecintos[index].comprarAnimal(nombre);
    }

    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }
    public ArrayList<TipoAnimal> getUnlocked() {
        return UnlockAni;
    }
    public ArrayList<TipoAnimal> getTotal() {
        return TotalAni;
    }
    public boolean isComprando() { return comprando; }
    public void setComprando(boolean comprando) { this.comprando = comprando; }
    public TipoHabitat getTipo() {
        return tipo;
    }
}
