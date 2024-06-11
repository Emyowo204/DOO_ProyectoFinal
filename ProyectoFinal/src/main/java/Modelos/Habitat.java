package Modelos;

public class Habitat {

    private TipoHabitat tipo;
    private Recinto[] listaRecintos;
    private boolean adquirido;

    public Habitat(TipoHabitat tipo) {
        this.tipo = tipo;
        adquirido = false;
        listaRecintos = new Recinto[6];
        for(int i=0; i<6; i++)
            listaRecintos[i] = new Recinto();
    }

    public void desbloquear() {
        adquirido = true;
    }

    public void desbloquearRecinto(int index, TipoAnimal animal) {
        listaRecintos[index].desbloquear(animal);
    }

    public void comprarAnimal(int index, String nombre) {
        listaRecintos[index].comprarAnimal(nombre);
    }

    public Recinto getRecinto(int index) {
        return listaRecintos[index];
    }
}
