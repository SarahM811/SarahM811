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
public class RockPaperScissors {
    private static int round, computerChoice, remainderRound, choiceN;
    private static String choice;
    private static int tie = 0;
    private static int Userwin = 0;
    private static int Computerwin = 0;
    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;
    private static String playAgain;
    
    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();
    
    public static void main(String[] args) {
        playRPS();
    }
     private static void playRPS() { 
        System.out.println("How many rounds do you want to play?");
        round = Integer.parseInt(scan.nextLine());
        
        if ( round <= 10 && round >= 1) {
            
            for ( remainderRound = round; remainderRound > 0; remainderRound--) {
                askUserInput();
                //remainderRound--;
             
               // if (remainderRound == 0) {
               //     System.out.println("Number of tie: " + tie + " number of your win: " + Userwin + " number of your loss: " + Computerwin);
                //}
            } 
            if (remainderRound == 0) {
                    System.out.println("Number of tie: " + tie + " number of your win: " + Userwin + " number of your loss: " + Computerwin);
                } 
        
            System.out.println("Do you want to play again?");
            playAgain = scan.nextLine();

            if ("yes".equals(playAgain)) {
                playRPS();
            } else {
            //if no, thanks for playing
                System.out.println("Thank you for playing!");
            }
            
        } else if (round < 1 || round > 10) {
            System.out.println("Invalid number of rounds. Please try again.");
        }
       
        //each round, ask for choice
    }

    private static void askUserInput() {
         
            System.out.println("Please choose, rock, paper, or scissors: ");
            choiceN = RPSnumber(scan.nextLine());
            //choose a random number
             computerChoice = random.nextInt(3);
            
                if (choiceN == computerChoice) {
                    tie++;
                    System.out.println("Tie!");
                } else if (choiceN < computerChoice) {
                    Computerwin++;
                    System.out.println("You lose!");
                } else if (choiceN > computerChoice) {
                    Userwin++;
                    System.out.println("You win!");
                }
        }
/*
    private static void playRPS() {
        System.out.println("How many rounds do you want to play?");
        round = scan.nextInt();
        //max round is 10, min round is 1, if 1<round<10, play
        //other -- show error message
        if ( round <= 10 && round >= 1) {
             for ( remainderRound = round; remainderRound > 0; remainderRound--) {
                askUserInput();
               // remainderRound--;
             //if round = 0 
             //display number of tie, user wins, computer wins and show the winner
                if (remainderRound == 0) {
                    System.out.println("Number of tie: " + tie + " number of your win: " + Userwin + " number of your loss: " + Computerwin);
               //if round > 0, asks for user choice again  
                } 
        } 
         //ask want to play again?
        System.out.println("Do you want to play again?");
        playAgain = scan.nextLine();
       
        // yes, program starts over
        if ( "yes".equals(playAgain)) {
            playRPS();
        } else {
        //if no, thanks for playing
            System.out.println("Thank you for playing!");
        }
            
        } else if (round < 1 || round > 10) {
            System.out.println("Invalid number of rounds. Please try again.");
        }
       
        //each round, ask for choice
       
    }
    */
    private static int RPSnumber (String answer) {
        if (answer == "rock") {
            int rockN = 0;
            return rockN;
            
        } else if (answer == "paper") {
           int pN = 1;
            return pN;
           
        } else if (answer == "scissors") {
            int sN = 2;
            return sN;
            
        } else {
            return -1;
        }
       
        
    }
}

