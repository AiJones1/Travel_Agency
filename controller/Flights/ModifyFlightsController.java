package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Agency;
import model.Flight;
import model.Exceptions.ErrorModel;

public class ModifyFlightsController extends Controller<Agency>{


    @FXML private Button modifyFlightBtn;
    @FXML private TextField airlineTf;
    @FXML private TextField flightNoTf;
    @FXML private TextField takeoffTf;
    @FXML private TextField landingTf;
    @FXML private TextField costTf;



    private String getAirline(){return airlineTf.getText();}
    private int getFlightNo(){return Integer.parseInt(flightNoTf.getText());}
    private String getTakeoff(){return takeoffTf.getText();}
    private String getLanding(){return landingTf.getText();}
    private double getCost(){return Double.parseDouble(costTf.getText());}

    public ModifyFlightsController(){
             
    }

    @FXML private void initialize() throws Exception{
        try{
            airlineTf.textProperty().addListener((o, oldTxt, newText)-> updateButton());
            flightNoTf.textProperty().addListener((o, oldTxt, newText)-> updateButton());
            takeoffTf.textProperty().addListener((o, oldTxt, newText)-> updateButton());
            landingTf.textProperty().addListener((o, oldTxt, newText)-> updateButton());
            costTf.textProperty().addListener((o, oldTxt, newText)-> updateButton()); 
    
        }catch(Exception e){
            takeoffTf.textProperty().addListener((o, oldTxt, newText)-> updateRemoveButton());
            landingTf.textProperty().addListener((o, oldTxt, newText)-> updateRemoveButton());
        }
    }
    public void updateButton(){
        modifyFlightBtn.setDisable(dataInAddFields());
        
    }
    public void updateRemoveButton(){
        modifyFlightBtn.setDisable(dataInRemoveFields());
    }
    
    private Boolean dataInAddFields(){
        return airlineTf.getText().isEmpty() || 
                flightNoTf.getText().isEmpty() ||
                takeoffTf.getText().isEmpty() ||
                landingTf.getText().isEmpty() ||
                costTf.getText().isEmpty();
    }
    private Boolean dataInRemoveFields(){
        return takeoffTf.getText().isEmpty() ||
                landingTf.getText().isEmpty();
    }
    public Agency getAgency(){
        return model;
    }
   
    @FXML private void handleClose(){
        stage.close();
    }
    @FXML private void handleAdd() throws Exception{
        try{
            Flight flight = new Flight(getAirline(), getFlightNo(), getTakeoff(), getLanding(), getCost());
            model.getFlights().getFlights().add(flight);
            stage.close();
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }

    }
    @FXML private void handleRemove() throws Exception{
        try{
            model.getFlights().removeFlight(getAgency().getFlights()
                    .getFlight(getTakeoff(), getLanding()));
            stage.close();
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
        
    }

    
}
