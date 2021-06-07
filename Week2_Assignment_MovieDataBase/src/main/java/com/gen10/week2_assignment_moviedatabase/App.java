/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase;

import com.gen10.week2_assignment_moviedatabase.controller.MovieController;
import com.gen10.week2_assignment_moviedatabase_View.UserIOConsoleImpl;
import com.gen10.week2_assignment_moviedatabase_View.UserIO;
import com.gen10.week2_assignment_moviedatabase_View.MovieView;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoException;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoFileImpl;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sakim
 */
public class App {

    public static void main(String[] args) throws MovieDaoException {
//        UserIO myIO = new UserIOConsoleImpl();
//        MovieDao myDao = new MovieDaoFileImpl();
//        MovieView myView = new MovieView(myIO);
//        MovieController controller = new MovieController(myDao, myView);
//        controller.run();
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    MovieController controller = ctx.getBean("controller", MovieController.class);
    controller.run();
    
    }
}
