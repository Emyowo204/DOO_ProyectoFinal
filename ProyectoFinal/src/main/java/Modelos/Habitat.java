package Modelos;

public class Habitat {

    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private boolean adquirido;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        adquirido = false;
        listaRecintos = new Recinto[6];
    }

    public void desbloquear() {
        adquirido = true;
    }

    public void desbloquearRecinto(int index, TipoAnimal animal) {
        listaRecintos[index].desbloquear(animal);
    }

    public void comprarAnimal(int index) {
        listaRecintos[index].comprarAnimal();
    }

    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }
}
