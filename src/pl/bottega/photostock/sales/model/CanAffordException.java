package pl.bottega.photostock.sales.model;


public class CanAffordException extends RuntimeException {

    public CanAffordException(String message) {
        super(message);
    }
}
