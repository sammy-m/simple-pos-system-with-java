/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP PAVILLION
 */
public class Profits {
    
    
    private final StringProperty  firstName;
    private final StringProperty  secondName;
    private final IntegerProperty  vehicle;
    private final IntegerProperty paid;
     
    public Profits( String firstName, String secondName, int vehicle,  int paid){
        
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.vehicle = new SimpleIntegerProperty(vehicle);
        this.paid= new SimpleIntegerProperty(paid);
       
        
    }

   

    public String getfirstName() {
        return firstName.get();
    }

    public String getsecondName() {
        return secondName.get();
    }

   

    public int getvehicle() {
        return vehicle.get();
    }

  

    public int getpaid() {
        return paid.get();
    }

  
    
    
    
  
    
     public void setfirstName(String value){
        firstName.set(value);
    }
     
      public void setsecondName(String value){
        secondName.set(value);
    }
      
        public void setvehicle(int value){
        vehicle.set(value);
    }
   
          public void setpaid(int value){
        paid.set(value);
    }
      
           
   
    public StringProperty firstNameProperty(){
    return firstName;
}
    public StringProperty secondNameProperty(){
    return secondName;
}
   
    public IntegerProperty vehicleProperty(){
    return vehicle;
}
    
    public IntegerProperty paidProperty(){
    return paid;
}
    
    public static int totalProfits(){
         int myProfit=0;
       try{
          
       Connection con = DbConnector.getConnection();
       Statement state = con.createStatement();
        ResultSet rs = state.executeQuery("SELECT AmountPaid FROM customer WHERE CustomerType = 'oneOff' ");
            while(rs.next()){
             myProfit += rs.getInt("AmountPaid");
            }
       
       }
       catch(Exception ex){System.out.println(ex);}
        return myProfit;
    }
    
}
