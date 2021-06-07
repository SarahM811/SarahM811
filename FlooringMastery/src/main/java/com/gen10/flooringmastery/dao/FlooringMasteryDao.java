/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sakim
 */
public interface FlooringMasteryDao {

    public Order addOrder(int orderNumber, Order order) throws FlooringMasteryPersistenceException;

    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException;

    public Order getOrder(int orderNumber) throws FlooringMasteryPersistenceException;

    public void editOrder(Order order, Object[] newData) throws FlooringMasteryPersistenceException;

    public Order removeOrder(int orderNumber) throws FlooringMasteryPersistenceException;

    public void loadOrder() throws FlooringMasteryPersistenceException;

    public void writeOrder() throws FlooringMasteryPersistenceException;

    public boolean getIsProdMode();

    public void setIsProdMode(boolean IsProdMode);
    
    public List<Order> getOrdersByDate(String orderDate) throws FlooringMasteryPersistenceException;
}
