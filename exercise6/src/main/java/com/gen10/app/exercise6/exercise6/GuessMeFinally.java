/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise6.exercise6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class GuessMeFinally {
    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        System.out.println("Your guess: ");
        int guess = scanner.nextInt();
        
        int randomN = -100 + random.nextInt(100 + 100 + 1); 
        int count = 0;
        
        int i = guess; 
        while (i != randomN) {
            if (i < randomN) (
                System.out.println("Ha, nice try - too low! Try again!");
                System.out.println(guess);
            ) else if (i > randomN) {
                     System.out.println("Too bad, way to high. Try again!");
                     System.out.println(guess);
                     }
                count++;
         } 
        
        if (i == randomN && count == 1) {
        System.out.println("Wow, nice guess! That was it!");
         } else if ( i == randomN && count > 1) {
             System.out.println("Finally! It's about time you got it!");
         }
         
    }
}
