/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.UserIO;

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

//    public int getNum1() {
//        return num1;
//    }
//
//    public void setNum1(int num1) {
//        this.num1 = num1;
//    }
//
//    public int getNum2() {
//        return num2;
//    }
//
//    public void setNum2(int num2) {
//        this.num2 = num2;
//    }
//
//    public String getOperator() {
//        return operator;
//    }
//
//    public void setOperator(String operator) {
//        this.operator = operator;
//    }
//
//    public int[] getArray() {
//        return array;
//    }
//
//    public void setArray(int[] array) {
//        this.array = array;
//    }
    
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
