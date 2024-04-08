/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import javax.swing.JOptionPane;
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

    public boolean validateName(String name) {
        boolean valid = false;
        if (name.matches("[a-zA-Z ]+")) {
            valid = true;
        }
        return valid;
    }

    public boolean validateEmailTypo(String email) {
        boolean valid = false;
        String emailRegex = "^[a-zA-ZåäöÅÄÖ0-9._%+-]+@[a-zA-ZåäöÅÄÖ0-9-]+\\.[a-zA-ZåäöÅÄÖ]{2,6}$";
        if (!email.isEmpty()) {
            if (email.length() <= 50) {
                if (email.matches(emailRegex)) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Stavfel på email");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Var vänlig fyll i en email");
        }
        return valid;
    }
    
    public boolean validatePhone(String phone){
        boolean valid = false;
        if(!phone.isEmpty()){
            if(phone.matches("\\d{3}-\\d{7}")){
                valid = true;
            }
            if(!valid){
                JOptionPane.showMessageDialog(null, "Stavfel på telefonnummer");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Var vänlig och fyll i ett telefonnummer.");
        }
        return valid;
        
    }

}
