package model.Exceptions;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ErrorModel extends Exception {
    private final StringProperty exception = new SimpleStringProperty();
    private final StringProperty message = new SimpleStringProperty();

    public ErrorModel(Exception ex, String message) {
        setException(ex);
        setMessage(message);
    }

    public StringProperty exceptionProperty(){
        return exception;
    }

    public String getException(){
        return exception.get();
    }

    public void setException(Exception ex){
        exception.set(ex.getClass().getSimpleName());
    }

    public StringProperty messageProperty(){
        return message;
    }

    public String getMessage(){
        return message.get();
    }

    public void setMessage(String msg){
        message.set(msg);
    }

}
