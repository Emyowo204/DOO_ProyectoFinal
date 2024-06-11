package Modelos;

public enum TipoAnimal {
    Mono(1000, TipoHabitat.Selva, TipoComida.Fruta,0),
    Leon(1000, TipoHabitat.Sabana, TipoComida.CarneRoja,1),
    Delfin(1000, TipoHabitat.Acuatico, TipoComida.Pescado,2);

    private int precio;
    private TipoHabitat habitat;
    private TipoComida comida;
    private int value;

    private TipoAnimal(int precio, TipoHabitat habitat, TipoComida comida, int value) {
        this.precio = precio;
        this.habitat = habitat;
        this.comida = comida;
        this.value = value;

    }

    public int getPrecio() { return precio; }
    public TipoHabitat getHabitat() { return habitat; }
    public TipoComida getComida() { return comida; }
    public int getValue() { return value; }
}
