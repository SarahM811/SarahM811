/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.service;

import com.gen10.week3.vendingmachine.controller.VendingMachineController;
import com.gen10.week3.vendingmachine.dao.VendingMachineAuditDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineAuditDaoFileImple;
import com.gen10.week3.vendingmachine.dao.VendingMachineDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoException;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.gen10.week3.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
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
public class VendingMachineServiceTest {

    VendingMachineService service;

    Map<String, Inventory> inventoryMap = new HashMap<>();

    public VendingMachineServiceTest() throws VendingMachineDaoException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VendingMachineService.class);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws VendingMachineDaoException {
        List<Inventory> inventoryList = service.inventoryList();

        for (int i = 0; i < inventoryList.size(); i++) {
            inventoryList.remove(i);
        }
    }

    @After
    public void tearDown() throws VendingMachineDaoException {
        service.removieItem("chocolate");
    }

    /**
     * Test of validateMoney method, of class VendingMachineService.
     */
    @Test
    public void testValidateMoney() throws Exception {
        Inventory item1 = new Inventory();
        item1.setPrice(BigDecimal.ONE);
        BigDecimal userMoney = new BigDecimal(2);

        service.validateMoney(userMoney, item1);

        try {
            Inventory item2 = new Inventory();
            item2.setPrice(BigDecimal.TEN);
            BigDecimal userMoney2 = new BigDecimal(1);
            service.validateMoney(userMoney2, item2);
        } catch (InsufficientFundsException e) {
            assertEquals("ERROR: not enough money to complete transaction.", e.getMessage());
            return;
        }

    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateChange() throws Exception {
        BigDecimal userMoney1 = new BigDecimal(1.41);
        BigDecimal price1 = new BigDecimal(1);

        int[] serviceChange1 = service.calculateChange(userMoney1, price1);
        assertEquals(1, serviceChange1[0]);
        assertEquals(1, serviceChange1[1]);
        assertEquals(1, serviceChange1[2]);
        assertEquals(1, serviceChange1[3]);
    }

    /**
     * Test of updateInventory method, of class VendingMachineService.
     */
    @Test
    public void testUpdateInventory() throws Exception {
        Inventory currentItem = new Inventory();
        currentItem.setItem("chocolate");
        currentItem.setPrice(BigDecimal.ONE);
        currentItem.setInventoryCount(5);

        service.updateInventory(currentItem);
        assertEquals(4, currentItem.getInventoryCount());
    }

    /**
     * Test of chooseItem method, of class VendingMachineService.
     */
    @Test
    public void testChooseItem() throws Exception {
       
        int userChoice = 1;
        Inventory fromService = service.chooseItem(userChoice);

        assertEquals("Snickers", fromService.getItem());

        try {
            //userChoice 2 is Milkyway, which is out of stock
            Inventory result = service.chooseItem(2);
        } catch (OutOfStockException e) {
            assertEquals("Milkyway is currently out of stock.", e.getMessage());
        }
    }

    /**
     * Test of inventoryList method, of class VendingMachineService.
     */
    @Test
    public void testInventoryList() throws Exception {
        List<Inventory> fromDao = service.inventoryList();
        assertEquals(3, fromDao.size());

        for (Inventory item : fromDao) {
            assertTrue(item instanceof Inventory);
        }
    }

}
