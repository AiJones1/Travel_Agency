package controller;

import au.edu.uts.ap.javafx.Controller;
// import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Agency;

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

    }
    @FXML private void exploreDestinations(ActionEvent event){

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
