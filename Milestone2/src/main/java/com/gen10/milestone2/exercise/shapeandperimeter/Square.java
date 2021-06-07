/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise.shapeandperimeter;

/**
 *
 * @author sakim
 */
public class Square extends Rectangle {
    
    private float sideLength;

    public float getSideLength() {
        return sideLength;
    }

    public void setSideLength(float sideLength) {
        this.sideLength = sideLength;
        setLength(sideLength);
        setWidth(sideLength);
    }
    
    public Square(String name, float length, float width) {
        super(name, length, width);
        if (length == width) {
            this.sideLength = length;
          } else {
            throw new Error("Sdies do not match");
        }
    }
    
    public Square(String name, float sideLength) {
        super(name, sideLength, sideLength);
        this.sideLength = sideLength;
    }
    
//    Square(String name, float sideLength) {
//        super(name);
//        this.sideLength = sideLength;
//    }
//    
//    private float sideLength;
//    
//    public float getSideLength() {
//        return sideLength;
//    }
//    public void setSideLength(float sideLength) {
//        this.sideLength = sideLength;
//    }
//
//    @Override
//    public float getArea() {
//        return sideLength * sideLength;
//    }
//
//    @Override
//    public float getPerimeter() {
//       return 4 * sideLength;
//    }
//    @Override
//    public String toString() {
//        return "Perimeter for the square is> " + getPerimeter() + " area for the square is>" + getArea();
//    }
}
