/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.assignment1.week1_assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class DogGenetics {
    
   private static Scanner scan = new Scanner(System.in);
   private static Random random = new Random();
   
    public static void main (String[] args) {
        System.out.println("What is your dog's name? ");
        String dogName = scan.nextLine();
        System.out.println(" Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        
        System.out.println(dogName + " is: ");
        
        int num1, num2, num3, num4, num5, total;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        num4 = 0;
        num5 = 0;
        
        
        total = num1 + num2 + num3 + num4 + num5;
        
              
        while ( total != 100) {
        num1 = random.nextInt(101);
        num2 = random.nextInt(101 - num1);
        num3 = random.nextInt(101 - num1- num2);
        num4 = random.nextInt(101 - num1 - num2 - num3);
        num5 = 100 - num1 - num2 - num3 - num4;
        total = num1 + num2 + num3 + num4 + num5;

        }
        if (total == 100) {
            System.out.println(num1 + "% St.Bernard");
            System.out.println(num2 + "% Chihuahua");
            System.out.println(num3 + "% Dramatic Red Nose Asian Pug");
            System.out.println(num4 + "% Common Cur");
            System.out.println(num5 + "% King Doberman");
            System.out.println("Wow, that's QUITE the dog!");
        }
    
    }
    
}

