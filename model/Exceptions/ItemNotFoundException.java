package model.Exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(){
        super("No items matching input.");
    }
}
