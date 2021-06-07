/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise6.exercise6;

import java.util.Random;

/**
 *
 * @author sakim
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
        
        Random random = new Random();
        int randomN = 13 + random.nextInt(89 - 13 + 1);
        
        System.out.println("Well here goes nothing...");
        
        int i;
        for (i = 1; i <= randomN; i++) {
            if (i % 2 == 0) {
                System.out.println("it loves me!");
            } else {
                System.out.println("It loves me NOT!");
            }            
        }
        if (i % 2 == 0 ) {
            System.out.println("Oh wow, it really loves me!");
        } else {
            System.out.println("Awww, bummer.");
        }
        
        
    }
}
