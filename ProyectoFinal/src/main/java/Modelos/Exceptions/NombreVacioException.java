package Modelos.Exceptions;

/** Esta excepción es resultante de ingresar un texto vacio como nombre de un animal */
public class NombreVacioException extends Exception {
    public NombreVacioException(String errorMessage) {
        super(errorMessage);
    }
}

