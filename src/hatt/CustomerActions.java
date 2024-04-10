    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;
import oru.inf.InfDB;


/**
 *
 * @author Alexander & Carl
 */
public class CustomerActions {
    
    private String customerID = ""; //Database: customer/cid
    private String name = ""; //Database: customer/name
    private String address = ""; //Database: customer/address
    private String phone = ""; //Database: customer/phone
    private String email = ""; //Database: customer/email
    // private String orgNumber = ""; //Database: business/org_number
    private static Database db;
    private static InfDB idb;
    
    
public CustomerActions(String customerID, String name, String address, String phone, String email) {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas. Koppla in den här när ni vill att systemet ska skapa en kund då kunden i förfrågan inte finns i systemet ännu.
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        db = new Database();
        
    }
    
    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns 
        this.customerID = customerID;
            db = new Database();
    }
    
public void addCustomer(String name, String address, String phone, String email) {
    Validation validation = new Validation();


        if (validation.validateName(name) && validation.validateAddress(address) &&
            validation.validateEmailTypo(email) && validation.validatePhone(phone)) {

            // Generera nytt customerID
            String id = db.getAutoIncrement("customer", "cid");
            System.out.println("id innan inser " + id);

            // Kontrollera om id är null innan det används
            if (id != null) {
                // Förbered värden för infogning i databasen
                String values = "('" + id + "', '" + name + "', '" + address + "', '" + phone + "', '" + email + "');";

                // Utför infogningen i databasen
                db.insert("customer", "(cid, name, address, phone, email)", values);

                JOptionPane.showMessageDialog(null, "En ny kund har blivit tillagd i systemet.");
                System.out.println(id + " " + values);
            } else {
                JOptionPane.showMessageDialog(null, "Misslyckades att generera CustomerID.");
                System.out.println(id);
            }
        }
}

        
    public void updateCustomer(){
      System.out.println("Kund updaterad");  
    }
    
    
    public boolean removeCustomer(String customerID) {
        boolean valid = false;
        try {
        String query = "DELETE FROM customer WHERE cid = '" + customerID + "'";
        idb.delete(query);
        
        System.out.println("Kund borttagen");
        } 
        catch (InfException ex) {
            ex.printStackTrace();
        
            return valid
        }
    }
        
    
    public HashMap<String, String> getCustomer(String customerID) { 
        
        String tableName = "customer";
        String columnWhere = "cid";
        String columnIdentifier = customerID; // Avgörs i gränsittet.
        HashMap<String, String> customer;
        
        customer = db.fetchRow(tableName, columnWhere, columnIdentifier);
        return customer;
        
    }
    
    public void testMethod(String test1, String test2) {
        String testName = test1;
        String testEmail = test2;
        
        System.out.println(testName + " " + testEmail);
    }
}
