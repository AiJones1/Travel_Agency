package model.Exceptions;

public class InsufficientDestinationsException extends Exception {
    public InsufficientDestinationsException(){
        super("Not Enough Destinations.");
    }
}
