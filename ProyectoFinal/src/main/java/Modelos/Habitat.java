package Modelos;

public class Habitat {

    private TipoHabitat tipo;
    private Recinto[] listaRecintos;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        listaRecintos = new Recinto[6];
    }

    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }
}
