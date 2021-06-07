/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.dao;

import com.gen10.week3.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sakim
 */
public class VendingMachineDaoTest {
   
   private Inventory currentItem = new Inventory();
   
        
    VendingMachineDao dao;
    Map<String, Inventory>inventoryMap = new HashMap<>();
    
    public VendingMachineDaoTest() {
    this.dao = new VendingMachineDaoFileImpl();

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws VendingMachineDaoException {
        
       List<Inventory> inventoryList = dao.inventoryList();

        for (int i =0; i<inventoryList.size(); i++) {
            inventoryList.remove(i);
        }
    }
    
    @After
    public void tearDown() throws VendingMachineDaoException {
        dao.removeItem("chocolate");
    }

    /**
     * Test of EnoughMoney method, of class VendingMachineDao.
     */
    @Test
    public void testEnoughMoney() throws Exception {
        BigDecimal userMoney = new BigDecimal(2);
        BigDecimal price = new BigDecimal(1);
        
       boolean fromDao = dao.EnoughMoney(userMoney, price);
        
        assertEquals(true, fromDao);
        
    }

    /**
     * Test of calculateChange method, of class VendingMachineDao.
     */
    @Test
    public void testCalculateChange() throws Exception {
        BigDecimal userMoney = new BigDecimal(2);
        BigDecimal price = new BigDecimal(1);
        
        int[] daoChange = dao.calculateChange(userMoney, price);
        assertEquals(4, daoChange[0]);
        
        BigDecimal userMoney1 = new BigDecimal(1.41);
        BigDecimal price1 = new BigDecimal(1);
        
        int[] daoChange1 = dao.calculateChange(userMoney1, price1);
        assertEquals(1, daoChange1[0]);
        assertEquals(1, daoChange1[1]);
        assertEquals(1, daoChange1[2]);
        assertEquals(1, daoChange1[3]);
   
    }

    /**
     * Test of updateInventory method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateInventory() throws Exception {
//        Inventory currentItem = new Inventory();
        currentItem.setItem("chocolate");
        currentItem.setPrice(BigDecimal.ONE);
        currentItem.setInventoryCount(5);
       
        dao.updateInventory(currentItem);
       assertEquals(4, currentItem.getInventoryCount());
        
               
    }

    /**
     * Test of inventoryList method, of class VendingMachineDao.
     */
    @Test
    public void testInventoryList() throws Exception {
        List<Inventory> fromDao = dao.inventoryList();
        assertEquals(4, fromDao.size());
        
        for ( Inventory item : fromDao ) {
            assertTrue(item instanceof Inventory);
        }
        
    }

    /**
     * Test of chooseItem method, of class VendingMachineDao.
     */
    @Test
    public void testChooseItem() throws Exception {
       
        int userChoice = 1;
        Inventory fromDao = dao.chooseItem(userChoice);
        
        assertEquals("Snickers", fromDao.getItem());
    }


   
    
}
