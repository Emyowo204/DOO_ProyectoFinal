package Modelos;

public enum TipoAnimal {
    Oso(1000, TipoHabitat.Bosque, TipoComida.Pescado),
    Zorro(1000, TipoHabitat.Bosque, TipoComida.Fruta),
    Carpintero(1000, TipoHabitat.Bosque, TipoComida.Insectos),
    Puma(1000, TipoHabitat.Bosque, TipoComida.CarneRoja),
    Huemul(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Pudu(1000, TipoHabitat.Bosque, TipoComida.Vegetacion),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Tiburon(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    LoboMarino(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Foca(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Coipo(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion),
    Tortuga(1000, TipoHabitat.Acuatico, TipoComida.Vegetacion);
    private int precio;
    private TipoHabitat habitat;
    private TipoComida comida;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida) {
        this.precio = precio;
        this.habitat = habitat;
        this.comida = comida;
    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return habitat; }
    public TipoComida getComida() { return comida; }
}
