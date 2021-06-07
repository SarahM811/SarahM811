/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author sakim
 */
public class Tax {

    private String State;
    private BigDecimal taxRate;

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 17 * hash + Objects.hashCode(this.State);
//        hash = 17 * hash + Objects.hashCode(this.taxRate);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Tax other = (Tax) obj;
//        if (!Objects.equals(this.State, other.State)) {
//            return false;
//        }
//        if (!Objects.equals(this.taxRate, other.taxRate)) {
//            return false;
//        }
//        return true;
//    }

    public Tax(String State, BigDecimal taxRate) {
        this.State = State;
        this.taxRate = taxRate;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "" + State + "" + taxRate;
    }

}
