/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Shashiki
 */
public class InfoController implements Initializable {

       public DbModels dbModels =new DbModels();
	ObservableList<SaleInfo> data=FXCollections.observableArrayList();
        ObservableList<RawInfo> rawData=FXCollections.observableArrayList();
        ObservableList<FinishedInfo> finishedData=FXCollections.observableArrayList();
   
        @FXML
	TableView<SaleInfo> saleTable;
         @FXML
	TableView<RawInfo> rawTable;
           @FXML
	TableView<FinishedInfo> finishedTable;
	
	@FXML
	private TableColumn<?, ?> cusIdCol;

	@FXML
	private TableColumn<?, ?> cusCol;

	@FXML
	private TableColumn<?, ?> typeCol;
        
        @FXML
	private TableColumn<?, ?> amountCol;
        
        @FXML
	private TableColumn<?, ?> priceCol;
        
        @FXML
	private TableColumn<?, ?> t_idCol;
        @FXML
	private TableColumn<?, ?> typCol;
        @FXML
	private TableColumn<?, ?> amouCol;
        
         @FXML
	private TableColumn<?, ?> f_t_idCol;
        @FXML
	private TableColumn<?, ?> f_typCol;
        @FXML
	private TableColumn<?, ?> f_amouCol;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                cusIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
		cusCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
                amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
                priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		t_idCol.setCellValueFactory(new PropertyValueFactory<>("type_id")); 
                typCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
                amouCol.setCellValueFactory(new PropertyValueFactory<>("amount")); 
                f_t_idCol.setCellValueFactory(new PropertyValueFactory<>("type_id")); 
                f_typCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
                f_amouCol.setCellValueFactory(new PropertyValueFactory<>("amount")); 
                SaleDbData();
                RawDbData();
                FinishedDbData();
    
    }
    
    	public void SaleDbData()
	{
		String query="select * from sale";
		
		try
		{
                    PreparedStatement pstms;
             pstms = dbModels.connection.prepareStatement(query);
                            ResultSet rs =pstms.executeQuery();
			
			
			while(rs.next())
			{
				data.add(new SaleInfo(rs.getInt("customer_id"), 
                                        rs.getString("customer"), 
                                        rs.getString("type_id"),
                                        rs.getInt("amount"),
                                        rs.getDouble("price")));
				saleTable.setItems(data);
			}
			pstms.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
    public void RawDbData()
	{
		String query="select * from raw_tea";
		
		try
		{
                    PreparedStatement pstms;
             pstms = dbModels.connection.prepareStatement(query);
                            ResultSet rs =pstms.executeQuery();
			
			
			while(rs.next())
			{
				rawData.add(new RawInfo(rs.getString("type_id"),
                                        rs.getString("type"),
                                        rs.getDouble("amount")));
				rawTable.setItems(rawData);
			}
			pstms.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
    public void FinishedDbData()
	{
		String query="select * from finished_tea";
		
		try
		{
                    PreparedStatement pstms;
             pstms = dbModels.connection.prepareStatement(query);
                            ResultSet rs =pstms.executeQuery();
			
			
			while(rs.next())
			{
				finishedData.add(new FinishedInfo(rs.getString("type_id"),
                                        rs.getString("type"),
                                        rs.getInt("amount")));
				finishedTable.setItems(finishedData);
			}
			pstms.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
