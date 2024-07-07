package Modelos.Utils;

import Modelos.Enumeration.TipoAnimal;
import Modelos.Exceptions.NombreVacioException;

import java.util.ArrayList;

/** Un recinto de animales de un zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public class Recinto {

    /** El tipo del animal correspondiente al recinto que correspondiente */
    private TipoAnimal tipo;

    /** Arreglo con los animales dentro del recinto */
    private ArrayList<Animal> listaAnimales;

    /** Cantidad de hambre en el recinto */
    private int hambre;

    /** Indicador de si el recinto fué adquirido */
    private boolean adquirido;

    /** Hábitat al que corresponde el recinto */
    private Habitat habitat;

    /** Cantidad de comida en el recinto */
    private int cantidadComida;

    /** Cantidad de penalizacion en el recinto */
    private int penalizacion;


    /** Constructor de recinto que recibe hábitat al cual corresponde
     * @param habitat Hábitat al cual corresponde
     */
    public Recinto(Habitat habitat) {
        hambre = 0;
        cantidadComida = 5;
        penalizacion = 0;
        tipo = null;
        this.habitat = habitat;
        listaAnimales = new ArrayList<>();
        adquirido =  false;
    }


    /** Método que establece que el hábitat fué desbloqueado */
    public void desbloquear() { adquirido = true; }

    /** Método que establece el el tipo de animal que corresponde al recinto */
    public void asignarAnimal(TipoAnimal animal) {
        if(tipo == null)
            tipo = animal;
        habitat.addAnimal(tipo);
    }

    /** Método para alimentar los animales dentro del recinto */
    public void alimentarAnimales() {
        cantidadComida++;
        penalizacion = 0;
    }

    /** Método que causa que a los animales le de hambre */
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

    /** Método acciona el rescate animal en el recinto */
    public void rescateAnimal() {
        if(!listaAnimales.isEmpty()) {
            listaAnimales.clear();
            penalizacion = 0;
            hambre = 0;
        }
    }

    /** Método para añadir un animal del tipo correspondiente al recinto */
    public void comprarAnimal(String nombre) throws Exception {
        if(nombre.isEmpty()) {
            throw new NombreVacioException("Nombre no ingresado");
        }
        listaAnimales.add(new AnimalFactory().crearAnimal(tipo, nombre));
    }

    /** Método para obtener la cantidad de penalización del recinto
     * @return int con el valor de penalización del recinto */
    public int getPenalizacion() {
        return penalizacion;
    }

    /** Método para obtener la lista de animales en el recinto
     * @return Lista de animales en el recinto */
    public ArrayList<Animal> getListaAnimales() { return listaAnimales; }

    /** Método para obtener el tipo del recinto
     * @return Tipo del recinto */
    public TipoAnimal getTipo() { return tipo; }

    /** Método para devuelve el estado de adquisición del recinto
     * @return Estado de adquisición del recinto */
    public boolean isAdquirido() { return adquirido; }

    /** Método para obtener el hábitat del recinto
     * @return Hábitat del recinto */
    public Habitat getHabitat() { return habitat; }

    /** Método para obtener la cantidad de animales del recinto
     * @return Cantidad de animales del recinto */
    public int getCantidadAnimal(){
        return listaAnimales.size();
    }

    /** Método para obtener la cantidad de comida del recinto
     * @return Cantidad de comida del recinto */
    public int getCantidadComida(){
        return cantidadComida;
    }
}
