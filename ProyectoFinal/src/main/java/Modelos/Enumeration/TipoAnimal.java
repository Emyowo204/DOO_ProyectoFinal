package Modelos.Enumeration;

public enum TipoAnimal {
    Carpintero(1000, TipoHabitat.Bosque, TipoComida.Insectos),
    Huemul(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Oso(1000, TipoHabitat.Bosque, TipoComida.Pescado),
    Pudu(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Puma(1000, TipoHabitat.Bosque, TipoComida.CarneRoja),
    Zorro(1000, TipoHabitat.Bosque, TipoComida.Frutos),

    Cebra(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Elefante(1000, TipoHabitat.Sabana, TipoComida.Frutos),
    Hienas(1000, TipoHabitat.Sabana, TipoComida.CarneRoja),
    Hipopotamo(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Jirafa(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Leon(1000, TipoHabitat.Sabana, TipoComida.CarneRoja),

    Capibara(1000, TipoHabitat.Selva, TipoComida.Vegetacion),
    Cocodrilo(1000, TipoHabitat.Selva, TipoComida.Pescado),
    Loro(1000, TipoHabitat.Selva, TipoComida.Frutos),
    Mono(1000, TipoHabitat.Selva, TipoComida.Frutos),
    OsoHormiguero(1000, TipoHabitat.Selva, TipoComida.Insectos),
    Serpiente(1000, TipoHabitat.Selva, TipoComida.Insectos),

    Coipo(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Foca(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    LoboMarino(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Tiburon(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Tortuga(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),

    Avestruz(1000, TipoHabitat.Desierto, TipoComida.Vegetacion),
    Camello(1000, TipoHabitat.Desierto, TipoComida.Vegetacion),
    Canguro(1000, TipoHabitat.Desierto, TipoComida.Vegetacion),
    Coyote(1000, TipoHabitat.Desierto, TipoComida.CarneRoja),
    Lagarto(1000, TipoHabitat.Desierto, TipoComida.Insectos),
    Suricata(1000, TipoHabitat.Desierto, TipoComida.Insectos),

    Alce(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),
    BuhoNival(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Morsa(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    OsoPolar(1000, TipoHabitat.Acuatico, TipoComida.CarneRoja),
    Pinguino(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    ZorroArtico(1000, TipoHabitat.Acuatico, TipoComida.CarneRoja);


    private int precio;
    private TipoHabitat tipoHabitat;
    private TipoComida comida;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida) {
        this.precio = precio;
        this.tipoHabitat = habitat;
        this.comida = comida;
    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return tipoHabitat; }
    public TipoComida getComida() { return comida; }
}