package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Agency;
import model.Destination;
import model.Exceptions.ErrorModel;

public class ModifyDestinationsController extends Controller<Agency> {
    
    public ModifyDestinationsController(){

    }
    private String getDestinationName(){return destinationNameTf.getText();}
    private String getDestinationCountry(){return destinationCountryTf.getText();}

    @FXML TextField destinationNameTf;
    @FXML TextField destinationCountryTf;
    @FXML Button modifyDestinationBtn;

    @FXML Button closeBtn;

    public void initialize(){
        if(model!=null){
            destinationNameTf.textProperty().addListener((o, oldName, newName)-> updateButton());
            destinationCountryTf.textProperty().addListener((o, oldCountry, newCountry)->updateButton());

        }
    }

    public void updateButton(){
        modifyDestinationBtn.setDisable(dataInAllTextFields());

    }

    public Boolean dataInAllTextFields(){
        return destinationNameTf.getText().isEmpty() ||
                destinationCountryTf.getText().isEmpty();
    }

    @FXML public void handleClose(){
        stage.close();
        
    }

    @FXML public void handleAddDestination(){
        try{
            Destination destination = new Destination(getDestinationName(),getDestinationCountry());
            model.getDestinations().addDestination(destination);
            stage.close();
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML public void handleRemoveDestination(){
        try{
            model.getDestinations().removeDestination(model.getDestinations().destination(getDestinationName(), getDestinationCountry()));
            stage.close();
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }





}
