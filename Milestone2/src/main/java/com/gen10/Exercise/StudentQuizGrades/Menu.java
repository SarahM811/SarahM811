/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.Exercise.StudentQuizGrades;

/**
 *
 * @author sakim
 */
public class Menu {
    UserIO io;
    
    Menu(UserIO io) {
        this.io = io;
    }
    
    public int display() {
        io.print("Pick one of the following options: ");
        io.print("1. Add students");
        io.print("2. List students");
        io.print("3. Remove students");
        io.print("4. Show student quiz scores");
        io.print("5. View student quize score average");
        io.print("6. Get lowest score");
        io.print("7. Exit the program");
        
        return io.readInt("Select one: ");
       
    }
    
    
    
    
}
