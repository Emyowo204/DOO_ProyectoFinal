package Modelos;

public class AnimalFactory {
    public Animal crearAnimal(TipoAnimal tipo, String nombre) {
        if(tipo == TipoAnimal.Mono) {
            return new Mono(nombre);
        }
        else if(tipo == TipoAnimal.Leon) {
            return new Leon(nombre);
        }
        else if(tipo == TipoAnimal.Delfin) {
            return new Delfin(nombre);
        }
        else if(tipo == TipoAnimal.Mono1) {
            return new Mono(nombre);
        }
        else if(tipo == TipoAnimal.Leon1) {
            return new Leon(nombre);
        }
        return new Delfin(nombre);
    }
}
