/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;
import java.sql.*;

/**
 *
 * @author Shashiki
 */

public class SqlCon {
       public static Connection Connector() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:tea_man.sqlite");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
}
