/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis10.helloworld;

/**
 *
 * @author sakim
 */
public class Helloworld {
     public static void main (String[] args) {
     System.out.println("Hello, World!");
     sayHello("Jonathan");
     String goodByeString = goodByeString("Aria");
     sayGoodBye(goodByeString);
             
 } 
     private static void sayHello(String name) {
         System.out.println("Hello," + name + "!");
     }
     
   
     public static void sayGoodBye(String goodByeString) {
         System.out.println(goodByeString);
     }
     public static String goodByeString(String name) {
         String goodByeString = "GoodBye " + name;
         return goodByeString;
     }
     
     
}
