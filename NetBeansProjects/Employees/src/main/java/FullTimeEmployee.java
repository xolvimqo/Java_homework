
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
public class FullTimeEmployee extends Employee { // Single level inheritance
    private double ratePerHour, salary; // instance variables fof the FullTimeEmployee class
    
    // Constructor
    public FullTimeEmployee(String fName, String lName, String add, String phNo, String empId, LocalDate dOB, double rPerHour, double sal) {
        super(fName, lName, add, phNo, empId, dOB); // super keyword is used to initiate the super class arguments
        ratePerHour = rPerHour;
        salary = sal;
    }
}
