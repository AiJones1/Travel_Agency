package controller.Flights;


import model.Flight;
import model.Flights;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Agency;


public class DisplayFlightsController extends Controller<Flights> {
    


    @FXML private Button closeBtn;
    @FXML private TableView<Flight> flightsTv;
    @FXML private TableColumn<Flight, String> airlineClm;
    @FXML private TableColumn<Flight, String> flightNoClm;
    @FXML private TableColumn<Flight, String> takeoffClm;
    @FXML private TableColumn<Flight, String> landingClm;
    @FXML private TableColumn<Flight, String> costClm;
    @FXML private TextField searchCountryTf;

    public DisplayFlightsController(){
   
    }
    @FXML public void initialize(){
        if(model!=null){

        flightsTv.setItems(model.getFlights());
        
        airlineClm.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());
        flightNoClm.setCellValueFactory(cellData -> cellData.getValue().flightNumberProperty().asString());
        takeoffClm.setCellValueFactory(cellData -> cellData.getValue().takeoffProperty());
        landingClm.setCellValueFactory(cellData -> cellData.getValue().landingProperty());
        costClm.setCellValueFactory(cellData -> cellData.getValue().costProperty().asString());

        searchCountryTf.textProperty().addListener((o, oldtxt, newTxt)-> updateTv()); 
             
        }
    }
    public void updateTv(){
        flightsTv.setItems(model.getFilteredFlights(searchCountryTf.getText()));
    }

    @FXML private void handleClose(){
        stage.close();
    }

}
