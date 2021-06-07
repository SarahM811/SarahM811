/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.simplecalculator;

/**
 *
 * @author sakim
 */
public class SimpleCalculator {
    private int num1, num2;
    private String operator;
    private int[] array;
    /*
    public void simpleCalc(String operator, int[] array) {
        System.out.println(playSC(operator, array));
    }
    */
    
    public int playSC(String operator, int[] array){
        if (operator.equalsIgnoreCase("addition")) {
            return addition(array[0], array[1]);
        } else if (operator.equalsIgnoreCase("subtraction")) {
            return subtraction(array[0], array[1]);
        } else if (operator.equalsIgnoreCase("multiplication")) {
            return multiplication(array[0], array[1]);
        } else if (operator.equalsIgnoreCase("division")) {
            return division(array[0], array[1]);
        } else {
            System.out.println("Invalid operator");
            return 0;
        }
        
    }
    
    public int addition(int num1, int num2) {
        return num1 + num2;
    }
    
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }
    
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }
    
    public int division(int num1, int num2) {
        return num1 / num2;
    }
}
