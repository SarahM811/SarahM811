/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise8.exercise8;

import java.util.Random;

/**
 *
 * @author sakim
 */
public class BarelyControlledChaos {
    
     static Random random = new Random();
      
    public static void main(String[] args) {
        String color = color();
        animal();
        //call animal method
        //colorAgain
        String colorAgain = color();
        //call number method, with a range 5-200
        int weight = numbermethod(5, 200);
        //call number method, with a range 10-20
        int distance = numbermethod(10, 20);
        //call number method with a range 10000 - 20000
        int number3 = numbermethod(10000, 20000);
        //call number method with a range 2 - 6
        int time = numbermethod(2, 6);
        
        System.out.println("Once, when I was very samll...");
        System.out.println("I was chased by a " + color + ", "
        + weight + " lb" + " miniature " + animal() + " for over "
        + distance + " miles!!");
        
        System.out.println("I had to hid in a filed of over " + number3 + " " +
                colorAgain + " poppies for nearly " + time + " hours until it left me alone!");
        
        System.out.println("\nIt was QUITE the experience, " + "let me tell you!");
    }
    
    private static String color() {
        
        Random random = new Random();
        
        String[] arr = {"white", "red", "blue", "black", "green"};
        int number = random.nextInt(arr.length);
        
        return arr[number];
    }
    
    private static String animal(){
        
        String[] arr1 = {"dog", "cat", "horse", "goat", "sheep"};
        int number2 = random.nextInt(arr1.length);
        
        return arr1[number2];
    
    }
    
    private static int numbermethod (int min, int max) {
        int response = min + random.nextInt(max - min + 1);
        return response;
    }
}
