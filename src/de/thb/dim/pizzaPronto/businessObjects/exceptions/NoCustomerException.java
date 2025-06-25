package de.thb.dim.pizzaPronto.businessObjects.exceptions;

public class NoCustomerException extends Exception {
    private static final long serialVersionUID = 4379684360813511592L;
    public NoCustomerException(String message) {
        super(message);
    }
    public NoCustomerException() {super("No Customer Here");}
}
