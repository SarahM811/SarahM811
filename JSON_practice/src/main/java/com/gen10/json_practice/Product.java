/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.json_practice;

import java.math.BigDecimal;

/**
 *
 * @author sakim
 */
class Product {
     private String productType;
    private int costPerSqFt;
    private int laborCostPerSqFt;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(int costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public int getLaborCostPerSqFtCarpet() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFtCarpet(int laborCostPerSqFtCarpet) {
        this.laborCostPerSqFt = laborCostPerSqFtCarpet;
    }
}
