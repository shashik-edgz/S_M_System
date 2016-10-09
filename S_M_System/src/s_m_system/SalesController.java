/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Shashiki
 */
public class SalesController implements Initializable {

    @FXML
    private TextField cutomerField;
    @FXML
    private TextField quentField;
    @FXML
    private TextField priceField;
    @FXML
    private RadioButton rB1;
    @FXML
    private RadioButton rB2;
    @FXML
    private RadioButton rB3;
  
   
   //varibles
   private String varCust;
   private Integer varQuen;
   private Double varprice;
   private String varRadio;
   private Double tempPrice;
   
   public DbModels dbModels =new DbModels();
   public cal calc = new cal();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void saleInfo(ActionEvent event){
    if(rB1.isSelected()){
    varRadio = "T1";
    tempPrice = 250.0;
    }
     if(rB2.isSelected()){
    varRadio = "T2";
    tempPrice = 550.0;
    }
      if(rB3.isSelected()){
    varRadio = "T3";
    tempPrice = 5000.0;
    }
      varCust = cutomerField.getText();
      varQuen = Integer.parseInt(quentField.getText());
      varprice = varQuen*tempPrice;
     priceField.setText(Double.toString(varprice));
     
      calc.dbFteaData(varQuen,varRadio);
      varprice =Double.parseDouble(priceField.getText());
      
       Statement stms;
    try {
         
             stms = dbModels.connection.createStatement();
             String sql = "insert into sale (customer,type_id,amount,price) values ('"+varCust+"','"+varRadio+"','"+varQuen+"','"+varprice+"')";
             stms.executeUpdate(sql);
            
             cutomerField.clear();
           //  priceField.clear();
             quentField.clear();
             rB1.setSelected(false);
             rB2.setSelected(false);
             rB3.setSelected(false);
              stms.close();
             dbModels.connection.close();
            /* ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("FXMLDocument.fxml").openStream());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();*/
             
             
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);  
    }
      
      

}
    
}
