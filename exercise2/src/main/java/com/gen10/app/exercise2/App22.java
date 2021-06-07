/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise2;


/**
 *
 * @author sakim
 */
public class App22 {
    
    //Function to print hollow rectangle
    static void print_rectangles(int n, int m) {
        int i, j;
        for (i =1; i <= n; i++)
        {
            for (j =1; j<=m; j++)
            {
                if (i == 1 || i == n ||
                    j == 1 || j == m)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
            
    public static void main(String[] args) {
        MenuOfChampions();
    }
    
        private static void InABucket() {
             //declare all KINDS of variables
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;
        
        //but declaring them just sets up the space for data
        //to use the variable, you have to data IN it first!
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        
        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.print("He was a bit hungry today, and ate this many pies : ");
        System.out.println(piesEaten);
        }
    
        private static void MoreBucketMoreFun() {
            //declare ALL THE THINGS
            //it's a good idea to declare them at the beginning
            int butterflies, beetles, bugs;
            String color, size, shape, thing;
            double number;
            
            // now give a couple of them values
            butterflies = 2;
            beetles = 4;
            
            bugs = butterflies + beetles;
            System.out.println("There are only " + butterflies + " butterflies");
            System.out.println("but " + bugs + " bugs total.");
            System.out.println("Uh oh, my dog at one.");
            butterflies--;
            System.out.println("Now there are only " + butterflies + " butterflies lieft.");
            System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
            System.out.println("Maybe I just counted wrong the first time...");
        }
        
        private static void TheOrderOfThings() {
            double number;
            String opinion, size, age, shape, color, origin, material, purpose;
            String noun;
            
            number = 5.0;
            opinion = "AWESOME";
            size = "teensy-weensy";
            age = "new";
            shape = "oblong";
            color = "BRIGHT yellow";
            origin = "AlphaCentaurian";
            material = "platinum";
            purpose = "good";
            
            noun = "dragons";
            
            //using + with strings - sticks them together
            System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape + " " + color + " " + origin + " " + material+ " " + purpose + " " + noun);
            
        }
        
        private static void BestAdderEver() {
            int apple, pear;
            String me, dogs, pet, many ;
            
            me = " dogs.";
            dogs = "Finn and Eevee are my dogs.";
            pet = "I have ";
            many = "I can't have " ;       
            apple = 2;
            pear = 3;
                  
            System.out.println(pet + apple + me + many + pear + me + dogs);
        }
        
        private static void MenuOfChampions() {
            
           int rows = 6, colums = 20;
           print_rectangle(rows, columns);
            
            String food1, food2, food3;
            float price1, price2, price3;
            
            food1 = "pasta $ ";
            food2 = "steak $ ";
            food3 = "shrimp scampi $ ";
            price1 = 8;
            price2 = 12;
            price3 = 11;
            
            System.out.println(food1 + price1);
            System.out.println(food2 + price2);   
            System.out.println(food3 + price3);
        }
}
