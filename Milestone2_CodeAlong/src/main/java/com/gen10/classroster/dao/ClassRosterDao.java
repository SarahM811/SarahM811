/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.dao;

import com.gen10.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author sakim
 */
public interface ClassRosterDao {
    
    Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException;
    
    List<Student> getAllStudents()
            throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId)
            throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentId)
            throws ClassRosterPersistenceException;
    
}
