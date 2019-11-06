/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Terry
 */

import java.time.LocalDate;

/**
 *
 * @author Diego Alejandro Estrada Beltrán <86diegoestrada@gmail.com>
 */
public class Employee {
    private String firstNAme, lastName, address,phNumber,emplyeeID;
    int age;
    private LocalDate dateOfBirth;
    
    public Employee(String fNAme,String lName,String add,String phNo,String empID,LocalDate dOB){
        this.firstNAme = fNAme;
        this.lastName = lName;
        this.address = add;
        this.phNumber = phNo;
        this.emplyeeID = empID;
        this.dateOfBirth = dOB;
    }
    
    public Employee(String fNAme,String lName,String phNo){
        this.firstNAme = fNAme;
        this.lastName = lName;
        this.phNumber = phNo;
    }
    
    public Employee(int age){
        this.age=age;
    }
    
    @Override
    public String toString(){
        return ("\nInformation of the Employee" + getFirstName()+" "+getLastName()+"\n"
                                                +getphNumber()+"\n"
                                                +getAddress()+"\n"
                                                +getEmpNO()+"\n"
                                                +getdateOfBirth()+"\n"
                                                +getAge());
    }
    
    public void setFirstName(String fname){
        //if(!firstNAme.matches("[a-z A-Z_]+")){
        if(!fname.matches("[a-z A-Z_]+")){// VALIDATION OF SETTER METHOD WITH THE LOCAL VARIABLE
            System.err.println("Please Enter the letters Only!!");
        }
        else{
            firstNAme=fname;
        }
    }
    
//    public void setFirstName(String fNAme){
//        firstNAme = fNAme;
//    }
    
    public void setLastName(String lName){
        //if(!lastName.matches("[a-z A-Z_]+")){
        if(ifAlphabetsOnly(lName)){
            lastName = lName;
        }else{
            System.err.println("Please Enter the letters Only!!");
        }
    }
    
    public void setAddress(String add){
        address = add;
    }
    
    public void setphNumber(String phNumber){
        if(!phNumber.matches("0-9")){
            throw new IllegalArgumentException("Number Only");
            //System.err.println("Please Enter the Numbers Only!!");
        }else{
            this.phNumber = phNumber;
        }
    }
    
    public void setEmpNO(String empNo){
        if(!phNumber.matches("0-9")){
            System.err.println("Please Enter the Numbers Only!!");
        }else{
            emplyeeID = empNo;
        }
    }
    
    public String getFirstName(){
        return firstNAme;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getphNumber(){
        return phNumber;
    }
    
    public String getEmpNO(){
        return emplyeeID;
    }
    
    public LocalDate getdateOfBirth(){
        return dateOfBirth;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age){
        if(age>100 && age >14){
            this.age=age;
        }
        else{
            System.err.println("Invalid age, enter a valid Age");
        }
    }    
    
    //utility methoxd to check if the string contains only letters
    private boolean ifAlphabetsOnly(String str){
        return str.chars().allMatch(Character::isLetter);
    }
    
}