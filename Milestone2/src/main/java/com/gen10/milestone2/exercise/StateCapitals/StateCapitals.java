/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise.StateCapitals;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author sakim
 */
public class StateCapitals {
    private String k;
    
    public static void main(String[] args ){
        HashMap <String, String> stateCap = new HashMap<>();
        stateCap.put("Alabama", "Montgomery");
        stateCap.put("Alaska", "Juneau");
        stateCap.put("Arizona", "Phoenix");
        stateCap.put("Arkansas", "Little Rock");
        
        Set<String> keys = stateCap.keySet();
        
        System.out.println("STATES: ");
        System.out.println("=============");
        for (String k: keys) {
            System.out.println(k);
        }
        System.out.println("\n");
        
        System.out.println("CAPTIALS: ");
        System.out.println("=============");
        for (String k: keys) {
            System.out.println(stateCap.get(k));
        }
        System.out.println("\n");
        
        System.out.println("STATE/CAPITAL PAIRS: ");
        System.out.println("=============");
        for (String k: keys) {
            System.out.println(k + " - " + stateCap.get(k));
        }
        
    }
}
