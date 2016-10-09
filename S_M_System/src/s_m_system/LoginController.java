/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shashiki
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
  private TextField txtUser;
  @FXML
  private TextField txtPass;
  @FXML
  private Label isConnected;
  
  Login_Valid login_Valid = new Login_Valid();
  Role_Route role_Route = new Role_Route();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void Login(ActionEvent event) throws IOException{
      try {
            if(login_Valid.isLogin(txtUser.getText(),txtPass.getText())){
                isConnected.setText("Username And Password is Correct");
                
                if(role_Route.role(txtUser.getText())){
                    
                 ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("Admin_panel.fxml").openStream());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Sales");
                stage.setResizable(false);
                stage.show();

                }else{
                
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("D_E_panel.fxml").openStream());
               // UserFXMLController userFXMLController = (UserFXMLController)loader.getController();
               // userFXMLController.GetUser(txtUser.getText());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("D_E_panel");
                stage.setResizable(false);
                stage.show();
                
                }
                
               
                
                
                
                
                
  }else {
                if (txtUser.getText().toString().compareTo("") == 0 || txtPass.getText().toString().compareTo("") == 0) {
                    isConnected.setText("Please Enter Your Username & Password");
                }else{
                    isConnected.setText("Username And Password is NOT Correct");
                }           
            }
      } catch (SQLException e) {
          isConnected.setText("Username And PasCorrect");
          e.printStackTrace();
          
      }

  }
}
