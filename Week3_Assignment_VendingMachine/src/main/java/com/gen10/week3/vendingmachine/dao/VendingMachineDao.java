/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.dao;

import com.gen10.week3.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sakim
 */
public interface VendingMachineDao {
    
    Map<String, Integer> inventoryList = new HashMap<>();
    
    public boolean EnoughMoney(BigDecimal userMoney, BigDecimal price) throws VendingMachineDaoException;
    
    public int[] calculateChange(BigDecimal userMoney, BigDecimal price) throws VendingMachineDaoException;
    
  //  public void updateInventory (Inventory item) throws VendingMachineDaoException ;
    public Inventory updateInventory (Inventory item) throws VendingMachineDaoException ;
    
  public ArrayList<Inventory> inventoryList() throws VendingMachineDaoException;
    
    public Inventory chooseItem(int userChoice) throws VendingMachineDaoException;

   public void removeItem(String itemName) throws VendingMachineDaoException;
  
}
