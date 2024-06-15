package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;

import java.util.ArrayList;

public class Recinto {
    private TipoAnimal tipo;
    private ArrayList<Animal> listaAnimales;
    private boolean adquirido;
    private Habitat habitat;

    public Recinto(Habitat habitat) {
        tipo = null;
        this.habitat = habitat;
        listaAnimales = new ArrayList<>();
        adquirido =  false;
    }

    public void desbloquear() { adquirido = true; }

    public void asignarAnimal(TipoAnimal animal) {
        if(tipo == null)
            tipo = animal;
        habitat.addAnimal(tipo);
    }

    public void comprarAnimal(String nombre) {
        listaAnimales.add(new AnimalFactory().crearAnimal(tipo, nombre));
    }
    public ArrayList<Animal> getListaAnimales() { return listaAnimales; }
    public TipoAnimal getTipo() { return tipo; }
    public boolean getAdquirido() { return adquirido; }
    public Habitat getHabitat() { return habitat; }
    public int getCantidadAnimal(){
        return listaAnimales.size();
    }
}
