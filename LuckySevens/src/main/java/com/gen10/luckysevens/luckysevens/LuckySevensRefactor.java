/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.luckysevens.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class LuckySevensRefactor {
    
    public void playLS() {
        
        Scanner scan = new Scanner(System.in);
        Random randomizer = new Random();
        
        int bet;
        int count = 0;
        
        System.out.println("How many dollars do you have?: ");
        bet = scan.nextInt();
        
        int max= bet;
        int countMax = 0;
        
        while (bet > 0) {
            int num = 1 + randomizer.nextInt(6);
            int num2 = 1 + randomizer.nextInt(6);
            int sum = num + num2;
            count ++;
            
            if (sum == 7) {
                bet += 4;
               } else {
                bet -= 1;
            }
            
            if (bet > max) {
                max = bet;
                countMax = count;
            }
        } 
        
            System.out.println("You are broke after " + count + " rolls.");
            System.out.println("You should have quit after " + countMax + " rolls when you had $ " + max + ".");
            
        }
        
    
}
