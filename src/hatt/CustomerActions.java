    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.HashMap;


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
    private Database db;
    
    
    
public CustomerActions(String customerID, String name, String address, String phone, String email) {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas. Koppla in den här när ni vill att systemet ska skapa en kund då kunden i förfrågan inte finns i systemet ännu.
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        
        db = new Database();
        
        initializeAddCustomer();
    }
    
    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns 
        this.customerID = customerID;
    }
    
    private void initializeAddCustomer() {
        addCustomer(customerID, name, address, phone, email);
    }
    
    public void addCustomer(String customerID, String name, String address, String phone, String email) {
        
    
    
    System.out.println("Kund tillagd"); 
    }
     
    public void updateCustomer(){
      System.out.println("Kund updaterad");  
    }
    
    public void deleteCustomer() {
        System.out.println("Kund bortagen"); 
    }
    
    public HashMap<String, String> getCustomer(String customerID) { 
        String tableName = "Customer";
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
