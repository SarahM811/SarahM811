/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.factorizer.factorizer;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class Factorizer1 {
   // public static void main(String[] args) {
    
    public void factorizer() {  
        Scanner inputReader = new Scanner(System.in);
        
        int tally = 0;
        int sum = 0;
        boolean flag = true;
        
        System.out.println("What number would you like to factor? ");
        int number = inputReader.nextInt();
        
        System.out.println("The factors of " + number + " are: ");
        
        for(int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.println(i + " ");
                tally++;
                sum = sum + i;
            }
         }
        
         if (sum == number) {
                    System.out.println(number + " is a perfect number.");
                } else {
                    System.out.println(number + " is not a perfect number.");
                } 
        if (tally > 1) {
            System.out.println(number + " is not a prime number");
        } else {
            System.out.println(number + " is a prime number.");
        }
        System.out.println("Total count is " + tally);
    }
}
//}
