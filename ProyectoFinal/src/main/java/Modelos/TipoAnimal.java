package Modelos;

public enum TipoAnimal {
    Mono(1000, TipoHabitat.Selva, TipoComida.Fruta),
    Leon(1000, TipoHabitat.Sabana, TipoComida.CarneRoja),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado),
    Mono1(1000, TipoHabitat.Selva, TipoComida.Fruta),
    Leon1(1000, TipoHabitat.Sabana, TipoComida.CarneRoja),
    Delfin1(1000, TipoHabitat.Acuatico, TipoComida.Pescado);
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
