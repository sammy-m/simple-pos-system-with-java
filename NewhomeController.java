/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP PAVILLION
 */
public class NewhomeController implements Initializable {

    @FXML
    Button logOut;
    @FXML
    ScrollPane spchkstk;
    @FXML
    MenuItem michkstk;
    @FXML
    Label chkstlb, lberroraddstk;
    @FXML
    Button bttoy;
    @FXML
    Button btbmw;
    @FXML
    Button btaudi;
    @FXML
    Button btisuzu;
    @FXML
    Button btallav;
    @FXML
    Button btniss;
    @FXML
    Button btmits, btaddstk, btrmstk, btsell;
    @FXML
    Label chkstklb, lbtoperrors, lbanalysis,lbdatte;
    @FXML
    MenuItem miaddstk, micus;
    @FXML
    AnchorPane anchpaddstk;
    @FXML
    ScrollPane sphome;
    @FXML
    ScrollPane spaddstk, sprmstk, spsell, spanalyse, spdebts;
    @FXML
    Menu mnhome;
    @FXML
    MenuItem mihome, mithissale, miitemsold, midebts, miprofits;
    @FXML
    TextField txtbrand, txtchassrs, txtreason;
    @FXML
    TextField txtmake;
    @FXML
    TextField txtyom;
    @FXML
    TextField txtchass;
    @FXML
    TextField txtbp, txtinstallamountsl, txtflamountsl, txtthisinstallsl;
    @FXML
    TextField txtrp, txtfstnmsl, txtscndnmsl, txtidsl, txtphnsl, txtbrandsl, txtmakesl, txtchasssl, txtinitdepsl, txtinstallnosl;
    @FXML
    ImageView homeimage;
    @FXML
    Pane rmstkpn;
    @FXML
    CheckBox cbdeposl, cbflpaysl, cbinstallsl, cbchqsl, cbbdsl, cbcashsl;
    @FXML
    Text txttataldebts, txttotalprof;
    @FXML
    private TableView<CustomerDetails> tbviewcus;
    @FXML
    private TableColumn<CustomerDetails, String> tcidcus;
    @FXML
    private TableColumn<CustomerDetails, String> tcfnamecus;
    @FXML
    private TableColumn<CustomerDetails, String> tcsnamecus;
    @FXML
    private TableColumn<CustomerDetails, String> tcphonecus;
    @FXML
    private TableColumn<CustomerDetails, Integer> tcvehiclecus;
    @FXML
    private TableColumn<CustomerDetails, String> tctypecus;
    @FXML
    private TableColumn<CustomerDetails, Integer> tcpaidcus;
    @FXML
    private TableColumn<CustomerDetails, Integer> tcbalcus;

    @FXML
    private TableView<AllSoldItems> tbviewitemsold;
    @FXML
    private TableColumn<AllSoldItems, String> tcbrandis;
    @FXML
    private TableColumn<AllSoldItems, String> tcmodelis;
    @FXML
    private TableColumn<AllSoldItems, String> tcyearis;
    @FXML
    private TableColumn<AllSoldItems, Integer> tcchassisis;

    @FXML
    private TableView<OnCreditCustomer> tbviewdebts;
    @FXML
    private TableColumn<OnCreditCustomer, String> tcfnamedebt;
    @FXML
    private TableColumn<OnCreditCustomer, String> tcsnamedebt;
    @FXML
    private TableColumn<OnCreditCustomer, Integer> tcvehicledebt;
    @FXML
    private TableColumn<OnCreditCustomer, Integer> tcpaiddebt;
    @FXML
    private TableColumn<OnCreditCustomer, Integer> tcoutstandingdebt;

    @FXML
    private TableView<Profits> tbviewprofits;
    @FXML
    private TableColumn<Profits, String> tcfnameprof;
    @FXML
    private TableColumn<Profits, String> tcsnameprof;
    @FXML
    private TableColumn<Profits, Integer> tcvehicleprof;
    @FXML
    private TableColumn<Profits, Integer> tcpaidprof;

    @FXML
    private TableView<AvailableStock> tbviewsc;
    @FXML
    private TableColumn<AvailableStock, String> tcbrandsc;
    @FXML
    private TableColumn<AvailableStock, String> tcmodelsc;
    @FXML
    private TableColumn<AvailableStock, String> tcyearsc;
    @FXML
    private TableColumn<AvailableStock, Integer> tcchasssc;
    @FXML
    private TableColumn<AvailableStock, Integer> tcbpsc;
    @FXML
    private TableColumn<AvailableStock, Integer> tcrpsc;
    
    

