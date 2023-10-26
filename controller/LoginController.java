package controller;
   
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Exceptions.ErrorModel;

public class LoginController extends Controller<Agency>{
    
    @FXML private TextField usernameTF;
    @FXML private PasswordField passwordTF;
    @FXML private Button loginBtn;
    @FXML private Button exitBtn;


    public LoginController(){
        model = new Agency();
        model.getAdministrators();
    }

    //ViewLoader.showStage(<model>, <fxml>, <title>, <stage>)

    @FXML private void handleLogin(ActionEvent event) throws Exception{
        String usrName = usernameTF.getText();
        String pw = passwordTF.getText();
            try{
                boolean isUser = model.getAdministrators().hasAdministrator(usrName, pw);
                if(isUser){
                    model.setLoggedInUser(model.getAdministrators().getAdministrator(usrName, pw));
                    Stage stage1 = new Stage();
                    stage1.getIcons().add(new Image("/image/agency_icon.png"));
                    ViewLoader.showStage(model, "/view/AgencyView.fxml", "Prog2 Travel Agency", stage1);  
                    stage.close(); 
                }   
            }catch(Exception e){
                ErrorModel error = new ErrorModel(e, "Stop Hacking!");
                ViewLoader.showErrorWindow(error);
            }            
    }

    @FXML private void handleExit(){
        stage.close();
    }
    public Agency getAgency(){
        return model;
    }
    
}
