package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Exceptions.ErrorModel;

public class ExploreFlightsController extends Controller<Agency>{
    @FXML private Label flightsWelcomeTxt;
    @FXML private Button viewFlightsBtn;
    @FXML private Button viewFitleredFlightsBtn;
    @FXML private Button addFlightBtn;
    @FXML private Button removeFlightsBtn;
    @FXML private Button closeBtn;

    public ExploreFlightsController(){

    }

    public void initialize(){
        if(model!=null){
            String flightsWelcome = model.getLoggedInUser().toString()+"Flights section";
            flightsWelcomeTxt.setText(flightsWelcome);
        }
    }

    @FXML private void viewFlights(ActionEvent event){

        try{
            Stage viewFlightsStage = new Stage();
            viewFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model, "/view/Flights/DisplayFlightsView.fxml","Display Flights", viewFlightsStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML private void viewFilteredFlights(ActionEvent event){
        try{
            Stage viewFilteredFlightsStage = new Stage();
            viewFilteredFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model, "/view/Flights/DisplayFilteredFlightsView.fxml","Display Flights Filtered", viewFilteredFlightsStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML private void addNewFlight(ActionEvent event){
        try{
            Stage addFlightStage = new Stage();
            addFlightStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model, "/view/Flights/AddFlightView.fxml","Add Flight", addFlightStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML private void removeFromFlights(ActionEvent event){
        try{
            Stage removeFlightStage = new Stage();
            removeFlightStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model, "/view/Flights/RemoveFlightView.fxml","Remove Flight", removeFlightStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }
    
    @FXML private void handleClose(){
        stage.close();
    }

    public Agency getAgency(){
        return model;
    }

}
