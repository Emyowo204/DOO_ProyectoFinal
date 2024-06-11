package Modelos;

public class Leon extends Animal {
    public Leon(String nombre){
        super(nombre, TipoAnimal.Leon);
    }

    @Override
    public int getNumImg() {
        return 1;
    }

    @Override
    public void moveInPath() {

    }
}
