/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP PAVILLION
 */
public class OnCreditCustomer {
    
    
    
     
    private final StringProperty  firstname;
    private final StringProperty  secondname;
    private final IntegerProperty  vehicle;
   
    private final IntegerProperty paid;
    private final IntegerProperty  outstanding;
     
    public OnCreditCustomer( String firstname, String secondname,  int vehicle,  int paid, int outstanding){
       
        this.firstname = new SimpleStringProperty(firstname);
        this.secondname = new SimpleStringProperty(secondname);
       
        this.vehicle = new SimpleIntegerProperty(vehicle);
    
        this.paid= new SimpleIntegerProperty(paid);
        this.outstanding= new SimpleIntegerProperty(outstanding);
        
    }

   

    public String getFirstname() {
        return firstname.get();
    }

    public String getSecondname() {
        return secondname.get();
    }

  

    public int getvehicle() {
        return vehicle.get();
    }

   

    public int getpaid() {
        return paid.get();
    }

    public int getOutstanding() {
        return outstanding.get();
    }
    
   
    
     public void setfirstname(String value){
        firstname.set(value);
    }
     
      public void setsecondname(String value){
        secondname.set(value);
    }
          
        public void setvehicle(int value){
        vehicle.set(value);
    }
       
          public void setpaid(int value){
        paid.set(value);
    }
           public void setOutstanding(int value){
        outstanding.set(value);
    }
           
  
    public StringProperty firstnameProperty(){
    return firstname;
}
    public StringProperty secondnameProperty(){
    return secondname;
}
  
    public IntegerProperty vehicleProperty(){
    return vehicle;
}
   
    public IntegerProperty paidProperty(){
    return paid;
}
    public IntegerProperty outstandingProperty(){
    return outstanding;
}
    
    
    
    
     public static void addCustomer(String idn, String fn, String sn, String pn, int chassis, int initialDeposit, int bal){
         
         
  try{
         Connection con = DbConnector.getConnection();
      Statement state = con.createStatement();
      state.execute("Insert into customer(id,firstName, secondName,PhoneNo,chassisNo,customerType, AmountPaid, balance) values(' "+idn+" ',' "+fn+" ', ' "+sn+" ', ' "+pn+" ', ' "+chassis+" ', 'credit', '" +initialDeposit+"' , '" +bal+"');");
}
  
   catch(Exception ex){ System.out.println(ex);}
     } 
    
}
