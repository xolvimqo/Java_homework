/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class PassArrayTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array1 = {10, 20, 30, 50, 80, 65, 100};
        System.out.println("Effect of passing reference to the entire array:" + "\nThe value of the original array.");
        for (int i = 0; i < array1.length; i++) {
        System.out.println(array1[i]);
        }
        PassArray psa = new PassArray();
        psa.doubleArrayElements(array1); // pass array reference
        System.out.println("The value of modified array is:");
        for (int j = 0; j < array1.length; j++) {
            System.out.println(array1[j]);
        }
        System.out.println("\n Effect of passing array element value" + "\n array1[2] before modify element "+ array1[2]);
        psa.modifyElement(array1[2]);
    }
    
}
