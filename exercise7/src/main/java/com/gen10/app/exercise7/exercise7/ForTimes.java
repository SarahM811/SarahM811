/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise7.exercise7;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class ForTimes {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which times table shall I recite?");
        int number = scanner.nextInt();
        
        for (int i = 1; i < 16; i++) {
            System.out.println(i + " * " + number + " is: " + (i * number));
        }
    }
}
