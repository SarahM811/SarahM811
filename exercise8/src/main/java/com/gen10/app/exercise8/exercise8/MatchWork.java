/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise8.exercise8;

/**
 *
 * @author sakim
 */
public class MatchWork {
    public static void main(String[] args) {
        String a = "apple";
        String b = "pear";
        double y = 42.0;
        int x = 1337;
        double Pi = pi();
        String word = "L";
        
        
        
        System.out.println(" The word Cart should come before Horse alphabetically : " + comesBefore(a, b));
        System.out.println(" Half of 42 = " + halfOf(y));
        System.out.println(" (short) Pi = " + Pi);
        System.out.println(" The first letter of the word Llama is: " + firstLetter(word));
        System.out.println(" 1337 x 1337 = " + times1337(x));
    }
    
    public static double pi() {
        return 3.14;
        
    }
    
    public static int times1337(int x){
        return x * 1337;
    }
    
    public static double halfOf(double y) {
        return y / 2;
    }
    
    public static String firstLetter(String word) {
        return word.substring(0,1);
    }
    
    public static boolean comesBefore(String a, String b) {
        return a.compareToIgnoreCase(b) < 0;
    }
}
