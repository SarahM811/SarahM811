/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine;

import com.gen10.week3.vendingmachine.controller.VendingMachineController;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoException;
import com.gen10.week3.vendingmachine.service.InsufficientFundsException;
import com.gen10.week3.vendingmachine.service.OutOfStockException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sakim
 */
public class App {
    
    public static void main(String[] args) throws OutOfStockException, InsufficientFundsException, VendingMachineDaoException {


          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
          controller.run();
        
    }
}
