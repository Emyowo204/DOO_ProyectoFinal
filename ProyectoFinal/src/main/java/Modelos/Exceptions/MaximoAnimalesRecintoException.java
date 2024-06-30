package Modelos.Exceptions;

/** Esta excepción es resultante de llegar al máximo de animales por recinto */
public class MaximoAnimalesRecintoException extends Exception {
    public MaximoAnimalesRecintoException(String errorMessage) {
        super(errorMessage);
    }
}

