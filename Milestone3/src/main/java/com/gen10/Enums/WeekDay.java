/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Enums;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class WeekDay {
    
   private static Scanner scanner = new Scanner(System.in);
  
   
    public static void main(String[] args) {
        
         System.out.println("What day is it today?");
         String response = scanner.nextLine();
         switch (response) {
             case "monday":
                daysUntilFriday(Week.MONDAY);
                break;
                case "tuesday":
                 daysUntilFriday(Week.TUESDAY);
                 break;
                 case "wednesday":
                 daysUntilFriday(Week.WEDNESDAY);
                 break;
                 case "thursday":
                 daysUntilFriday(Week.THURSDAY);
                 break;
                 case "Friday":
                 daysUntilFriday(Week.FRIDAY);
                 break;
                 default:
                 throw new UnsupportedOperationException();
         }
    }
    
    
    
    
    public static void daysUntilFriday(Week dayEnum) {
               
        switch (dayEnum){
            case MONDAY:
                System.out.println("You have 4 days until Friday");
            case TUESDAY:
                System.out.println("You have 3 days until Friday");
            case WEDNESDAY:
                System.out.println("You have 2 days until Fiday");
            case THURSDAY:
                System.out.println("You have 1 day until Friday");
            case FRIDAY:
                System.out.println("Today is Friday!");
            default:
                //throw new UnsupportedOperationException();
                System.out.println("Something's wrong");
                
        }
    }
}
