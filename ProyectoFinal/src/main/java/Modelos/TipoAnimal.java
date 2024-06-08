package Modelos;

public enum TipoAnimal {
    Mono(1000, TipoHabitat.Jungla),
    Leon(1000, TipoHabitat.Sabana),
    Delfin(1000, TipoHabitat.Acuatico);

    private TipoAnimal(int precio, TipoHabitat tipo) {

    }
}
