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
public class GuessMeMore {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        System.out.println("Your guess: ");
        int guess = scanner.nextInt();
        int randomN = -100 + random.nextInt(201); // Min + random.nextInt(Max - Min +1)
        System.out.println("");
        if (guess == randomN) {
            System.out.println("Wow, nice guess!");
        } else if (guess < randomN) {
            System.out.println("Ha, nice try- too low! Try again!");
            System.out.println(guess);
        } else if (guess > randomN) {
            System.out.println("Too high");
        }
       
        
        
        
        /*
        int i = guess; 
        while (i < randomN || i > randomN) {
           System.out.println("Ha, nice try - too low! Try again!");
           i = scanner.nextInt();
         } if (i == randomN) {
             System.out.println("Wow, nice guess! That was it!");
         }
         */
    }
}
