package Modelos.Exceptions;

/** Esta excepción es resultante de tener una cantidad menor de dinero al precio de la compra */
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
}

