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
public class Nissan extends VehicleProperties implements Vehicle  {

    @Override
    public void sell(int chass) {
        try{
            
         Connection con = DbConnector.getConnection();
         Statement state = con.createStatement();
          state.execute("UPDATE vehicle SET status = 'sold' WHERE chassis = '"+chass+"'"); 
          System.out.println("haha success");
       } 
       catch(Exception ex ){ System.out.println(ex);}
    }

  

  

    @Override
    public void showAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    }
   

   
   
       
   
    

