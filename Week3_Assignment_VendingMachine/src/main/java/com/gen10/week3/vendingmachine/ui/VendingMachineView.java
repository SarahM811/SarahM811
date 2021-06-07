/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.ui;

import com.gen10.week3.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author sakim
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    public void displayMenu() {
        io.print("Vending Machine");
        io.print("====Main Menu====");
        io.print("1. Snickers - $1.25");
        io.print("2. MilkyWay - $1.50");
        io.print("3. Sunchips - $1.40");
        io.print("4. Doritos - $1.75");
        io.print("5. Exit");
    }
    
    public BigDecimal getUserMoney() {
       
        String userInput = io.readString("How much money would you like to insert into the vending machine?");
        BigDecimal userMoney = new BigDecimal(userInput);
        return userMoney;
    }
    
    public int getUserChoice() {
        int userChoiceOfItem = io.readInt("Please choose an item you would like to purchase.", 1,5);
                return userChoiceOfItem;
    }
    
    public void displayChanges(int[] numberOfChanges) {
        io.print("Your changes are: " + numberOfChanges[0] + " quarters | " + numberOfChanges[1] + " dimes | " + numberOfChanges[2] + " nickels | " + numberOfChanges[3] 
                + " pennies");
    }
    
    public void displayItemInfo(String[] chosenItem) {
        io.print("You chose: " + chosenItem[0] + "| price: " + chosenItem[1] + "| inventory: " + chosenItem[2]);
    }
    
    public void displayInventoryInfo(List<Inventory> itemList) {
        io.print("====Current Inventory====");
        for (Inventory currentItem: itemList) {
            io.print(currentItem.getItem() + " [$" + currentItem.getPrice() + "] [" + currentItem.getInventoryCount() + " available.]");
        }
    }
    
    public void displayInsufficientMoney() {
        io.print("Insufficient fund.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print(errorMsg);
    }

    public void displayExitMessage() {
        io.print("Good bye!");
    }

        
}
