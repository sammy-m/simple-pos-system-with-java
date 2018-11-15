/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.*;


/**
 *
 * @author HP PAVILLION
 */
public class Toyota extends VehicleProperties implements Vehicle  {
    
   public  void sell(int chass){
       try{
           System.out.println("hello");
         Connection con = DbConnector.getConnection();
         Statement state = con.createStatement();
          state.execute("UPDATE vehicle SET status = 'sold' WHERE chassis = '"+chass+"' "); 
       } 
       catch(Exception ex ){ System.out.println(ex);}
       
   }
  

    @Override
    public void showAvailable() {
          try{
           
                     Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM vehicle WHERE brandId = '2' AND Status ='inStock' " );
      while(rs.next()){
      
      System.out.println(rs.getString("brand")+  " "+ rs.getString("model")+" "+rs.getString("year")+" "+rs.getString("chassis")+" "+rs.getInt("BuyingPrice")+" "+rs.getInt("ResalePrice"));
      
      
      }
     
                }
                catch (Exception ex){System.out.println(ex);}
    }

   
}
