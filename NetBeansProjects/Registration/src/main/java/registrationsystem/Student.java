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
 * @Description: Represents a student enrolled in the school
 */
public class Student {
    // variables
    String firstName, lastName, address, city, zipCode, program;
    int studentNumber;
    LocalDate dateOfBirth, dateOfEnrollment;
    boolean isSuspended = false;
    private List<Course> completedCourses = new ArrayList<Course>();
    private List<Integer> grades = new ArrayList<Integer>();
    
    // constructor
    public Student (String fName, String lName, String address, String city, String zCode, String program, int stuNumber, LocalDate dOE, LocalDate dOB){
        firstName = fName;
        lastName = lName;
        this.address = address;
        this.city = city;
        zipCode = zCode;
        this.program = program;
        studentNumber = stuNumber;
        dateOfBirth = dOB;
        
        // checks student's age is below 100
        if (getStudentAge() > 100) {
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        dateOfEnrollment = dOE;
    }
    
    // Setters
    public void setBirthday(LocalDate dOB) {
        dateOfBirth = dOB;
    }
    
    // Resets address
    public void changeAddress(String address, String city, String zCode){
        this.address = address;
        this.city = city;
        zipCode = zCode;
    }
    
    // set isSuspend to true
    public void suspendStudent(){
        isSuspended = true;
    }
    
    // set isSuspend to false
    public void reinstateStudent(){
        isSuspended = false;
    }
    
    // add course and grade to list of completed courses
    public void addCompletedCourse(Course course, int grade){
        if (grade <= 100 && grade >=0) {
            completedCourses.add(course);
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
    }
    
    // Getters
    // gets student number
    public int getStudentNumber(){
        return studentNumber;
    }
    
    // gets list of completed courses
    public String getCoursesCompleted(){
        String str = "[";
        for (int i = 0; i < completedCourses.size(); i++){
            str += completedCourses.get(i).toString() + " grade=" + grades.get(i);
            if (i + 1 < completedCourses.size()){
                str += ", ";
            } else {
                str += "]";
            }
        }
        return str;
    }
    
    // get student's age
    public int getStudentAge() {
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
    
    // gets student's address
    public String getStudentAddress(){
        return address + " " + city + " " + zipCode;
    }
    
    // gets student's birth day
    public LocalDate getStudentBirthday(){
        return dateOfBirth;
    }
    
    // gets the enrolled year
    public int getNoOfYearEnrolled(){
        return dateOfEnrollment.getYear();
    }
    
    // checks if students in good standing
    public boolean StudentInGoodStanding(){
        return !isSuspended;
    }
    
    // checks if student has completed the course
    public boolean hasCompleted(String courseCode){
        boolean boo = false;
        for (int i = 0; i < completedCourses.size(); i++){
            if (completedCourses.get(i).getCourseCode().equals(courseCode) && grades.get(i) > 50) {
                boo = true;
            }
        }
        return boo;
    }
    
    // gets first name
    public String getFirstName(){
        return firstName;
    }
    
    // gets last name
    public String getLastName(){
        return lastName;
    }
    
    // return a string
    public String toString(){
        String str = getFirstName() + " " + getLastName() + ", student number: " + getStudentNumber();
        return str;
    }
}
