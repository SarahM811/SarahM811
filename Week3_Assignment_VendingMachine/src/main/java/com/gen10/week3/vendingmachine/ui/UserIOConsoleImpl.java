/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.ui;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class UserIOConsoleImpl implements UserIO {
   
    
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    
    @Override
    public double readDouble(String prompt) {
        String value = readString(prompt);
        return Double.parseDouble(value);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double value = readDouble(prompt);
//        if ( value < min || value > max) {
//            System.out.println("Invalid value, must be: " + min + " < value < " + max);
//            return readDouble(prompt, min, max);
//        } else {
            return value;
 //       }
    }

    @Override
    public float readFloat(String prompt) {
        String value = readString(prompt);
        return Float.parseFloat(value);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float value = readFloat(prompt);
//        if ( value < min || value > max) {
//            System.out.println("Invalid value, must be: " + min + " < value < " + max);
//            return readFloat(prompt, min, max);
//        } else {
            return value;
      //  }
    }

    @Override
    public int readInt(String prompt) {
        String value = readString(prompt);
        try {
             return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            print("invlide number. number must be an integer");
            return readInt(prompt);
        }
           
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int value = readInt(prompt);
//        if ( value < min || value > max) {
//            System.out.println("Invalid value, must be: " + min + " < value < " + max);
//            return readInt(prompt, min, max);
//        } else {
            return value;
        //}
    }

    @Override
    public long readLong(String prompt) {
        String value = readString(prompt);
        return Long.parseLong(value);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long value = readLong(prompt);
//        if ( value < min || value > max) {
//            System.out.println("Invalid value, must be: " + min + " < value < " + max);
//            return readLong(prompt, min, max);
//        } else {
            return value;
     //   }
    }
    
    @Override
    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }
    
}

