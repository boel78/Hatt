/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    
    public void fetchRows(boolean whereBool, String table, String whereColumn, String value) {

        try {
            if (whereBool) {
                String query1 = "SELECT * FROM " + table + " WHERE " + whereColumn + " = " + value;
                ArrayList<HashMap<String, String>> rows1;
                rows1 = idb.fetchRows(query1);
            } else {
                String query2 = "SELECT * FROM " + table;
                ArrayList<HashMap<String, String>> rows2;
                rows2 = idb.fetchRows(query2);
            }

        } catch (InfException ex) {
            ex.printStackTrace();
        }
    }
   

}