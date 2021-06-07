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
public class FortuneCookie {
    public static void main(String[] args) {
        Random random = new Random();
        
        String [] arr = {"Those aren't the droids you're looking for.", "goonies never say die.", "tryno. do, or do no. there is no try", "Make it so.", "Kneel before Zod."};
        int select = random.nextInt(arr.length);
        
        System.out.println("Your Greek Fortune : " + arr[select]);
    }
}
