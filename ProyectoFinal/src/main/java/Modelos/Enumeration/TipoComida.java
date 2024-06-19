package Modelos.Enumeration;

public enum TipoComida {
    Vegetacion(100,"Vegetación",0),
    Arbustos(100,"Arbustos",1),
    Frutos(100,"Frutos",2),
    CarneRoja(100,"Carne roja",3),
    Pescado(100,"Pescado",4),
    Roedor(100,"Roedor",5),
    Insectos(100,"Insectos",6);

    private int precio;
    private String nombre;
    private int value;

    private TipoComida(int precio, String nombre, int value) {
        this.precio = precio;
        this.nombre = nombre;
        this.value = value;
    }
    public int getPrecio() { return precio; }
    public String getNombre(){ return nombre; }
    public int getValue() { return value; }

}
