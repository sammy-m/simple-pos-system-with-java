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
public class VehicleProperties {
    public String brand;
    public String Make;
    public String chassisNo;
    public double bp;
    public double sp;
    public int yearOfManuf;
    
    public VehicleProperties(){
        
    }
    
    public static String checkBrand(int chassiss) throws SQLException{
        ResultSet rs= null;
              try{
           
      Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
         rs = state.executeQuery("SELECT brand FROM vehicle WHERE chassis = '"+chassiss+"' " );
     
        
     
                }
                catch (Exception ex){System.out.println(ex);}
        
     if(rs.next()){
         return rs.getString("brand");
     }else{
         return null;
     }
    }
    
    
}
