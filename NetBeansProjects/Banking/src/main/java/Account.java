/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class Account {
    // instance variables
    private String firstName, lastName, phoneNumber;
    private double balance = 0.0;
    private String accountType;
    private Customer customer;
    
    // constant
    private final String regex = "[a-z A-Z_]+";
    
    // constructor
    public Account(String fname, String lname, String phoneNumber, double balance) {
        firstName = fname;
        lastName = lname;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
    public Account(String accType, Customer cust, double blc) {
        accountType = accType;
        customer = cust;
        balance = blc;
    }
    
    // setter methods
    public void setfirstName(String fname) {
        if (!isLetterOnlyAlphabet(fname)) {
            throw new IllegalArgumentException("Please enter letters only!!");
        } else {
            firstName = fname;
        }
    }
    
    public void setlastName(String lname) {
        if (!isLetterOnlyAlphabet(lname)) {
            throw new IllegalArgumentException("Please enter letters only!!");
        } else {
            lastName = lname;
        }
    }
    
    public void deposit(double value) {
        balance += value;
    }
    
    public void withdrawal(double value) {
        balance -= value;
    }
    
    // getter methods
    public String getfirstName() {
        return firstName;
    }
    
    public String getlastName() {
        return lastName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // utility method to check if string is letters
    public boolean isLetterOnlyAlphabet(String str) {
        return str.matches(regex);
    }
    
    // toString is the string representation of the class
    @Override
    public String toString() {
        return ("FirstName:" + getfirstName() + " LastName:" + getlastName() + " Balance:" + getBalance());
    }
}
