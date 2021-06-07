/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.StudentQuizGrades;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class QuizScore {
    private int[] quiz;
    private String name;
    private int average, sum;
    private Scanner scanner = new Scanner(System.in);
    
    QuizScore(String name, int[] quiz) {
        this.name = name;
        this.quiz = quiz;
       
        
    }
    
    @Override
    public String toString() {
       for (int i = 0; i < 3; i++) {
           sum += quiz[i];
       }
       average = sum /3;
       return "name: " + name + " | score for quiz 1: " + quiz[0] + " |quiz2: " + quiz[1] + "| quiz3: "+ quiz[2] + " | average score: " + average;
    }

//    @Override
//    public void print(String message) {
//        System.out.println(message);
//    }
//
//    @Override
//    public double readDouble(String prompt) {
//        double value = Double.parseDouble(readString(prompt));
//        return value;
//    }
//
//    @Override
//    public double readDouble(String prompt, double min, double max) {
//        double value = readDouble(prompt);
//        if (value < min || value > max) {
//            System.out.println("Your number needs to be " + min + " < number < " + max);
//            return readDouble(prompt, min, max);
//        } else {
//            return value;
//        }
//    }
//
//    @Override
//    public float readFloat(String prompt) {
//        Float value = Float.parseFloat(readString(prompt));
//        return value;
//    }
//
//    @Override
//    public float readFloat(String prompt, float min, float max) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int readInt(String prompt) {
//        int value = Integer.parseInt(readString(prompt));
//        return value;
//    }
//
//    @Override
//    public int readInt(String prompt, int min, int max) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public long readLong(String prompt) {
//       long value = Long.parseLong(readString(prompt));
//        return value;
//    }
//
//    @Override
//    public long readLong(String prompt, long min, long max) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String readString(String prompt) {
//        print(prompt);
//        return scanner.nextLine();
//    }
}
