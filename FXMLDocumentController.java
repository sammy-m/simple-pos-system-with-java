/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
 *
 * @author HP PAVILLION
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField usrnm;
    
     @FXML
    private PasswordField pswd;
     
     @FXML
    private Button lgn;
     
     @FXML
    private Button snup;

 @FXML
    private Button butt;
 
     @FXML
     private Label errors;
     
     @FXML 
     private Button trybut;
     
     
     @FXML
     private void emptyFileds(ActionEvent event) throws IOException, SQLException{
         
         if(usrnm.getText().equals("") || pswd.getText().equals("")){
             
             errors.setText("Fields Cannot be Empty");
         }
         //implement check database
         
         else{
             String pass = pswd.getText().trim();
             String passFromDb = UserLogin.checkUser(usrnm.getText().trim());
             //for no password
             if (passFromDb == null){ JOptionPane.showMessageDialog(null, "incorrect username or password");}
             else{
             System.out.println(passFromDb);
            if(pass.equals(passFromDb.trim())){
             Parent root = FXMLLoader.load(getClass().getResource("Newhome.fxml"));
             Scene hm = new Scene(root);
             Stage hmstage = (Stage)((Node) event.getSource()).getScene().getWindow();
             hmstage.setScene(hm);
             hmstage.show();
             

         }
            else{
                JOptionPane.showMessageDialog(null, "incorrect username or password");
            }
         }
           }
         
     }
     
     @FXML
     private void signUp(ActionEvent event) throws IOException{
          Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
          Scene sinup = new Scene(root);
          Stage sinupstage = (Stage) ((Node) event.getSource()).getScene(). getWindow();
          sinupstage.setScene(sinup);
          sinupstage.show();
          
     }
      
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("NewHm.fxml"));
          Scene newhm = new Scene(root);
          Stage hoomestage = (Stage) ((Node) event.getSource()).getScene(). getWindow();
          hoomestage.setScene(newhm);
          hoomestage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
