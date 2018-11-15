/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP PAVILLION
 */
public class CustomerDetails {
    private final StringProperty id;
    private final StringProperty  firstName;
    private final StringProperty  secondName;
    private final StringProperty  phone;
    private final IntegerProperty  vehicle;
    private final StringProperty  type;
    private final IntegerProperty paid;
    private final IntegerProperty  balance;
     
    public CustomerDetails(String id, String firstName, String secondName, String phone, int vehicle, String type, int paid, int balance){
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.phone = new SimpleStringProperty(phone);
        this.vehicle = new SimpleIntegerProperty(vehicle);
        this.type = new SimpleStringProperty(type);
        this.paid= new SimpleIntegerProperty(paid);
        this.balance= new SimpleIntegerProperty(balance);
        
    }

    public String getid() {
        return id.get();
    }

    public String getfirstName() {
        return firstName.get();
    }

    public String getsecondName() {
        return secondName.get();
    }

    public String getphone() {
        return phone.get();
    }

    public int getvehicle() {
        return vehicle.get();
    }

    public String gettype() {
        return type.get();
    }

    public int getpaid() {
        return paid.get();
    }

    public int getbalance() {
        return balance.get();
    }
    
    
    public void setid(String value){
        id.set(value);
    }
    
     public void setfirstName(String value){
        firstName.set(value);
    }
     
      public void setsecondName(String value){
        secondName.set(value);
    }
       public void setphone(String value){
        phone.set(value);
    }
        public void setvehicle(int value){
        vehicle.set(value);
    }
         public void settype(String value){
        type.set(value);
    }
          public void setpaid(int value){
        paid.set(value);
    }
           public void setbalance(int value){
        balance.set(value);
    }
           
    public StringProperty idProperty(){
    return id;
}
    public StringProperty firstNameProperty(){
    return firstName;
}
    public StringProperty secondNameProperty(){
    return secondName;
}
    public StringProperty phoneProperty(){
    return phone;
}
    public IntegerProperty vehicleProperty(){
    return vehicle;
}
    public StringProperty typeProperty(){
    return type;
}
    public IntegerProperty paidProperty(){
    return paid;
}
    public IntegerProperty balanceProperty(){
    return balance;
}
  
}
