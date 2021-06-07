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
public abstract class Shape {
    private String name;
    Shape(String name) {
        this.name = name;
    }
    
    public abstract String toString();
    public abstract float getArea();
    public abstract float getPerimeter() ;
}
