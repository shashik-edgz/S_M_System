/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shashiki
 */
public class Role_Route {
          public DbModels dbModels =new DbModels();
          private String userRole;

    public boolean role(String user) throws SQLException{
        Statement stms;
             stms = dbModels.connection.createStatement();
             ResultSet rs=null;
        try {
             
             rs =stms.executeQuery("select role from login where username='"+user+"'");
             userRole =rs.getString("role"); 
             System.out.println(userRole);
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           stms.close();
           rs.close();
           
         if(userRole.equals("admin")){
                 System.out.println("trueeeee admin");
                 return true ;
             }else{
             System.out.println("flas admin");
                 return false;
                  
             }
        
        }
     
             
            
             
    }
}
