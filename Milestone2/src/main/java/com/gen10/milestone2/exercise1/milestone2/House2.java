/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise1.milestone2;

/**
 *
 * @author sakim
 */
public class House2 {
    private int squareFootage;
    private int numberOfRooms;
    private int width;
    private int height;
    private int length;
    private int celingHeight;
    private int numberOfWindows;
    private int numberOfFloors;
    private Theme theme;
    
    
   
            
            
    House2(int squareFootage, int numberOfRooms) {
        this.squareFootage = squareFootage;
        this.numberOfRooms = numberOfRooms;
        
    }
            
   
    public void getInventory() {
        //prints out inventory of the house
    }
    
    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    
}
