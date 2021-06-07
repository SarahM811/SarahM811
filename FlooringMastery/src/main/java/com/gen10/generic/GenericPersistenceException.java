/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.generic;

/**
 *
 * @author sakim
 */
class GenericPersistenceException extends Exception {
    public GenericPersistenceException(String message) {
        super(message);
    }

    public GenericPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
