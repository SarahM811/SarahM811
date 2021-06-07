/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise.StateCapitals;

/**
 *
 * @author sakim
 */
public class Capital {
    private String name;
    private int population;
    private float squareMiles;
    
    Capital(String name, int population, float squareMiles) {
        this.name = name;
        this.population = population;
        this.squareMiles = squareMiles;
    }
    
    @Override
    public String toString() {
        return name + "| population: " + population + "  | Area: " + squareMiles;
    }

}
