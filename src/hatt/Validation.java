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
import javax.swing.JTextField;
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
                JOptionPane.showMessageDialog(null, "Stavfel på telefonnummer\n Telefonnummer skrivs såhär: XXX-XXXXXXX");
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
}
