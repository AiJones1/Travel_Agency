package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Exceptions.ErrorModel;


public class ExploreDestinationsController extends Controller<Agency>{

    @FXML Label desWelcomeTxt;
    @FXML Button viewDestinationsBtn;
    @FXML Button viewFilteredDestinationsBtn;
    @FXML Button addDestinationBtn;
    @FXML Button removeDestinationBtn;
    @FXML Button closebtn;

    public void initialize(){
        if(model!=null){
            desWelcomeTxt.setText(model.getLoggedInUser().toString()+"Destinations section");
        }
    }

    @FXML public void handleViewDestination(){
        try{
            Stage viewDestinationStage = new Stage();
            viewDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/DisplayDestinationsView.fxml","Destinations",viewDestinationStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

        @FXML public void handleViewFliteredDestinations(){
        try{
            Stage viewFilteredDestinationStage = new Stage();
            viewFilteredDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/DisplayFilteredDestinationsView.fxml","Destinations",viewFilteredDestinationStage);
        }catch(Exception e){

            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

    @FXML public void handleAddDestination(){
        try{
            Stage addDestinationStage = new Stage();
            addDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/AddDestinationView.fxml","Add Destination", addDestinationStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }



    @FXML public void handleRemoveDestination(){
        try{
            Stage removeDestinationStage = new Stage();
            removeDestinationStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/RemoveDestinationView.fxml","Remove Destination", removeDestinationStage);
        }catch(Exception e){
            ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
        }
    }

   @FXML public void handleClose(){
        stage.close();
   }

   public Agency getAgency(){
    return model;
   }

   
}
