/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.ui;

import com.gen10.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author sakim
 */
public class ClassRosterView_Class {
    private UserIO io;
    
    public ClassRosterView_Class(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Students");
            io.print("4. Edit a Students");
            io.print("5. Remove a Student");
            io.print("6. Exit");
            
            return io.readInt("Please select from the above choices.", 1,6);
    }
    
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter cohort");
        
        Student currentStudent = new Student(studentId);
        
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        
        return currentStudent;
    }
    
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    
    public void displayCreatSuccessBanner() {
        io.readString("Student successfully created. Please hit enter to continue");
    }
    
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + ": " + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        
        io.readString("Please hit enter to contiunue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student===");
    }
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("===Remove Student===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("===ERROR===");
        io.print(errorMsg);
    }
    
    
}
