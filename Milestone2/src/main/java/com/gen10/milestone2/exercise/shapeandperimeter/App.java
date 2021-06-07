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
public class App {
    public static void main(String[] args) {
        
        float[] sides = {23.2f, 13.4f, 16.6f};
        
        Shape square = new Square("square", 10.0f);
        Square square2 = new Square("square2", 15.0f);
        Shape rectangle = new Rectangle("Rectangle1", 10.0f, 20.0f);
        Shape triangle = new Triangle("traiangle", 15.0f, 25.0f, sides);
        Shape circle = new Circle("circle", 8.0f);
       // System.out.println(triangle.getPerimeter());
       // System.out.println(triangle.getArea());
        System.out.println(circle.toString());
        
       Shape[] ourShapes = {triangle, square, square2, rectangle, circle};
       describeShapes(ourShapes);
    }
    
    private static void describeShapes(Shape[] shapes) {
        for (Shape s : shapes) {
            s.toString();
            System.out.println(s.toString());
            System.out.println(s.getArea());
            System.out.println(s.getPerimeter());
            System.out.println("");
        }
    }
}
