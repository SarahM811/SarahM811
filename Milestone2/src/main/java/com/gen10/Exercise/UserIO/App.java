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
public class App {

    private static SimpleCalculator myCalculator = new SimpleCalculator();
    private static UserIO io = new UserIOConsole();

    public static void main(String[] args) {

        int userChoice = io.readInt("What operation would you like to perform?");

        if (userChoice == 5) {
            io.print("Thank you!");
            System.exit(0);
        }

        int userOperand1 = io.readInt("Choose one integer operand to calcualte");
        int userOperand2 = io.readInt("chosse another integer operand");

        String value = performOperation(userChoice, userOperand1, userOperand2);
        io.print("The result is : " + value);
    }

    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    private static String performOperation(int userChoice, int userOperand1, int userOperand2) {
        String value = "";
        switch (userChoice) {
            case ADDITION:
                value = "" + myCalculator.addition(userOperand1, userOperand2);
                break;
            case SUBTRACTION:
                value = "" + myCalculator.subtraction(userOperand1, userOperand2);
                break;
            case MULTIPLICATION:
                value = "" + myCalculator.multiplication(userOperand1, userOperand2);
                break;

            case DIVISION:
                value = "" + myCalculator.division(userOperand1, userOperand2);
                break;
        }
        return value;
    }
}
