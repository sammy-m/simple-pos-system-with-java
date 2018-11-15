/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP PAVILLION
 */
public class UserLogin {
    
     public static String checkUser(String user) throws SQLException{
        ResultSet rs= null;
              try{
           
      Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
                  System.out.println(user);
         rs = state.executeQuery("SELECT * FROM users WHERE userName = '"+user.trim()+"' " );
     
        
     
                }
                catch (Exception ex){System.out.println(ex);}
               System.out.println("i got the username");
        
     if(rs.next()){
         System.out.println("YEEES !!");
         return rs.getString("password");  
     }
     
     return null;
    }
    
}


