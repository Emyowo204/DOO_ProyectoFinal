package Modelos;

public class AnimalFactory {
    public Animal crearAnimal(TipoAnimal tipo) {
        if(tipo == TipoAnimal.Mono) {
            return new Mono();
        }
        else if(tipo == TipoAnimal.Leon) {
            return new Leon();
        }
        return new Delfin();
    }
}
