/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;


/**
 *
 * @author Alexander & Carl
 */
public class CustomerActions {
    
    private String customerID = "";
    
    public CustomerActions() {
        //Koppling till databsen sker i konstruktorn där kunden ska skapas
    }
    
    public CustomerActions(String customerID) {
        //Koppling till databsen sker i konstruktorn med en kund som readan finns 
    }
    
    public void addCustomer() {
        
    
    
    System.out.println("Kund tillagd"); 
    }
    
    
    
    public void updateCustomer(){
      System.out.println("Kund updaterad");  
    }
    
    
    
    public void deleteCustomer() {
        System.out.println("Kund bortagen"); 
    }
    
    
    
    public String getCustomer() {
        System.out.println("Kund hämtad");
        return ("test lyckats");
    }
    
    public static void testMethod(String test1, String test2) {
        String testName = test1;
        String testEmail = test2;
        
        System.out.println(testName + " " + testEmail);
        
    }
    
}
