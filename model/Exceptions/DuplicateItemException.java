package model.Exceptions;

public class DuplicateItemException extends Exception {
    public DuplicateItemException(){
        super("Duplicates aren't alright.");
    }
    
}
