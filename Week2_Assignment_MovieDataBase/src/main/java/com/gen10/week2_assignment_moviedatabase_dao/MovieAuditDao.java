/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase_dao;

/**
 *
 * @author sakim
 */
public interface MovieAuditDao  {
    
    public void writeAuditEntry (String entry) throws MovieDaoException;
}
