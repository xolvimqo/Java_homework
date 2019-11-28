/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yu-Ming(Terry) Gu
 * @StudentNumber 200410610
 * @Description: Represents a course enrolled in the school
 */
public class Course {
    // Variables
    private Instructor instructor;
    private String courseCode, courseName, room;
    private DayOfWeek day;
    private LocalTime time;
    private int hours;
    private int maxStudentNumber = 3;
    private String prerequisite = "";
    private List<Student> students = new ArrayList<Student>();
    
    // Constructor without prerequisite
    public Course(Instructor inst, String courseCode, String courseName, String room, DayOfWeek day, LocalTime time, int hours) {
        instructor = inst;
        this.courseCode = courseCode;
        // Checks if instructor is qualified to teach the course
        if (!instructor.InstructorcanTeach(courseCode)) {
            throw new IllegalArgumentException("Professor " + instructor.getFullName() + " is not qualified to teach " + courseCode );
        }
        
        this.courseName = courseName;
        this.room = room;
        this.day = day;
        this.time = time;
        // Checks if course start time is between 08:00-18:00
        if (time.isBefore(LocalTime.of(8, 0)) || time.isAfter(LocalTime.of(18, 0))) {
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        
        this.hours = hours;
    }
    
    // Overloaded constructor with prerequisite
    public Course(Instructor inst, String courseCode, String courseName, String room, DayOfWeek day, LocalTime time, int hours, String prerequisite) {
        instructor = inst;
        this.courseCode = courseCode;
        // Checks if instructor is qualified to teach the course
        if (!instructor.InstructorcanTeach(courseCode)) {
            throw new IllegalArgumentException("Professor " + instructor.getFullName() + " is not qualified to teach " + courseCode );
        }
        
        this.courseName = courseName;
        this.room = room;
        this.day = day;
        this.time = time;
        // Checks if course start time is between 08:00-18:00
        if (time.isBefore(LocalTime.of(8, 0)) || time.isAfter(LocalTime.of(18, 0))) {
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        
        this.hours = hours;
        this.prerequisite = prerequisite;
    }
    
    // Checks if this course need a prerequisite course
    public String checkPrerequisite(){
        String str = "";
        if (!prerequisite.equals("")) {
            str = prerequisite;
        }
        return str;
    }
    
    // Adds a student to the course
    public String addStudent(Student student) {
        String message = "";
        
        // Checks if student is in a good standing
        if (student.StudentInGoodStanding()){
            // Checks if students' number is small than max number
            if (students.size() < this.maxStudentNumber){
                // Checks if the course has a prerequisite course
                if (prerequisite.equals("")){
                    students.add(student);
                } else {
                    // Checks if student has completed the prerequisite course
                    if (student.getCoursesCompleted().contains(prerequisite)){
                        students.add(student);
                    } else {
                        message = "Student has not completed the prerequisite course: " + prerequisite;
                    }
                }
            } else {
                message = "Student was not added because the course is full";
            }
        } else {
            message = "The Student is not in good standing and cannot join the course.";
        }
        return message;
    }
    
    // Resets the size of the max number of students 
    public String setClassSize(int maxStuNumber){
        String message = "";
        if (maxStuNumber <= 40){
            maxStudentNumber = maxStuNumber;
        } else {
            maxStudentNumber = 40;
            message = "Max class size = 40, it has been set to 40";
        }
        return message;
    }
    
    // Checks if the average age of students is greater than 25
    public boolean matureClass(){
        int totalAge = 0;
        int numberOfStudents = 0;
        boolean isMatureClass = false;
        for (int i = 0; i < students.size(); i++) {
            totalAge += students.get(i).getStudentAge();
            numberOfStudents++;
        }
        if (totalAge/numberOfStudents > 25) {
            isMatureClass = true;
        }
        return isMatureClass;
    }
    
    // Getters
    // Gets room name
    public String getClassRoom(){
        return room;
    }
    
    // returns day and time of the course
    public String getCourseDayAndTime() {
        String dayAndTime = day.toString() + "'s, starting at " + time.toString();
        return dayAndTime;
    }
    
    // gets instructor
    public Instructor getInstructorToTeach() {
        return instructor;
    }
    
    // gets students' list of the course
    public String displayTheClassList(){
        String classList = "";
        for (int i = 0; i < students.size(); i++){
            classList += (students.get(i).firstName + " " + students.get(i).lastName + ", student number: " + students.get(i).studentNumber);
        }
        return classList;
    }
    
    // gets class size
    public int getClassSize(){
        return maxStudentNumber;
    }
    
    // gets course code
    public String getCourseCode(){
        return courseCode;
    }
    
    // get course name
    public String getCourseName(){
        return courseName;
    }
    
    // return course code and course name
    @Override
    public String toString(){
        String message = this.getCourseCode() + "-" + this.getCourseName();
        return message;
    }
}
