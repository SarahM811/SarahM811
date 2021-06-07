/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.controller;

import com.gen10.classroster.dao.ClassRosterDao;
import com.gen10.classroster.dao.ClassRosterPersistenceException;
import com.gen10.classroster.dao.ClassRosterDaoFileImpl;
import com.gen10.classroster.dto.Student;
import com.gen10.classroster.service.ClassRosterDataValidationException;
import com.gen10.classroster.service.ClassRosterDuplicateIdException;
import com.gen10.classroster.service.ClassRosterServiceLayer;
import com.gen10.classroster.ui.ClassRosterView;
import com.gen10.classroster.ui.UserIO;
import com.gen10.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author sakim
 */
public class ClassRosterController {

    ClassRosterView view;
    ClassRosterDao dao;
    private ClassRosterServiceLayer service;
 //   private UserIO io = new UserIOConsoleImpl();

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreatSuccessBanner();
                hasErrors = false;
            }  catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        
        
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
//    private void editStudent() {
//        view.displayEditSutdentBanner();
//        String studentId = view.getStudentId();
//        Student student = dao.getStudent(studentId);
//        String[] newData = new String[3];
//        String[] propertyNames = student.getPropertyNames();
//        for (int i = 0; i < propertyNames.length; i++ ) {
//            String propertyValue = view.getPropertyValueInput(propertyNames[i]); 
//            if (!propertyValue.equals("")) { newData[i] = propertyValue;}
//        }
//        //Ask to eedit each fields
//        //if field should be added, as for new value
//        
//        
//        dao.editStudent(student);
//        view.displayEditStudentSuccessBanner(student);
//        
//    }
}
