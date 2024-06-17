package Modelos.Enumeration;

public enum TipoHabitat {
    Bosque(2000, 1000,0),
    Sabana(2000, 1000,1),
    Selva(2000, 1000,2),
    Acuario(2000, 1000,3),
    Desierto(2000, 1000,4),
    Artico(2000, 1000,5);
    private int precio;
    private int precioRecinto;
    private int value;

    private TipoHabitat(int precio, int precioRecinto, int value) {
        this.precio = precio;
        this.precioRecinto = precioRecinto;
        this.value = value;
    }
    public int getPrecio() { return precio; }
    public int getPrecioRecinto() { return precioRecinto; }
    public int getValue() { return value; }
}
