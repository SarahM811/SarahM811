/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.advice;

import com.gen10.flooringmastery.dao.FlooringMasteryAuditDaoFile;
import com.gen10.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.gen10.flooringmastery.service.FlooringMasteryServiceLayer;
import com.gen10.flooringmastery.service.FlooringMasteryServiceLayerFileImpl;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author sakim
 */
public class LoggingAdvice {
    FlooringMasteryAuditDaoFile auditDao;
   
    
    public LoggingAdvice(FlooringMasteryAuditDaoFile auditDao) {
        this.auditDao = auditDao;
    } 
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
       // for (Object currentArg : args) {
           // auditEntry += currentArg;
           
       // }
       if (args[1].toString().toLowerCase().equals("y") | args[1].toString().toLowerCase().equals("yes") ) {
       auditEntry += args[0];
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
       } 
    }
    
    public void createAuditEntryForEdit(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
       // for (Object currentArg : args) {
           // auditEntry += currentArg;
           
       // }
       if (args[2].toString().toLowerCase().equals("y") | args[2].toString().toLowerCase().equals("yes")) {
       auditEntry += args[0];
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
       } 
    }
}
