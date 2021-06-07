/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.advice;

import com.gen10.week3.vendingmachine.dao.VendingMachineAuditDao;
import com.gen10.week3.vendingmachine.dao.VendingMachineDaoException;
import com.gen10.week3.vendingmachine.service.InsufficientFundsException;
import com.gen10.week3.vendingmachine.service.OutOfStockException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author sakim
 */
public class LoggingAdvice {

    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": Item successfully dispensed. | user choice: " ;
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineDaoException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void createAuditEntryForInsufficientFunds(JoinPoint jp, InsufficientFundsException e) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + "| Error: " + formatStringInsufficientException(e) + "| user money: $";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineDaoException ex) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    private String formatStringInsufficientException(InsufficientFundsException e) {
        String errorClass = e.getClass().getTypeName();
        return errorClass.substring(errorClass.lastIndexOf(".") + 1);
    }
    

    public void createAuditEntryForOutOfStock(JoinPoint jp, OutOfStockException stockex) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + "| Error: " + formatStringForOutOfStock(stockex) + " | user choice: ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineDaoException ex) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    private String formatStringForOutOfStock(OutOfStockException stockex) {
        String errorClass = stockex.getClass().getTypeName();
        return errorClass.substring(errorClass.lastIndexOf(".") + 1);
    }
}
