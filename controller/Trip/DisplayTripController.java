package controller.Trip;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Itinery;
import model.Trip;

public class DisplayTripController extends Controller<Trip> {


    @FXML private ListView<Itinery> itineryLv;
    @FXML private Button viewIndividualBtn;
    @FXML private Button closeBtn;


    @FXML public void initialize(){
        if(model!=null){

            itineryLv.setItems(model.getItinery());

        }
    }

    @FXML private void handleViewIndividual(){

    }

    @FXML private void handleClose(){
        stage.close();
    }
}
