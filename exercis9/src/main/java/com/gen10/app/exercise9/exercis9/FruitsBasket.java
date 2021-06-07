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
public class FruitsBasket {
    public static void main(String[] args) {
        
        int apple = 0;
        int orange = 0;
        
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        for (int i=0; i < fruit.length; i++) {
            if (fruit[i] == "Apple") {
                apple++;
            } else {
                orange++;
            }
        }
        
        String[] appleArr = new String[apple];
        String[] orangeArr = new String[orange];
        
        
        int appleIndex = 0;
        int orangeIndex = 0;
        
        for (int i = 0; i < fruit.length; i++) {
            if("Apple".equals(fruit[i])) {
                appleArr[appleIndex] = fruit[i];
                appleIndex++;
            } else if ("Orange".equals(fruit[i])) {
                orangeArr[orangeIndex] = fruit[i];
                orangeIndex++;
            }
        }
        
        
        System.out.println("# of fruits: " + fruit.length);
        System.out.println("# of apples: " + apple);
        System.out.println("# of oranges: " + orange);
        System.out.println(Arrays.toString(appleArr));
        System.out.println(Arrays.toString(orangeArr));

    }
}
