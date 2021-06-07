/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.service;

import com.gen10.week3.vendingmachine.dao.VendingMachineAuditDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoException;
import com.gen10.week3.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author sakim
 */
public class VendingMachineService {

    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;

    public VendingMachineService(VendingMachineDao dao, VendingMachineAuditDao auditDao) throws VendingMachineDaoException {

        this.dao = dao;
        this.auditDao = auditDao;
    }

    public void validateMoney(BigDecimal userMoney, Inventory item) throws InsufficientFundsException, VendingMachineDaoException {

        BigDecimal itemPrice = item.getPrice();
        if (userMoney.compareTo(itemPrice) < 0) {
          //  auditDao.writeAuditEntry(userMoney + " is insufficient amount of fund.");
            throw new InsufficientFundsException("ERROR: not enough money to complete transaction.");
        }
    }

    public int[] calculateChange(BigDecimal userMoney, BigDecimal price) throws VendingMachineDaoException {
        return dao.calculateChange(userMoney, price);
    }

    public Inventory updateInventory(Inventory item) throws VendingMachineDaoException {
       
        return dao.updateInventory(item);
        

    }

    public Inventory chooseItem(int userChoice) throws OutOfStockException, VendingMachineDaoException {
        Inventory chosenItem = dao.chooseItem(userChoice);
        if (chosenItem.getInventoryCount() > 0) {
           // auditDao.writeAuditEntry(chosenItem.getItem() + " is successfully dispensed to the customer");
            return chosenItem;
        } else {
           // auditDao.writeAuditEntry(chosenItem.getItem() + " is out of stock");
            throw new OutOfStockException(chosenItem.getItem() + " is currently out of stock.");
            
        }

    }

    public ArrayList<Inventory> inventoryList() throws VendingMachineDaoException {
        return dao.inventoryList();
    }
    
    public void removieItem(String itemName) throws VendingMachineDaoException {
        dao.removeItem(itemName);
    }
}
