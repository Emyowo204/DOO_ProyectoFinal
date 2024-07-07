package Modelos.Enumeration;

/** Una lista (Enum) de los diferentes tipos de animales
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum TipoAnimal {
    Carpintero(100, TipoHabitat.Bosque, TipoComida.Insectos,"Carpintero",0),
    Huemul(200, TipoHabitat.Bosque, TipoComida.Arbustos,"Huemul",1),
    Oso(300, TipoHabitat.Bosque, TipoComida.Pescado,"Oso",2),
    Pudu(100, TipoHabitat.Bosque, TipoComida.Arbustos,"Pudú",3),
    Puma(300, TipoHabitat.Bosque, TipoComida.CarneRoja,"Puma",4),
    Zorro(200, TipoHabitat.Bosque, TipoComida.Roedor,"Zorro",5),

    Cebra(100, TipoHabitat.Sabana, TipoComida.Vegetacion,"Cebra",6),
    Elefante(300, TipoHabitat.Sabana, TipoComida.Arbustos,"Elefante",7),
    Hiena(100, TipoHabitat.Sabana, TipoComida.CarneRoja,"Hiena",8),
    Hipopotamo(200, TipoHabitat.Sabana, TipoComida.Vegetacion,"Hipopótamo",9),
    Jirafa(300, TipoHabitat.Sabana, TipoComida.Arbustos,"Jirafa",10),
    Leon(200, TipoHabitat.Sabana, TipoComida.CarneRoja,"León",11),

    Cocodrilo(300, TipoHabitat.Selva, TipoComida.Pescado,"Cocodrilo",12),
    Loro(100, TipoHabitat.Selva, TipoComida.Frutos,"Loro",13),
    Mono(200, TipoHabitat.Selva, TipoComida.Frutos,"Mono",14),
    OsoHormiguero(200, TipoHabitat.Selva, TipoComida.Insectos,"Oso hormiguero",15),
    Pantera(300, TipoHabitat.Selva, TipoComida.CarneRoja,"Pantera",16),
    Serpiente(100, TipoHabitat.Selva, TipoComida.Roedor,"Serpiente",17),

    Ajolote(100, TipoHabitat.Acuario, TipoComida.Insectos,"Ajolote",18),
    Delfin(200, TipoHabitat.Acuario, TipoComida.Pescado,"Delfín",19),
    LoboMarino(200, TipoHabitat.Acuario, TipoComida.Pescado,"Lobo marino",20),
    Orca(300, TipoHabitat.Acuario, TipoComida.CarneRoja,"Orca",21),
    Tiburon(300, TipoHabitat.Acuario, TipoComida.Pescado,"Tiburón",22),
    Tortuga(100, TipoHabitat.Acuario, TipoComida.Vegetacion,"Tortuga",23),

    Avestruz(200, TipoHabitat.Desierto, TipoComida.Frutos,"Avestruz",24),
    Camello(300, TipoHabitat.Desierto, TipoComida.Vegetacion,"Camello",25),
    Canguro(300, TipoHabitat.Desierto, TipoComida.Vegetacion,"Canguro",26),
    Coyote(200, TipoHabitat.Desierto, TipoComida.CarneRoja,"Coyote",27),
    Lagarto(100, TipoHabitat.Desierto, TipoComida.Insectos,"Lagarto",28),
    Suricata(100, TipoHabitat.Desierto, TipoComida.Insectos,"Suricata",29),

    Alce(200, TipoHabitat.Artico, TipoComida.Arbustos,"Alce",30),
    BuhoNival(100, TipoHabitat.Artico, TipoComida.Roedor,"Búho nival",31),
    Morsa(300, TipoHabitat.Artico, TipoComida.Pescado,"Morsa",32),
    OsoPolar(300, TipoHabitat.Artico, TipoComida.CarneRoja,"Oso polar",33),
    Pinguino(100, TipoHabitat.Artico, TipoComida.Pescado,"Pingüino",34),
    ZorroArtico(200, TipoHabitat.Artico, TipoComida.Roedor,"Zorro ártico",35);

    /** Número entero que contiene el precio de uno de los animales */
    private int precio;

    /** El tipo de habitat de un animal */
    private TipoHabitat habitat;

    /** El tipo de comida de un animal */
    private TipoComida comida;

    /** String con el nombre genérico de un animal */
    private String nombre;

    /** Número entero que contiene la posición en lista de un animal */
    private int value;

    /** Constructor donde se guarda el precio, el tipo de habitat, el tipo de comida, el nombre y el número de lista de un tipo de animal
     * @param precio El número entero con el precio de uno de los animales
     * @param habitat El tipo de habitat de uno de los animales
     * @param comida El tipo de comida de uno de los animales
     * @param nombre String que contiene el nombre genérico del animal
     * @param value El número entero con la posición en lista de un animal */
    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida, String nombre, int value) {
        this.precio = precio;
        this.habitat = habitat;
        this.comida = comida;
        this.nombre = nombre;
        this.value = value;
    }

    /** Método que obtener el precio de un animal
     * @return Número entero con el precio del animal */
    public int getPrecio() { return precio; }

    /** Método que obtener el tipo de habitat de un animal
     * @return Un TipoHabitat con el tipo de habitat del animal */
    public TipoHabitat getHabitat() { return habitat; }

    /** Método que obtener el tipo de comida de un animal
     * @return Un TipoComida con el tipo de comida del animal */
    public TipoComida getComida() { return comida; }

    /** Método que obtener el nombre genérico de un animal
     * @return El String con el nombre genérico del animal */
    public String getNombre() { return nombre; }

    /** Método que obtener la posición en lista de un animal
     * @return Número entero con la posición en lista del animal */
    public int getValue(){ return value; }
}