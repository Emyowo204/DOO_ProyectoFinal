package Modelos;

public class Zoologico {
    private Habitat[] listaHabitat;

    public Zoologico() {
        listaHabitat = new Habitat[4];
        for(int i=0; i<4; i++) {
            listaHabitat[i] = new Habitat(TipoHabitat.values()[i]);
        }
    }

   public void comprarHabitat(int index) {
       listaHabitat[index].desbloquear();
   }

    public void comprarRecinto(int index, int recinto, TipoAnimal animal) {
        listaHabitat[index].desbloquearRecinto(recinto, animal);
    }

    public void comprarAnimal(int index, int recinto) {
        listaHabitat[index].comprarAnimal(recinto);
    }
}
