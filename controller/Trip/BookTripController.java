package controller.Trip;

import java.util.Observable;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Itinery;
import model.Trip;
import model.Exceptions.ErrorModel;


public class BookTripController extends Controller<Trip>{


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
            welcomeTxt.setText(model.getAgency().getLoggedInUser().toString()+"Trip section");

        }
    }
    @FXML private void handleAddDestination(){
        try{
            Stage addTripDestination = new Stage();
            addTripDestination.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Add Destination", addTripDestination);
        }catch(Exception e){
              ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));          
        }
    }
    @FXML private void handleRemoveDestination(){
        try{
            Stage removeTripDestination = new Stage();
            removeTripDestination.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Remove Destination", removeTripDestination);
        }catch(Exception e){
              ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));          
        }
    }
    @FXML private void handleAddConnectingFlights() throws Exception{
        try{
            model.addConnectingFlights();
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));          
        }
        
    }
    @FXML private void handleViewTrip(){
        try{
            Stage itineryStage = new Stage();
            itineryStage.getIcons().add(new Image("/image/trip_icon.png"));

            ViewLoader.showStage(model, "/view/Trip/DisplayTripView.fxml", "Display Trip", itineryStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML private void handleClose(){
        stage.close();
    }

}
