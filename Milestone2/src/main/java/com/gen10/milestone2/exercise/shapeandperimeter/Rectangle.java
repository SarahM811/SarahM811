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
public class Rectangle extends Shape {
    
    private float length;
    private float width;
    
    Rectangle(String name, float length, float width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    
    
    @Override
    public float getArea() {
        return length * width;
    }

    @Override
    public float getPerimeter() {
        return (2 * length) + (2 * width);
    }
    @Override
    public String toString() {
        return "Perimeter for the rectangle is> " + getPerimeter() + " area for the rectangle is>" + getArea();
    }
}
