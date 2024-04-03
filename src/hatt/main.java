/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hatt;
import oru.inf.InfDB;
import oru.inf.InfException;

public class main {
    
    private static InfDB idb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
        try{
        System.out.println(idb.fetchRow("SELECT * FROM Kund"));
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
    }
    
}
