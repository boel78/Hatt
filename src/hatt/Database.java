/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author lukasdenfete
 */
public class Database {
    private InfDB idb;
    
    public Database(){
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
    }
   
// Metod som hämtar allt ur customer databasen eller specifik column. Inte ett ensamt värde
    public ArrayList<String> getCustomerColumns(String columns, String condition)    {
        //String column: column namn som man vill få ut data ifrån ex. *, name eller email.
        //String condition: (column där man vill granska vilkor) = '(värdet man vill hitta)'
        
        ArrayList<String> customers = new ArrayList<>();
        String query = "Select " + columns + " From Customer;";
        
        if (columns != null && !condition.isEmpty())  {
            query += " Where" + condition + "";
        }
        try {
            customers = idb.fetchColumn(query);
        }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        return customers;
    }

    // Metod som hämtar ett enskilt värde från kundtabellen 
    public String getCustomerSingle(String columns, String condition)    {
        //String column: column namn som man vill få ut data ifrån ex. *, name eller email.
        //String condition: (column där man vill granska vilkor) = '(värdet man vill hitta)'
        
        String customerValue = "";
        String query = "Select " + columns + " From Customer;";
        
        if (columns != null && !condition.isEmpty())  {
            query += " Where" + condition + "";
        }
        try {
            customerValue = idb.fetchSingle(query);
        }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        return customerValue;
    }   
}