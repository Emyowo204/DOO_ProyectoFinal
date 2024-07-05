package Modelos.Enumeration;

/** Una lista (Enum) de los animales pertenecientes a cada habitat
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum ListaAnimales {
    Bosque(new TipoAnimal[]{TipoAnimal.Carpintero,TipoAnimal.Huemul,TipoAnimal.Oso,TipoAnimal.Pudu,TipoAnimal.Puma,TipoAnimal.Zorro}),
    Sabana(new TipoAnimal[]{TipoAnimal.Cebra,TipoAnimal.Elefante,TipoAnimal.Hiena,TipoAnimal.Hipopotamo,TipoAnimal.Jirafa,TipoAnimal.Leon}),
    Selva(new TipoAnimal[]{TipoAnimal.Cocodrilo,TipoAnimal.Loro,TipoAnimal.Mono,TipoAnimal.OsoHormiguero,TipoAnimal.Pantera,TipoAnimal.Serpiente}),
    Acuario(new TipoAnimal[]{TipoAnimal.Ajolote,TipoAnimal.Delfin,TipoAnimal.LoboMarino,TipoAnimal.Orca,TipoAnimal.Tiburon,TipoAnimal.Tortuga}),
    Desierto(new TipoAnimal[]{TipoAnimal.Avestruz,TipoAnimal.Camello,TipoAnimal.Canguro,TipoAnimal.Coyote,TipoAnimal.Lagarto,TipoAnimal.Suricata}),
    Artico(new TipoAnimal[]{TipoAnimal.Alce,TipoAnimal.BuhoNival,TipoAnimal.Morsa,TipoAnimal.OsoPolar,TipoAnimal.Pinguino,TipoAnimal.ZorroArtico});

    /** Arreglo de todos los tipos de animales pertenecientes a un habitat */
    private TipoAnimal[] animales;

    /** Constructor donde se guarda el arreglo con los tipos de animales de un habitat
     * @param animales El arreglo con los tipos de animales correspondientes a un habitat */
    private ListaAnimales(TipoAnimal[] animales) {
        this.animales = animales;
    }

    /** Método que obtener el arreglo de tipos de animales de un habitat
     * @return Un arreglo de tipos de animales correspondientes a un habitat */
    public TipoAnimal[] getAnimales() { return animales; }
}
