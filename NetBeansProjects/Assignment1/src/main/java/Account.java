
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Terry
 */
public class Account {
    // 
    private String firstName, lastName;
    private double balance = 0.0;
    private final String regex = "[a-z A-Z_]+";
    // setter methods
    public Account(String fname, String lname, double balance) {
        firstName = fname;
        lastName = lname;
        this.balance = balance;
    }
    
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
//        return ((str != null) && !str.equals("") && str.chars().allMatch(Character::isLetter));
        return str.matches(regex);
    }
    
    // toString is the string representation of the class
    @Override
    public String toString() {
        return ("FirstName:" + getfirstName() + " LastName:" + getlastName() + " Balance:" + getBalance());
    }
}