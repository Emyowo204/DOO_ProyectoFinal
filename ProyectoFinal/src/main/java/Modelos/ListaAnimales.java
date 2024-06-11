package Modelos;

public enum ListaAnimales {
    Bosque(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Sabana(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Selva(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Acuatico(new TipoAnimal[]{TipoAnimal.Coipo,TipoAnimal.Delfin,TipoAnimal.Foca,TipoAnimal.LoboMarino,TipoAnimal.Tiburon,TipoAnimal.Tortuga}),
    Desierto(new TipoAnimal[]{TipoAnimal.Coipo,TipoAnimal.Delfin,TipoAnimal.Foca,TipoAnimal.LoboMarino,TipoAnimal.Tiburon,TipoAnimal.Tortuga}),
    Artico(new TipoAnimal[]{TipoAnimal.Coipo,TipoAnimal.Delfin,TipoAnimal.Foca,TipoAnimal.LoboMarino,TipoAnimal.Tiburon,TipoAnimal.Tortuga});
    private TipoAnimal[] animales;
    private ListaAnimales(TipoAnimal[] animales) {
        this.animales = animales;
    }
    public TipoAnimal[] getAnimales() { return animales; }
}
