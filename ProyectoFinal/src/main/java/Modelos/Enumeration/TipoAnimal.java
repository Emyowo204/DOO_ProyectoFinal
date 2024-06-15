package Modelos.Enumeration;

public enum TipoAnimal {
    Carpintero(100, TipoHabitat.Bosque, TipoComida.Insectos,"Carpintero"),
    Huemul(100, TipoHabitat.Bosque, TipoComida.Arbustos,"Huemul"),
    Oso(100, TipoHabitat.Bosque, TipoComida.Pescado,"Oso"),
    Pudu(100, TipoHabitat.Bosque, TipoComida.Arbustos,"Pudú"),
    Puma(100, TipoHabitat.Bosque, TipoComida.CarneRoja,"Puma"),
    Zorro(100, TipoHabitat.Bosque, TipoComida.Roedor,"Zorro"),

    Cebra(100, TipoHabitat.Sabana, TipoComida.Vegetacion,"Cebra"),
    Elefante(100, TipoHabitat.Sabana, TipoComida.Arbustos,"Elefante"),
    Hiena(100, TipoHabitat.Sabana, TipoComida.CarneRoja,"Hiena"),
    Hipopotamo(100, TipoHabitat.Sabana, TipoComida.Vegetacion,"Hipopótamo"),
    Jirafa(100, TipoHabitat.Sabana, TipoComida.Arbustos,"Jirafa"),
    Leon(100, TipoHabitat.Sabana, TipoComida.CarneRoja,"León"),

    Cocodrilo(100, TipoHabitat.Selva, TipoComida.Pescado,"Cocodrilo"),
    Loro(100, TipoHabitat.Selva, TipoComida.Frutos,"Loro"),
    Mono(100, TipoHabitat.Selva, TipoComida.Frutos,"Mono"),
    OsoHormiguero(100, TipoHabitat.Selva, TipoComida.Insectos,"Oso hormiguero"),
    Pantera(100, TipoHabitat.Selva, TipoComida.CarneRoja,"Pantera"),
    Serpiente(100, TipoHabitat.Selva, TipoComida.Roedor,"Serpiente"),

    Coipo(100, TipoHabitat.Oceano, TipoComida.Arbustos,"Coipo"),
    Delfin(100, TipoHabitat.Oceano, TipoComida.Pescado,"Delfín"),
    LoboMarino(100, TipoHabitat.Oceano, TipoComida.Pescado,"Lobo marino"),
    Orca(100, TipoHabitat.Oceano, TipoComida.CarneRoja,"Orca"),
    Tiburon(100, TipoHabitat.Oceano, TipoComida.Pescado,"Tiburón"),
    Tortuga(100, TipoHabitat.Oceano, TipoComida.Vegetacion,"Tortuga"),

    Avestruz(100, TipoHabitat.Desierto, TipoComida.Frutos,"Avestruz"),
    Camello(100, TipoHabitat.Desierto, TipoComida.Vegetacion,"Camello"),
    Canguro(100, TipoHabitat.Desierto, TipoComida.Vegetacion,"Canguro"),
    Coyote(100, TipoHabitat.Desierto, TipoComida.CarneRoja,"Coyote"),
    Lagarto(100, TipoHabitat.Desierto, TipoComida.Roedor,"Lagarto"),
    Suricata(100, TipoHabitat.Desierto, TipoComida.Insectos,"Suricata"),

    Alce(100, TipoHabitat.Artico, TipoComida.Vegetacion,"Alce"),
    BuhoNival(100, TipoHabitat.Artico, TipoComida.Roedor,"Búho nival"),
    Morsa(100, TipoHabitat.Artico, TipoComida.Pescado,"Morsa"),
    OsoPolar(100, TipoHabitat.Artico, TipoComida.CarneRoja,"Oso polar"),
    Pinguino(100, TipoHabitat.Artico, TipoComida.Pescado,"Pingüino"),
    ZorroArtico(100, TipoHabitat.Artico, TipoComida.Roedor,"Zorro ártico");


    private int precio;
    private TipoHabitat tipoHabitat;
    private TipoComida comida;
    private String nombre;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida, String nombre) {
        this.precio = precio;
        this.tipoHabitat = habitat;
        this.comida = comida;
        this.nombre = nombre;
    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return tipoHabitat; }
    public TipoComida getComida() { return comida; }
    public String getNombre() { return nombre; }
}