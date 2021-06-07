/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.assignment1.week1_assignment;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class HealthyHearts {
    private static final Scanner scan = new Scanner(System.in);
    private static Integer age;
    private static boolean valid;
    private static final String question = "What is your age?";
    public static void main(String[] args) {
        getAge(question);
        int maxRate = 220 - age;
        int targetRateMin = (int) Math.round(0.5 * maxRate);
        int targetRateMax = (int) Math.round(0.85 * maxRate);
        
        System.out.println("Your maximum heart rate should be " + (int) Math.round(maxRate) + " beats per minute");
        System.out.println("Your target HR zone is " + targetRateMin + " - " + targetRateMax + " beats per minute");
    }
        /*
        System.out.println("What is your age? ");
        age = Integer.parseInt(scan.nextLine());
        
        if (age > 0) {
        float maxRate = 220 - age;
        int targetRateMin = (int) Math.round(0.5 * maxRate);
        int targetRateMax = (int) Math.round(0.85 * maxRate);
        
        System.out.println("Your maximum heart rate should be " + (int) Math.round(maxRate) + " beats per minute");
        System.out.println("Your target HR zone is " + targetRateMin + " - " + targetRateMax + " beats per minute");
        }
        else {
                System.out.println("Please put correct number integer of your age");
                }
        */
        
        private static int getAge(String question) {
            System.out.println(question);
            //while (valid = true) {
            try {
                age = Integer.parseInt(scan.nextLine());
                //break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid number. Please enter a whole number.");
                getAge(question);
            }
         //   }
            if (age <= 0) {
                System.out.println("Invalid number. Please enter a whole positive number.");
                getAge(question);
            } 
            return age;
        }
        
        
    
}
