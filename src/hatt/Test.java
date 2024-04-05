package hatt;

import oru.inf.InfDB;
import oru.inf.InfException;

public class Test {
    
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
        System.out.println("Test lyckades!");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
    }
    //public void hej då{
        
    }
    
