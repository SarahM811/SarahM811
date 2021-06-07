/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.assignment1.week1_assignment;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class SummativeSums {
    private static Scanner scan = new Scanner(System.in);
    private static int[] arr1, arr2, arr3;
    private static int[] arrayA = {1, 90, -33, -55, 67, -16, 28, -55, 15};
    private static int[] arrayB =  { 999, -60, -77, 14, 160, 301 };
    private static int[] arrayC = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 } ;
    
    public static void main(String[] args) {
        Example();
        System.out.println("#1 Array Sum: " + getSum(arrayA));
        System.out.println("#1 Array Sum: " + getSum(arrayB));
        System.out.println("#1 Array Sum: " + getSum(arrayC));
        
        userInput();
        System.out.println("Sum of array#1 is: " + getSum(arr1));
        System.out.println("Sum of array#2 is: " + getSum(arr2));
        System.out.println("Sum of array#3 is: " + getSum(arr3));
        
    }
    
    private static int getSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        } 
        return sum;
    }
    
    public static void userInput() {
        System.out.println("How many numbers do you want to put in array#1? ");
        int num1 = Integer.parseInt(scan.nextLine());
        arr1 = new int[num1];
        
        System.out.println("Enter " + num1 + " numbers you want to put in array#1: ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Array#1: " + Arrays.toString(arr1));
        
        System.out.println("How many numbers do you want to put in array#2? ");
        int num2 = Integer.parseInt(scan.nextLine());
        arr2 = new int[num2];
        
        System.out.println("Enter " + num2 + " numbers you want to put in array#2: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Array#2: " + Arrays.toString(arr2));
        
        System.out.println("How many numbers do you want to put in array#3? ");
        int num3 = Integer.parseInt(scan.nextLine());
        arr3 = new int[num3];
        
        System.out.println("Enter " + num3 + " numbers you want to put in array#31: ");
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Array#3: " + Arrays.toString(arr3));
            
    }
    
    private static void Example() {
       
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        System.out.println(Arrays.toString(arrayC));
    }
}
