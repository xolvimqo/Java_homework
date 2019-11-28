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
 * @author Yu-Ming(Terry) Gu
 * @StudentNumber 200410610
 * @Description: Represents a instructor who teaches in the school
 */
public class Instructor {
    // variables
    private String firstName, lastName, address, city, zipCode;
    private int instructorId;
    private LocalDate dateOfRegistration, dateOfBirth;
    private List<String> subjectsToTeach = new ArrayList<String>();
    
    // constructor
    public Instructor(String fName, String lName, int instructorId, String address, String city, String zipCode, LocalDate dOR, LocalDate dOB) {
        firstName = fName;
        lastName = lName;
        this.instructorId = instructorId;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        dateOfRegistration = dOR;
        dateOfBirth = dOB;
        
        // throw error if has an invalid hire date
        if ((LocalDate.now().getYear() - dOR.getYear()) > 80){
            throw new IllegalArgumentException( dOR.toString() + " as a hire date would mean Anita started working over 80 years ago");
        }
        // throw error if age over 100
        if (getAgeInYears() > 100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
    }
    
    // Setters
    // add courses that instructor can teach
    public void addCourseToInstructorAbilities(String courseCode) {
        if (!subjectsToTeach.contains(courseCode)){
            this.subjectsToTeach.add(courseCode);
        }
    }
    
    // add courses that instructor can teach
    public void addCourseToAbilities(String subject) {
        subjectsToTeach.add(subject);
    }
    
    // sets address
    public void changeAddress(String address, String city, String zipCode){
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    // set birth day of instructor
    public void setBirthday(LocalDate dOB){
        dateOfBirth = dOB;
    }
    
    // Getters
    // get age of instructor
    public int getAgeInYears() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        if (LocalDate.now().getMonthValue() < dateOfBirth.getMonthValue()){
            age--;
        } else if (LocalDate.now().getMonthValue() == dateOfBirth.getMonthValue()){
            if (LocalDate.now().getDayOfMonth() < dateOfBirth.getDayOfMonth()) {
                age--;
            }
        }
        return age;
    }
    
    // gets working years at college
    public int NoOfYearsAtCollege() {
        int workingYearsAtCollege = LocalDate.now().getYear() - dateOfRegistration.getYear();
        return workingYearsAtCollege;
    }
    
    // gets address of instructor
    public String getInstructorAddress(){
        return address + ", " + city + ", " + zipCode;
    }
    
    // return list of subjects that instructor is certified to teach
    public String listOfSubjectsCertifiedToTeach() {
        String str = "[";
        if (subjectsToTeach.size() > 0 ){
            for (int i = 0; i < subjectsToTeach.size(); i++){
                str += subjectsToTeach.get(i);
                if (i + 1 < subjectsToTeach.size()) {
                    str += ", ";
                } else {
                    str += "]";
                }
            }
        } else {
            str = "not qualified to teach courses yet.";
        }
        return str;
    }
    
    // checks if instructor can teach the subject
    public boolean InstructorcanTeach(String subject){
        return subjectsToTeach.contains(subject);
    }
    
    // gets first name
    public String getFirstName(){
        return firstName;
    }
    
    // gets last name
    public String getLastName(){
        return lastName;
    }
    
    // return full name
    public String getFullName(){
        String fullName = this.getFirstName() + " " + this.getLastName();
        return fullName;
    }
    
    // return full name
    public String toString(){
        return getFullName();
    }
}
