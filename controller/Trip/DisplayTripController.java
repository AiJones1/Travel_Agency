package controller.Trip;


import java.io.IOException;
import java.util.Observable;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Destinations;
import model.Flights;
import model.Itinery;
import model.Trip;

public class DisplayTripController extends Controller<Trip> {


    @FXML private ListView<Itinery> itineryLv;
    @FXML private Button viewIndividualBtn;
    @FXML private Button closeBtn;


    @FXML public void initialize() throws Exception{
        if(model!=null){

            itineryLv.setItems(model.getItinery());
            itineryLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            model.getFlights().getFlights().addListener(new ListChangeListener<Itinery>() {
                @Override
                public void onChanged(Change<? extends Itinery> c) {
                    updateItineryLv();
                }
            });
            model.getDestinations().getDestinations().addListener(new ListChangeListener<Itinery>() {
                @Override
                public void onChanged(Change<? extends Itinery> d) {
                    updateItineryLv();
                }
            });
  
        }
    }

    @FXML private void handleViewIndividual() throws IOException{
        ObservableList<Itinery> selectedItems = itineryLv.getSelectionModel().getSelectedItems();
        model.getFlights().getClass();
        Destinations destinations = new Destinations(selectedItems);
        // Flights flights = new Flights(selectedItems);
        for(Itinery i: selectedItems){
            System.out.println(i.getClass());
        }

        Stage viewDestinationStage = new Stage();
        viewDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(destinations, "/view/Destinations/DisplayDestinationsView.fxml", "De", viewDestinationStage);

    }

    @FXML private void handleClose(){
        stage.close();
    }

    public void updateItineryLv(){
        itineryLv.setItems(model.getItinery());
    }

}
