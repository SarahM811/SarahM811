/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.exercis9;

import java.util.Arrays;

/**
 *
 * @author sakim
 */
public class StillPositive {
    public static void main(String[] args) {
        
        System.out.println("Gotta stay positive...!");
        
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311 };
        
      /*
        for ( int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                System.out.println(numbers[i]);
            } else {
                System.out.print("");
            }
        } 
       */ 
        for (int num: numbers) {
            if (num >= 0) {
                System.out.println(num + "");
            }
        }
    
      /* in class examples
        
         
        String[] newArray = new String[10];
        System.out.println(Arrays.toString(newArray));
        --changes newArray to have 10 elements in it.
       */ 
    }
}
    