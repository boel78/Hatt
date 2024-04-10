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
    private Validation validation;

    public CustomerActions(String customerID, String name, String address, String phone, String email) {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas. Koppla in den här när ni vill att systemet ska skapa en kund då kunden i förfrågan inte finns i systemet ännu.
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        validation = new Validation();
        db = new Database();
    }

    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns 
        this.customerID = customerID;
        db = new Database();
    }

    public void addCustomer(String name, String address, String phone, String email) {
        Validation validation = new Validation();

        if (validation.validateName(name) && validation.validateAddress(address)
                && validation.validateEmailTypo(email) && validation.validatePhone(phone)) {

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

    public void updateCustomer(String customerID, String name, String address, String phone, String email) {

        String preparedQuery = ("UPDATE customer SET name = '" + name + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' WHERE cid = " + customerID);
        System.out.println(preparedQuery);
        try {
            db.updatePreparedQuery(preparedQuery);
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
                db.deleteRow("private_customer", "cid", customerID);
            } else if (Validation.checkExistingCell("business_customer", "cid", customerID)) {
                db.deleteRow("business_customer", "cid", customerID);
            }

            boolean orderHittade = false;
            while (!orderHittade) {
                if (Validation.checkExistingCell("xOrder", "customer", customerID)) {

                    String oid = db.fetchSingle("oid", "xOrder", "customer", customerID);
                    System.out.println(oid);

                    if (Validation.checkExistingCell("order_consists_of_materials", "oid", oid)) {
                        System.out.println("BAJS");
                        db.deleteRow("order_consists_of_materials", "oid", oid);
                    }

                    if (Validation.checkExistingCell("waybill", "oid", oid)) {
                        System.out.println("BAJS");
                        db.deleteRow("waybill", "oid", oid);
                    }

                    boolean invoiceHittade = false;
                    while (!invoiceHittade) {
                        if (Validation.checkExistingCell("invoice", "oid", oid)) {
                            System.out.println("HITTAR INVOICE");
                            String inid = db.fetchSingle("inid", "invoice", "oid", oid);

                            if (Validation.checkExistingCell("accountant_access", "inid", inid)) {
                                db.deleteRow("accountant_access", "inid", inid);
                            }

                            if (Validation.checkExistingCell("ordering_materials", "inid", inid)) {
                                db.deleteRow("ordering_materials", "inid", inid);
                            }
                            db.deleteRow("invoice", "oid", oid);

                        } else {
                            invoiceHittade = true;
                        }
                    }

                    db.deleteRow("xOrder", "customer", customerID);
                } else {
                    orderHittade = true;
                }
            }
            boolean requestsHittade = false;
            while (!requestsHittade) {
                if (Validation.checkExistingCell("requests", "customer", customerID)) {
                    db.deleteRow("requests", "customer", customerID);
                }
                else{
                    requestsHittade = true;
                }
                
            }

            db.deleteRow("customer", "cid", customerID);
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

        customer = db.fetchRow(tableName, columnWhere, columnIdentifier);
        return customer;

    }

    public void testMethod(String test1, String test2) {
        String testName = test1;
        String testEmail = test2;

        System.out.println(testName + " " + testEmail);
    }
}
