package Modelos.Enumeration;

public enum TipoComida {
    Arbustos(100,0),
    CarneRoja(100,1),
    Frutos(100,2),
    Insectos(100,3),
    Pescado(100,4),
    Roedor(100,5),
    Vegetacion(100,6);

    private int precio;
    private int value;

    private TipoComida(int precio, int value) {
        this.precio = precio;
        this.value = value;
    }
    public int getPrecio() { return precio; }
    public int getValue() { return value; }
}
