package Modelos;

public abstract class Animal {
    private String nombre;
    private TipoAnimal tipo;
    private TipoHabitat habitat;
    private TipoComida comida;

    public Animal(String nombre, TipoAnimal tipo){
        habitat = tipo.getHabitat();
        comida = tipo.getComida();
    }
}
