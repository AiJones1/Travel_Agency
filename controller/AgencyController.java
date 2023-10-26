package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Exceptions.ErrorModel;

public class AgencyController extends Controller<Agency>{
    
    @FXML private Label welcomeTxt;
    @FXML private Button exploreFlightsBtn;
    @FXML private Button exploreDestinationsBtn;
    @FXML private Button bookTripBtn;
    @FXML private Button exitBtn;

    public AgencyController(){

    }

    public void initialize(){
        if(model!=null){
            String welcome = model.getLoggedInUser().toString() +"Prog2 Travel Agency";
            welcomeTxt.setText(welcome);
          
        }
    }

    @FXML private void exploreFlights(ActionEvent event){
        try{
            Stage flightsStage = new Stage();
            flightsStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model, "/view/Flights/ExploreFlightsView.fxml", "Prog2 Travel Agency", flightsStage);
        }catch(Exception e){
            ErrorModel error1 = new ErrorModel(e, "Mission Failed");
            ViewLoader.showErrorWindow(error1);
        }
        
    }
    @FXML private void exploreDestinations(ActionEvent event){
        try{
            Stage destinationsStage = new Stage();
            destinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));            
            ViewLoader.showStage(model, "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", destinationsStage);
        }catch(Exception e){
            ErrorModel error2 = new ErrorModel(e, "Mission Failed");
            ViewLoader.showErrorWindow(error2);

        }
    }
    @FXML private void bookTrip(ActionEvent event){
        try{
            Stage tripStage = new Stage();
            tripStage.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(model, "/view/Trip/BookTripView.fxml", "Book a Trip", tripStage);
        }catch(Exception e){
            ErrorModel error2 = new ErrorModel(e, "Mission Failed");
            ViewLoader.showErrorWindow(error2);

        }
    }

    @FXML private void handleClose(){
        stage.close();
    }

    public Agency getAgency(){
        return model;
    }
    
}
