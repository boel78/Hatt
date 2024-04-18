/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package hatt;

import java.util.ArrayList;

/**
 *
 * @author joakimfockstedt
 */
public class Calculate {

    public Calculate() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    public double addNumbers(ArrayList<String> numbers) {
        double result = 0;

        for (String i : numbers) {
            double j = Double.valueOf(i);
            result += j;
        }

        return round(result, 3);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    public String calculateMoms(String input){
        Double dinput = Double.parseDouble(input);
        Double exmoms = (dinput*0.75);
        Double rounded = round(exmoms, 3);
        String output = rounded.toString();
        
        return output;
        
    
    
    }

}
