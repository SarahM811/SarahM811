/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class InterestCalc {
        
    
    public static void main(String[] args) {
        
        double initial, yearlyInterest;
        double rate;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How much would you like to invest? ");
        initial = scan.nextDouble();
        
        System.out.println("What's the interest rate?  ");
        rate = scan.nextDouble();

        System.out.println("How many times will it be compound a year- daily, monthly, or quarterly? ");
        Double compound = scan.nextDouble();
        
        System.out.println("For how many years would you like to invest your money for? ");
        int year = scan.nextInt();
        
        double interest = initial * rate;
        double totalAmount = initial; 
        double adjRate = rate / compound;
        
        System.out.println("Calculating interest annually for " + year + " years with " + rate + "% rate for $" + initial);

        for (int i = 1; i <= year; i++ ) {
            yearlyInterest = totalAmount * rate;
            totalAmount += yearlyInterest;
            Double amount = totalAmount - yearlyInterest;
            Double compoundInterest = totalAmount * adjRate;
            System.out.println(i + " year: ");
            if (i == 1) {
                System.out.println("Starting principal: " + initial);
                System.out.println("Total interest: " + yearlyInterest);
                System.out.println("Final balance: " + totalAmount);
            } else {
            System.out.println("Starting principal: " + amount);
            System.out.println("Total interest: " + yearlyInterest);
            System.out.println("Final balance: " + totalAmount);
            } 
        }
       
        /*
        System.out.println("Calculating interest quarterly for " + year + " years with " + rate + "% rate for $" + initial);
       
        for (int j = 0; j <= compound; i++) {
                    
                }
        */
        }
    private static Double compound (String term) {
        if (term == "daily") {
            double compoundN = 365;
            return compoundN;
        } else if (term == "monthly") {
            double compoundN = 12;
            return compoundN;
        } else if (term == "quarterly") {
            double compoundN = 4;
            return compoundN;
        } else {
            double compoundN = 1;
            return compoundN;
        }
    }
       
    
    
   
}
