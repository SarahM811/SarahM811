/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise9.exercis9;

import java.util.Arrays;

/**
 *
 * @author sakim
 */
public class FruitSalad_Class_optimize {
    


    private static int numBerries = 0;
    private static int numApples = 0;
    private static int numOranges = 0;
    private static int numTomatoes = 0;
    private static int numTotalFruit = 0;
    private static int numOtherFruit = 0;
    
    private static int numBerries2 = 0;
    private static int numApples2 = 0;
    private static int numOranges2 = 0;
    private static int numTomatoes2 = 0;
    private static int numTotalFruit2 = 0;
    private static int numOtherFruit2 = 0;
    
    private static int fsIndex= 0;
    
    private static String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", 
            "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", 
            "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry",
            "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        
    private static String[] fruitSalad = new String[12];

    public static void main(String[] args) {
        
        
        int fruitCount = 0;
        for (int i = 0; i < fruit.length; i++) {
            if ( checkForFruit(fruit[i]," apple") ) {
                numApples++;
            } else if (checkForFruit(fruit[i],"berry") ) {
                numBerries++;
            } else if (checkForFruit(fruit[i],"orange") ) {
                numOranges++;
            } else if (checkForFruit(fruit[i], "tomato") ) {
                numTomatoes++;
            } else {
                numOtherFruit++;
            }
            fruitCount++;
        
        }
        
        numTotalFruit = numApples + numBerries + numOranges + numTomatoes + numOtherFruit;
        
        if (fruitCount == numTotalFruit ) {
            System.out.println("Everything is good.");
        }
        
        System.out.println(numTotalFruit + " < total " + numApples + " < apples " + numBerries + " < berries " + numOranges + " < oranges " + numTomatoes + " < tomatoes " + numOtherFruit + "< other fruits.");
        
        
        addBerries(fsIndex);
        addOtherFruit();
        
        
        System.out.println("Enjoy!!");
        System.out.println(Arrays.toString(fruitSalad));
        
    }    
    
    private static void addBerries(int fsIndex) {
        for ( String fruitName : fruit ) {
            if ( fsIndex == 12) {break; }
            
            if ( checkForFruit(fruitName, "berry") ) {
                if (numBerries2 < 3) {
                    fruitSalad[fsIndex] = fruitName;
                    fsIndex++;
                    
                }
            }
        }
    }
    
    private static boolean checkForFruit(String matchString, String fruit) {
        return matchString.toLowerCase().contains(fruit);
        }

    private static void addOtherFruit() {
        for ( String fruitName : fruit ) {
            if ( fsIndex == 12) {break; }
            
            if ( checkForFruit(fruitName, "apple") ) {
                if (numApples2 < 3) {
                    fruitSalad[fsIndex] = fruitName;
                    fsIndex++;
                    numApples2++;
                }
                
            }   else if (checkForFruit(fruitName,"berry") ) {
                
                    continue;
                
            }   else if (checkForFruit(fruitName,"orange") ) {
                 if (numOranges2 < 2) {
                    fruitSalad[fsIndex] = fruitName;
                    fsIndex++;
                    numOranges2++;
                    }
                    
            }    else if (checkForFruit(fruitName, "tomato") ) {
                continue;
                    
            }   else {
                    fruitSalad[fsIndex] = fruitName;
                    fsIndex++;
                    numOtherFruit2++;
                    
            }
        }
    }
}

