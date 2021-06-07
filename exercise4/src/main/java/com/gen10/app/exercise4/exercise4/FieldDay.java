/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise4.exercise4;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class FieldDay {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        String team;
       
        
        String s1 = "Baggins";
        String s2 = "Dresden";
        String s3 = "Howl";
        String s4 = "Potter";
        String s5 = "Vimes";
        
                
        
        System.out.println("What's your last name? ");
        
        String name = myscanner.nextLine();
        
        int comparison1 = name.compareToIgnoreCase(s1);
        int comparison2 = name.compareToIgnoreCase(s2);
        int comparison3 = name.compareToIgnoreCase(s3);
        int comparison4 = name.compareToIgnoreCase(s4);
        int comparison5 = name.compareToIgnoreCase(s5);
       
        if(comparison1 < 0 ) {
            team = "Red Dragons";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        } else if(comparison1 > 0 && 0 > comparison2) {
            team = "Dark Wizards";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        
        } else if(comparison2 > 0 && comparison3 < 0){
            team = "Moving Castles";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        } else if(comparison3 > 0 && comparison4 < 0) {
            team = "Golden Snitches";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        } else if(comparison4 > 0 && comparison5 < 0) {
            team = "Night Guards";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        } else if(comparison5 > 0) {
            team = "Black Holes";
            System.out.println("Aha! You're on the team " + team + "!");
            System.out.println("Good luck in the games!");
        }
        
    }
}
