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
        
        /*
        *   String column: column namn som man vill få ut data ifrån ex. *, name eller email.
        *   ex. Om du vill hämta alla kolumner: "*"
        *   Om du vill hämta kolumnen för kundnamn: "name"
        *   Om du vill hämta kolumnen för kundens e-postadress: "email"
        *   
        *   String condition: Här ska du ange ett villkor som specificerar vilka rader som ska hämtas från databastabellen.
        *   Det måste formateras på detta sätt i parametern. "(Kolumn) = '(värde)'
        *   Där du ersätter (kolumn) med namnet på kolumnen du vill granska ditt vilkor emot.
        *   och (värde) mot det värdet du vill ha i vilkoret.
        *   Ex. på parameter värden för String condition: 
        *   "CID = '1'"
        *   Det här värdet kan vara null eller tom sträng vilket ger inget vilkor i SQL frågan.
        */
        
        ArrayList<String> customers = new ArrayList<>();
        String query = "Select " + columns + " From Customer;";
        
        if (columns != null && !condition.isEmpty())  {
            query += " Where " + condition + ";";
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
        
        
        /*
        *   String column: column namn som man vill få ut data ifrån ex. *, name eller email.
        *   ex. Om du vill hämta alla kolumner: "*"
        *   Om du vill hämta kolumnen för kundnamn: "name"
        *   Om du vill hämta kolumnen för kundens e-postadress: "email"
        *   
        *   String condition: Här ska du ange ett villkor som specificerar vilka rader som ska hämtas från databastabellen.
        *   Det måste formateras på detta sätt i parametern. "(Kolumn) = '(värde)'
        *   Där du ersätter (kolumn) med namnet på kolumnen du vill granska ditt vilkor emot.
        *   och (värde) mot det värdet du vill ha i vilkoret.
        *   Ex. på parameter värden för String condition: 
        *   "CID = '1'"
        *   Det här värdet kan vara null eller tom sträng vilket ger inget vilkor i SQL frågan.
        */
        
        String customerValue = "";
        String query = "Select " + columns + " From Customer;";
        
        if (condition != null && !condition.isEmpty())  {
            query += " Where " + condition + ";";
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