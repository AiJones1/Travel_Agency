package controller.Trip;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Agency;
import model.Trip;


public class BookTripController extends Controller<Agency>{

    Trip trip = new Trip(model);
    @FXML private Label welcomeTxt;
    @FXML private Button addDestinationBtn;
    @FXML private Button removeDestinationBtn;
    @FXML private Button addConnectingFlightsBtn;
    @FXML private Button viewTripBtn;
    @FXML private Button closeBtn;

    public BookTripController(){

    }

    @FXML public void initialize(){
        if(model!=null){
            welcomeTxt.setText(model.getLoggedInUser().toString()+"Trip section");
        }
    }
    @FXML private void handleAddDestination(){

    }
    @FXML private void handleRemoveDestination(){

    }
    @FXML private void handleAddConnectingFlights(){

    }
    @FXML private void handleViewTrip(){

    }

    @FXML private void handleClose(){
        stage.close();
    }
    public Agency getAgency(){
        return model;
    }

}
