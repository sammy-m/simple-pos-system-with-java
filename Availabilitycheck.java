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
public class Availabilitycheck {
    
      public static String checkAvailable(String brand, String model, int chassis) throws SQLException{
        ResultSet rs= null;
              try{
           
      Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
                  System.out.println(chassis);
         rs = state.executeQuery("SELECT * FROM vehicle WHERE brand = '"+brand.trim()+"' AND model = '"+model.trim()+"' AND chassis ="+chassis+" AND Status = 'inStock' " );
   
                  System.out.println("SELECT * FROM vehicle WHERE brand = '"+brand.trim()+"' AND model = '"+model.trim()+"' AND chassis ="+chassis+"");
     
                }
                catch (Exception ex){System.out.println(ex);}
               System.out.println("i got the available");
        
     if(rs.next()){
         System.out.println("YEEES !!");
         return rs.getString("brand");  
     }
     
     return null;
    }
    
    
}
