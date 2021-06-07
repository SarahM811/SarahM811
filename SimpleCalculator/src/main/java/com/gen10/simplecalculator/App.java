/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.simplecalculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class App {
    private static Scanner scan  = new Scanner(System.in);
    private static String choiceOfOperation, choice;
    
    public static void main(String[] args) {
        do {
            getUserInput();
        } 
        while (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"));
        
    }
    
    public static void getUserInput() {
        
        SimpleCalculator myCalc = new SimpleCalculator();
        
        
            System.out.println("Would you like to play a simple calculotor?");
            choice = scan.nextLine();
            if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
                System.out.println("Thank you!");
                System.exit(0);
            }
           
            System.out.println("What operation would you like to do?- addition, subtraction, multiplication, division");
            choiceOfOperation = scan.nextLine();
            System.out.println("Please choose two numbers: ");
            int[] numberArr = new int[2];
            for ( int i = 0; i < 2; i++) {
                numberArr[i] = Integer.parseInt(scan.nextLine());
            }
            System.out.println(Arrays.toString(numberArr));

            //SimpleCalculator myCalc = new SimpleCalculator();
            int answer = myCalc.playSC(choiceOfOperation, numberArr);
            //int answer = myCalc.addition(numberArr[1], numberArr[0]);

            System.out.println("The answer for your choice of operation " + choiceOfOperation + " for the numbers you chose is " + answer);
        
        
        //while (choice != "no" || choice != "n");
        
    } 
    
    
}
