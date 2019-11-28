/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Yu-Ming(Terry) Gu
 * @StudentNumber 200410610
 * @Description: Represents a course with lab enrolled in the school
 */
public class CourseWithLab extends Course{
    // Variables
    private Instructor labTech;
    private String labRoom;
    private DayOfWeek labDay;
    private LocalTime labTime;
    
    // Constructor
    public CourseWithLab(Instructor inst, String courseCode, String courseName, String room, DayOfWeek day, LocalTime time, int hours, Instructor labTech, String labRoom, DayOfWeek labDay, LocalTime labTime){
        super(inst, courseCode, courseName, room, day, time, hours);
        this.labTech = labTech;
        this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTime = labTime;
        
        //throw error if lab tech is not qualified to host the lab
        if (!labTech.listOfSubjectsCertifiedToTeach().contains(courseCode + "-LAB")) {
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
        
        // throw error if the lab start time is not between 8:00 - 18:00
        if (labTime.isBefore(LocalTime.of(8, 0)) || labTime.isAfter(LocalTime.of(18, 0))){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
    }
    
    // Overloaded Constructor with prerequisite
    public CourseWithLab(Instructor inst, String courseCode, String courseName, String room, DayOfWeek day, LocalTime time, int hours, String prerequisite, Instructor labTech, String labRoom, DayOfWeek labDay, LocalTime labTime){
        super(inst, courseCode, courseName, room, day, time, hours, prerequisite);
        this.labTech = labTech;
        if (!labTech.listOfSubjectsCertifiedToTeach().contains(courseCode + "-LAB")){
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
        this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTime = labTime;
        if (labTime.isBefore(LocalTime.of(8, 0)) || labTime.isAfter(LocalTime.of(18, 0))){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
    }
    
    // Getters
    // return lab tech
    public Instructor getLabTech(){
        return labTech;
    }
    
    // get class room and time of lab
    public String getLabClassAndTime(){
        String message = "room: " + getLabRoom() + ", " + getLabDay().toString() + " starting at " + getLabTime().toString();
        return message;
    }
    
    // get lab room
    public String getLabRoom() {
        return labRoom;
    }
    
    // get day of lab course
    public DayOfWeek getLabDay(){
        return labDay;
    }
    
    // gets time of lab course
    public LocalTime getLabTime(){
        return labTime;
    }
    
    // returns course code with course name of lab
    @Override
    public String toString(){
        String message = this.getCourseCode() + "-" + this.getCourseName() + " with lab";
        return message;
    }
}
