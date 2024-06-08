package Modelos;

import java.util.ArrayList;

public class Recinto {
    private TipoAnimal tipo;
    private ArrayList<Animal> listaAnimales;
    private boolean adquirido;

    public Recinto() {
        tipo = null;
        listaAnimales = new ArrayList<>();
        adquirido =  false;
    }

    public void desbloquear(TipoAnimal animal) {
        if(tipo == null)
            tipo = animal;
        adquirido = true;
    }

    public void comprarAnimal(String nombre) {
        if (tipo == null) {
            // error
        }
        else {
            listaAnimales.add(new AnimalFactory().crearAnimal(tipo, nombre));
        }
    }
}
