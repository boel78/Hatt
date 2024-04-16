/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package hatt;

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

    public int addNumbers(String[] numbers) {
        int result = 0;

        for (String i : numbers) {
            int j = Integer.valueOf(i);
            result += j;
        }

        return result;
    }

}
