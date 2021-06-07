/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.StudentQuizGrades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class StudentQuizGrades {
    static private Scanner scanner = new Scanner(System.in);
    static private HashMap<String, QuizScore> scoreList = new HashMap<>();
    static private int[] scoreArr = new int[3];
    private static String name;
    private static QuizScore Q;
    private static String addResponse;
    
    public static void main(String[] args) {
        
        do {
        userInput();
        }
        while (addResponse.equalsIgnoreCase("yes")); 
    }

    
    static public void addName(String name, QuizScore score) {
        
        scoreList.put(name, score);
        System.out.println("Your name is added to the list.");
        System.out.println("Currently there are " + scoreList.size() + " studnets on the list.");
    }
    
    static public void removeName (String name, QuizScore score) {
        System.out.println("Which name would you like to remove from the list?");
        String removeN = scanner.nextLine();
        QuizScore removeScore = scoreList.get(removeN);
        scoreList.remove(removeN, removeScore);
        System.out.println("Your name and scores have been removed from the list");
        System.out.println("Total number of students on the list is now "+ scoreList.size());
    }
    
    static public void displayList(HashMap hashmap) {
        for (String studentNames : scoreList.keySet()) {
            QuizScore scores = scoreList.get(studentNames);
            System.out.println(scores.toString());
        }
       
    }
    
    static public int[] getScores (String prompt) {
        System.out.println(prompt);
        for (int i = 0; i <3; i++) {
            
            scoreArr[i] = Integer.parseInt(scanner.nextLine());
        }
        return scoreArr;
    }
    
    static public HashMap addtoHashMap(String name, QuizScore scores) {
        //HashMap<String, QuizScore> hashmap2 = new HashMap<>();
        //hashmap2.put(name, scores);
        scoreList.put(name, scores);
        return scoreList;
    }
    
    static public void userInput() {
        System.out.println("What is your name?");
        String studentName = scanner.nextLine();
        
        int[] studentScore = getScores("What are the scores of your 3 quizzes?");
        QuizScore qs = new QuizScore(studentName, studentScore);
        
        addName(studentName, qs);
       
        scoreList = addtoHashMap(studentName, qs);
        //displayList(scoreList);
        System.out.println("Would you like to remove a name from the list?");
        String removalAnswer = scanner.nextLine();
        if (removalAnswer.equalsIgnoreCase("yes")) {
            removeName(studentName, qs);
        } else {
            displayList(scoreList);
        }
            System.out.println("Would you like to add another name?");
            String addResponse = scanner.nextLine();
            if (addResponse.equalsIgnoreCase("no")) {
                System.exit(0);
            } else{
                userInput();
            }
    }
    
}
