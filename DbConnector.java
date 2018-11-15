/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;
import java.sql.*;
/**
 *
 * @author HP PAVILLION
 */
public class DbConnector {
    

  private static final String CUSTOMER_TABLE = "create table if not exists Customer ( "
      + "   id varchar(20) PRIMARY KEY, firstName VARCHAR(20), SecondName VARCHAR(20), "
      + "   PhoneNo VARCHAR(20),chassisNo INT,customerType varchar(10),AmountPaid INT ,balance INT )";
  private static final String  VEHICLE_TABLE = "create table if not exists Vehicle ("
          + " brand varchar(15),  year varchar(5), chassis INT PRIMARY KEY, model varchar(10),BuyingPrice double, ResalePrice double, Status varchar(10),brandId INT)";
  
  private static final String  USERS_TABLE = "create table if not exists Users ("
          + " firstName varchar(15),  secondName varchar(15), idNo INT PRIMARY KEY, userName varchar(10),password varchar(15), Status varchar(10))";
  public static Connection getConnection() throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/sam";
    String username = "sam";
    String password = "sammy1997";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
  
   

  public static void main(String args[]) {
      
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(CUSTOMER_TABLE);
           
      System.out.println(" customer table created");
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    
    } catch (SQLException e) {
      System.out.println(e);
     
    } catch (Exception e) {
      System.out.println(e);
    
    } finally {
      try {
        stmt.close();
        conn.close();        
      } catch (SQLException e) {
       System.out.println(e);
      }
    }
    
    
     try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(USERS_TABLE);
           
      System.out.println(" user table created");
    } catch (ClassNotFoundException e) {
      System.out.println(e);
     
    } catch (SQLException ex) {
      System.out.println(ex);
      
    } catch (Exception e) {
      System.out.println(e);
     
    } finally {
      try {
        stmt.close();
        conn.close();        
      } catch (SQLException e) {
        System.out.println(e);
      }
    }
    
    
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(VEHICLE_TABLE);
           
      System.out.println(" VEHICLE table created");
    } catch (ClassNotFoundException e) {
      System.out.println(e);
      
    } catch (SQLException e) {
      System.out.println(e);
     
    } catch (Exception e) {
      System.out.println(e);
     
    } finally {
      try {
        stmt.close();
        conn.close();        
      } catch (SQLException e) {
       System.out.println(e);
      }
    }
    
  }
}
           
    

