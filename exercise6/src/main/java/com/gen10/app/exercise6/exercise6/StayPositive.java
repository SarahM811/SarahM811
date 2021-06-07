/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise6.exercise6;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class StayPositive {
    public static void main(String[] args) {
       
        Scanner myscanner = new Scanner(System.in);
        
        System.out.println("What number should I count down from? ");
        int i = myscanner.nextInt();
        System.out.println("Here goes!");
        
        while (i >= 0) {
            System.out.println(i); //how to put 10 numbers per line
            i--;
        } 
        System.out.println("Whew, better stop there...!");
            
    }
}
