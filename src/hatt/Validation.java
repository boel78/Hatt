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


    public Validation() {

    }

    public static boolean validateName(String name) {
        boolean valid = false;
        if (name.matches("[a-zA-ZåäöÅÄÖ]+\\s?+[a-zA-ZåäöÅÄÖ]+")) {
            System.out.println("NAMN OK");
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
                JOptionPane.showMessageDialog(null, "Stavfel på telefonnummer\nTelefonnummer skrivs såhär:\nXXX-XXXXXXX");
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
        boolean valid = address.matches(".*\\d*");
        return valid;
    }

    public static boolean checkExistingCell(String tableName, String columnName, String keyWord) {
        boolean exists = false;
        String query = "SELECT * FROM " + tableName;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        list = Database.fetchRows(false, tableName, columnName, keyWord);

        for (HashMap<String, String> column : list) {
            for (String key : column.keySet()) {
                if (key.equals(columnName)) {
                    if(column.get(key) == null){

                    }
                    else if (column.get(key).equals(keyWord)) {
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }

        public static void main(String[] args) {
        new Validation();
    }

    public static boolean isDouble(String input) {
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

    //Kollar om accessoar arraylisten är tom och då söker den inte mot databasens material då en hatt inte måste ha en accessoar
    //Använder valideringsmetoden doesAccessoryExist
        public static boolean accessoryValidation(ArrayList<String> accessories) {
        boolean accessoriesNotEmpty = false;
        boolean accessoryExists = true;
        for (String accessory : accessories) {
            if (!accessory.isEmpty()) {
                accessoriesNotEmpty = true;
                break;
            }
        }
        if (accessoriesNotEmpty) {
            if(!doesAccessoryExist(accessories)){
                accessoryExists = false;
        }
    }
        return accessoryExists;
    }

     //Kollar om fabric finns i databasen med hjälp av doesFabricExist
     //Kan gå att ta bort och bara använda doesFabricExist
    public static boolean fabricValidation(ArrayList<String> fabrics) {
       boolean exists = false;
       if(doesFabricExist(fabrics)){
           exists = true;
       }
       return exists;
    }

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
            JOptionPane.showMessageDialog(null, "Beskrivning kan max ha 50 tecken!");
        }
        return correctLength;
    }
    
    //Validerar fältet för description i createOrder
    public static boolean validateDescription200(JTextField tf){
        boolean correctLength = true;
        if(tf.getText().length()>200){
            correctLength = false;
            JOptionPane.showMessageDialog(null, "Beskrivning kan max ha 200 tecken!");
        }
        return correctLength;
    }

    //Validerar fältet för estimated time i createOrder
    //Kan ersättas av isDouble metoden men då måste det komma upp ett felmeddelande som här
    public static boolean isDoubleErrorMessage(JTextField tf){
        boolean b = false;
        try {
            Double.parseDouble(tf.getText());
            b = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett tal. Vid decimaler använd . för att skilja");

        }
        return b;
    }

    //Kollar om ett fält är av double om den inte är tom
    //Om den inte är tom och inte är double så kallar man på metoden isDoubleErrorMessage
    public static boolean isDoubleIfNotEmpty(JTextField tf){
        boolean isEmpty = false;

        if(tf.getText().isEmpty()){
            isEmpty = true;
        }else if (isDoubleErrorMessage(tf)) {
            isEmpty = true;
        }
            return isEmpty;
    }

    //Kollar om det man skriver in är ett befintligt tyg i databasen
    public static boolean doesFabricExist(ArrayList<String> fabrics) {
        boolean exists = false;
        ArrayList<String> fabricsDb = Database.fetchColumn(false, "name", "materials WHERE mid IN (SELECT mid FROM fabric)", "", "");
        for (String tf : fabrics) {
            exists = false;
            for (String name : fabricsDb) {
                if (name.equalsIgnoreCase(tf)) {
                    exists = true;
                }
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "Vänligen skriv in ett existerande tyg!");
                break;
            }
        }
        return exists;
    }

    //Kollar om det man skriver in är en befintlig accessoar i databasen
    public static boolean doesAccessoryExist(ArrayList<String> accessories) {
        boolean exists = false;
        ArrayList<String> accessoriesDb = Database.fetchColumn(false, "name", "materials WHERE mid IN (SELECT mid FROM accessories)", "", "");
        for (String tf : accessories) {
            exists = false;
            for (String name : accessoriesDb) {
                if (name.equalsIgnoreCase(tf)) {
                    exists = true;
                }
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "Vänligen skriv in en existerande accessoar!");
                break;
            }
        }
        return exists;
    }

        // Valideringsmetod för organisationsnummer
    public static boolean validateOrgNumber(String orgNumber) {
        // Kontrollera om strängen är null eller om den inte har rätt längd för ett organisationsnummer
        if (orgNumber == null || orgNumber.length() != 11) {
            return false;
        }

        // Kontrollera om de första sex tecknen är siffror
        for (int i = 0; i < 6; i++) {
            if (!Character.isDigit(orgNumber.charAt(i))) {
                return false;
            }
        }

        // Kontrollera om det sjunde tecknet är ett bindestreck
        if (orgNumber.charAt(6) != '-') {
            return false;
        }

        // Kontrollera om de sista fyra tecknen är siffror
        for (int i = 7; i < 11; i++) {
            if (!Character.isDigit(orgNumber.charAt(i))) {
                return false;
            }
        }

        // Om alla kontroller passerar, returnera true
        return true;
    }
}
