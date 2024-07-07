package Modelos.Utils;

import Modelos.Enumeration.*;
import java.util.ArrayList;

/** Una fábrica de animales para crear y retornar instancias de animales específicos
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Habitat {
    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private ArrayList<TipoAnimal> UnlockAni;
    private ArrayList<TipoAnimal> TotalAni;
    private boolean adquirido;
    private boolean comprando;
    private boolean temperatura;
    private int penalizacionHabitat;

    public Habitat(TipoHabitat tipo, ListaAnimales lista) {
        penalizacionHabitat = 0;
        this.tipo = tipo;
        adquirido = false;
        comprando = false;
        temperatura = false;
        listaRecintos = new Recinto[6];
        UnlockAni = new ArrayList<>();
        TotalAni = new ArrayList<>();
        for(int i=0; i<6; i++) {
            listaRecintos[i] = new Recinto(this);
            TotalAni.add(lista.getAnimales()[i]);
        }
    }

    public int getPenalizacionHabitat(){
        penalizacionHabitat = 0;
        for (int i = 0; i < 6; i++) {
            penalizacionHabitat+=listaRecintos[i].getPenalizacion();
        }
        return penalizacionHabitat;
    }
    public void desbloquear() {
        adquirido = true;
    }
    public void desblTemperatura() {
        temperatura = true;
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
    public boolean getTemperatura() { return temperatura; }
    public void setComprando(boolean comprando) { this.comprando = comprando; }
    public TipoHabitat getTipo() {
        return tipo;
    }
}
