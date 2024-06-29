package Modelos.Exceptions;

/** Esta excepción es resultante de producto sin retirar del expendedor */
public class MaximoAnimalesRecintoException extends Exception {
    public MaximoAnimalesRecintoException(String errorMessage) {
        super(errorMessage);
    }
}

