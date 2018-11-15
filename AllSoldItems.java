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
public class AllSoldItems {
      private final StringProperty brand;
    private final StringProperty  model;
    private final StringProperty  year;
    private final IntegerProperty  chassis;
   
     
    public AllSoldItems(String brand, String model, String year, int chassis){
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleStringProperty(year);
        this.chassis = new SimpleIntegerProperty(chassis);
        
        
    }

    public String getBrand() {
        return brand.get();
    }

    public String getModel() {
        return model.get();
    }

    public String getYear() {
        return year.get();
    }

    public int getChassis() {
        return chassis.get();
    }

   
    
    
    public void setBrand(String value){
        brand.set(value);
    }
    
     public void setModel(String value){
        model.set(value);
    }
     
      public void setYear(String value){
        year.set(value);
    }
      
        public void setChasssis(int value){
        chassis.set(value);
    }
      
           
    public StringProperty brandProperty(){
    return brand;
}
    public StringProperty modelProperty(){
    return model;
}
    public StringProperty yearProperty(){
    return year;
}
   
    public IntegerProperty chassisProperty(){
    return chassis;
}
  
}
