/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author HP PAVILLION
 */
public class OneOffCustomer {
    
    public static void addCustomer(String idn, String fn, String sn, String pn, int chassis, int fullAmount){
    try {
    Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            int balance = 0;
           state.execute("Insert into customer(id,firstName, secondName,PhoneNo,chassisNo,customerType, AmountPaid, balance) values(' "+idn+" ',' "+fn+" ', ' "+sn+" ', ' "+pn+" ', ' "+chassis+" ', 'oneOff', '" +fullAmount+"','" +balance+"');");            
}
    catch(Exception ex){ System.out.println(ex);}
    
     try {
    Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            int balance = 0;
           state.execute("UPDATE customer SET balance ='" + balance + "' WHERE chassisNo = '" + chassis + "'");            
}
    catch(Exception ex){ System.out.println(ex);}
}
}

    

