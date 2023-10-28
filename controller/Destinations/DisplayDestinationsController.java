package controller.Destinations;

import model.Destination;
import model.Destinations;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.scene.control.*;

public class DisplayDestinationsController extends Controller<Destinations> {
    
    @FXML private Button closeBtn;
    @FXML private TableView<Destination> destinationsTv;
    @FXML private TableColumn<Destination, String> nameClm;
    @FXML private TableColumn<Destination, String> countryClm;
    @FXML private TextField searchCountryTf;

    @FXML private void initialize(){
        if(model!=null){
            destinationsTv.setItems(model.getDestinations());

            nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
            countryClm.setCellValueFactory(cellData -> cellData.getValue().countryProperty());

            searchCountryTf.textProperty().addListener((o, oldtxt, newtxt)-> updateTv());
        }
    }



    @FXML public void handleClose(){
        stage.close();
    }
    public void updateTv(){
        destinationsTv.setItems(model.getFilteredDestinations(searchCountryTf.getText()));
    }


}
