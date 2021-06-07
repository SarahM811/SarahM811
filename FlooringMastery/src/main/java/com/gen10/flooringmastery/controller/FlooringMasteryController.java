/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.controller;

import com.gen10.flooringmastery.dao.FlooringMasteryAuditDaoFile;
import com.gen10.flooringmastery.dao.FlooringMasteryDao;
import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.dao.ProductDaoFile;
import com.gen10.flooringmastery.dao.TaxDaoFile;
import com.gen10.flooringmastery.dto.Order;
import com.gen10.flooringmastery.service.DateValidationException;
import com.gen10.flooringmastery.service.FlooringMasteryServiceLayer;
import com.gen10.flooringmastery.service.OrderDataValidationException;
import com.gen10.flooringmastery.service.OrderValidationException;
import com.gen10.flooringmastery.view.FlooringMasteryView;
import java.util.List;

/**
 *
 * @author sakim
 */
public class FlooringMasteryController {

    FlooringMasteryDao dao;
    FlooringMasteryView view;
    ProductDaoFile productDao;
    TaxDaoFile taxDao;
    FlooringMasteryServiceLayer service;
    FlooringMasteryAuditDaoFile auditDao;

    public FlooringMasteryController(FlooringMasteryServiceLayer service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws FlooringMasteryPersistenceException, OrderDataValidationException, DateValidationException, OrderValidationException {

        int userChoice = 0;
        boolean keepGoing = true;
       // modeSelection();

        while (keepGoing) {
            try {
                view.displayMainMenu();
                userChoice = view.getuserChoice();

                switch (userChoice) {
                    case 1:
                        displayOrderList();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        saveOrder();
                        break;
                    case 6:
                        System.out.println("EXIT");
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            } catch (FlooringMasteryPersistenceException | DateValidationException | OrderDataValidationException | NumberFormatException | OrderValidationException e) {
                handleErrors(e);

            }
        }

        exitMessage();
    }

    private void displayOrderList() throws FlooringMasteryPersistenceException, DateValidationException {
        String orderDate = view.getOrderDate();
        List<Order> orderList = null;

        orderList = service.getOrderList(orderDate);
        view.displayOrderBanner();
        view.displayOrderList(orderList);

    }

    private void addOrder() throws FlooringMasteryPersistenceException, OrderDataValidationException, NumberFormatException {
        view.displayAddOrder();
        Order newOrder = null;

        Object[] userInput = view.userOrderInput();
        newOrder = service.createOrder(userInput);

        view.displaySummary(newOrder);
        String commitChoice = view.commitUserInput();

        Order addedOrder = service.addOrder(newOrder, commitChoice);
        if (commitChoice.toLowerCase().equals("y") | commitChoice.toLowerCase().equals("yes")) {
            view.displayCommitSuccess();
        } else {
            return;
        }

    }

    private void editOrder() throws FlooringMasteryPersistenceException, OrderValidationException {
        view.displayEditOrder();
        String orderDate = view.getOrderDate();
        int orderNum = view.getOrderNumber();

        Order selectedOrder = service.getOrder(orderNum);
        view.displayOrderEditableInformation(selectedOrder);
        String[] propertyNames = selectedOrder.getPropertyNames();
        Object[] newValues = new Object[4];
        for (int i = 0; i < propertyNames.length; i++) {
            Object newValue = view.getPropertyValueInput(propertyNames[i], selectedOrder);
            Object correctValue = service.getCorrectItems(propertyNames[i], newValue);
            if (!newValue.equals("")) {
                newValues[i] = correctValue;
            }
        }
        String commitChoice = view.commitUserInput();
        Order editedOrder = service.editOrder(selectedOrder, newValues, commitChoice);
        if (commitChoice.toLowerCase().equals("y") | commitChoice.toLowerCase().equals("yes")) {
            view.displayEditSuccessBanner();
            view.displayOrderBanner();
            view.displaySummary(editedOrder);
        } else {
            return;
        }

    }

    private void removeOrder() throws FlooringMasteryPersistenceException, OrderValidationException {
        view.displayRemoveOrder();
        String orderDate = view.getOrderDate();
        int orderNum = view.getOrderNumber();

        Order toRemove = service.getOrder(orderNum);
        view.displaySummary(toRemove);
        String commitChoice = view.commitUserInput();
        if (service.getProdMode() == true && (commitChoice.toLowerCase().equals("y") | commitChoice.toLowerCase().equals("yes"))) {
            service.removeOrder(toRemove, commitChoice);
            view.displayRemoveSuccessBanner(toRemove);
        } else if (service.getProdMode() == false) {
            view.displayTrainingModeNotSave();
        }

    }

    private void saveOrder() throws FlooringMasteryPersistenceException, DateValidationException {

        boolean isProdMode = service.getProdMode();
        if (isProdMode == true) {
            List<Order> allOrderList = service.getOrderList();
            for (int i = 0; i < allOrderList.size(); i++) {
                Order order = allOrderList.get(i);
                service.writeOrder(order.getDate());

            }
            view.displaySaveSuccessBanner();
        } else if (isProdMode == false) {
            view.displayTrainingModeNotSave();
        }

    }

    private void unknownCommand() {
        view.unknownCommand();
    }

    private void exitMessage() {
        System.out.println("Bye!");
    }

    private void modeSelection() {
        boolean isProdMode = view.isProdMode();
        if (isProdMode == true) {
            String password = view.askPassword();
            if (password.equals("123456")) {
                service.setIsProdMode(isProdMode);
            } else {
                view.displayIncorrectPassword();
                modeSelection();
            }
        } else {
            service.setIsProdMode(isProdMode);
        }

    }

    private void handleErrors(Exception e) {
        view.displayErrorMessage(e.getMessage());
    }
}
