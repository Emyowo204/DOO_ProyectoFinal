package Modelos.Utils;

import Modelos.Enumeration.*;

import java.util.ArrayList;

public class Habitat {
    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private ArrayList<TipoAnimal> UnlockAni;
    private ArrayList<TipoAnimal> TotalAni;
    private boolean adquirido;
    private boolean comprando;

    public Habitat(TipoHabitat tipo, ListaAnimales lista) {
        this.tipo = tipo;
        adquirido = false;
        comprando = false;
        listaRecintos = new Recinto[6];
        UnlockAni = new ArrayList<>();
        TotalAni = new ArrayList<>();
        for(int i=0; i<6; i++) {
            listaRecintos[i] = new Recinto(this);
            TotalAni.add(lista.getAnimales()[i]);
        }
    }

    public void desbloquear() {
        adquirido = true;
    }
    public void addAnimal(TipoAnimal animal) { UnlockAni.add(animal); }
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
    public boolean isAdquirido() { return adquirido; }
    public void setComprando(boolean comprando) { this.comprando = comprando; }
    public TipoHabitat getTipo() {
        return tipo;
    }
}
