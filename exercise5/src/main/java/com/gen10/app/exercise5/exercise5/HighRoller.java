/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise5.exercise5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class HighRoller {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random diceRoller = new Random();
        
        int rollResult = diceRoller.nextInt(6) + 1;
        
        System.out.println("TIME TO ROOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);
        
        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult > 1) {
            System.out.println("How many sides does the dice have? ");
            int diceNum = scanner.nextInt();
            int rollResult2 = diceRoller.nextInt(diceNum) + 1;
       
        if (rollResult2 == diceNum) {
            System.out.println("You rolled a critical! Nice job");
        } 
        
        } 
    }
}
