/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author sakim
 */
public class Change {
    private int numQuarter;
    private int numDime;
    private int numNickel;
    private int numPennies;
    public static BigDecimal QUARTER = new  BigDecimal(0.25);
    public static BigDecimal DIME = new BigDecimal(0.10);
    public static BigDecimal NICKEL = new BigDecimal(0.05);
    public static BigDecimal PENNIES = new BigDecimal(0.01);

    public int getNumQuarter() {
        return numQuarter;
    }

    public void setNumQuarter(int numQuarter) {
        this.numQuarter = numQuarter;
    }

    public int getNumDime() {
        return numDime;
    }

    public void setNumDime(int numDime) {
        this.numDime = numDime;
    }

    public int getNumNickel() {
        return numNickel;
    }

    public void setNumNickel(int numNickel) {
        this.numNickel = numNickel;
    }

    public int getNumPennies() {
        return numPennies;
    }

    public void setNumPennies(int numPennies) {
        this.numPennies = numPennies;
    }
    
    
    
}
