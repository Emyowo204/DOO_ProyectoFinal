package Modelos.Enumeration;

public enum TipoHabitat {
    Bosque(1000, 1000,1500,0),
    Sabana(2000, 1000,2000,1),
    Selva(2000, 1000,1500,2),
    Acuario(3000, 1500,2500,3),
    Desierto(3000, 1500,2000,4),
    Artico(4000, 2000,3000,5);
    private int precio;
    private int precioRecinto;
    private int precioTemperatura;
    private int value;

    private TipoHabitat(int precio, int precioRecinto, int precioTemp, int value) {
        this.precio = precio;
        this.precioRecinto = precioRecinto;
        this.precioTemperatura = precioTemp;
        this.value = value;
    }
    public int getPrecio() { return precio; }
    public int getPrecioRecinto() { return precioRecinto; }
    public int getprecioTemperatura() { return precioTemperatura; }
    public int getValue() { return value; }
}
