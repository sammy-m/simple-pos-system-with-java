/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author HP PAVILLION
 */
public class SignUpController implements Initializable {
    
         @FXML
     private Button btsub;
          @FXML
          private TextField txfstnm;
          
          @FXML
         private PasswordField pswdfadm;
          
          @FXML
        private TextField txscdnm;
          
          @FXML
        private TextField txtusrnm,txtemail;
          
          @FXML
        private PasswordField pswdfpswd,pswfpswd;
          
          @FXML
        private PasswordField pswfcnfpswd;
          
          @FXML
        private Label error;
          @FXML
          
          private void signUpp(ActionEvent event) throws IOException{
               if (txfstnm.getText().equals("") || txscdnm.getText().equals("")){
               JOptionPane.showMessageDialog(null, "fields cannot be empty");
               }
            
               else{
             Parent rooot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
             Scene snup = new Scene(rooot);
             Stage snupstage = (Stage)((Node) event.getSource()).getScene().getWindow();
             snupstage.setScene(snup);
             snupstage.show();
             
             //add log in stuff to db
             String fname = txfstnm.getText();
             String sname = txscdnm.getText();
             String usrname = txtusrnm.getText().trim();
             int idn = Integer.parseInt(txtemail.getText());
             String pass = pswfpswd.getText();
             String confPas = pswfcnfpswd.getText();
             String adminPass = pswdfadm.getText();
             
             if(pswdfadm.getText().equals("3445s")){
             if( pswfcnfpswd.getText().equals(pass)){
                 
                  try{
              Connection con = DbConnector.getConnection();
                Statement state = con.createStatement();
                state.execute("Insert into users(firstName,secondName,idNo,userName,password,Status) values(' " + fname + " ',' " + sname + " ', ' " + idn + " ', '"+usrname+"', ' " + pass + " ', 'user')");
            } catch (Exception ex) {
                System.out.println(ex);
            }
                 
             }
             
             else{
                 JOptionPane.showMessageDialog(null, "passwords did not match");
             }
             }
             else{  JOptionPane.showMessageDialog(null, "incorrect admin password");}
             
            
             
             
             
             
             
             
             
               }

             
              
          }
         
         

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
