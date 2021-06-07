/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.service;

import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author sakim
 */
public interface FlooringMasteryServiceLayer {

    public Order getOrder(int orderNumber) throws FlooringMasteryPersistenceException, OrderValidationException;

    public List<Order> getOrderList(String orderDate) throws FlooringMasteryPersistenceException, DateValidationException;

    public List<Order> getOrderList() throws FlooringMasteryPersistenceException;

    public void removeOrder(Order order, String commitChoice) throws FlooringMasteryPersistenceException;

    public Order editOrder(Order order, Object[] newData, String userCommitChoice) throws FlooringMasteryPersistenceException;

    public Order createOrder(Object[] userInput) throws FlooringMasteryPersistenceException, OrderDataValidationException;

    public Order addOrder(Order order, String userCommitChoice) throws FlooringMasteryPersistenceException;
    
    public Order addOrder(Order order, boolean userCommitChoice) throws FlooringMasteryPersistenceException;

    public Object getCorrectItems(String propertyName, Object propertyValue) throws FlooringMasteryPersistenceException;

    public void writeOrder(String orderDate) throws FlooringMasteryPersistenceException, DateValidationException;
    
    public void setIsProdMode(boolean IsProdMode);

    public boolean getProdMode();
}
