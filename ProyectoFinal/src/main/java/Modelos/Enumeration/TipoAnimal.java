package Modelos.Enumeration;

public enum TipoAnimal {
    Carpintero(1000, TipoHabitat.Bosque, TipoComida.Insectos,"Carpintero"),
    Huemul(1000, TipoHabitat.Bosque, TipoComida.Arbustos,"Huemul"),
    Oso(1000, TipoHabitat.Bosque, TipoComida.Pescado,"Oso"),
    Pudu(1000, TipoHabitat.Bosque, TipoComida.Arbustos,"Pudú"),
    Puma(1000, TipoHabitat.Bosque, TipoComida.CarneRoja,"Puma"),
    Zorro(1000, TipoHabitat.Bosque, TipoComida.Roedor,"Zorro"),

    Cebra(1000, TipoHabitat.Sabana, TipoComida.Vegetacion,"Cebra"),
    Elefante(1000, TipoHabitat.Sabana, TipoComida.Arbustos,"Elefante"),
    Hiena(1000, TipoHabitat.Sabana, TipoComida.CarneRoja,"Hiena"),
    Hipopotamo(1000, TipoHabitat.Sabana, TipoComida.Vegetacion,"Hipopótamo"),
    Jirafa(1000, TipoHabitat.Sabana, TipoComida.Arbustos,"Jirafa"),
    Leon(1000, TipoHabitat.Sabana, TipoComida.CarneRoja,"León"),

    Cocodrilo(1000, TipoHabitat.Selva, TipoComida.Pescado,"Cocodrilo"),
    Loro(1000, TipoHabitat.Selva, TipoComida.Frutos,"Loro"),
    Mono(1000, TipoHabitat.Selva, TipoComida.Frutos,"Mono"),
    OsoHormiguero(1000, TipoHabitat.Selva, TipoComida.Insectos,"Oso hormiguero"),
    Pantera(1000, TipoHabitat.Selva, TipoComida.CarneRoja,"Pantera"),
    Serpiente(1000, TipoHabitat.Selva, TipoComida.Roedor,"Serpiente"),

    Coipo(1000, TipoHabitat.Acuatico, TipoComida.Arbustos,"Coipo"),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado,"Delfín"),
    LoboMarino(1000, TipoHabitat.Acuatico, TipoComida.Pescado,"Lobo marino"),
    Orca(1000, TipoHabitat.Acuatico, TipoComida.CarneRoja,"Orca"),
    Tiburon(1000, TipoHabitat.Acuatico, TipoComida.Pescado,"Tiburón"),
    Tortuga(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion,"Tortuga"),

    Avestruz(1000, TipoHabitat.Desierto, TipoComida.Frutos,"Avestruz"),
    Camello(1000, TipoHabitat.Desierto, TipoComida.Vegetacion,"Camello"),
    Canguro(1000, TipoHabitat.Desierto, TipoComida.Vegetacion,"Canguro"),
    Coyote(1000, TipoHabitat.Desierto, TipoComida.CarneRoja,"Coyote"),
    Lagarto(1000, TipoHabitat.Desierto, TipoComida.Roedor,"Lagarto"),
    Suricata(1000, TipoHabitat.Desierto, TipoComida.Insectos,"Suricata"),

    Alce(1000, TipoHabitat.Artico, TipoComida.Vegetacion,"Alce"),
    BuhoNival(1000, TipoHabitat.Artico, TipoComida.Roedor,"Búho nival"),
    Morsa(1000, TipoHabitat.Artico, TipoComida.Pescado,"Morsa"),
    OsoPolar(1000, TipoHabitat.Artico, TipoComida.CarneRoja,"Oso polar"),
    Pinguino(1000, TipoHabitat.Artico, TipoComida.Pescado,"Pingüino"),
    ZorroArtico(1000, TipoHabitat.Artico, TipoComida.Roedor,"Zorro ártico");


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