/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.StudentQuizGrades;

/**
 *
 * @author sakim
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort; // Java or .NET + cohort month/year

    public Student(String studentId) {
        this.studentId = studentId;
    }
    
    public Student(String studentId, String firstName, String lastName, String cohort) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cohort = cohort;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }   
    
    static final String DELIM = "::";
    public String marshalize() {
        return String.join(Student.DELIM, new String[] {studentId, firstName, lastName, cohort});
        
    }
    
    String getName() {
        return firstName + " " + lastName;
    }
}
