/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class InterestCalc_Class {
    
    private int numYears;
   // private float annInterestRate, initialPrinciple;
    private BigDecimal annInterestRate, initialPrinciple;
    private int numPeriods;
    private int yearNum;
 //   private float startPrinciple, totalInterest, endPrinciple;
    private BigDecimal startPrinciple, totalInterest, endPrinciple;
    
    private Scanner userInput = new Scanner(System.in);
    
    
    public void playInterestCalc() {
        getUserInput();
        int totalPeriods = calcTotalPeriods();
        calcTotalInterest();
    }  
    
    private void getUserInput() {
        System.out.println("Please specify num years");
        numYears = Integer.parseInt(userInput.nextLine());
        
        System.out.println("Please specify principle:");
        initialPrinciple = new BigDecimal(userInput.nextLine());
        
        System.out.println("Please specify annual Int Rate:");
        annInterestRate = new BigDecimal(userInput.nextLine());
        
        System.out.println("Please specify periods per years");
        numPeriods = Integer.parseInt(userInput.nextLine());
    }

    private int calcTotalPeriods() {
        return numYears * numPeriods;
    }

    private void outputInfo(int yearNum, BigDecimal startPrinciple, BigDecimal totalInterest, BigDecimal endPrinciple) {
        
        System.out.println("yearNum: " + yearNum + "startPrinciple: " + startPrinciple + "interst Earned: " + totalInterest + 
                "endPrinciple: " + endPrinciple);
    }

    private void calcTotalInterest() {
        startPrinciple = initialPrinciple;
        for(int i = 1; i <= numYears; i++) {
                BigDecimal annualInterest = new BigDecimal(0);
                BigDecimal currentBalance = startPrinciple;
                
            for (int j = 0; j < numPeriods; j++) {
                BigDecimal periodInterest = calcPeriodInterest(currentBalance, annInterestRate.divide(BigDecimal.valueOf(numPeriods), 2, RoundingMode.HALF_UP));
                currentBalance = periodInterest.add(currentBalance);
                annualInterest = periodInterest.add(annualInterest);
            }
            
            endPrinciple = startPrinciple.add(annualInterest);
            outputInfo(i, startPrinciple, annualInterest, endPrinciple);
            startPrinciple = endPrinciple;
        }
    }
    private BigDecimal calcPeriodInterest(BigDecimal currentBalance, BigDecimal periodInterestRate) {
        BigDecimal percentage = new BigDecimal(100);
         return currentBalance.multiply(periodInterestRate.divide(percentage, 2, RoundingMode.HALF_UP));

    }
}
