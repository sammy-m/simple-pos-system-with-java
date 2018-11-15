/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

/**
 *
 * @author HP PAVILLION
 */
public class TestClass {

    private String name;
  
    public  String mycustomer (){
           
            NewhomeController obj = new NewhomeController();
            String name = obj.getCustomerName();
            this.name = name;
            System.out.println(" the name gotten is " + name);
        return  name;    
        
    }
    
    public static void main (String [] args){
        
    }
    
   

  
    
}
