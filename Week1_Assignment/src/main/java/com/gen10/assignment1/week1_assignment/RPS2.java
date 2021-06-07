/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.assignment1.week1_assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class RPS2 {
    private static int round, computerChoice, remainderRound, choiceN;
    private static String choice;
    private static int tie = 0;
    private static int Userwin = 0;
    private static int Computerwin = 0;
    private static String playAgain;
    private static String[] arr = {"rock", "paper", "scissors"};
    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();
    
    public static void main(String[] args) {
        do {
        playRPS();
        
        System.out.println("Do you want to play again?- yes or no");
            playAgain = scan.nextLine();
        }
         
            while (playAgain.equals("yes")) ;
            
            
            
           if (playAgain.equals("no")) {
                System.out.println("Thank you for playing!");
            }
        
        
        
        }
    
     private static void playRPS() { 
        tie = 0;
        Userwin = 0;
        Computerwin = 0;
        System.out.println("How many rounds do you want to play?");
        round = Integer.parseInt(scan.nextLine());
        
        if ( round <= 10 && round >= 1) {
            
            for ( remainderRound = round; remainderRound > 0; remainderRound--) {
                askUserInput();
                }
        
            
            if (remainderRound == 0) {
                    System.out.println("Number of tie: " + tie + " number of your win: " + Userwin + " number of your loss: " + Computerwin);
                }
            
            if (Userwin > Computerwin) {
                System.out.println("You are the winner!");
            } else if (Userwin < Computerwin) {
                System.out.println("You lost agaaisnt the computer!");
            } else if (Userwin == Computerwin) {
                System.out.println("It's a tie between you and the computer!");
            } 
        
        }    
        else if (round < 1 || round > 10) {
            System.out.println("Invalid number of rounds. Please try again.");
            playRPS();
        }
        
    }


    private static void askUserInput() {
         
            System.out.println("Please choose, rock, paper, or scissors: ");
            choice = scan.nextLine();
            
                           
                if (choice.equalsIgnoreCase("rock") && (compChoice().equalsIgnoreCase("paper")) ) {
                    Computerwin++;
                    System.out.println("You lose!");
                } else if (choice.equalsIgnoreCase("paper") && (compChoice().equalsIgnoreCase("scissors")) ) {
                    Computerwin++;
                    System.out.println("You lose!");
                } else if (choice.equalsIgnoreCase("scissors") && (compChoice().equalsIgnoreCase("rock")) ) {
                    Computerwin++;
                    System.out.println("You lose!");
                } else if (choice.equalsIgnoreCase("rock") && (compChoice().equalsIgnoreCase("scissors")) ) {
                    Userwin++;
                    System.out.println("You win!");
                } else if (choice.equalsIgnoreCase("paper") && (compChoice().equalsIgnoreCase("rock")) ) {
                    Userwin++;
                    System.out.println("You win!");
                } else if (choice.equalsIgnoreCase("scissors") && (compChoice().equalsIgnoreCase("paper")) ) {
                    Userwin++;
                    System.out.println("You win!");
                } else {
                    tie++;
                    System.out.println("Tie!");
                }
    }   

    private static String compChoice() {
        
        int RPS = random.nextInt(3);
        return arr[RPS];
       }
}
