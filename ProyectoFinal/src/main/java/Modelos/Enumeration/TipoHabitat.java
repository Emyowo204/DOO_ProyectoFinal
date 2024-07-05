package Modelos.Enumeration;

/** Una lista (Enum) de los diferentes tipos de habitats
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum TipoHabitat {
    Bosque(1000, 1000,1500,0),
    Sabana(2000, 1000,2000,1),
    Selva(2000, 1000,1500,2),
    Acuario(3000, 1500,2500,3),
    Desierto(3000, 1500,2000,4),
    Artico(4000, 2000,3000,5);

    /** Número entero que contiene el precio de uno de los habitats */
    private int precio;

    /** Número entero que contiene el precio del recinto de uno de los habitats */
    private int precioRecinto;

    /** Número entero que contiene el precio de la mejora de temperatura de uno de los habitats */
    private int precioTemperatura;

    /** Número entero que contiene la posición en lista de un habitat */
    private int value;

    /** Constructor donde se guarda el precio, el precio del recinto, el recio de la temperatura y el número de lista de un tipo de habitat
     * @param precio El número entero con el precio de uno de los habitats
     * @param precioRecinto El número entero con el precio del recinto de uno de los habitats
     * @param precioTemp El número entero con el precio de la mejora de temperatura de uno de los habitats
     * @param value El número entero con la posición en lista de un habitat */
    private TipoHabitat(int precio, int precioRecinto, int precioTemp, int value) {
        this.precio = precio;
        this.precioRecinto = precioRecinto;
        this.precioTemperatura = precioTemp;
        this.value = value;
    }

    /** Método que obtener el precio de un habitat
     * @return Número entero con el precio del habitat */
    public int getPrecio() { return precio; }

    /** Método que obtener el precio del recinto de un habitat
     * @return Número entero con el precio del recinto de un habitat */
    public int getPrecioRecinto() { return precioRecinto; }

    /** Método que obtener el precio de la mejora de temperatura de un habitat
     * @return Número entero con el precio de la mejora de temperatura de un habitat */
    public int getprecioTemperatura() { return precioTemperatura; }

    /** Método que obtener la posición en lista de un habitat
     * @return Número entero con la posición en lista del habitat */
    public int getValue() { return value; }
}
