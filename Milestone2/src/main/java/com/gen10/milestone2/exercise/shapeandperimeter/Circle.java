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
public class Circle extends Shape {
    private float radius;
    final private float PI = (float)Math.PI;
    
    Circle(String name, float radius) {
            super(name);
            this.radius = radius;

        }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
    
    
    @Override
    public float getArea() {
        return PI *  radius * radius;
    }

    @Override
    public float getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Perimeter for the circle is> " + getPerimeter() + " area for the circle is>" + getArea();
    }
    
}
