/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shashiki
 */
public class cal{
      public DbModels dbModels =new DbModels();
      
    private Integer fTea;
   // private String type;
    
    public void dbFteaData(Integer qunti,String typ){
    
    try {
      
              Statement stms;
             stms = dbModels.connection.createStatement();
             ResultSet rs =stms.executeQuery("select amount from finished_tea where type_id='"+typ+"'");
             fTea=rs.getInt("amount"); 
             System.out.println(fTea);
             fTea=fTea-qunti;
             String sqlString = "update finished_tea set amount="+fTea+" where type_id='"+typ+"'";
             stms.executeUpdate(sqlString);
             rs.close();
             stms.close();
             
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+":"+e.getMessage());
          
        }
    }
      
    
    
   
}
