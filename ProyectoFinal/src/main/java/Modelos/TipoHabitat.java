package Modelos;

public enum TipoHabitat {
    Bosque(2000, 1000,0, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1}),
    Sabana(2000, 1000,1, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1}),
    Selva(2000, 1000,2, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1}),
    Acuatico(2000, 100,3, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1}),
    Desierto(2000, 1000,4, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1}),
    Artico(2000, 1000,5, new TipoAnimal[]{TipoAnimal.Mono,TipoAnimal.Leon,TipoAnimal.Delfin,TipoAnimal.Mono1,TipoAnimal.Leon1,TipoAnimal.Delfin1});
    private int precio;
    private int precioRecinto;
    private int value;
    private TipoAnimal[] animales;

    private TipoHabitat(int precio, int precioRecinto, int value, TipoAnimal[] animales) {
        this.precio = precio;
        this.precioRecinto = precioRecinto;
        this.value = value;
        this.animales = animales;
    }
    public int getPrecio() { return precio; }
    public int getPrecioRecinto() { return precioRecinto; }
    public int getValue() { return value; }
    public TipoAnimal[] getAnimales() { return animales; }
}
