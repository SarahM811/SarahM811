/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.service;

/**
 *
 * @author sakim
 */
public class DateValidationException extends Exception {
    public DateValidationException (String message) {
        super(message);
    }
    
    public DateValidationException (String message, Throwable cause) {
        super(message, cause);
    }
}
