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
public class Knock {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock knock! Guess who! ");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess.equals("Marty McFly")) {
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); //sorry, had to!
            
        } else {
            System.out.println("Dude, do I -look -like " + nameGuess);
        }
            
    }
}
