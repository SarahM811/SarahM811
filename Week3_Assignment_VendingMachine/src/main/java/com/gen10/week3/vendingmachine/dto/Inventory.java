/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.dto;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sakim
 */
public class Inventory {

    private String item;
    private BigDecimal price;
    private int inventoryCount;
    // public static Inventory Snickers, Milkyway, Doritos, Sunchips;

    public Map<String, Inventory> inventoryMap = new HashMap<>();

//    public Inventory(String item, BigDecimal price, int inventoryCount) {
//        this.item = item;
//        this.price = price;
//        this.inventoryCount = inventoryCount;
//    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;

    }

    @Override
    public String toString() {
        return " Item: " + item + " |Price: " + price + " "
                 + " |Inventory count: " + inventoryCount;
    }

}
