/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase.advice;

import com.gen10.week2_assignment_moviedatabase_dao.MovieAuditDao;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author sakim
 */
public class LoggingAdvice {
    MovieAuditDao auditDao;
    
    public LoggingAdvice(MovieAuditDao auditDao) {
       this.auditDao= auditDao;
    }
    
     public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (MovieDaoException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    
}
