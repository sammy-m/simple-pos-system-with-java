/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HP PAVILLION
 */
public class Time {
     public   static String getDate( ) {
 
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    //get current date time with Date()
    Date date = new Date();
    //System.out.println(dateFormat.format(date));
 
    //get current date time with Calendar()
    Calendar cal = Calendar.getInstance();
    return (dateFormat.format(cal.getTime()));
 
  }
    
}
