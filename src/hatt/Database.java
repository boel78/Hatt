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
    private static InfDB idb;
    
    public Database(){
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }

    }
    
    public static ArrayList<String> getAllCustomerID(){
        ArrayList<String> customerIDList = new ArrayList<>(); 
        
        try
        {
            customerIDList = idb.fetchColumn("SELECT cid FROM customer");
        }
        catch (InfException ex)
        {
            ex.printStackTrace();
        }
        
        return customerIDList;
    }
    
    public static void main(String[] args){
        new Database();
    }
   
    public static ArrayList<String> getAllCustomerID(){
        ArrayList<String> customerIDList = new ArrayList<>(); 
        
        try
        {
            customerIDList = idb.fetchColumn("SELECT cid FROM customer");
        }
        catch (InfException ex)
        {
            ex.printStackTrace();
        }
        
        return customerIDList;
    }
    
    public static void main(String[] args){
        new Database();
    }
    
}