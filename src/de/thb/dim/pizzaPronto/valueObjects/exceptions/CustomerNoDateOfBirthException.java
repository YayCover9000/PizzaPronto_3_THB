package de.thb.dim.pizzaPronto.valueObjects.exceptions;

public class CustomerNoDateOfBirthException extends Exception {
    private static final long serialVersionUID = -3319565690504052208L;
    public CustomerNoDateOfBirthException() {
        super("Internal error: No date of birth.");
    }
    public CustomerNoDateOfBirthException(String message) {
        super(message);
    }
}
