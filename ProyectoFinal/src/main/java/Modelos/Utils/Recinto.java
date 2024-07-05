package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Exceptions.NombreVacioException;

import java.util.ArrayList;

public class Recinto {
    private TipoAnimal tipo;
    private ArrayList<Animal> listaAnimales;
    private int hambre;
    private boolean adquirido;
    private Habitat habitat;
    private int cantidadComida;
    private int penalizacion;

    public Recinto(Habitat habitat) {
        hambre = 0;
        cantidadComida = 5;
        penalizacion = 0;
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

    public void alimentarAnimales() {
        cantidadComida++;
        penalizacion = 0;
    }

    public void addHambre() {
        if(getCantidadAnimal()>0)
            hambre++;
        if(hambre>(20-getCantidadAnimal())) {
            if(cantidadComida>0) {
                cantidadComida--;
                hambre = 0;
                penalizacion = 0;
            }
            else if(hambre<(30-getCantidadAnimal()))
                penalizacion = 5;
            else if(hambre<(40-getCantidadAnimal()))
                penalizacion = 10;
            else if(hambre<(50-getCantidadAnimal()))
                penalizacion = 15;
            else {
                penalizacion = 100;
            }
        } else
            penalizacion = 0;
    }

    public void rescateAnimal() {
        if(!listaAnimales.isEmpty()) {
            listaAnimales.clear();
            penalizacion = 0;
            hambre = 0;
        }
    }

    public void comprarAnimal(String nombre) throws Exception {
        if(nombre.isEmpty()) {
            throw new NombreVacioException("Nombre no ingresado");
        }
        listaAnimales.add(new AnimalFactory().crearAnimal(tipo, nombre));
    }

    public int getPenalizacion() {
        return penalizacion;
    }
    public ArrayList<Animal> getListaAnimales() { return listaAnimales; }
    public TipoAnimal getTipo() { return tipo; }
    public boolean isAdquirido() { return adquirido; }
    public Habitat getHabitat() { return habitat; }
    public int getCantidadAnimal(){
        return listaAnimales.size();
    }
    public int getCantidadComida(){
        return cantidadComida;
    }
}
