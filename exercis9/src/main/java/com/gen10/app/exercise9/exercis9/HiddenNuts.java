/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.exercis9;

import java.util.Random;

/**
 *
 * @author sakim
 */
public class HiddenNuts {
    public static void main(String[] args) {
        
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden....");
        
        
        //Nut finding code should go here
        for (int i = 0; i < hidingSpots.length; i++) {
            if (hidingSpots[i] == "Nut") {
                System.out.println("Found it! It's in spot# " + i);
                break;
            } else{
                System.out.println("Still searching...");
            } break;
        } 
        
    }
}
