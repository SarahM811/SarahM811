/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.service;

import com.gen10.flooringmastery.dao.FlooringMasteryAuditDaoFile;
import com.gen10.flooringmastery.dao.FlooringMasteryDao;
import static com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl.DELIMITER;
import static com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl.ORDER_FILE;
import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.dao.ProductDaoFile;
import com.gen10.flooringmastery.dao.TaxDaoFile;
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
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class FlooringMasteryServiceLayerFileImpl implements FlooringMasteryServiceLayer {

    FlooringMasteryDao dao;
    ProductDaoFile productDao;
    TaxDaoFile taxDao;
    FlooringMasteryAuditDaoFile auditDao;

    final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMddyyyy");
    Scanner scanner = new Scanner(System.in);
    LocalDate ld = LocalDate.now();
    String formattedDate = ld.format(DATE_FORMAT);

    public FlooringMasteryServiceLayerFileImpl(FlooringMasteryDao dao, ProductDaoFile productDao, TaxDaoFile taxDao, FlooringMasteryAuditDaoFile auditDao) throws FlooringMasteryPersistenceException {
        dao.loadOrder();
        this.dao = dao;
        this.productDao = productDao;
        this.taxDao = taxDao;
        this.auditDao = auditDao;
    }

    @Override
    public Order getOrder(int orderNumber) throws FlooringMasteryPersistenceException, OrderValidationException {
        validateOrder(orderNumber);
        Order selectedOrder = dao.getOrder(orderNumber);
        addDependency(selectedOrder);
        return selectedOrder;
    }

    @Override
    public void removeOrder(Order order, String commitChoice) throws FlooringMasteryPersistenceException {
        dao.removeOrder(order.getOrderNumber());
        if (commitChoice.toLowerCase().equals("y") || commitChoice.toLowerCase().equals("yes")) {

            dao.writeOrder();
            //  auditDao.writeAuditEntry("Order number " + order.getOrderNumber() +  "removed");
        }

    }

    //method to take object(from view in cotroller) and define those objects and put it in object[]
    @Override
    public Object getCorrectItems(String propertyName, Object propertyValue) throws FlooringMasteryPersistenceException {

        Object propertyValue2;
        Object propertyValue3;

        Object correctPropertyValue = null;
        if (!propertyValue.equals("")) {
            switch (propertyName) {
                case "Customer Name":
                    correctPropertyValue = propertyValue;
                    break;
                case "State":
                    propertyValue2 = taxDao.getTax((int) propertyValue).getState();
                    correctPropertyValue = propertyValue2;
                    break;
                case "Product Type":
                    propertyValue3 = productDao.getProduct((int) propertyValue).getProductType();
                    correctPropertyValue = propertyValue3;
                    break;
                case "Area":
                    
                    correctPropertyValue = propertyValue;
                default:
                    break;
            }
        }

        return correctPropertyValue;
    }

    @Override
    public Order editOrder(Order order, Object[] newData, String userCommitChoice) throws FlooringMasteryPersistenceException {
        dao.editOrder(order, newData);
        if (userCommitChoice.toLowerCase().equals("y") || userCommitChoice.toLowerCase().equals("yes")) {

            dao.addOrder(order.getOrderNumber(), order);
            dao.writeOrder();
            //   auditDao.writeAuditEntry("Order number " + order.getOrderNumber() + " information is edited.|" + order.toString());
        }
        return order;
    }

    @Override
    public Order createOrder(Object[] userInput) throws FlooringMasteryPersistenceException, OrderDataValidationException {

        validateOrderData(userInput);
        String customerName;
        String state;
        String productType;
        BigDecimal area;
        try {
            customerName = (String) userInput[0];
            state = taxDao.getTax((int) userInput[1]).getState();
            productType = productDao.getProduct((int) userInput[2]).getProductType();
            area = new BigDecimal((String) userInput[3]);
        } catch (NumberFormatException e) {
            throw new OrderDataValidationException("Area needs to be in a number.");
        }
        Order newOrder = new Order();

        newOrder.setCustomerName(customerName);
        newOrder.setState(state);
        newOrder.setProductType(productType);
        newOrder.setArea(area);
        addDependency(newOrder);

        return newOrder;
    }

    private void validateOrderData(Object[] userInput) throws OrderDataValidationException {
        if (userInput[0].equals("") | userInput[1] == null | userInput[2] == null | userInput[3] == null) {
            throw new OrderDataValidationException("You must put valid value into each entry");
        }
    }

    @Override
    public Order addOrder(Order order, String userCommitChoice) throws FlooringMasteryPersistenceException {
         if (userCommitChoice.toLowerCase().equals("y") || userCommitChoice.toLowerCase().equals("yes")) {
             return addOrder(order, true);
         } else {
             return addOrder(order, false);
         }
    }

    @Override
    public Order addOrder(Order order, boolean shouldCommit) throws FlooringMasteryPersistenceException {
        if (shouldCommit) {

            dao.addOrder(order.getOrderNumber(), order);
            dao.writeOrder();
            //  auditDao.writeAuditEntry("Order number " + order.getOrderNumber() + " is added to the order list.");
        }

        return dao.addOrder(order.getOrderNumber(), order);

    }

    @Override
    public List<Order> getOrderList(String orderDate) throws FlooringMasteryPersistenceException, DateValidationException {

        dao.loadOrder();

        validateDate(orderDate);

        List<Order> orderList = new ArrayList<>(dao.getOrdersByDate(orderDate));

        for (Order order : orderList) {
            addDependency(order);
        }

        if (orderList.size() == 0) {
            throw new DateValidationException("No orders are found for the date.");
        }
        return orderList;

    }

    @Override
    public List<Order> getOrderList() throws FlooringMasteryPersistenceException {
        dao.loadOrder();
        List<Order> orderList = new ArrayList<>(dao.getAllOrders());

        for (Order order : orderList) {

            addDependency(order);
        }

        return orderList;
    }

    @Override
    public void writeOrder(String orderDate) throws FlooringMasteryPersistenceException, DateValidationException {
        dao.loadOrder();
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("Order_" + orderDate + ".txt"));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not save data to " + "Order_" + orderDate + ".txt", e);
        }

        for (Order order : getOrderList(orderDate)) {

            out.println(order.marshalize(order, DELIMITER));
            out.flush();
        }

        out.close();
    }

    private void addDependency(Order newOrder) throws FlooringMasteryPersistenceException {
        Product product = productDao.getProduct(newOrder.getProductType());
        newOrder.setProduct(product);

        Tax tax = taxDao.getTax(newOrder.getState());
        newOrder.setTax(tax);
    }

    private void validateDate(String orderDate) throws FlooringMasteryPersistenceException, DateValidationException {
        try {
            LocalDate.parse(orderDate, DATE_FORMAT);

        } catch (DateTimeParseException e) {
            throw new DateValidationException("Please put the right format of date - MMddyyyy");
        }
    }

    private void validateOrder(int orderNum) throws OrderValidationException, FlooringMasteryPersistenceException {
        if (dao.getOrder(orderNum) == null) {
            throw new OrderValidationException("No order was found.");
        }
    }

    @Override
    public void setIsProdMode(boolean IsProdMode) {
        dao.setIsProdMode(IsProdMode);
    }

    @Override
    public boolean getProdMode() {
        return dao.getIsProdMode();
    }
  
}
