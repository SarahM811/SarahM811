/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster;

import com.gen10.classroster.controller.ClassRosterController;
import com.gen10.classroster.dao.ClassRosterAuditDao;
import com.gen10.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.gen10.classroster.dao.ClassRosterDao;
import com.gen10.classroster.dao.ClassRosterDaoFileImpl;
import com.gen10.classroster.service.ClassRosterServiceLayer;
import com.gen10.classroster.service.ClassRosterServiceLayerImpl;
import com.gen10.classroster.ui.ClassRosterView;
import com.gen10.classroster.ui.UserIO;
import com.gen10.classroster.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sakim
 */
public class App {
    
    public static void main(String[] args) {
//        UserIO myIo= new UserIOConsoleImpl();
//        ClassRosterView myView = new ClassRosterView(myIo);
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
//        ClassRosterController controller = new ClassRosterController(myService, myView);
//        controller.run();
        
          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
          controller.run();
    }
}
