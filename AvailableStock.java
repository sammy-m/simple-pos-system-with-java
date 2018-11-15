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
public class AvailableStock {
     private final StringProperty brand;
    private final StringProperty  model;
    private final StringProperty  year;
    private final IntegerProperty  chassis;
    private final IntegerProperty buyingPrice;
    private final IntegerProperty  sellingPrice;
     
    public AvailableStock(String brand, String model, String year,  int chassis, int buyingPrice, int sellingPrice){
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleStringProperty(year);
        this.chassis = new SimpleIntegerProperty(chassis);
        this.buyingPrice= new SimpleIntegerProperty(buyingPrice);
        this.sellingPrice= new SimpleIntegerProperty(sellingPrice);
        
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

  

    public int getBuyingPrice() {
        return buyingPrice.get();
    }

    public int getSellingPrice() {
        return sellingPrice.get();
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
     
        public void setChassis(int value){
        chassis.set(value);
    }
        
          public void setBuyingPrice(int value){
        buyingPrice.set(value);
    }
           public void setSellingPrice(int value){
        sellingPrice.set(value);
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
  
    public IntegerProperty buyingPriceProperty(){
    return buyingPrice;
}
    public IntegerProperty sellingPriceProperty(){
    return sellingPrice;
}
  
    
}
