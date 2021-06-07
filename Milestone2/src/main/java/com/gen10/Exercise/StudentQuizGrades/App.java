/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.StudentQuizGrades;

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
import java.util.Set;

/**
 *
 * @author sakim
 */
public class App {

    static UserIO io;
    static Map<String, List> students = new HashMap<>();
    
    public static void main(String[] args) {
        io = new UserIOConsole();
        
        Student s = new Student("1");
        writeFile(String fileName, Studen[] student);
//        Menu menu = new Menu(io);
//        boolean keepWorking;
//        do {
//        int choice = menu.display();
//        handleChoice(choice);
//        
//        String returnToMenu = io.readString("Would you like to return to menu?");
//        if (returnToMenu.equalsIgnoreCase("yes") || returnToMenu.equalsIgnoreCase("y")) {
//            keepWorking = true;
//        } else
//            io.print("Thanks!");
//            keepWorking = false;
//        } while (keepWorking);
    }

    static final int ADD_STUDENT = 1;
    static final int LIST_STUDENT = 2;
    static final int REMOVE_STUDENT = 3;
    static final int VIEW_QUIZ_SCORES = 4;
    static final int VIEW_QUIZ_AVERAGE = 5;
    static final int GET_LOWEST_SCORE = 6;
    static final int EXIT_PROGRAM = 7;

    static public void handleChoice(int choice) {
        switch (choice) {
            case ADD_STUDENT:
                addStudent();
                break;
            case LIST_STUDENT:
                listStudents();
                break;
            case REMOVE_STUDENT:
                removeStudent();
                break;
            case VIEW_QUIZ_SCORES:
                viewQuizScores();
                break;
            case VIEW_QUIZ_AVERAGE:
                viewQuizAverage();
                break;
             case GET_LOWEST_SCORE:
                getLowestScore();
                break;
            case EXIT_PROGRAM:
                System.exit(-1);
                break;
            default:
                io.print("something bad happened");
                break;
        }
    }

    //    View a list of students in the system
    //    Add a student to the system
    //    Remove a student from the system
    //    View a list of quiz scores for a given student
    //    View the average quiz score for a given student
    
    static private void addStudent() {
        // input name
        String name = io.readString("Enter student name");
        // input student scores
        List<Float> scores = new ArrayList<>(); 
       // String keepAdding;
        boolean keepAdding;
       do {
            float score = 0 ;
            try {
               score =  io.readFloat("Enter a score:  (-1 to stop)");
            } catch (NumberFormatException e) {
                score -= 1;
            }
            keepAdding = (score >= 0);
            if (keepAdding) {scores.add(score) ; }
            
        } while (keepAdding);
       
       students.put(name, scores);
    }

    static private void listStudents() {
        Set<String> studentNames = students.keySet();
            if (studentNames.size() > 0) {
                io.print("Here are the students: ");
            for (String studentName : students.keySet()) {
                io.print("-" + studentName);
        }
        
        } else {
                io.print("No students have been added");
        }
        io.print("");
        
    }

    static private void removeStudent() {
        String studentName = getStudentName("which student do you want to remove?");
        students.remove(studentName);
    }

    static private void viewQuizScores() {
         String studentName = getStudentName("View quiz scores");
    }

    static private void viewQuizAverage() {
        io.print("View quiz average");
    }

//    static private void vewQuizAverage() {
//        String studentName = getStudentName("");
//        
//    }
    
    private static String getStudentName(String prompt) {
        
        boolean studentInvalid = false;
        String studentName;
        do {
            studentInvalid = false;
            studentName = io.readString(prompt);
            if (students.keySet().contains(studentName)) {
                students.remove(studentName);
            } else {
                io.print("I dont know that student.");
                studentInvalid = true;
            }
        } while (studentInvalid);
        return studentName;
    }
    static private void getLowestScore() {
        io.print("Lowest score is: " + getLowest(getStudentScores("Get lowest score which student?")));
        io.print();
    }
    
    private static float calcAvg(List scores) {
        float sum =0f;
        for ( int i = 0; i < scores.size(); i++) {
            sum += (float)scores.get(i);
        }
        return sum / scores.size();
    }
    
    private static float getLowest(List scores) {
        float lowest = Float.POSITIVE_INFINITY;
        for ( int i = 0; i < scores.size(); i++) {
            float score = (float)scores.get(i);
           if (score < lowest ) {
               lowest = score;
           }
        }
        return lowest;
    }

    private static List getStudentScores(String prompt) {
        String studentName = getStudentName(prompt);
        return students.get(studentName);
        
    }
    
    private static void writeFile(String fileName, Map<students, List> student) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        for (student s : getStudents(students)) {
            List<Float> scores = students.get(s);
            String row = String.join(Student.DELIM, elements)
            out.printlin(s.marshalize());
        }
        out.flush();
        out.close();
    }
    
    private static List readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
    // go through the file line by line
        List<Student> students = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            String[] data = currentLine.split(Student.DELIM);
            Student s = new Student(data[0]);
            s.setFirstName(data[1]);
            s.setLastName(data[2]);
            s.setCohort(data[3]);
            students.add(s);
        }   
        return students;
    }
    
    private Student[] getStudents(Map<Student, List> students) {
        Object[] allStudents = students.keySet().toArray();
        return Arrays.copyOf(allStudents, allStudents.length, )
    }
    
    
    
}
