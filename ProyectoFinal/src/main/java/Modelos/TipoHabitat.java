package Modelos;

public enum TipoHabitat {
    Bosque(2000, 1000,0, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono}),
    Sabana(2000, 1000,1, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono}),
    Selva(2000, 1000,2, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono}),
    Acuatico(2000, 100,3, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono}),
    Desierto(2000, 1000,4, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono}),
    Artico(2000, 1000,5, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono,TipoAnimal.Mono});
    private int precio;
    private int precioRecinto;
    private int value;

    private TipoHabitat(int precio, int precioRecinto, int value, TipoAnimal[] animales) {
        this.precio = precio;
        this.precioRecinto = precioRecinto;
        this.value = value;
    }
    public int getPrecio() { return precio; }
    public int getPrecioRecinto() { return precioRecinto; }
    public int getValue() { return value; }
}
