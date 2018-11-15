/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP PAVILLION
 */
public class Debts {
    
     public static int totalDebts() throws Exception{
         int myDebts=0;
       try{
          
       Connection con = DbConnector.getConnection();
       Statement state = con.createStatement();
        ResultSet rs = state.executeQuery("SELECT balance FROM customer WHERE customerType = 'credit' ");
            while(rs.next()){
             myDebts += rs.getInt("balance");
            }
       
       }
        catch(Exception ex){System.out.println(ex);}
        return myDebts;
     }
}
