/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dto;

import com.gen10.flooringmastery.service.Calculator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sakim
 */
public class Order {

    private int orderNumber;
    private String customerName;
    private String state;
    private String productType;
    private BigDecimal area;
    private static int startingOrderNumber = 1;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private Product product;
    private Tax tax;

    public Order() {
        this.orderNumber = generateOrderNumber();
        this.date = getCurrentDate();
    }

    public String getCurrentDate() {
        LocalDate ld = LocalDate.now();
        String formattedDate = ld.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        return formattedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getTotalTaxAmount() {
        return Calculator.calculateTotalTax(tax, getLaborCost(), getMaterialCost());
    }

    

    public BigDecimal getLaborCost() {
        return Calculator.totalLaborCost(this, product);
    }

   
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
        if (startingOrderNumber <= orderNumber) {
            Order.startingOrderNumber = orderNumber + 1;
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return Calculator.totalMaterialCost(this, product);
    }

    
    public BigDecimal getTotal() {
        return Calculator.totalCost(getLaborCost().add(getMaterialCost()), getTotalTaxAmount());
    }

    

    public void editProperty(int propertyIndex, Object newValue) {
        switch (propertyIndex) {
            case 0:
                setCustomerName((String) newValue);
                break;
            case 1:
                setState((String) newValue);
                break;
            case 2:
                setProductType((String) newValue);
                break;
            case 3:
                setArea((BigDecimal) newValue);
               
                break;

            default:
                System.out.println("");
        }
    }

    public String[] getPropertyNames() {
        return new String[]{"Customer Name", "State", "Product Type", "Area"};
    }

    public int generateOrderNumber() {
        return startingOrderNumber++;
    }

    public String marshalize(Order order, String delimiter) {
        return String.join(delimiter, new String[]{Integer.toString(order.getOrderNumber()), order.getCustomerName(), order.getState(), order.getTax().getTaxRate().toString(),
            order.getProductType(), order.getProduct().getCostPerSqFt().toString(), order.getProduct().getLaborCostPerSqFt().toString(), order.getArea().toString(), order.getMaterialCost().toString(),
            order.getLaborCost().toString(), order.getTotalTaxAmount().toString(), order.getTotal().toString()});
    }
    
    @Override
    public String toString() {
        return "Order number: " + getOrderNumber() + "| customer name: " + getCustomerName() + "| state: " + getState() + "| product type: " + getProductType()
                + "| area: " + getArea();
    }
}
