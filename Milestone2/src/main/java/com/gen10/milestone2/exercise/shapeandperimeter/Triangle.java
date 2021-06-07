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
public class Triangle extends Shape {
    final private int SIDES = 3;
    private float base;
    private float height;
    
    private float[] sides;
    
    Triangle(String name, float base, float height, float[] sides) {
        super(name);
        this.sides = new float [SIDES];
        this.base = base;
        this.height = height;
        for (int i = 0; i < SIDES; i++) {
            this.sides[i] = sides[i];
    
        }
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getSide(int index) {
        return sides[index];
    }

    public void setSide(int index, float side) {
        this.sides[index] = sides[index];
    }

    public float[] getSides() {
        return sides;
    }

    public void setSides(float[] sides) {
        this.sides = sides;
    }
    
    

    @Override
    public float getArea() {
        return (0.5f * (base * height));    
    }

    @Override
    public float getPerimeter() {
        return sides[0] + sides[1] + sides[2];
    }
    @Override
    public String toString() {
        return "Perimeter for the triangle is> " + getPerimeter() + " area for the triangle is>" + getArea();
    }
}
