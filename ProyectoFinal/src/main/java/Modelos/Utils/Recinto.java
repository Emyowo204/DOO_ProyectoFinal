package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;

import java.util.ArrayList;

public class Recinto {
    private TipoAnimal tipo;
    private ArrayList<Animal> listaAnimales;
    private int hambre;
    private boolean adquirido;
    private Habitat habitat;

    public Recinto(Habitat habitat) {
        int hambre = 0;
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

    public void alimentarAnimales(){
        hambre=0;
    }

    public void addHambre(){
        if(getCantidadAnimal()>0)
            hambre++;
    }

    public int getPenalizacion(){
        if(hambre>2){
            return 5;
        }else {
            return 0;
        }
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
