/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.dao;

import com.gen10.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();
    // private List<Student> studentList = new ArrayList<>();

    @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException {

        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;

    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterPersistenceException {
        loadRoster();
        // return students.get(studentId);
//        Student selected = null;
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentList.get(i).getStudentId().equals(studentId)) {
//                selected = studentList.get(i);
//            }
//        }
//        if (selected == null) {
//            throw new ClassRosterPersistenceException("No student was found");
//        } else {
        return students.get(studentId);
        //  }
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        Student removedStudent = students.remove(studentId);
        // Student toRemove = getStudent(studentId);

        //studentList.remove(toRemove);
        // students.remove(toRemove.getStudentId());
        writeRoster();
        // return removedStudent;
        return removedStudent;
    }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            //create scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Student currentStudent = new Student(currentTokens[0]);

            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            students.put(currentStudent.getStudentId(), currentStudent);
        }

        scanner.close();
    }

    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not save student data.", e);
        }

        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            out.println(currentStudent.getStudentId() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());

            out.flush();
        }
        out.close();
    }

    //make a method that gets all Ids
//    private List<String> getStudentIds() {
//        List<String> studentIds = new ArrayList<>();
//        for (int i = 0; i < studentList.size(); i++) {
//            String studentId = studentList.get(i).getStudentId();
//            if (studentIds.contains(studentId)) {
//                studentIds.add(studentId);
//            }
//        }
//        return studentIds;
//    }

//    private void editStudent(Student student, String[] newData)
//            throws ClassRosterPersistenceException{
//        removeStudent(student.getStudentId());
//        for (int i = 0; i < newData.length; i++) {
//            String newValue = newData[i];
//            if (!newValue.equals("")) {
//                student.editProperty(i, newValue);
//            }
//        }
//        addStudent(student.getStudentId(), student);
//    }
}
