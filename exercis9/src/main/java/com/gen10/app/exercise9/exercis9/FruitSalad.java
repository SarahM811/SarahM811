/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.exercis9;

/**
 *
 * @author sakim
 */
public class FruitSalad {
    public static void main(String[] args) {
        
        /*
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", 
            "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", 
            "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry",
            "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        int saladIndex = 0;
        String[] fruitSalad = new String[saladIndex];
        String[] berry = {"Blueberry", "Strawberry", "Raspberry", "Blackberry", "Snozzberry"};
        
        
        
        
        for (int i = 0; i < fruit.length; i++ ) {
            if ( fruit[i].equals("Blueberry") || fruit[i].equals("Strawberry") || fruit[i].equals("Raspberry") || fruit[i].equals("Blackberry") || fruit[i].equals("Snozzberry") ) {
                fruitSalad[saladIndex] = fruit[i];
                saladIndex++;
            } else if()
        }
        */
        
       int apples = 0;
       int oranges = 0;
       int tomatoes = 0;
       int otherFruits = 0;
       int appleCounter = 0;
       int orangeCounter = 0;
       int tomatoesCounter = 0;
       int otherFruitsCounter = 0;

       String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", 
           "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", 
           "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", 
           "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
       

       String[] fruitSalad = new String[12];

       // Code Recipe for fruit salad should go here!

       for(int i = 0; i < fruit.length; i++){
           if ("Apple".contains(fruit[i])){
               apples++;
           } else if ("Orange".contains(fruit[i])) {
               oranges++;
           } else if ("Tomato".contains(fruit[i])) {
               tomatoes++;
           } else {
               otherFruits++;
           }
       }

       String[] appleArray = new String[apples];
       String[] orangeArray = new String[oranges];
       String[] tomatoArray = new String[tomatoes];
       String[] otherFruitsArray = new String[otherFruits];

       for(int i =0; i < fruit.length; i++){
           if ("Apple".equals(fruit[i])){
               appleArray[appleCounter] = fruit[i];
               appleCounter++;
           } else if ("Orange".equals(fruit[i])){
               orangeArray[orangeCounter] = fruit[i];
               orangeCounter++;
           } else if ("Tomato".equals(fruit[i])){
               tomatoArray[tomatoesCounter] = fruit[i];
               tomatoesCounter++;
           } else {
               otherFruitsArray[otherFruitsCounter] = fruit[i];
               otherFruitsCounter++;
           }
    }
}
