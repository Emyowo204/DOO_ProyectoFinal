package Modelos;

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

    public void desbloquear(TipoAnimal animal) {
        if(tipo == null)
            tipo = animal;
        adquirido = true;
        habitat.addAnimal(tipo);
    }

    public void comprarAnimal(String nombre) {
        if (tipo == null) {
            // error
        }
        else {
            listaAnimales.add(new AnimalFactory().crearAnimal(tipo, nombre));
        }
    }
    public ArrayList<Animal> getListaAnimales() { return listaAnimales; }
    public TipoAnimal getTipo() { return tipo; }
}
