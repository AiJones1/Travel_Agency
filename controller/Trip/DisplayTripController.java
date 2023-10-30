package controller.Trip;


import java.util.InputMismatchException;
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
import model.Exceptions.ErrorModel;

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

    @FXML private void handleViewIndividual() throws Exception{
        ObservableList<Itinery> selectedItems = itineryLv.getSelectionModel().getSelectedItems();
        if(selectedItems.isEmpty()){
            // Based on specifications the button didn't need to be disabled with no selection
            // Simply exiting the function if nothing has been selected, otherwise this code
            // would open an empty destinations page
            return;
        }
        
        int destinationsCount =0;
        for(Itinery i: selectedItems){
            if(i.getClass()==model.getDestinations().getDestinations().get(0).getClass()){
                destinationsCount++;
            }
        }
        if(destinationsCount == selectedItems.size()){
            try{
            Destinations destinations = new Destinations(selectedItems);
            Stage viewDestinationStage = new Stage();
            viewDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(destinations, "/view/Destinations/DisplayDestinationsView.fxml", "View Destinations", viewDestinationStage);                    
            }catch(Exception e){
                ViewLoader.showErrorWindow(new ErrorModel(new InputMismatchException(), "Can't display flight and destination on the same page"));                   
            }

        }else{
            try{
                Flights flights = new Flights(selectedItems);
                Stage viewFlightsStage = new Stage();
                viewFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(flights, "/view/Flights/DisplayFlightsView.fxml", "View Flights", viewFlightsStage);
            }catch(Exception e){
                ViewLoader.showErrorWindow(new ErrorModel(new InputMismatchException(), "Can't display flight and destination on the same page"));                   
            }

        }         
        
    }

    @FXML private void handleClose(){
        stage.close();
    }

    public void updateItineryLv(){
        itineryLv.setItems(model.getItinery());
    }

}
