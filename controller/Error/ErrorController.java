package controller.Error;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Exceptions.ErrorModel;




public class ErrorController extends Controller<ErrorModel>{

    @FXML private Label errorMessageLabel;
    @FXML private Label exceptionLabel;
    @FXML private Button closeBtn;
    public ErrorController(){

    }

    public void initialize(){
        if(model!=null){
            errorMessageLabel.textProperty().bind((model.messageProperty()));
            exceptionLabel.textProperty().bind(model.exceptionProperty());
        }   
    }
    @FXML private void handleClose(){
        stage.close();
    }

    
    public ErrorModel getErrorModel(){
        return model;
    }
}