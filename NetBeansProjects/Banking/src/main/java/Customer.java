
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class Customer {
    private String firstName, lastName, email, phoneNumber;
    private LocalDate dateOfBirth;
    /*
     * @param firstName
     * @param lastName
     */
    
    public Customer(String fName, String lName, LocalDate dOB, String email, String phNum){
        firstName = fName;
        lastName = lName;
        dateOfBirth = dOB;
        this.email = email;
        phoneNumber = phNum;
    }
    
    // Getters
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
