/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import com.jfoenix.controls.JFXTabPane;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shashiki
 */
public class D_E_panelController implements Initializable {

    @FXML
    private RadioButton fT1;
     @FXML
    private RadioButton fT2;
      @FXML
    private RadioButton fT3;
       @FXML
    private RadioButton rT1;
        @FXML
    private RadioButton rT2;
         @FXML
    private RadioButton rT3;
               @FXML
    private RadioButton rT4;
               
     @FXML
     private TextField fTeaField;
      @FXML
     private TextField rTeaField;
     
      private String teaType;
      private Integer fTquen;
      private Integer tempfTquen;
      private Double tempAmount;
      private Double varAmount;

               
            public DbModels dbModels =new DbModels();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }
public void updateFtea(){
if(fT1.isSelected()){
teaType ="T1";
}
if(fT2.isSelected()){
teaType ="T2";
}
if(fT3.isSelected()){
teaType ="T3";
}
fTquen=Integer.parseInt(fTeaField.getText());

try {
      
              Statement stms;
             stms = dbModels.connection.createStatement();
             ResultSet rs =stms.executeQuery("select amount from finished_tea where type_id='"+teaType+"'");
             tempfTquen=rs.getInt("amount"); 
             System.out.println(tempfTquen);
             tempfTquen+=fTquen;
             String sqlString = "update finished_tea set amount="+tempfTquen+" where type_id='"+teaType+"'";
             stms.executeUpdate(sqlString);
             rs.close();
             stms.close();
             fTeaField.clear();
             
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+":"+e.getMessage());
          
        }


}
public void updateRtea(){
if(rT1.isSelected()){
teaType ="RT1";
}
if(rT2.isSelected()){
teaType ="RT2";
}
if(rT3.isSelected()){
teaType ="RT3";
}
if(rT4.isSelected()){
teaType ="RT4";
}

varAmount=Double.parseDouble(rTeaField.getText());

try {
      
              Statement stms;
             stms = dbModels.connection.createStatement();
             ResultSet rs =stms.executeQuery("select amount from raw_tea where type_id='"+teaType+"'");
             tempAmount=rs.getDouble("amount"); 
             System.out.println(tempAmount);
             tempAmount+=varAmount;
             String sqlString = "update raw_tea set amount="+tempAmount+" where type_id='"+teaType+"'";
             stms.executeUpdate(sqlString);
             rs.close();
             stms.close();
             rTeaField.clear();
             
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+":"+e.getMessage());
          
        }


}
    
 public void logout(ActionEvent event) throws IOException{
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
    
    
}
