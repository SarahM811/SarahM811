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
public class ForTimesFor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which times table shall I recite?");
        int number = scanner.nextInt();
        int correct = 0;
        int wrong = 0;

        for (int i = 1; i < 16; i++) {
            System.out.println(i + " * " + number + " is: ");
            int answer = scanner.nextInt();

            if (answer == (i * number)) {
                System.out.println("Correct!");
                correct++;
            } else {
                System.out.println("Wrong!");
                wrong++;
            }

        }
        System.out.println("You got " + correct + " right");
    }
}
