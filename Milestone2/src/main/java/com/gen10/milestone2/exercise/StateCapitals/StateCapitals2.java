/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise.StateCapitals;

import java.util.HashMap;

/**
 *
 * @author sakim
 */
public class StateCapitals2 {
    static String[][] capitalData = {{"Montgomery", "205000", "156"},
        {"Juneau", "31000", "3255"},
        { "Phoenix","1445000","517"},
        {"Little Rock", "193000", "116"} };
    static String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas"};
    
    static HashMap<String, Capital> capitalMap = new HashMap<>();
    
    public static void main(String[] args) {
        buildCaptialMap();
        outputValues();
    }

    private static void buildCaptialMap() {
        for (int i = 0; i < states.length; i++) {
            String name = capitalData[i][0];
            int population = Integer.parseInt(capitalData[i][1]);
            float squareMiles = Float.parseFloat(capitalData[i][2]);
            Capital capital = new Capital(name, population, squareMiles);
            capitalMap.put(states[i],capital);
        }
    }

    private static void outputValues() {
       // for ( String state : capitalMap.keySet()) {
        for ( String state : states) {
            Capital c = capitalMap.get(state);
            System.out.println(state + " - " + c.toString());
        }
    }
    
    
}
