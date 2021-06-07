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
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        int firstIndex = 0;
        int secondIndex = 0;
        //int wholeIndex = 0;

        // Sorting code should go here!
        for (int wholeIndex = 0; wholeIndex < wholeNumbers.length; wholeIndex++) {
            if (secondIndex == secondHalf.length) {
                wholeNumbers[wholeIndex] = firstHalf[firstIndex];
            } else if(firstIndex == firstHalf.length) {
                wholeNumbers[wholeIndex] = secondHalf[secondIndex];
            } else if (firstHalf[firstIndex] > secondHalf[secondIndex]) {
                wholeNumbers[wholeIndex] = secondHalf[secondIndex];
                secondIndex++;
            } else{
                wholeNumbers[wholeIndex] = firstHalf[firstIndex]; 
                firstIndex++;
        }
        
    }
        System.out.println(Arrays.toString(wholeNumbers));
    }
    
}
