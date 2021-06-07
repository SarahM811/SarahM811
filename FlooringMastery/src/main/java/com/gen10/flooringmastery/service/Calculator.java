/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.service;

import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author sakim
 */
public class Calculator {
    
    public static BigDecimal calculateTotalTax(Tax tax, BigDecimal totalLaborCost, BigDecimal totalMaterialCost) {
        BigDecimal laborAndMaterial = totalLaborCost.add(totalMaterialCost);
        BigDecimal taxRate = tax.getTaxRate().divide(new BigDecimal("100"));
        return laborAndMaterial.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
    }

    
    public static BigDecimal totalLaborCost(Order order, Product selectedProd) {
        return order.getArea().multiply(selectedProd.getLaborCostPerSqFt()).setScale(2, RoundingMode.HALF_UP);
    }

    
    public static BigDecimal totalMaterialCost(Order order, Product selectedProd) {
        return order.getArea().multiply(selectedProd.getCostPerSqFt()).setScale(2, RoundingMode.HALF_UP);
    }

    
    public static BigDecimal totalCost(BigDecimal laborAndMaterial, BigDecimal totalTax) {
        return laborAndMaterial.add(totalTax).setScale(2, RoundingMode.HALF_UP);
    }
}
