/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author sakim
 */
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {

    public static final String ORDER_FILE = "OrderList.txt";
    public static final String DELIMITER = "::";
    private String fileName;
  //  private boolean IsProdMode = true;
    private boolean IsProdMode;

    private Map<Integer, Order> orderMap = new HashMap<>();
    private Map<String, Product> productMap = new HashMap<>();
    private Map<String, Tax> taxMap = new HashMap<>();
    private Map<String, Object> newInfo = new HashMap<>();
    Scanner scanner;
    LocalDate ld = LocalDate.now();
    String formattedDate = ld.format(DateTimeFormatter.ofPattern("MMddyyyy"));

    public FlooringMasteryDaoFileImpl(boolean IsProdMode) throws FlooringMasteryPersistenceException {
        loadOrder();
        this.IsProdMode = IsProdMode;
    }

    @Override
    public boolean getIsProdMode() {
        return IsProdMode;
    }

    @Override
    public void setIsProdMode(boolean IsProdMode) {
        this.IsProdMode = IsProdMode;
    }

    @Override
    public Order addOrder(int orderNumber, Order order) throws FlooringMasteryPersistenceException {
        orderMap.put(orderNumber, order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        loadOrder();
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public Order getOrder(int orderNumber) throws FlooringMasteryPersistenceException {
        loadOrder();
        return orderMap.get(orderNumber);
    }

    @Override
    public void editOrder(Order order, Object[] newData) throws FlooringMasteryPersistenceException {
        for (int i = 0; i < newData.length; i++) {
            Object newValue = newData[i];
            if (newValue != null && !newValue.equals("")) {
                order.editProperty(i, newValue);
            }
        }

    }

    @Override
    public Order removeOrder(int orderNumber) throws FlooringMasteryPersistenceException {
        loadOrder();
        Order toRemove = orderMap.get(orderNumber);
        orderMap.remove(toRemove.getOrderNumber());

        return toRemove;
    }

    @Override
    public void loadOrder() throws FlooringMasteryPersistenceException {
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("OrderList.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load data from " + "OrderList.txt", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);

            Order order = new Order();

            order.setDate(currentTokens[0]);
            order.setOrderNumber(Integer.parseInt(currentTokens[1]));
            order.setCustomerName(currentTokens[2]);
            order.setState((currentTokens[3]));
            order.setProductType((currentTokens[4]));
            order.setArea(new BigDecimal(currentTokens[5]));

            orderMap.put(order.getOrderNumber(), order);
        }
        scanner.close();
    }

    @Override
    public void writeOrder() throws FlooringMasteryPersistenceException {
        writeOrder(getIsProdMode());
    }

    private void writeOrder(boolean IsProdMode) throws FlooringMasteryPersistenceException {
        if (!IsProdMode) {
            return;
        }

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("OrderList.txt"));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not save data to " + "OrderList.txt", e);
        }

        for (Order order : orderMap.values()) {
            out.println(marshalize(order, DELIMITER));
            out.flush();
        }

        out.close();
    }

    private String marshalize(Order order, String delimiter) {
        return String.join(delimiter, new String[]{order.getDate(), Integer.toString(order.getOrderNumber()), order.getCustomerName(), order.getState(),
            order.getProductType(), (order.getArea()).toString()});
    }
    
    @Override
    public List<Order> getOrdersByDate(String orderDate) throws FlooringMasteryPersistenceException {
        loadOrder();
        return orderMap.values()
                .stream()
                .filter(o -> o.getDate().equals(orderDate))
                .collect(Collectors.toList());
    }

}
