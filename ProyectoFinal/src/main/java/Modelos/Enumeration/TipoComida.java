package Modelos.Enumeration;

/** Una lista (Enum) de los diferentes tipos de comidas para animales
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum TipoComida {
    Vegetacion(50,"Vegetación",0),
    Arbustos(50,"Arbustos",1),
    Frutos(100,"Frutos",2),
    CarneRoja(200,"Carne roja",3),
    Pescado(150,"Pescado",4),
    Roedor(100,"Roedor",5),
    Insectos(50,"Insectos",6);

    /** Número entero que contiene el precio de una de las comidas */
    private int precio;

    /** String con el nombre de una comida */
    private String nombre;

    /** Número entero que contiene la posición en lista de una comida */
    private int value;

    /** Constructor donde se guarda el precio, el nombre y el número de lista de un tipo de comida
     * @param precio El número entero con el precio de una de las comidas
     * @param nombre String que contiene el nombre de la comida
     * @param value El número entero con la posición en lista de una comida */
    private TipoComida(int precio, String nombre, int value) {
        this.precio = precio;
        this.nombre = nombre;
        this.value = value;
    }

    /** Método que obtener el precio de una comida
     * @return Número entero con el precio de la comida */
    public int getPrecio() { return precio; }

    /** Método que obtener el nombre de una comida
     * @return El String con el nombre de la comida */
    public String getNombre(){ return nombre; }

    /** Método que obtener la posición en lista de una comida
     * @return Número entero con la posición en lista de la comida */
    public int getValue() { return value; }

}
