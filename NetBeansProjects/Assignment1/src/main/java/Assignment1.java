/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radhika
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int marks = 0, tests = 0, low = 1, high = 8, medium = 4;
        //Above are test variable you do not need to declare those variables
        
        /******************************************************/
        /*    I will manually add marks to display your name and student no.*/
        System.out.println("~~TEST 1~~");
        System.out.println("Display your name and Student No. here: Terry Gu, 200410610");
        
        /*****************************************************/ 
         System.out.println("TEST 2: Must use toString method to display the values of all the varibales in exact format given in expected result");
        System.out.println("Expected result: FirstName:Jane LastName:Green Balance: 50.0");
        Account acc1 = new Account("Jane", "Green", 50.0);
        System.out.println("Actual result:" + acc1.toString());
        if (acc1.toString().equals("FirstName:Jane LastName:Green Balance:50.0")) {
            marks += high;
            tests++;
            System.out.println("TEST 2 PASSED!!");

        } else {
            System.out.println("TEST 2 FAILED");
        }

       
        /***********************************************/
        System.out.println("Test 3: Testing getter methods.");
        if (acc1.getfirstName().equals("Jane") && acc1.getlastName().equals("Green") && acc1.getBalance() == 50.0) 
        {
            marks += medium;
            tests++;
            System.out.println("TEST 3 PASSED!!");

        } else 
        {
            System.out.println("TEST 3 FAILED");
        }
        
        
        /***************************************************/
        System.out.println("Test 4: Positive testing setter methods .");
        acc1.setfirstName("Anita");
        acc1.setlastName("Knapp");
        acc1.deposit(35.0);
        if (acc1.getfirstName().equals("Anita") && acc1.getlastName().equals("Knapp") && acc1.getBalance() == 85.0) {
            marks += low;
            tests++;
            System.out.println("TEST 4 PASSED!!");
        } else 
        {
            System.out.println("TEST 4 FAILED");
        }
        
        
        
        /*********************************************/
        System.out.println("Test 5: Negative testing setter methods, for all the set methods.");

        // This try-catch is for first name: 
        try {
            acc1.setfirstName("1235");
        } catch (IllegalArgumentException ex) {
            marks += medium;
            tests++;
            System.out.println("TEST 5a PASSED");
                    }
    
        // This try-catch is for last name: 
        try {
            acc1.setlastName("1235");
        } catch (IllegalArgumentException ex) {
            marks += medium;
            tests++;
            System.out.println("TEST 5b PASSED");
        }
        
        // This try-catch is for first name: 
        try {
            acc1.deposit(-20);
        } catch (IllegalArgumentException ex) {
            marks += medium;
            tests++;
            System.out.println("TEST 5c PASSED:");
        }
        
        
        /*************************************************/
        System.out.println("Total tests passed:" + tests + "\n"
                + "total marks scored:" + marks);
    }

}