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
    private String orgNumber = ""; //Database: business/org_number

    public CustomerActions(String customerID, String name, String address, String phone, String email, String orgNumber) {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas. Koppla in den här när ni vill att systemet ska skapa en kund då kunden i förfrågan inte finns i systemet ännu.
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.orgNumber = orgNumber;
    }

    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns 
        this.customerID = customerID;
    }

    public void addCustomer(String name, String address, String phone, String email, String orgNumber) {

        if (Validation.validateName(name) && Validation.validateAddress(address)
                && Validation.validateEmailTypo(email) && Validation.validatePhone(phone)) {

            // Generera nytt customerID
            String id = Database.getAutoIncrement("customer", "cid");
            System.out.println("id innan insert " + id);

            // Kontrollera om id är null innan det används
            if (id != null) {
                // Förbered värden för infogning i databasen
                String values1 = "('" + id + "', '" + name + "', '" + address + "', '" + phone + "', '" + email + "');";
                String values2 = "('" + id + "', '" + orgNumber + "')";
                // Utför infogningen i databasen
                Database.insert("customer", "(cid, name, address, phone, email)", values1);

                JOptionPane.showMessageDialog(null, "En ny kund har blivit tillagd i systemet.");
                System.out.println(id + " " + values1);
                
                if(!orgNumber.equals(""))   {
                    if(Validation.existsCustomerID(id)){
                        
                        Database.insert("business_customer", "(cid, org_number)", values2);
                        
                        System.out.print("Added as a business customer ");
                        System.out.println(id + " " + values2);
                    }   else    {
                        System.out.println("Finns inget cid att placera org_number mot");
                    }
                }   else    {
                    System.out.println("Added as a private customer");
                }  
            } else {
                JOptionPane.showMessageDialog(null, "Misslyckades att generera CustomerID.");
                System.out.println(id);
            }
        } else {
            System.out.println("validering i addCustomer misslyckad");
        }
    }

    public void updateCustomer(String customerID, String name, String address, String phone, String email, String orgNumber, String fetchedOrgNumber) {

        String values1 = "('" + customerID + "', '" + orgNumber + "')";
        String empty = "";
        String preparedQuery = "UPDATE customer SET name = '" + name + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' WHERE cid = " + customerID;
        System.out.println(preparedQuery);
        boolean validOrgNr = false;
        
        try {
            int confirmUpdate1 = JOptionPane.showConfirmDialog(null, "Är du säker att du vill updatera kund", "Bekräfta ändering.", JOptionPane.YES_NO_OPTION);
            if (confirmUpdate1 == JOptionPane.YES_OPTION) {
             if(!name.isBlank() && !customerID.isBlank() && !address.isBlank() && !phone.isBlank() && !email.isBlank())    {
                Database.updatePreparedQuery(preparedQuery);
                JOptionPane.showMessageDialog(null, "Updatering av kund med ID: " + customerID + " lyckades.");
                System.out.println(customerID);
                
                if (Validation.validateOrgNumber(orgNumber) && !Validation.checkExistingCell("business_customer", "org_number", orgNumber)) {
                    validOrgNr = true;
                }
                
                //
                if(!orgNumber.equals(empty) && validOrgNr) {
                    // if org number exists
                    if (Validation.checkExistingCell("business_customer", "cid", customerID) && Validation.checkExistingCell("business_customer", "org_number", fetchedOrgNumber)) {
                        preparedQuery = "UPDATE business_customer SET org_number = '" + orgNumber + "' WHERE cid = '" + customerID + "'";
                        System.out.print(preparedQuery);
                        Database.updatePreparedQuery(preparedQuery);
                    } else  {
                        System.out.println("Could not update Organization Number 1");
                    }
                    
                    // if org number needs too be added
                    if (!Validation.checkExistingCell("business_customer", "cid", customerID) && !Validation.checkExistingCell("business_customer", "org_number", fetchedOrgNumber)) {
                        int confirmUpdate2 = JOptionPane.showConfirmDialog(null, "Kunden är en privat kund, är du säker att du vill lägga till organisationsnummer och göra om kunden till en företags kund?", "Bekräfta ändering.", JOptionPane.YES_NO_OPTION);
                            if (confirmUpdate2 == JOptionPane.YES_OPTION) {
                                if(Validation.existsCustomerID(customerID)){
                                    
                        
                                    Database.insert("business_customer", "(cid, org_number)", values1);
                        
                                    System.out.print("Added new org number");
                                    System.out.println(customerID + " " + values1);
                                }   else    {
                                System.out.println("Finns inget cid att placera org_number mot");
                                }
                            }   else {
                                System.out.println("fel i JOption");
                            }  
                    }   else    {
                    System.out.println("Could not update Organization Number 2");
                    }
                } else if(!orgNumber.equals(empty)) {
                    JOptionPane.showMessageDialog(null, "Organisations nummret finns redan.");
                }
                    // Om man vill ta bort ett existerande OrgNr
                    if(orgNumber.equals(empty) && Validation.checkExistingCell("business_customer", "org_number", fetchedOrgNumber) && Validation.checkExistingCell("business_customer", "cid", customerID)) {
                        int confirmUpdate3 = JOptionPane.showConfirmDialog(null, "Kunden är en företags kund, är du säker att du vill tabort organisationsnummer och göra om kunden till en privat kund?", "Bekräfta ändering.", JOptionPane.YES_NO_OPTION);
                        if (confirmUpdate3 == JOptionPane.YES_OPTION) {
                            Database.deleteRow("business_customer", "cid", customerID);         
                        } else {
                            System.out.println("fel i JOption");
                        }
                    } else {
                    System.out.println("fel i (orgNumber.equals(empty) && Validation.checkExistingCell(\"business_customer\", \"org_number\", orgNumber) && Validation.checkExistingCell(\"business_customer\", \"cid\", customerID))");
                    }
              }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ett fel Uppstod vid updatering av Kund information för kund med id: " + customerID + ".");
        }
    }

    public boolean removeCustomer(String customerID) {
        boolean valid = false;
        try {
            int confirmUpdate = JOptionPane.showConfirmDialog(null, "Är du säker att du vill ta bort kund", "Bekräfta.", JOptionPane.YES_NO_OPTION);
            if (confirmUpdate == JOptionPane.YES_OPTION) {
            //Om kunden är privatkund
            if (Validation.checkExistingCell("private_customer", "cid", customerID)) {
                Database.deleteRow("private_customer", "cid", customerID);
            } else if (Validation.checkExistingCell("business_customer", "cid", customerID)) {
                Database.deleteRow("business_customer", "cid", customerID);
            }

            
            //Loopar igenom ordrar tills alla är borta
            boolean orderHittade = false;
            while (!orderHittade) {
                if (Validation.checkExistingCell("xOrder", "customer", customerID)) {

                    String oid = Database.fetchSingle("oid", "xOrder", "customer", customerID);
                    System.out.println(oid);

                    if (Validation.checkExistingCell("order_consists_of_materials", "oid", oid)) {
                        Database.deleteRow("order_consists_of_materials", "oid", oid);
                    }

                    if (Validation.checkExistingCell("waybill", "oid", oid)) {
                        Database.deleteRow("waybill", "oid", oid);
                    }

                    
                    //Loopar igenom alla invoice
                    boolean invoiceHittade = false;
                    while (!invoiceHittade) {
                        if (Validation.checkExistingCell("invoice", "oid", oid)) {
                            String inid = Database.fetchSingle("inid", "invoice", "oid", oid);

                            if (Validation.checkExistingCell("accountant_access", "inid", inid)) {
                                Database.deleteRow("accountant_access", "inid", inid);
                            }

                            if (Validation.checkExistingCell("ordering_materials", "inid", inid)) {
                                Database.deleteRow("ordering_materials", "inid", inid);
                            }
                            Database.deleteRow("invoice", "oid", oid);

                        } else {
                            invoiceHittade = true;
                        }
                    }

                    Database.deleteRow("xOrder", "customer", customerID);
                } else {
                    orderHittade = true;
                }
            }
            
            //Loopar igenom alla requests
            boolean requestsHittade = false;
            while (!requestsHittade) {
                if (Validation.checkExistingCell("requests", "customer", customerID)) {
                    Database.deleteRow("requests", "customer", customerID);
                }
                else{
                    requestsHittade = true;
                }
                
            }

            Database.deleteRow("customer", "cid", customerID);
            System.out.println("Kund borttagen");
            valid = true;
            JOptionPane.showMessageDialog(null, "Kunden med kundID " + customerID + " har tagits bort.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ett fel uppstod med att ta bort kund.");
        }
        return valid;
    }

    public HashMap<String, String> getCustomer(String customerID) {

        String tableName = "customer";
        String columnWhere = "cid";
        String columnIdentifier = customerID; // Avgörs i gränsittet.
        HashMap<String, String> customer;

        customer = Database.fetchRow(tableName, columnWhere, columnIdentifier);
        return customer;

    }

    public String getOrgNumber(String customerID) {
        String columnName = "org_number";
        String tableName = "business_customer";
        String columnWhere = "cid";
        
        String customerOrgNumber = Database.fetchSingle(columnName, tableName, columnWhere, customerID);

        
        System.out.println(customerOrgNumber);
        return customerOrgNumber;
    }
    
    public void testMethod(String test1, String test2) {
        String testName = test1;
        String testEmail = test2;

        System.out.println(testName + " " + testEmail);
    }
}
