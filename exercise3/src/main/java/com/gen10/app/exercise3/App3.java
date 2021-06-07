/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise3;

import java.util.Scanner;
/**
 *
 * @author sakim
 */
public class App3 {
    public static void main(String[] args) {
      
        AllTheTrivia();
    }
    
    private static void QuestForTheUserInput() {
        Scanner inputReader = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double velocityOfSwallow;
        
        System.out.println("What is your name?? ");
        yourName = inputReader.nextLine();
        
        System.out.println("What is your quest?? ");
        yourQuest = inputReader.nextLine();
        
        System.out.println("What is the airspeed velocity of an unladen swallow?!?! ");
        velocityOfSwallow = inputReader.nextDouble();
        
        System.out.println("How do you know " + velocityOfSwallow + " is correct," + yourName + ",");
        System.out.println("when you didn't even know if the swallow was African or European!");
        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest);
    }
    
    private static void DontForgetToStoreIt() {
        
        int meaningOfLifeAndEverything = 42;
        double pi = 3.14159;
        String cheese, color;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Give me pi to at least 5 decimals: ");
        inputReader.nextDouble();
        
        System.out.println("What is the meaning of life, the universe & everything? ");
        meaningOfLifeAndEverything = Integer.parseInt(inputReader.next());
        
        System.out.println("What is your favorite kind of cheese? ");
        cheese = inputReader.next();
        
        System.out.println("Do you like the color red or blue more? ");
        color = inputReader.next();
        
        System.out.println("Oooh, " + color + " " + cheese + " sounds delicious!");
        System.out.println("The circumference of life is " + (2 * pi * meaningOfLifeAndEverything));
        
    }
    
    private static void PassingTheTurningTest() {
        
        String name, color, fruit, food;
        int number;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What's your name? ");
        name = inputReader.next();
        
        System.out.println("Hi " + name + "what's your favorite color? ");
        color = inputReader.next();
        
        System.out.println("Huh, " + color + "? Mine's blue.");
        
        System.out.println("I really like peaches. They're my favorite fruit.");
        System.out.println("What's YOUR favorite fruit." + name + "?");
        fruit = inputReader.next();
        
        System.out.println("Really?" + fruit + "?" + "That's great." );
        System.out.println("Speaking of favorites, what's your favorite number? ");
        number = inputReader.nextInt();
        
        System.out.println(number + "is a great number.");
        System.out.println("Did you know " + number + " * 7" + " is " + (number * 7) + "?");
        System.out.println("Well, thanks for talking to me, " + name);
          
        
    }
    
    public static void AllTheTrivia(){
        
        Scanner myScanner = new Scanner(System.in);
       
        
       String response1, response2, response3, response4;
        
        
        response1 = askQuestion("1,024 Gigabytes is equal to one what? ");
        
        System.out.println("In our solar system which is the only planet that rotates clockwise? ");
        response2 = myScanner.next();
        
        System.out.println("The largest volcano ever discovered in our solar system is located on which planet? ");
        response3 = myScanner.next();
        
        System.out.println("What is the most abundant element in the earth's atmosphere? ");
        response4 = myScanner.next();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + response3 + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + response1 + "!");
        System.out.println("That's amazing that " + response2 + " is the most abundant element in the atmosphere...");
        System.out.println(response4 + " is the only planet that rotates clockwise, neat!");
    
    }
    private static String askQuestion(String question) {
        Scanner myScanner = new Scanner(System.in);
        String response;
        
        System.out.println(question);
        response = myScanner.nextLine();
        
        return response;
    }
/*
    refactoring with askQuestion
    so AllTheTrivia can be....
    
    public static void AllTheTrivia(String[] args) {
    String response1, response2, response3, reponse4
    
    response1 = askQuestion("1024 Gigabytes is equal to one what? ");
    }
    so on and so forth
    
*/
    private static void DoItBetter() {
       Scanner inputR = new Scanner(System.in);
       
       int mile, hotdogs, lang;
       
        System.out.println("How many miles can you run? ");
        mile = inputR.nextInt();
        
        System.out.println("Good, but I can run " + (mile * 2 + 1) + " miles!");
        
        System.out.println("How many hotdogs can you eat? ");
        hotdogs = inputR.nextInt();
        
        System.out.println("I can eat " + (hotdogs * 2 + 1) + " hotdogs!");
        
        System.out.println("How many languages can you speak? ");
        lang = inputR.nextInt();
        System.out.println("I can actually speak " + (lang * 2 + 1) + " languages!");    
       
    }
    
    private static void HealthyHearts() {
        Scanner inputR = new Scanner(System.in);
        
        float age, maxRate;
        age = 0;
        maxRate = 220 - age;
        
        System.out.println("How old are you? ");
        age = inputR.nextInt();
        
        System.out.println("Your maximum heart rate should be  " + maxRate + " beats per minute");
        System.out.println("Your target HR Zone is " + (0.5 * maxRate) + "-" + (0.8 * maxRate) + " beats per minute");
        
    }
    
    private static void MiniMadLibs() {
        Scanner inputR = new Scanner(System.in);
        
        String noun, adj, noun2, number, adj2, pnoun, pnoun2, pnoun3, verb, pverb;
        
        System.out.println("I need a noun: ");
        noun = inputR.next();
        
        System.out.println("Now an ad: ");
        adj = inputR.next();
        
        System.out.println("Another noun: ");
        noun2 = inputR.next();
        
        System.out.println("And a number: ");
        number = inputR.next();
        
        System.out.println("Another adj: ");
        adj2 = inputR.next();
        
        System.out.println("A plural noun: ");
        pnoun = inputR.next();
        
        System.out.println("Another one: ");
        pnoun2 = inputR.next();
        
        System.out.println("One more: ");
        pnoun3 = inputR.next();
        
        System.out.println("A verb (present tense): ");
        verb = inputR.next();
        
        System.out.println("Same verb (past tense): ");
        pverb = inputR.next();
        
        System.out.println(noun + ": the " + adj + " frontier. These are voyages of the starship " + noun + 
                ". Its " + number + "-year mission: to explore strange " + adj2 + " " + pnoun + ", to seek out " +
                adj2 + " " + pnoun2 + " and " + adj2 + " " + pnoun3 + ", to boldly " + verb + " where no one has " 
        + pverb + " before.");
    }
    
}
