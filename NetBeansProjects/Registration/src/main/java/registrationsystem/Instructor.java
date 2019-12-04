/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Last_
 */
public class Instructor {
    private String firstName, lastName, address, city, zipCode;
    private int instructorId;
    private LocalDate dateOfRegistration, dateOfBirth;
    private List<String> subjectsToTeach = new ArrayList<String>();
    
    public Instructor(String fName, String lName, int instructorId, String address, String city, String zipCode, LocalDate dOR, LocalDate dOB) {
        firstName = fName;
        lastName = lName;
        this.instructorId = instructorId;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        dateOfRegistration = dOR;
        dateOfBirth = dOB;
    }
    
    // Setters
    public void addCourseToInstructorAbilities(String courseCode) {
        this.subjectsToTeach.add(courseCode);
    }
    
    public void addCourseToAbilities(String subject) {
        subjectsToTeach.add(subject);
    }
    
    public void changeAddress(String address, String city, String zipCode){
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public void setBirthday(LocalDate dOB){
        dateOfBirth = dOB;
    }
    
    // Getters
    public int getAgeInYears() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return age;
    }
    
    public int NoOfYearsAtCollege() {
        int workingYearsAtCollege = LocalDate.now().getYear() - dateOfRegistration.getYear();
        return workingYearsAtCollege;
    }
    
    public String getInstructorAddress(){
        return address;
    }
    
    public List<String> listOfSubjectsCertifiedToTeach() {
        return subjectsToTeach;
    }
    
    public boolean InstructorcanTeach(String subject){
        return subjectsToTeach.contains(subject);
    }
}
