package Modelos.Enumeration;

public enum TipoAnimal {
    Carpintero(1000, TipoHabitat.Bosque, TipoComida.Insectos),
    Huemul(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Oso(1000, TipoHabitat.Bosque, TipoComida.Pescado),
    Pudu(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Puma(1000, TipoHabitat.Bosque, TipoComida.CarneRoja),
    Zorro(1000, TipoHabitat.Bosque, TipoComida.Fruta),

    Coipo(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Foca(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    LoboMarino(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Tiburon(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Tortuga(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),

    Cebra(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Elefante(1000, TipoHabitat.Sabana, TipoComida.Fruta),
    Hienas(1000, TipoHabitat.Sabana, TipoComida.CarneRoja),
    Hipopotamo(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Jirafa(1000, TipoHabitat.Sabana, TipoComida.Vegetacion),
    Leon(1000, TipoHabitat.Sabana, TipoComida.CarneRoja);

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