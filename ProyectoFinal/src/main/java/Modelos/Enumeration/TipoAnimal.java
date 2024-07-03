package Modelos.Enumeration;

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

    private int precio;
    private TipoHabitat tipoHabitat;
    private TipoComida comida;
    private String nombre;
    private int value;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida, String nombre, int value) {
        this.precio = precio;
        this.tipoHabitat = habitat;
        this.comida = comida;
        this.nombre = nombre;
        this.value = value;
    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return tipoHabitat; }
    public TipoComida getComida() { return comida; }
    public String getNombre() { return nombre; }
    public int getValue(){ return value; }
}