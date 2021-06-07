/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.controller;

import com.gen10.week3.vendingmachine.dao.VendingMachineDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoException;
import com.gen10.week3.vendingmachine.dto.Inventory;
import com.gen10.week3.vendingmachine.service.InsufficientFundsException;
import com.gen10.week3.vendingmachine.service.OutOfStockException;
import com.gen10.week3.vendingmachine.service.VendingMachineService;
import com.gen10.week3.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author sakim
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineDao dao;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws OutOfStockException, InsufficientFundsException, VendingMachineDaoException {
        boolean keepGoing = true;
        service.inventoryList();
        int userChoice = 0;

        while (keepGoing) {
            view.displayMenu();
            BigDecimal userMoney = view.getUserMoney();

            userChoice = getUserChoice();
            System.out.println("Choice: " + userChoice);

            if (userChoice == 5) {
                keepGoing = false;
            } else {

                Inventory chosenItem;
                try {
                    chosenItem = service.chooseItem(userChoice);
                } catch (OutOfStockException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                }
                displayInventory();

                boolean hasMoney = validateMoney(userMoney, chosenItem);
                if (hasMoney == true) {
                    service.updateInventory(chosenItem);
                    int[] changes = service.calculateChange(userMoney, chosenItem.getPrice());
                    view.displayChanges(changes);
                } else {
                    view.displayInsufficientMoney();
                   // run();

                }
            }

        }
        view.displayExitMessage();

    }

    private int getUserChoice() {
        return view.getUserChoice();
    }

    private boolean validateMoney(BigDecimal userMoney, Inventory item) throws VendingMachineDaoException, InsufficientFundsException, OutOfStockException {
        try {

            service.validateMoney(userMoney, item);

        } catch (InsufficientFundsException e) {
            view.displayErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private void displayInventory() throws VendingMachineDaoException {
        List<Inventory> itemList = service.inventoryList();
        view.displayInventoryInfo(itemList);
    }

   

}
