package Modelos.Enumeration;

import Modelos.Enumeration.TipoAnimal;

public enum ListaAnimales {
    Bosque(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Sabana(new TipoAnimal[]{TipoAnimal.Cebra,TipoAnimal.Elefante,TipoAnimal.Hienas,TipoAnimal.Hipopotamo,TipoAnimal.Jirafa,TipoAnimal.Leon}),
    Selva(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Acuatico(new TipoAnimal[]{TipoAnimal.Coipo,TipoAnimal.Delfin,TipoAnimal.Foca,TipoAnimal.LoboMarino,TipoAnimal.Tiburon,TipoAnimal.Tortuga}),
    Desierto(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Artico(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro});
    private TipoAnimal[] animales;
    private ListaAnimales(TipoAnimal[] animales) {
        this.animales = animales;
    }
    public TipoAnimal[] getAnimales() { return animales; }
}
