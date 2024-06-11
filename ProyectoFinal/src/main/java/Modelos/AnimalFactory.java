package Modelos;

public class AnimalFactory {
    public Animal crearAnimal(TipoAnimal tipo, String nombre) {
        if(tipo == TipoAnimal.Mono) {
            return new Mono(nombre);
        }
        else if(tipo == TipoAnimal.Leon) {
            return new Leon(nombre);
        }

        return new Delfin(nombre, TipoAnimal.Delfin);
    }
}
