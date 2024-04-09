/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author lukasdenfete
 */
public class Validation {

    private Database db;

    public Validation() {
        db = new Database();
    }

    public static boolean validateName(String name) {
        boolean valid = false;
        if (name.matches("[a-zA-Z ]+")) {
            valid = true;
        }
        return valid;
    }

    public static boolean validateEmailTypo(String email) {
        boolean valid = false;
        String emailRegex = "^[a-zA-ZåäöÅÄÖ0-9._%+-]+@[a-zA-ZåäöÅÄÖ0-9-]+\\.[a-zA-ZåäöÅÄÖ]{2,6}$";
        if (!email.isEmpty()) {
            if (email.length() <= 50) {
                if (email.matches(emailRegex)) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Email cannot be longer than 50 characters");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email cannot be empty");
        }
        return valid;
    }

    public static boolean validatePhone(String phone) {
        boolean valid = false;
        if (!phone.isEmpty()) {
            if (phone.matches("\\d{3}-\\d{7}")) {
                valid = true;
            }
            if (!valid) {
                JOptionPane.showMessageDialog(null, "Stavfel på telefonnummer");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Var vänlig och fyll i ett telefonnummer.");
        }
        return valid;

    }

    public static boolean txtHasValue(JTextField txt) {
        boolean valid = true;
        if (txt.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(null, "Var vänlig fyll i alla rutor!");
            txt.requestFocus();
        }
        return valid;
    }

    public static boolean existsCustomerID(String customerID) {
        ArrayList<String> customerIDs = Database.getAllCustomerID();
        return customerIDs.contains(customerID);
    }

    public static boolean validateCustomerID(String customerID) {
        boolean valid = false;
        // Check if customerID only contains digits
        if (customerID.matches("\\d+")) {

            if (!existsCustomerID(customerID)) {
                valid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Customer ID already exists");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer ID must be a numeric value");
        }
        return valid;
    }

    public static boolean validateAddress(String address) {
        boolean valid = address.matches(".*\\d.*") && address.matches(".*[a-zA-Z].*");
        return valid;
    }

    public boolean checkExistingCell(String tableName, String columnName, String keyWord) {
        boolean exists = false;
        String query = "SELECT * FROM " + tableName;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        list = db.fetchRows(false, tableName, columnName, keyWord);

        for (HashMap<String, String> column : list) {
            for (String key : column.keySet()) {
                if (key.equals(columnName)) {
                    if (column.get(key).equals(keyWord)) {
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }

    public boolean isDouble(String input) {
        boolean b = false;
        try {
            Double.parseDouble(input);
            b = true;
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return b;
    }
    
     //SKA IN I MAIN BRANCHEN
    //Kollar om material finns 
    public static boolean doesMaterialExist(ArrayList<String> list) {
        boolean exists = false;

       /* for (String tf : list) {
            if (tf.isEmpty()) {
                list.remove(tf);
            }
        }
*/
        ArrayList<String> materials = Database.fetchColumn(false, "name", "materials", "", "");
        for (String tf : list) {
            for (String name : materials) {
                if (name.equalsIgnoreCase(tf)) {
                    exists = true;
                    break;
                }
            }
        }
        if (!exists) {
            JOptionPane.showMessageDialog(null, "Vänligen skriv in ett existerande material!");
        }
        return exists;
    }
    
    //SKA IN I MAIN BRANCHEN
    //Validerar två fält och om någon utav de är tomma så kommer errormeddelande för createOrder
    public static boolean hasValueTwoFields(JTextField tf1, JTextField tf2) {

        boolean hasValue = true;
        if (!tf1.getText().isEmpty() && tf2.getText().isEmpty()) {
            hasValue = false;
            JOptionPane.showMessageDialog(null, "OBS alla inskrivna accessoarer/tyger måste ha antal/storlek!");
        } else if (tf1.getText().isEmpty() && !tf2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "OBS alla inskrivna accessoarer/tyger måste ha antal/storlek!");
            hasValue = false;
        }
        return hasValue;
    }
    
    //Validerar fält i createOrder då vissa fält kan vara tomma
    public static boolean hasValueMandatory(JTextField tf){
        boolean hasValue = true;
        if(tf.getText().isEmpty()){
            hasValue = false;
            JOptionPane.showMessageDialog(null, "Vänligen fyll i obligatoriska rutor!");
        }
               
        return hasValue;
    }
    
    //Validerar fältet för description i createOrder
    public static boolean validateDescription(JTextField tf){
        boolean correctLength = true;
        if(tf.getText().length()>50){
            correctLength = false;
            JOptionPane.showMessageDialog(null, "Vänligen ange max 50 tecken!");
        }
        return correctLength;
    }
    
    //Validerar fältet för estimated time i createOrder
    public static boolean validateEstimatedTime(JTextField tf){
        boolean b = false;
        try {
            Double.parseDouble(tf.getText());
            b = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett tal. Vid decimaler använd . för att skilja");

        }
        return b;
    }
    //Kollar om det man skriver in är ett tyg
    //Kan gå att göra till en gemensam med isMaterialAccessories
    public static boolean isMaterialFabric(JTextField tf){
        
        boolean isFabric = false;
        ArrayList<String> fabrics = Database.fetchColumn(true, "name", "materials", "mid","IN (SELECT mid FROM fabric)");
        for(String name : fabrics){
            if(name.equalsIgnoreCase(tf.getText())){
                isFabric = true;
                break;
            }
        }
        if(!isFabric){
                JOptionPane.showMessageDialog(null, "Vänligen skriv in ett tyg");
            }
        return isFabric;
    }
    
    //Kollar om det man skriver in är en accessoar
    //Kan gå att göra till en gemensam med isMaterialFabric
    public static boolean isMaterialAccesories(JTextField tf){
        
        boolean isAccessory = false;
        ArrayList<String> accessories = Database.fetchColumn(true, "name", "materials", "mid","IN (SELECT mid FROM accessories)");
        for(String name : accessories){
            if(name.equalsIgnoreCase(tf.getText())){
                isAccessory = true;
                break;
            }
        }
        if(!isAccessory){
            JOptionPane.showMessageDialog(null, "Vänligen skriv in en accessoar");
        }
        return isAccessory;
    }

}
