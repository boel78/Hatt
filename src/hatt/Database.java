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

    private static InfDB idb;

    public Database() {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> getAllCustomerID() {
        ArrayList<String> customerIDList = new ArrayList<>();

        try {
            customerIDList = idb.fetchColumn("SELECT cid FROM customer");
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        return customerIDList;
    }

    public static void main(String[] args) {
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
    
    //columnName är kolumnnamnet på kolumnen du vill hämta ifrån
    //tableName är tabellnamnet
    //withWhereStatement ska vara true om man vill ha med WHERE eller false om man inte vill
    //whereIdentifier är eran identifierare på sökningen, t.ex WHERE where = whereIdentifier
    //whereIdentifierIsString ska vara true om identifieraren är en String/varchar annars false
    public static ArrayList<String> fetchColumn(String columnName, String tableName, boolean withWhereStatement, String where, String whereIdentifier, boolean whereIdentifierIsString) {
        ArrayList<String> response = new ArrayList<String>();

        String whereAndStringQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE " + where + " = '" + whereIdentifier + "'";
        String whereNotStringQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE " + where + " = " + whereIdentifier;
        String noWhereQuery = "SELECT " + columnName + " FROM " + tableName;
        try {
            if (withWhereStatement && whereIdentifierIsString) {
                response = idb.fetchColumn(whereAndStringQuery);
            } else if (withWhereStatement && !whereIdentifierIsString) {
                response = idb.fetchColumn(whereNotStringQuery);
            } else {
                response = idb.fetchColumn(noWhereQuery);
            }

        } catch (InfException ex) {
            ex.printStackTrace();
        }

        return response;
    }
}
