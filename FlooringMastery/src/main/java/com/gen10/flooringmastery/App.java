/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery;

import com.gen10.flooringmastery.controller.FlooringMasteryController;
import com.gen10.flooringmastery.dao.FlooringMasteryAuditDaoFile;
import com.gen10.flooringmastery.dao.FlooringMasteryDao;
import com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.dao.ProductDaoFile;
import com.gen10.flooringmastery.dao.TaxDaoFile;
import com.gen10.flooringmastery.service.DateValidationException;
import com.gen10.flooringmastery.service.FlooringMasteryServiceLayer;
import com.gen10.flooringmastery.service.FlooringMasteryServiceLayerFileImpl;
import com.gen10.flooringmastery.service.OrderDataValidationException;
import com.gen10.flooringmastery.service.OrderValidationException;
import com.gen10.flooringmastery.view.FlooringMasteryView;
import com.gen10.flooringmastery.view.UserIO;
import com.gen10.flooringmastery.view.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sakim
 */
public class App {

    public static void main(String[] args) throws FlooringMasteryPersistenceException, OrderDataValidationException, DateValidationException, OrderValidationException {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); 
        FlooringMasteryController controller = ctx.getBean("controller", FlooringMasteryController.class);
        controller.run();
    }
}
