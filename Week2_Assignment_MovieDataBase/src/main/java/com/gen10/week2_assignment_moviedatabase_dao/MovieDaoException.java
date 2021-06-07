/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase_dao;

import java.io.IOException;

/**
 *
 * @author sakim
 */
public class MovieDaoException extends Exception {

    public MovieDaoException(String message) {
        
            super(message);
    }
    
    public MovieDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
