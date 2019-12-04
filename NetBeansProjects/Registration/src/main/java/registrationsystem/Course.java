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
 * @author Last_
 */
public class Course {
    private Instructor instructor;
    private String courseCode, courseName, room;
    private DayOfWeek day;
    private LocalTime time;
    private int hours;
    private int maxStudentNumber = 3;
    private List<Student> students = new ArrayList<Student>();
    
    public Course(Instructor inst, String courseCode, String courseName, String room, DayOfWeek day, LocalTime time, int hours) {
        instructor = inst;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.room = room;
        this.day = day;
        this.time = time;
        this.hours = hours;
    }
    
    public String addStudent(Student student) {
        String message = "";
        if (student.StudentInGoodStanding()){
            if (students.size() < this.maxStudentNumber){
                students.add(student);
            } else {
                message = "Student was not added because the course is full";
            }
        } else {
            message = "The Student is not in good standing and cannot join the course.";
        }
        return message;
    }
    
    public String setClassSize(int maxStuNumber){
        String message = "";
        if (maxStuNumber <= 40){
            maxStudentNumber = maxStuNumber;
        } else {
            maxStudentNumber = 40;
            message = "Max class size = 40, it has been set to 40";
        }
    }
    
    // Getters
    public String getClassRoom(){
        return room;
    }
    
    public String getCourseDayAndTime() {
        String dayAndTime = day.toString() + "'s, starting at " + time.toString();
        return dayAndTime;
    }
    
    public Instructor getInstructorToTeach() {
        return instructor;
    }
    
    public List<String> displayTheClassList(){
        List<String> classList = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++){
            classList.add(students.get(i).firstName + " " + students.get(i).lastName + ", student number: " + students.get(i).studentNumber);
        }
        return classList;
    }
    
    public int getClassSize(){
        return maxStudentNumber;
    }
}
