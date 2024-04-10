/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;

/**
 *
 * @author lukasdenfete
 */
public class Database {

    private InfDB idb;

    public Database() {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<String> getAllCustomerID() {
        ArrayList<String> customerIDList = new ArrayList<>();

        try {
            customerIDList = idb.fetchColumn("SELECT cid FROM customer");
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        return customerIDList;
    }

    public void main(String[] args) {
        new Database();
    }

    //columnName är kolumnnamnet på kolumnen du vill hämta ifrån, tableName är tabellnamnet, columnWhere är vilken kolumn ni har som "sökning" 
    //columnIdentifier är eran identifierare på sökningen, t.ex WHERE columnWhere = columnIdentifier
    public String fetchSingle(String columnName, String tableName, String columnWhere, String columnIdentifier) {
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE " + columnWhere + " = '" + columnIdentifier + "'";
        String response = "";
        try {
            response = idb.fetchSingle(query);
        } catch (InfException ex) {
            System.out.println(ex.getMessage());

        }
        return response;
    }

    //tableName är tabellnamnet
    //whereIdentifier är eran identifierare på sökningen, t.ex WHERE where = whereIdentifier
    public HashMap<String, String> fetchRow(String tableName, String where, String whereIdentifier) {
        String query = "SELECT * FROM " + tableName + " WHERE " + where + " = " + whereIdentifier;
        HashMap<String, String> response = new HashMap<String, String>();
        System.out.println(query);
        try {
            response = idb.fetchRow(query);
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ArrayList<HashMap<String, String>> fetchRows(boolean whereBool, String tableName, String where, String whereIdentifier) {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String query = "";
        if (whereBool) {
            query = "SELECT * FROM " + tableName + " WHERE " + where + " = " + whereIdentifier;
        } else {
            query = "SELECT * FROM " + tableName;
        }
        try {
            list = idb.fetchRows(query);
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
    //whereBool ska vara true om man vill ha med WHERE eller false om man inte vill
    //columnName är kolumnnamnet på kolumnen du vill hämta ifrån
    //tableName är tabellnamnet
    //whereIdentifier är eran identifierare på sökningen, t.ex WHERE where = whereIdentifier
    //Om whereIdentifier är varchar skriv med ' ' i parametern
    public ArrayList<String> fetchColumn(boolean whereBool, String columnName, String tableName, String where, String whereIdentifier) {
        ArrayList<String> response = new ArrayList<>();
        String query = "";
        if (whereBool) {
                query = "SELECT " + columnName + " FROM " + tableName + " WHERE " + where + " = " + whereIdentifier;
            } else{
                query = "SELECT " + columnName + " FROM " + tableName;
            }
        try {
          response = idb.fetchColumn(query);
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        return response;
    }

    // columns is "(column1, column2 etc)", values is "(value1, value2, etc)"
    public void insert(String tableName, String columns, String values) {
        String query = "INSERT INTO " + tableName + " " + columns + " VALUES " + values;
        try {
            idb.insert(query);
            System.out.println("Insert succesful");

        } catch (InfException ex) {
            ex.printStackTrace();
        }

    }

    //Ganska självförklarlig, tableName är tabellnamnet och columnName är kolumnnamnet
    //som du vill ha inkrement-id ifrån. 
    public String getAutoIncrement(String tableName, String columnName) {
        String id = "0";

        try {
            id = idb.getAutoIncrement(tableName, columnName);
        } catch (InfException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ett fel uppstod med att lägga till en ny kund.");
        }

        return id;
    }


}
