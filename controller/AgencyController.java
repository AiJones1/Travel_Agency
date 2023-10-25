package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
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
        model = new Agency();
    }

    public void initialize(){
        if(model!=null){
            String welcome = model.getLoggedInUser().toString() +"Prog2 Travel Agency";
            welcomeTxt.setText(welcome);           
        }
    }

    @FXML private void exploreFlights(ActionEvent event){
        try{
            ViewLoader.showStage(model, "/view/Flights/ExploreFlightsView.fxml", "Prog2 Travel Agency", new Stage());
        }catch(Exception e){
            ErrorModel error1 = new ErrorModel(e, "Mission Failed");
            ViewLoader.showErrorWindow(error1);
        }
        
    }
    @FXML private void exploreDestinations(ActionEvent event){
        try{
            ViewLoader.showStage(model, "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", new Stage());
        }catch(Exception e){
            ErrorModel error2 = new ErrorModel(e, "Mission Failed");
            ViewLoader.showErrorWindow(error2);

        }
    }
    @FXML private void bookTrip(ActionEvent event){

    }

    @FXML private void handleClose(){
        stage.close();
    }

    public Agency getAgency(){
        return model;
    }
    
}
