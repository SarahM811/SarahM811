/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise6.exercise6;

/**
 *
 * @author sakim
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooooooooo...! *SPLASH*");
        
        int depthDivedInFt = 0;
        
        //ocean is deep, 36200 ft
        //if we reach the bottom, we should stop
       while(depthDivedInFt < 36200) {
           System.out.println("So far, we've swam " + depthDivedInFt + " feet");
           
           if(depthDivedInFt >= 20000) {
               System.out.println("Uhhh, i think i see a Kraken, guys ...");
               System.out.println("TIME TO GO!");
               break;
           }
           
           
           // I can swim real fast, 500ft at a time
           depthDivedInFt += 1000;
           
       } 
        System.out.println("");
        System.out.println("we ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
