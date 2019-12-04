/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;

/**
 *
 * @author Last_
 */
public class Student {
    String firstName, lastName, address, city, zipCode, program;
    int studentNumber;
    LocalDate dateOfBirth, dateOfEnrollment;
    boolean isSuspended = false;
    
    public Student (String fName, String lName, String address, String city, String zCode, String program, int stuNumber, LocalDate dOE, LocalDate dOB){
        firstName = fName;
        lastName = lName;
        this.address = address;
        this.city = city;
        zipCode = zCode;
        this.program = program;
        studentNumber = stuNumber;
        dateOfBirth = dOB;
        dateOfEnrollment = dOE;
    }
    
    // Setters
    public void changeAddress(String address, String city, String zCode){
        this.address = address;
        this.city = city;
        zipCode = zCode;
    }
    
    public void suspendStudent(){
        isSuspended = true;
    }
    
    public void reinstateStudent(){
        isSuspended = false;
    }
    
    // Getters
    public int getStudentAge() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return age;
    }
    
    public String getStudentAddress(){
        return address;
    }
    
    public LocalDate getStudentBirthday(){
        return dateOfBirth;
    }
    
    public double getNoOfYearEnrolled(){
        return dateOfEnrollment.getYear();
    }
    
    public boolean StudentInGoodStanding(){
        return !isSuspended;
    }
}
