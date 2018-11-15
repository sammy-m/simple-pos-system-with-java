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
public class Customers<T> {
    
    public T modeOfPayment;
    private String Firstnm;
    private String Secondnm;
    private String IdNo;
    private String phoneNo;
    private String amountPaid;
    private String balance;
    
   

   

    Customers(String Firstnm, String Secondnm, String IdNo, String phoneNo, String amountPaid, String balance, T modeOfPayment) {
         this.modeOfPayment = modeOfPayment;
        this.Firstnm = Firstnm;
        this.Secondnm = Secondnm;
        this.IdNo = IdNo;
        this.phoneNo = phoneNo;
        this.amountPaid = amountPaid;
        this.balance = balance;
        
    }

   
    
  
  
}
