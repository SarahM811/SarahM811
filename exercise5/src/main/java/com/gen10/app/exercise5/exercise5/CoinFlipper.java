/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise5.exercise5;

import java.util.Random;

/**
 *
 * @author sakim
 */
public class CoinFlipper {
    public static void main(String[] args) {
        Random flip = new Random();
        
        String [] arr = {"HEADS","TAILS"};
        int select = flip.nextInt(arr.length);
        
        System.out.println("Ready, Set, Flip...!!");
        System.out.println("You got " + arr[select]);
                
    }
}
