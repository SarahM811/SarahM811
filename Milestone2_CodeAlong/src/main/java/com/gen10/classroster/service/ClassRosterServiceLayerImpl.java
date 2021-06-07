/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.service;

import com.gen10.classroster.dao.ClassRosterAuditDao;
import com.gen10.classroster.dao.ClassRosterDao;
import com.gen10.classroster.dao.ClassRosterPersistenceException;
import com.gen10.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author sakim
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        //first check if there is already a student
        //associated with the given student's id
        //if so, we're done
        //throw a classrosterDuplicateIdException
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: could not create student. Student ID " + student.getStudentId()
                    + " already exists.");
        }
        
        //Now valideate all fiedlds given on student object
        //this method will throw an exception
        //if any of the validation rules are violated
        validatesStudentData(student);
        
        //We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addStudent(student.getStudentId(), student);
        
        //student was successfully created, now write to auditDao
      //  auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
        
    
        
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
       Student removedStudent = dao.removeStudent(studentId);
       //write audit log
       //auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }

    private void validatesStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException("ERROR: All fields [First Name, Last Name, Cohorot] are required.");
        }

    }

}
