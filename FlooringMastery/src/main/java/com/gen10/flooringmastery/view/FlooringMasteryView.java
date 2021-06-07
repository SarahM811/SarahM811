/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.view;

import com.gen10.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class FlooringMasteryView {

    UserIO io;
    Scanner scanner = new Scanner(System.in);

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public boolean isProdMode() {
        boolean isProdMode;
        io.print("* <<Flooring Program>>");
      
        io.print("* 1. Training mode");
        io.print("* 2. Production mode");
        
         int userModeChoice = io.readInt("Please choose the mode.",1,2);
         
         if (userModeChoice == 1) {
             isProdMode = false;
         } else {
             isProdMode = true;
         }
         
         return isProdMode;
    }
    
    public void displayMainMenu() {
        io.print("*******************************************");
        io.print("* <<Flooring Program>>");
        io.print(" ");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an order");
        io.print("* 3. Edit an order");
        io.print("* 4. Remove an order");
        io.print("* 5. Save Current Work");
        io.print("* 6. EXIT");
        io.print("*");
        io.print("********************************************");
    }

    public int getuserChoice() {
        return io.readInt("Please select an option.",1,6);
    }

    public String getOrderDate() {
        return io.readString("What is the date of an order? Please follow the date format of MMddYYYY.");
    }

    public int getOrderNumber() {
        return io.readInt("What is the order number?");
    }

    public String getUserName() {
        return io.readString("customer name: ");

    }

    public Object[] userOrderInput() {
        // Object[] orderInfo = new Object[4];
        String name = io.readString("customer name: ");

        io.print("* 1. OH");
        io.print("* 2. PA");
        io.print("* 3. MI");
        io.print("* 4. IN");

        int stateChoice = io.readInt("Please select the state: ",1,4);

        io.print("* 1. Carpet");
        io.print("* 2. Laminate");
        io.print("* 3. Tile");
        io.print("* 4. Wood");

        int productChoice = io.readInt("Please select product type:",1,4);

      // BigDecimal area = new BigDecimal(io.readString("Please enter the area: "));
        String area = io.readString("Please enter the area: ");

        Object[] orderInfo = {name, stateChoice, productChoice, area};
        return orderInfo;

    }

    public int getUserProductType() {
        return getUserProductType(true);

    }

    public int getUserProductType(boolean IsMandatory) {
        int maxNumber = 4;
        io.print("* 1. Carpet");
        io.print("* 2. Laminate");
        io.print("* 3. Tile");
        io.print("* 4. Wood");

        if (!IsMandatory) {
            io.print("5. Skip");
            maxNumber = 5;
        }

        return io.readInt("Please select product type:", 1, maxNumber);
    }

    public BigDecimal getAreaFromUser() {
        String area = io.readString("Please enter the area: ");
        return new BigDecimal(area);
    }

    public int getUserState() {
        io.print("* 1. OH");
        io.print("* 2. PA");
        io.print("* 3. MI");
        io.print("* 4. IN");

        return io.readInt("Please select the state: ", 1, 4);
    }

    public Object getPropertyValueInput(String PropertyName, Order order) {
        Object propertyValue = "";

        String answer = io.readString("Edit property " + PropertyName + "? (y/n)");
        if (answer.equals("yes") || answer.equals("y")) {
            switch (PropertyName) {
                case "Customer Name":
                    io.print("Customer name: (" + order.getCustomerName() + ")");
                    propertyValue = io.readString("Enter new customer name:");
                    break;
                case "State":
                    io.print("State: (" + order.getState() + ")");
                    propertyValue = getUserState();
                    break;
                case "Product Type":
                    io.print("Product type: {" + order.getProductType() + ")");
                    propertyValue = getUserProductType();
                    break;
                case "Area":
                    io.print("Area: (" + order.getArea() + ")");
                    propertyValue = new BigDecimal(io.readString("Enter new property value"));
                    break;
                default:
                    break;
            }
        }
        return propertyValue;
    }

    public void displayOrderEditableInformation(Order order) {

        System.out.println("Order number: " + order.getOrderNumber() + "| Cutomer Name: " + order.getCustomerName() + "| State: " + order.getTax().getState()
                + "| Product Type: " + order.getProduct().getProductType() + "| Area: " + order.getArea());
    }

    public void displayOrderList(List<Order> orderList) {
        for (Order order : orderList) {
            displaySummary(order);

        }
    }

    public void displayAddOrder() {
        io.print("");
        io.print("=======Add Order========");
    }

    public void displaySummary(Order order) {

       
        io.print("Order number: " + order.getOrderNumber() + "| Cutomer Name: " + order.getCustomerName() + "| State: " + order.getState()
                + "| State tax Rate: " + order.getTax().getTaxRate() + "| Product Type: " + order.getProductType()
                + "| Cost Per Square Foot: " + order.getProduct().getCostPerSqFt() + "| Labor cost per Sq Ft: " + order.getProduct().getLaborCostPerSqFt()
                + "| Area: " + order.getArea()
                + "| Material Cost: " + order.getMaterialCost() + "| Labor Cost: " + order.getLaborCost() + "| total taxes: " + order.getTotalTaxAmount()
                + "| Total cost: " + order.getTotal());
        io.print(" ");
    }

    public String commitUserInput() {
        return io.readString("Would you like to commit this order? (y/n)");
    }

    public void displayEditOrder() {
        io.print("=====Edit Order======");
    }

    public void displayRemoveOrder() {
        io.print("====Remove Order======");
    }

    public void displayRemoveSuccessBanner(Order toRemove) {
        io.print("======Order Number " + toRemove.getOrderNumber() + " successfully removed======");
    }

    public void displayEditSuccessBanner() {
        io.print("======Edit Successfully done. Editted information is below =====");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public void displaySaveSuccessBanner() {
        io.print("=====Order changes successfully saved======");
    }

    public void displayTrainingModeNotSave() {
        io.print("You are in a training mode. You are not able to save your data.");
    }

    public String askPassword() {
        return io.readString("Please enter password to use production mode.");
    }

    public void displayIncorrectPassword() {
        io.print("Incorrect Password. You cannot use production mode.");
    }

    public void displayOrderBanner() {
       io.print("========Order Display========");
    }

    public void unknownCommand() {
       io.print("Unknown Command - please choose the correct option");
    }

    public void displayCommitSuccess() {
       io.print("Order information successfully committed.");
    }
}
