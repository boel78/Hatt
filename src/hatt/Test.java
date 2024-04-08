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
        System.out.println(idb.fetchRow("SELECT * FROM customer"));
        System.out.println("Test lyckades!");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
        new CreateOrderExistingCustomer(idb).setVisible(true);
    }
    //public void hej då{
        
    }
    
