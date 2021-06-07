/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sakim
 */
public class FlooringMasteryDaoTest {
   FlooringMasteryDao dao;
//   Order order1; 
   Order newOrder;
   Scanner scanner;
  
   
    public FlooringMasteryDaoTest() throws FlooringMasteryPersistenceException {
        this.dao = new FlooringMasteryDaoStubFile();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FlooringMasteryPersistenceException {
        
   
        
        newOrder = new Order();
        newOrder.setCustomerName("Testing");
        newOrder.setState("PA");
        newOrder.setProductType("Carpet");
        newOrder.setArea(BigDecimal.ONE);
       
    }
    
    @After
    public void tearDown() throws FlooringMasteryPersistenceException {
        List<Order> orderList = dao.getAllOrders();
        for (Order order : orderList) {
            dao.removeOrder(order.getOrderNumber());
            dao.writeOrder();
        }
        
    }

    /**
     * Test of addOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order order1 = new Order();
      
        Order result = dao.addOrder(order1.getOrderNumber(), order1);
        
        assertEquals(order1, result);
        
        Order fromDao = dao.getOrder(order1.getOrderNumber());
        assertEquals(order1, fromDao);
        
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        
        int initialSize = dao.getAllOrders().size();
        dao.addOrder(newOrder.getOrderNumber(), newOrder);
        int expected = initialSize + 1;
        int result = dao.getAllOrders().size();
        
        assertEquals(expected,result);
        
        List<Order> fromDao = dao.getAllOrders();
        for (Order order : fromDao) {
            assertTrue(order instanceof Order);
        }
    }

    /**
     * Test of getOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetOrder() throws Exception {
       
       
        dao.addOrder(newOrder.getOrderNumber(), newOrder);
        Order result = dao.getOrder(newOrder.getOrderNumber());
        
        assertEquals(newOrder, result);
    }

    /**
     * Test of editOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testEditOrder() throws Exception {
        Order order = new Order();
        order.setCustomerName("Brian");
        order.setState("PA");
        order.setProductType("Carpet");
        order.setArea(new BigDecimal(10));
        
        Object[] newData = {"John", "IN", "Wood", new BigDecimal(20)};
        
        dao.editOrder(order, newData);
        
        String expectedCustomerName = "John";
        String result=order.getCustomerName();
        
        assertEquals(expectedCustomerName, result);
        
        String expectedState = "IN";
        String resultState=order.getState();
        
        assertEquals(expectedState, resultState);
        
        String expectedProdType = "Wood";
        String resultProdType=order.getProductType();
        
        assertEquals(expectedProdType, resultProdType);
        
        BigDecimal expectedArea = new BigDecimal(20);
        BigDecimal resultArea=order.getArea();
        
        assertEquals(expectedArea, resultArea);
        
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        Order order1 = new Order();
        
        dao.addOrder(order1.getOrderNumber(), order1);
        
        
        dao.removeOrder(order1.getOrderNumber());
        Order result = dao.getOrder(order1.getOrderNumber());
        
        assertNull(result);
    }

        /**
     * Test of loadOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testLoadOrder() throws Exception {
        dao.addOrder(newOrder.getOrderNumber(), newOrder);
        dao.writeOrder();
        dao.loadOrder();
        int result = dao.getAllOrders().size();
        int expected = 1;
        
        assertEquals(expected,result);
    }

    /**
     * Test of writeOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testWriteOrder() throws Exception {
        List<Order> orderList = dao.getAllOrders();
        dao.addOrder(newOrder.getOrderNumber(), newOrder);
        dao.writeOrder();
        
        int resultNumLines = countNumOfLines("Testing.txt");
        int exceptedNumLines = 1;
        
        assertEquals (exceptedNumLines, resultNumLines);

        dao.setIsProdMode(false);
        Order trainModeOrder = new Order();
        dao.addOrder(trainModeOrder.getOrderNumber(),trainModeOrder);
        dao.writeOrder();
        int resultNumLineTrain = countNumOfLines("Testing.txt");
        int expectedNumLineTrain = resultNumLines;
        
        assertEquals(expectedNumLineTrain, resultNumLineTrain);
        
    }

    /**
     * Test of getIsProdMode method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetIsProdMode() {
        dao.setIsProdMode(true);
        boolean result = dao.getIsProdMode();
        boolean expected = true;
        
        assertEquals(expected, result);
    }

    /**
     * Test of setIsProdMode method, of class FlooringMasteryDao.
     */
    @Test
    public void testSetIsProdMode() {
        dao.setIsProdMode(true);
        boolean result = dao.getIsProdMode();
        boolean expected = true;
        
        assertEquals(expected, result);
    }

    /**
     * Test of getOrdersByDate method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        dao.addOrder(newOrder.getOrderNumber(), newOrder);
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        List<Order> daoList = dao.getOrdersByDate(formattedDate);
        int result = daoList.size();
        int expected = 1;
        
        assertEquals(expected, result);
        
    }

    private int countNumOfLines(String fileName) throws FlooringMasteryPersistenceException {
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load data from " + fileName, e);
        }

        String currentLine;
        int numOfLine = 0;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            numOfLine++;
        }
        scanner.close();
        return numOfLine;
        
    }

   
}
