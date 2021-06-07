/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.dto;

import static com.gen10.classroster.dao.ClassRosterDaoFileImpl.DELIMITER;
import java.util.Objects;

/**
 *
 * @author sakim
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort; //Java or .NET + cohort month/year
    
    public Student(String studentId) {
        this.studentId = studentId;
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

    public String getStudentId() {
        return studentId;
    }

    
    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
    
    
//    public static final String DELIMITER = "::";
//
//    public String masrshalize(String delimiter) {
//        return String.join(delimiter, new String[] {studentId, firstName, lastName, cohort});
//    }
//    
//    public String marshalize() {
//        return marshalize(Student, DELIMITER);
//    }
    
//    public String[] getPropertyNames() {
//        return new String[] {"firstName", "lastName", "studenetId", "cohort"};
//    }
//    
//    public String getPropertyValueInput(String PropertyName) {
//        String propertyValue = "";
//        String answer = io.readString("Edit property " + propertyName + "? (y/n");
//        if (answer.equals("yes") || answer.equals("y")) {
//            propertyValue = io.readString("Enter new property value");
//        }
//        return propertyValue;
//    }
//
//    public void editProperty(int propertyIndex, String newValue) {
//        switch(propertyIndex) {
//            case 0:
//                setFirstName(newValue);
//                break;
//            case 1:
//                setLastName(newValue);
//                break;
//            case 2:
//                setCohort(newValue);
//                break;
//            default:
//                break;
//                
//        }  
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.studentId);
        hash = 37 * hash + Objects.hashCode(this.cohort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.cohort, other.cohort)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "ID. " + studentId + " |Name: " + firstName + " " 
                + lastName + " |Cohort: " + cohort;
    }
    
    
}
