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

    public CustomerActions(String customerID, String name, String address, String phone, String email) {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas. Koppla in den här när ni vill att systemet ska skapa en kund då kunden i förfrågan inte finns i systemet ännu.
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns
        this.customerID = customerID;
    }

    public void addCustomer(String name, String address, String phone, String email) {

        if (Validation.validateName(name) && Validation.validateAddress(address)
                && Validation.validateEmailTypo(email) && Validation.validatePhone(phone)) {

            // Generera nytt customerID
            String id = Database.getAutoIncrement("customer", "cid");
            System.out.println("id innan inser " + id);

            // Kontrollera om id är null innan det används
            if (id != null) {
                // Förbered värden för infogning i databasen
                String values = "('" + id + "', '" + name + "', '" + address + "', '" + phone + "', '" + email + "');";

                // Utför infogningen i databasen
                Database.insert("customer", "(cid, name, address, phone, email)", values);

                JOptionPane.showMessageDialog(null, "En ny kund har blivit tillagd i systemet.");
                System.out.println(id + " " + values);
            } else {
                JOptionPane.showMessageDialog(null, "Misslyckades att generera CustomerID.");
                System.out.println(id);
            }
        }
    }

    public void updateCustomer(String customerID, String name, String address, String phone, String email) {

        String preparedQuery = ("UPDATE customer SET name = '" + name + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' WHERE cid = " + customerID);
        System.out.println(preparedQuery);
        try {
            Database.updatePreparedQuery(preparedQuery);
            JOptionPane.showMessageDialog(null, "Updatering av kund med ID: " + customerID + " lyckades.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ett fel Uppstod vid updatering av Kund information för kund med id: " + customerID + ".");
        }
    }

    public boolean removeCustomer(String customerID) {

        boolean valid = false;
        try {
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
                    Database.updatePreparedQuery("UPDATE xOrder SET customer=null where customer= " + customerID);

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

    public void testMethod(String test1, String test2) {
        String testName = test1;
        String testEmail = test2;

        System.out.println(testName + " " + testEmail);
    }
}
