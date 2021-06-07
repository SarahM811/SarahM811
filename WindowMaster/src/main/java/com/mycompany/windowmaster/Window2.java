/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windowmaster;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class Window2 {
    static Scanner myScanner = new Scanner(System.in);
// inside this class, i can access myScanner
    
    public static void main(String[] args) {
        float windowHeight = getFloat("What is the window height?");
        float windowWidth = getFloat("What is the window width?");
                  
        float area = getArea(windowWidth, windowHeight);
        float perimeter = getPerimeter(windowWidth, windowHeight);
        float cost = getCost(area, perimeter);    
        
        outputValues(area, perimeter, cost);
    }
    
    private static float getFloat(String question) {
        return Float.parseFloat(getInput(question));
    }
    
    private static String getInput(String question) {
        System.out.println(question);
        return myScanner.nextLine();
        

    }
    
   private static float getArea(float width, float height) {
       float area = width * height;
       return area;
   }
   
   private static float getPerimeter (float width, float height) {
       return 2 * (width + height);
   }
   
   private static float getCost(float area, float perimeter) {
       return 3.50f * area + (float)2.25 * perimeter;
   }
   
   private static void outputValues(float area, float perimeter, float cost) {
       System.out.println("The area is: " + area);
       System.out.println("The perimeter is: " + perimeter);
       System.out.println("The cost is: " + cost);
   }
}
