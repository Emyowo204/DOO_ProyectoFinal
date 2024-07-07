package Modelos.Utils;

import Modelos.Enumeration.*;
import java.util.ArrayList;

/** Una hábitat de animales de un zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Habitat {

    /** El tipo del hábitat que correspondiente */
    private TipoHabitat tipo;
    /** Arreglo con los recintos dentro del hábitat */
    private Recinto[] listaRecintos;
    /** Arreglo con los animales desbloqueados */
    private ArrayList<TipoAnimal> UnlockAni;

    /** Arreglo con todos los animales pertenecientes al habitat */
    private ArrayList<TipoAnimal> TotalAni;
    /** Indicador de sí el hábitat fué adquirido */
    private boolean adquirido;
    /** Indicador de sí hay una operación de compra dentro del hábitat */
    private boolean comprando;
    /** Indicador de sí la mejora de temperatura está activa */
    private boolean temperatura;
    /** Cantidad de penalizacion en el hábitat */
    private int penalizacionHabitat;

    /** Constructor de hábitat que recibe el tipo y los animales correspondientes a este
     * @param tipo El tipo de hábitat
     * @param lista Lista de los animales correspondientes al hábitat
     */
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

    /** Método para obtener la cantidad de penalización en el hábitat
     * @return int con el valor de penalización en el habítat */
    public int getPenalizacionHabitat(){
        penalizacionHabitat = 0;
        for (int i = 0; i < 6; i++) {
            penalizacionHabitat+=listaRecintos[i].getPenalizacion();
        }
        return penalizacionHabitat;
    }

    /** Método que establece que el hábitat fué desbloqueado */
    public void desbloquear() {
        adquirido = true;
    }

    /** Método que establece que la mejora de temperatura fué desbloqueado */
    public void desblTemperatura() {
        temperatura = true;
    }

    /** Método para agregar a un animal a los animales desbloqueados
     * @param animal tipo de animal a desbloquear
     */
    public void addAnimal(TipoAnimal animal) { UnlockAni.add(animal); }

    /** Método para obtener un recinto del hábitat
     * @param index Indica el número correspondiente al recinto a obtener
     * @return Recinto en la posición de index del hábitat */
    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }

    /** Método para obtener los animales desbloqueados
     * @return Arreglo con los animales desbloqueados
     */
    public ArrayList<TipoAnimal> getUnlocked() {
        return UnlockAni;
    }

    /** Método que entrega los animales pertenecientes al hábitat
     * @return Arreglo con los animales pertenecientes al hábitat
     */
    public ArrayList<TipoAnimal> getTotal() {
        return TotalAni;
    }

    /** Método que devuelve el estado de compra del hábitat
     * @return Estado de compra del hábitat */
    public boolean isComprando() { return comprando; }

    /** Método que devuelve el estado de adquisición del hábitat
     * @return Estado de adquisición del hábitat */
    public boolean isAdquirido() { return adquirido; }

    /** Método que devuelve el estado de la mejora de temperatura del hábitat
     * @return Estado de la mejora de temperatura */
    public boolean getTemperatura() { return temperatura; }

    /** Método para establecer que el estado de compra del hábitat */
    public void setComprando(boolean comprando) { this.comprando = comprando; }
    public TipoHabitat getTipo() {
        return tipo;
    }
}
