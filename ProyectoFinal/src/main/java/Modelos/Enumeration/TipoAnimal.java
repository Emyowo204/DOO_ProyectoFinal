package Modelos.Enumeration;

public enum TipoAnimal {
    Carpintero(100, TipoHabitat.Bosque, TipoComida.Insectos,"Carpintero", "info"),
    Huemul(200, TipoHabitat.Bosque, TipoComida.Arbustos,"Huemul", "info"),
    Oso(250, TipoHabitat.Bosque, TipoComida.Pescado,"Oso", "info"),
    Pudu(350, TipoHabitat.Bosque, TipoComida.Arbustos,"Pudú", "info"),
    Puma(350, TipoHabitat.Bosque, TipoComida.CarneRoja,"Puma", "info"),
    Zorro(450, TipoHabitat.Bosque, TipoComida.Roedor,"Zorro", "info"),

    Cebra(100, TipoHabitat.Sabana, TipoComida.Vegetacion,"Cebra", "info"),
    Elefante(100, TipoHabitat.Sabana, TipoComida.Arbustos,"Elefante", "info"),
    Hiena(100, TipoHabitat.Sabana, TipoComida.CarneRoja,"Hiena", "info"),
    Hipopotamo(100, TipoHabitat.Sabana, TipoComida.Vegetacion,"Hipopótamo", "info"),
    Jirafa(100, TipoHabitat.Sabana, TipoComida.Arbustos,"Jirafa", "info"),
    Leon(100, TipoHabitat.Sabana, TipoComida.CarneRoja,"León", "info"),

    Cocodrilo(100, TipoHabitat.Selva, TipoComida.Pescado,"Cocodrilo", "info"),
    Loro(100, TipoHabitat.Selva, TipoComida.Frutos,"Loro", "info"),
    Mono(100, TipoHabitat.Selva, TipoComida.Frutos,"Mono", "info"),
    OsoHormiguero(100, TipoHabitat.Selva, TipoComida.Insectos,"Oso hormiguero", "info"),
    Pantera(100, TipoHabitat.Selva, TipoComida.CarneRoja,"Pantera", "info"),
    Serpiente(100, TipoHabitat.Selva, TipoComida.Roedor,"Serpiente", "info"),

    Ajolote(100, TipoHabitat.Acuario, TipoComida.Insectos,"Ajolote", "info"),
    Delfin(100, TipoHabitat.Acuario, TipoComida.Pescado,"Delfín", "info"),
    LoboMarino(100, TipoHabitat.Acuario, TipoComida.Pescado,"Lobo marino", "info"),
    Orca(100, TipoHabitat.Acuario, TipoComida.CarneRoja,"Orca", "info"),
    Tiburon(100, TipoHabitat.Acuario, TipoComida.Pescado,"Tiburón", "info"),
    Tortuga(100, TipoHabitat.Acuario, TipoComida.Vegetacion,"Tortuga", "info"),

    Avestruz(100, TipoHabitat.Desierto, TipoComida.Frutos,"Avestruz", "info"),
    Camello(100, TipoHabitat.Desierto, TipoComida.Vegetacion,"Camello", "info"),
    Canguro(100, TipoHabitat.Desierto, TipoComida.Vegetacion,"Canguro", "info"),
    Coyote(100, TipoHabitat.Desierto, TipoComida.CarneRoja,"Coyote", "info"),
    Lagarto(100, TipoHabitat.Desierto, TipoComida.Roedor,"Lagarto", "info"),
    Suricata(100, TipoHabitat.Desierto, TipoComida.Insectos,"Suricata", "info"),

    Alce(100, TipoHabitat.Artico, TipoComida.Vegetacion,"Alce", "info"),
    BuhoNival(100, TipoHabitat.Artico, TipoComida.Roedor,"Búho nival", "info"),
    Morsa(100, TipoHabitat.Artico, TipoComida.Pescado,"Morsa", "info"),
    OsoPolar(100, TipoHabitat.Artico, TipoComida.CarneRoja,"Oso polar", "info"),
    Pinguino(100, TipoHabitat.Artico, TipoComida.Pescado,"Pingüino", "info"),
    ZorroArtico(100, TipoHabitat.Artico, TipoComida.Roedor,"Zorro ártico", "info");

    private int precio;
    private TipoHabitat tipoHabitat;
    private TipoComida comida;
    private String nombre;

    private String info;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida, String nombre, String info) {
        this.precio = precio;
        this.tipoHabitat = habitat;
        this.comida = comida;
        this.nombre = nombre;
        this.info = info;
    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return tipoHabitat; }
    public TipoComida getComida() { return comida; }
    public String getNombre() { return nombre; }
    public String getInfo(){ return info; }
}