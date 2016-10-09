/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.sql.Connection;

/**
 *
 * @author Shashiki
 */

public class DbModels {
     Connection connection;
    
    public DbModels(){
     connection = SqlCon.Connector();
     if(connection==null)System.exit(1);
    }
    
    public boolean isDbConnected(){
        try {
            return !connection.isClosed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
