package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
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
        model = new Agency();
    }

    public void initialize(){
        if(model!=null){
            String flightsWelcome = model.getLoggedInUser().toString()+"Flights section";
            flightsWelcomeTxt.setText(flightsWelcome);
        }
    }

    @FXML private void viewFlights(ActionEvent event){
        try{

        }catch(Exception e){
            ErrorModel error1 = new ErrorModel(e, "Flight crashed");
            ViewLoader.showErrorWindow(error1);
        }
    }


    @FXML private void handleClose(){
        stage.close();
    }

    public Agency getAgency(){
        return model;
    }

}
