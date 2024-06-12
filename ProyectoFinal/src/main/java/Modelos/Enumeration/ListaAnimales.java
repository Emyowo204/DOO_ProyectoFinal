package Modelos.Enumeration;

import Modelos.Enumeration.TipoAnimal;

public enum ListaAnimales {
    Bosque(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Sabana(new TipoAnimal[]{TipoAnimal.Cebra,TipoAnimal.Elefante,TipoAnimal.Hienas,TipoAnimal.Hipopotamo,TipoAnimal.Jirafa,TipoAnimal.Leon}),
    Selva(new TipoAnimal[]{TipoAnimal.Cocodrilo,TipoAnimal.Loro,TipoAnimal.Mono,TipoAnimal.OsoHormiguero,TipoAnimal.Pantera,TipoAnimal.Serpiente}),
    Acuatico(new TipoAnimal[]{TipoAnimal.Coipo,TipoAnimal.Delfin,TipoAnimal.LoboMarino,TipoAnimal.Orca,TipoAnimal.Tiburon,TipoAnimal.Tortuga}),
    Desierto(new TipoAnimal[]{TipoAnimal.Avestruz,TipoAnimal.Camello,TipoAnimal.Canguro,TipoAnimal.Coyote,TipoAnimal.Lagarto,TipoAnimal.Suricata}),
    Artico(new TipoAnimal[]{TipoAnimal.Alce,TipoAnimal.BuhoNival,TipoAnimal.Morsa,TipoAnimal.OsoPolar,TipoAnimal.Pinguino,TipoAnimal.ZorroArtico});
    private TipoAnimal[] animales;
    private ListaAnimales(TipoAnimal[] animales) {
        this.animales = animales;
    }
    public TipoAnimal[] getAnimales() { return animales; }
}
