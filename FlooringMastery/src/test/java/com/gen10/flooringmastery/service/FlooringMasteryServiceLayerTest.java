/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.service;

import com.gen10.flooringmastery.dao.FlooringMasteryAuditDaoFile;
import com.gen10.flooringmastery.dao.FlooringMasteryDao;
import com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import static com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl.DELIMITER;
import com.gen10.flooringmastery.dao.FlooringMasteryDaoStubFile;
import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.dao.ProductDaoFile;
import com.gen10.flooringmastery.dao.TaxDaoFile;
import com.gen10.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
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
public class FlooringMasteryServiceLayerTest {

    private FlooringMasteryDao dao;
    private FlooringMasteryServiceLayer service;
    private ProductDaoFile productDao;
    private TaxDaoFile taxDao;

    Order newOrder;
    LocalDate today = LocalDate.now();
    String formattedToday = today.format(DateTimeFormatter.ofPattern("MMddyyyy"));
    String orderDate = formattedToday;
    int initialListSize;
    Scanner scanner;

    public FlooringMasteryServiceLayerTest() throws FlooringMasteryPersistenceException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", FlooringMasteryServiceLayer.class);
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
        newOrder.setCustomerName("new");
        newOrder.setProductType("Wood");
        newOrder.setState("PA");
        newOrder.setArea(BigDecimal.ONE);

        //  service.addOrder(newOrder, "n");
        initialListSize = service.getOrderList().size();
    }

    @After
    public void tearDown() throws FlooringMasteryPersistenceException {
        service.setIsProdMode(false);
        List<Order> orderList = service.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            service.removeOrder(order, "y");

        }

    }

    /**
     * Test of getOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
        service.addOrder(newOrder, "n");
        Order chosenOrder = service.getOrder(newOrder.getOrderNumber());

        assertEquals(chosenOrder, newOrder);

        try {
            Order emptyOrder = service.getOrder(100);
        } catch (OrderValidationException e) {
            assertEquals("No order was found.", e.getMessage());
        }
    }

    /**
     * Test of getOrderList method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetOrderList_String() throws Exception {
        service.addOrder(newOrder, "n");

        List<Order> foundList = service.getOrderList(orderDate);
        int expectedListSize = initialListSize + 1;
        int serviceResult = foundList.size();

        assertEquals(expectedListSize, serviceResult);

        try {
            List<Order> dateValidateList = service.getOrderList("Dec7th");
        } catch (DateValidationException e) {
            assertEquals("Please put the right format of date - MMddyyyy", e.getMessage());
        }

        try {
            List<Order> noOrderList = service.getOrderList("12302018");
        } catch (DateValidationException e) {
            assertEquals("No orders are found for the date.", e.getMessage());
        }

    }

    /**
     * Test of getOrderList method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetOrderList_0args() throws Exception {
        service.addOrder(newOrder, "n");
        List<Order> allOrderList = service.getOrderList();
        int expected = initialListSize + 1;
        int result = allOrderList.size();

        assertEquals(expected, result);
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        service.addOrder(newOrder, "y");

        Order toRemove = service.getOrder(newOrder.getOrderNumber());
        service.removeOrder(toRemove, "y");
        int expected = initialListSize;
        int result = service.getOrderList().size();

        assertEquals(expected, result);
        
        try {
        Order resultOrder = service.getOrder(toRemove.getOrderNumber());
        } catch (OrderValidationException e) {
            assertEquals("No order was found.", e.getMessage());
        }
    }

    /**
     * Test of editOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
//        service.addOrder(newOrder, "n");
        Object[] newData = {"name", "OH", "Carpet", new BigDecimal(10)};
        Order editOrder = service.editOrder(newOrder, newData, "n");

        String editName = "name";
        String afterServiceName = editOrder.getCustomerName();

        assertEquals(editName, afterServiceName);
        assertEquals(newData[1], editOrder.getState());
        assertEquals(newData[2], editOrder.getProductType());
        assertEquals(newData[3], editOrder.getArea());
    }

    /**
     * Test of createOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCreateOrder() throws Exception {
        Object[] userInput = {"createOrder", 1, 1, "20"};
        Order fromService = service.createOrder(userInput);

        String name = "createOrder";
        String fromServiceName = fromService.getCustomerName();

        assertEquals(name, fromServiceName);
        assertEquals("OH", fromService.getState());
        assertEquals("Carpet", fromService.getProductType());
        assertEquals(new BigDecimal(20), fromService.getArea());

        try {
            Object[] userInput2 = {"testing", 1, 2, "number"};
            Order ErrorTest = service.createOrder(userInput2);
        } catch (OrderDataValidationException e) {
            assertEquals("Area needs to be in a number.", e.getMessage());
        }

        try {
            Object[] userInput3 = {"", 1, 2, "3"};
            Order ErrorTest = service.createOrder(userInput3);
        } catch (OrderDataValidationException e) {
            assertEquals("You must put valid value into each entry", e.getMessage());
        }

    }

    /**
     * Test of addOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order testAdd = new Order();
        Order fromService = service.addOrder(testAdd, "n");

        assertEquals(testAdd, fromService);

        int resultListSize = service.getOrderList().size();
        int expected = initialListSize + 1;

        assertEquals(expected, resultListSize);
        
        Order testResult =service.getOrder(testAdd.getOrderNumber());
        assertEquals(testAdd, testResult);
    }

    /**
     * Test of getCorrectItems method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetCorrectItems() throws Exception {
        String[] propertyNames = {"Customer Name", "State", "Product Type", "Area"};
        String correctName = "John";
        Object serviceName = service.getCorrectItems(propertyNames[0], "John");

        assertEquals(correctName, (String) serviceName);

        String state = "PA";
        Object serviceState = service.getCorrectItems(propertyNames[1], 2);
        assertEquals(state, (String) serviceState);

        String productType = "Carpet";
        Object servicePT = service.getCorrectItems(propertyNames[2], 1);
        assertEquals(productType, (String) servicePT);

        BigDecimal area = new BigDecimal(10);
        Object serviceArea = service.getCorrectItems(propertyNames[3], new BigDecimal(10));
        assertEquals(area, (BigDecimal) serviceArea);
    }

    /**
     * Test of writeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testWriteOrder() throws Exception {
        service.addOrder(newOrder, true);
        service.writeOrder(newOrder.getDate());
        
        int result = service.getOrderList(orderDate).size();
        int expected = initialListSize + 1;

        assertEquals(expected, result);
        
        String fileName = "Order_"+ newOrder.getDate()+".txt";
        int result1 = countNumOfLines(fileName);
        int expected1 = initialListSize + 1;
        assertEquals(expected1, result1);

    }

    /**
     * Test of setIsProdMode method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testSetIsProdMode() {
        service.setIsProdMode(true);
        boolean expected = true;
        boolean result = service.getProdMode();

        assertEquals(expected, result);
    }

    /**
     * Test of getProdMode method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetProdMode() {
        service.setIsProdMode(true);
        boolean expected = true;
        boolean result = service.getProdMode();

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