    @FXML
    void setHome() {
        sphome.toFront();
         cbinstallsl.setVisible(false);
       
    }
    
    @FXML
    void setDate() {
        String myDate = Time.getDate();
        lbdatte.setText(myDate);
       
    }

    @FXML
    void goHome(ActionEvent event) {
        sphome.toFront();
    }

    @FXML
    void addingStock(ActionEvent event) {
        if (event.getTarget().equals(miaddstk)) {
            spaddstk.toFront();
        } else {
            sphome.toFront();
        }
    }

    @FXML
    void chekingStock(ActionEvent event) {
        spchkstk.toFront();
    }

    @FXML
    void checkallStock(ActionEvent event) {
        try {
            Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            // state.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @FXML
    void adddingStock(ActionEvent event) {
        String br = txtbrand.getText().trim();
        String ym = txtyom.getText();
        String mk = txtmake.getText().trim();
        
        String chs = txtchass.getText();
        //check for empty fields

        if (txtbrand.getText().equals("") || txtmake.getText().equals("") || txtyom.getText().equals("") || txtchass.getText().equals("") || txtbp.getText().equals("")) {
           JOptionPane.showMessageDialog(null, "fields cannot be empty");

        }
           
        else{
            int rp = Integer.parseInt(txtrp.getText());
            int bp = Integer.parseInt(txtbp.getText());
            
            //checking for resale price
            if(rp<bp){
                    JOptionPane.showMessageDialog(null, "resale price is less than buying price" );
                }
            //check for valid brands
           else if(txtbrand.getText().equals("Toyota") || txtbrand.getText().equals("Nissan") || txtbrand.getText().equals("Mitsubishi") || txtbrand.getText().equals("BMW") || txtbrand.getText().equals("Audi") || txtbrand.getText().equals("Isuzu")){
            
            
        
            try {
                int brandNo;
                if (txtbrand.getText().equals("Nissan")) {
                    brandNo = 1;
                } else if (txtbrand.getText().equals("Toyota")) {
                    brandNo = 2;
                } else if (txtbrand.getText().equals("Isuzu")) {
                    brandNo = 3;
                } else if (txtbrand.getText().equals("Mitsubishi")) {
                    brandNo = 4;
                } else if (txtbrand.getText().equals("BMW")) {
                    brandNo = 5;
                } else {
                    brandNo = 6;
                }
                Connection con = DbConnector.getConnection();
                Statement state = con.createStatement();
                state.execute("Insert into vehicle(brand,model, year,chassis,BuyingPrice, ResalePrice, Status, brandId) values('"+br.trim()+"','"+mk.trim()+" ', ' " + ym + " ', ' " + chs + " ', ' " + bp + " ', '" + rp + "', 'inStock', '" + brandNo + " ');");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            txtbrand.clear();
            txtmake.clear();
            txtyom.clear();
            txtchass.clear();
            txtbp.clear();
            txtrp.clear();
            lberroraddstk.setText("");
        }
            else{
                JOptionPane.showMessageDialog(null, "invalid brand!");
            }
        }
       
    }

    @FXML
    void removingStock(ActionEvent event) {
        sprmstk.toFront();
    }

    @FXML
    void buttonRemovestk(ActionEvent event) {
        boolean available = false;
        int chass = Integer.parseInt(txtchassrs.getText().trim());
        try {

            Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM vehicle WHERE chassis = '" + chass + "' AND Status = 'inStock'");

            while (rs.next()) {
                available = true;
                System.out.println("ITEM: " + rs.getInt("chassis"));
            }
            if (available == true) {

                state.execute("UPDATE vehicle SET status = 'removed' WHERE chassis = '" + chass + "'");

                txtchassrs.clear();
                txtreason.clear();
                JOptionPane.showMessageDialog(null, "Removed!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Item not in stock!");//error here!!!!
                System.out.println("DFGH");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @FXML
    void sellVehicle(ActionEvent event) {
        spsell.toFront();
    }

    @FXML
    private ObservableList<AvailableStock> vehicle;

    @FXML
    void checkStock(ActionEvent event) throws Exception {
        chkstklb.setVisible(false);
        tbviewsc.setVisible(true);

        if (event.getSource().equals(btallav)) {
            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle  WHERE Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(bttoy)) {
            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '2' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(btmits)) {

            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '4' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(btniss)) {

            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '1' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(btisuzu)) {
            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '3' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(btaudi)) {
            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '6' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        } else if (event.getSource().equals(btbmw)) {
            try {
                Connection conn = DbConnector.getConnection();
                vehicle = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE brandId = '5' AND Status ='inStock' ");
                while (rs.next()) {
                    vehicle.add(new AvailableStock(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            //setting cell value to tab view 
            tcbrandsc.setCellValueFactory(new PropertyValueFactory<>("brand"));
            tcmodelsc.setCellValueFactory(new PropertyValueFactory<>("model"));
            tcyearsc.setCellValueFactory(new PropertyValueFactory<>("year"));
            tcchasssc.setCellValueFactory(new PropertyValueFactory<>("chassis"));
            tcbpsc.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            tcrpsc.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));

            tbviewsc.setItems(null);
            tbviewsc.setItems(vehicle);

        }

    }

    @FXML
    void sellingnow(ActionEvent event) throws Exception {
        String fn = txtfstnmsl.getText();
        String sn = txtscndnmsl.getText();
        String idn = txtidsl.getText();
        String pn = txtphnsl.getText();
        String brand = txtbrandsl.getText().trim();
        String make = txtmakesl.getText().trim();
        
        
        //no empty fields
        if(txtfstnmsl.getText().equals("") || txtscndnmsl.getText().equals("") || txtidsl.getText().equals("") || txtbrandsl.getText().equals("") || txtmakesl.getText().equals("") || txtphnsl.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "fill all fields!");
        }
        else{
        //checking availability b4 selling
      
        
        
        int chassis = Integer.parseInt(txtchasssl.getText());
          String branddb = Availabilitycheck.checkAvailable(brand.trim(), make.trim(), chassis);
           System.out.println(" hello 2"+branddb);
          
          if (branddb == null){ JOptionPane.showMessageDialog(null, "vehicle not in stock ");}
          
          else{
               System.out.println(" hello "+branddb);
        try {
            if (cbdeposl.isSelected()) {
                int initialDeposit = Integer.parseInt(txtinitdepsl.getText());

                Connection con = DbConnector.getConnection();
                Statement state = con.createStatement();
                state.execute("Insert into customer(id,firstName, secondName,PhoneNo,chassisNo,customerType, AmountPaid) values(' " + idn + " ',' " + fn + " ', ' " + sn + " ', ' " + pn + " ', ' " + chassis + " ', 'credit', '" + initialDeposit + "');");

            } else if (cbflpaysl.isSelected()) {
                int fullAmount = Integer.parseInt(txtflamountsl.getText());

                OneOffCustomer.addCustomer(idn, fn, sn, pn, chassis, fullAmount);

                // Connection con = DbConnector.getConnection();
                // Statement state = con.createStatement();
                // state.execute("Insert into customer(id,firstName, secondName,PhoneNo,chassisNo,customerType, AmountPaid) values(' "+idn+" ',' "+fn+" ', ' "+sn+" ', ' "+pn+" ', ' "+chassis+" ', 'oneOff', ' " +fullAmount+"');");   
            } else {
                //implement deduct installment
                int idno = Integer.parseInt(txtidsl.getText());

                Connection con = DbConnector.getConnection();

                Statement state = con.createStatement();
               // state.execute("UPDATE  customer SET balance = '"+balance+"' ");
            }

            String brandd = VehicleProperties.checkBrand(chassis).trim();
     
            if (brandd.equals("Toyota")) {
                System.out.println(brandd);
                new Toyota().sell(chassis);

            } else if (brandd.equals("Nissan")) {
                new Nissan().sell(chassis);
                System.out.println(brandd);
            } else if (brandd.equals("Isuzu")) {
                new Isuzu().sell(chassis);
                System.out.println(brandd);
            } else if (brandd.equals("Mitsubishi")) {
                new Mitsubishi().sell(chassis);
                System.out.println(brandd);
            } else if (brandd.equals("Audi")) {
                new Audi().sell(chassis);
                System.out.println(brandd);
            } else if (brandd.equals("BMW")) {
                new BmW().sell(chassis);
                System.out.println(brandd);
            }

            //Toyota.sell(chassis);
            //  Connection con = DbConnector.getConnection();
            //  Statement state = con.createStatement();
            // state.execute("Insert into vehicle WHERE chassis  =  ( status) values( 'sold');");   
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //updating vehicle to sold  
        try {
            int paid = Integer.parseInt(txtinitdepsl.getText());

            int full = Testmain.getSellingPrice(chassis);
            int bal = full - paid;
            System.out.println("this is the selling price " + full);
            System.out.println("this is the amount paid " + paid);
            System.out.println("this is the balance " + bal);

            Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            state.execute("UPDATE customer SET balance ='" + bal + "' WHERE chassisNo = '" + chassis + "'");
            //SET balance  = '"+bal+"'  WHERE chassisNo = '"+chassis+"'");
           
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
           
               int  bal = 0;
            Connection con = DbConnector.getConnection();
            Statement state = con.createStatement();
            state.execute("UPDATE customer SET balance ='" +bal+ "' WHERE customerType = 'oneOff'");
            //SET balance  = '"+bal+"'  WHERE chassisNo = '"+chassis+"'");
           
        } catch (Exception ex) {
            System.out.println(ex);
        }

        txtfstnmsl.clear();
        txtscndnmsl.clear();
        txtidsl.clear();
        txtphnsl.clear();
        txtbrandsl.clear();
        txtmakesl.clear();
        txtchasssl.clear();
        txtinitdepsl.clear();
        txtflamountsl.clear();
        cbbdsl.setSelected(false);  //if error check here!!
        cbcashsl.setSelected(false);
        cbdeposl.setSelected(false);
        cbflpaysl.setSelected(false);
        cbbdsl.setSelected(false);
        cbchqsl.setSelected(false);
    }
    }

    }

    @FXML
    void checkboxDeposit(ActionEvent event) {
        cbflpaysl.setSelected(false);
        cbinstallsl.setSelected(false);
        txtinitdepsl.setVisible(true);
        txtinstallnosl.setVisible(false);
        txtinstallamountsl.setVisible(false);
        txtflamountsl.setVisible(false);
        txtthisinstallsl.setVisible(false);

    }

    @FXML
    void checkboxFullpayment(ActionEvent event) {
        //cbdeposl,cbflpaysl,cbinstallsl,cbchqsl,cbbdsl,cbcashsl;
        cbdeposl.setSelected(false);
        cbinstallsl.setSelected(false);
        txtflamountsl.setVisible(true);
        txtinitdepsl.setVisible(false);
        txtinstallnosl.setVisible(false);
        txtinstallamountsl.setVisible(false);
        txtthisinstallsl.setVisible(false);
        //cbbdsl.setSelected(false);
        //cbcashsl.setSelected(false);
        //cbdeposl.setSelected(false);
        //cbflpaysl.setSelected(false);
        // cbbdsl.setSelected(false);
        // cbchqsl.setSelected(false);

    }

    @FXML
    void checkboxInstallments(ActionEvent event) {
        cbdeposl.setSelected(false);
        cbflpaysl.setSelected(false);
        txtthisinstallsl.setVisible(true);
        txtflamountsl.setVisible(false);
        txtinitdepsl.setVisible(false);
        txtinstallnosl.setVisible(false);
        txtinstallamountsl.setVisible(false);
    }

    @FXML
    void modesOfPay(ActionEvent event) {

        if (event.getTarget().equals(cbchqsl)) {
            cbbdsl.setSelected(false);
            cbcashsl.setSelected(false);
        } else if (event.getTarget().equals(cbbdsl)) {
            cbchqsl.setSelected(false);
            cbcashsl.setSelected(false);
        } else {
            cbbdsl.setSelected(false);
            cbchqsl.setSelected(false);
        }
    }

    @FXML
    private ObservableList<AllSoldItems> itemsold;

    @FXML
    void checkItemsSold(ActionEvent event) throws Exception {
        spanalyse.toFront();
        tbviewitemsold.setVisible(true);
        tbviewdebts.setVisible(false);
        tbviewprofits.setVisible(false);
        txttataldebts.setVisible(false);
        txttotalprof.setVisible(false);
        lbanalysis.setVisible(false);
        tbviewcus.setVisible(false);

        //start here tommorrow
        try {
            Connection conn = DbConnector.getConnection();
            itemsold = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vehicle WHERE Status = 'sold' ");
            while (rs.next()) {
                itemsold.add(new AllSoldItems(rs.getString(1), rs.getString(4), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //setting cell value to tab view 
        tcbrandis.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tcmodelis.setCellValueFactory(new PropertyValueFactory<>("model"));
        tcyearis.setCellValueFactory(new PropertyValueFactory<>("year"));
        tcchassisis.setCellValueFactory(new PropertyValueFactory<>("chassis"));

        tbviewitemsold.setItems(null);
        tbviewitemsold.setItems(itemsold);

    }
    @FXML
    private ObservableList<OnCreditCustomer> debts;

    @FXML
    void checkingDebts(ActionEvent event) throws Exception {
        spanalyse.toFront();
        tbviewdebts.setVisible(true);
        tbviewitemsold.setVisible(false);
        tbviewprofits.setVisible(false);
        txttataldebts.setVisible(true);
        txttotalprof.setVisible(false);
        lbanalysis.setVisible(true);
        tbviewcus.setVisible(false);

        //here
        try {
            Connection conn = DbConnector.getConnection();
            debts = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer WHERE customerType = 'credit'");
            while (rs.next()) {
                debts.add(new OnCreditCustomer(rs.getString(2), rs.getString(3), rs.getInt(5), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //setting cell value to tab view 
        tcfnamedebt.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        tcsnamedebt.setCellValueFactory(new PropertyValueFactory<>("secondname"));
        tcvehicledebt.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
        tcpaiddebt.setCellValueFactory(new PropertyValueFactory<>("paid"));
        tcoutstandingdebt.setCellValueFactory(new PropertyValueFactory<>("outstanding"));

        tbviewdebts.setItems(null);
        tbviewdebts.setItems(debts);

        lbanalysis.setText(String.format("%d", Debts.totalDebts()));

    }
    @FXML
    private ObservableList<Profits> profits;

    @FXML
    void checkingProfits(ActionEvent event) throws Exception {
        spanalyse.toFront();
        tbviewprofits.setVisible(true);
        tbviewdebts.setVisible(false);
        tbviewitemsold.setVisible(false);
        txttataldebts.setVisible(false);
        txttotalprof.setVisible(true);
        lbanalysis.setVisible(true);
        tbviewcus.setVisible(false);

        try {
            Connection conn = DbConnector.getConnection();
            profits = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer WHERE customerType ='oneOff' ");
            while (rs.next()) {
                profits.add(new Profits(rs.getString(2), rs.getString(3), rs.getInt(5), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        lbanalysis.setText(String.format("%d", Profits.totalProfits()));

        //setting cell value to tab view 
        tcfnameprof.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcsnameprof.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tcvehicleprof.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
        tcpaidprof.setCellValueFactory(new PropertyValueFactory<>("paid"));

        tbviewprofits.setItems(null);
        tbviewprofits.setItems(profits);

    }

    //initializing  observable list 
    @FXML
    private ObservableList<CustomerDetails> data;
    private DbConnector dc;

    /*  @FXML
        void checkingCustomer(ActionEvent event){
            spanalyse.toFront();
            tbviewprofits.setVisible(false);
            tbviewdebts.setVisible(false);
            tbviewitemsold.setVisible(false);
            txttataldebts.setVisible(false);
            txttotalprof.setVisible(false);
            lbanalysis.setVisible(false);
            tbviewcus.setVisible(true);
            
        } */
    @FXML
    void logingOut(ActionEvent event) throws IOException {
        Parent rooot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene snup = new Scene(rooot);
        Stage snupstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        snupstage.setScene(snup);
        snupstage.show();
    }

    public String getCustomerName() {
        return txtfstnmsl.getText();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setHome();
        getCustomerName();
        dc = new DbConnector();
        setDate();

    }

    @FXML
    private void getCustomersFromDB(ActionEvent event) throws Exception {
        try {
            Connection conn = dc.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                data.add(new CustomerDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //hiding other items in gridpane
        spanalyse.toFront();
        tbviewprofits.setVisible(false);
        tbviewdebts.setVisible(false);
        tbviewitemsold.setVisible(false);
        txttataldebts.setVisible(false);
        txttotalprof.setVisible(false);
        lbanalysis.setVisible(false);
        tbviewcus.setVisible(true);
        //setting cell value to tab view 
        tcidcus.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcfnamecus.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcsnamecus.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tcphonecus.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcvehiclecus.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
        tctypecus.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcpaidcus.setCellValueFactory(new PropertyValueFactory<>("paid"));
        tcbalcus.setCellValueFactory(new PropertyValueFactory<>("balance"));

        tbviewcus.setItems(null);
        tbviewcus.setItems(data);

    }

}
