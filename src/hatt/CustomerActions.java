/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatt;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander & Carl
 */
public class CustomerActions {
    
    //private Fält
    
    public CustomerActions() {
        //Koppling till databsen sker i konstruktorn för att peka på den kunden man vill ha
    }
    
    
    private void addCustomer() {
        
    
    
    System.out.println("Kund tillagd"); 
    }
    
    
    
    private void updateCustomer(){
      System.out.println("Kund updaterad");  
    }
    
    
    
    private void deleteCustomer() {
        System.out.println("Kund bortagen"); 
    }
    
    
    
    private String getCustomer() {
        System.out.println("Kund hämtad");
        return ("test lyckats");
    }
    
    
}
