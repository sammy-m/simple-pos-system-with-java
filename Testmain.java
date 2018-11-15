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
public class Testmain {
   
    
  public static void addOneOffCustomer(String idn, String fn, String sn, String pn, int chassis, int fullAmount ){
       String Firstnm=null, Secondnm=null,IdNo=null,phoneNo=null,amountPaid=null,balance=null ;
       
          OneOffCustomer.addCustomer(idn, fn, sn, pn, chassis,fullAmount );
  
       // Customers<OneOffCustomer> oneOff = new Customers<OneOffCustomer> ( Firstnm, Secondnm,  IdNo, phoneNo,  amountPaid, balance,new OneOffCustomer );
      // OnCreditCustomer.addCustomer(idn, fn, sn, pn, chassis, fullAmount,bal);
  }
   
  
  
  public static int getSellingPrice(int chasis) throws SQLException{
      
      ResultSet rs= null;
              try{
           
      Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
         rs = state.executeQuery("SELECT ResalePrice FROM vehicle WHERE chassis = '"+chasis+"' " );
     
        
     
                }
                catch (Exception ex){System.out.println(ex);}
        
     if(rs.next()){
         return rs.getInt("ResalePrice");
     }else{
         return 0;
     }

}
  
   public static int getDeposit(int chasis) throws SQLException{
      
      ResultSet rs= null;
              try{
           
      Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
         rs = state.executeQuery("SELECT AmountPaid FROM customer WHERE chassisNo = '"+chasis+"' " );
     
        
     
                }
                catch (Exception ex){System.out.println(ex);}
        
     if(rs.next()){
         return rs.getInt("AmountPaid");
     }
     else{
         return 0;
     }

}
  
}

