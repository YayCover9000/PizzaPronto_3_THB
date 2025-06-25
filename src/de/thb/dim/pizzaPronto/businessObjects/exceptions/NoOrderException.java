package de.thb.dim.pizzaPronto.businessObjects.exceptions;

public class NoOrderException extends Exception {
    private static final long serialVersionUID = -6889739443415526906L;
    public NoOrderException(String message) {
        super(message);
    }
    public NoOrderException() {super("No order available.");}

}
