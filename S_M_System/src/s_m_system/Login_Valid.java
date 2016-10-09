/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shashiki
 */
public class Login_Valid {
           public DbModels dbModels =new DbModels();

    public boolean isLogin(String user,String pass) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from login where username= ? and password = ?";
        try {
            preparedStatement = dbModels.connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
            return true;
            }else{
            return false;
            }

        } catch (Exception e) {
            return false;
        }finally{
            
        preparedStatement.close();
        resultSet.close();
        }
    }
}
