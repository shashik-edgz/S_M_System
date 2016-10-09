/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shashiki
 */
public class Admin_Controller implements Initializable {
    @FXML
    private TextField password1;
    @FXML
    private TextField username1;
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton dEntry;
    
               public DbModels dbModels =new DbModels();

    /**
     * Initializes the controller class.
     */
    
    private String varUsername;
    private String varPassword;
    private String radioRole;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public  void login_man1(ActionEvent event) throws IOException{
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("Login.fxml").openStream()); 
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.setResizable(false);
                stage.show();
}    
    public  void saleInfo(ActionEvent event) throws IOException{
              //  ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("Info.fxml").openStream()); 
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Sale Information");
                stage.setResizable(false);
                stage.show();
}   
    public  void home1(ActionEvent event) throws IOException{
              //  ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("Sales.fxml").openStream()); 
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.setResizable(false);
                stage.show();
} 
 public void sginUpReg(ActionEvent event) throws SQLException{
    
    
    varUsername = username1.getText();
    varPassword = password1.getText();
    if(admin.isSelected()){
    radioRole="admin";
    }
    if(dEntry.isSelected()){
        radioRole="d_entry";
    }
    Statement stms;
    try {
         
             stms = dbModels.connection.createStatement();
             String sql = "insert into login (username,password,role) values ('"+varUsername+"','"+varPassword+"','"+radioRole+"')";
             stms.executeUpdate(sql);
             stms.close();
             dbModels.connection.close();
             
           
             
             
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
        
    }
   
}   
}
