package Modelos;

public class Mono extends Animal {
    public Mono(String nombre){
        super(nombre, TipoAnimal.Mono);
    }

    @Override
    public int getNumImg() {
        return 2;
    }
}
