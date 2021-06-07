/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.generic;

import java.util.List;

/**
 *
 * @author sakim
 */
public interface GenericDao<T> {
    /**
     * Adds the given Student to the roster and associates it with the given 
     * object id. If there is already a object associated with the given 
     * object id it will return that object object, otherwise it will 
     * return null.
     * 
     * @param objectId id with which object is to be associated
     * @param object object to be added to the roster
     * @return the Student object previously associated with the given  
     * object id if it exists, null otherwise
     */
    T addObject(String objectId, T object) throws GenericPersistenceException;

    /**
     * Returns a String array containing the object ids of all 
     * objects in the roster.
     * 
     * @return String array containing the ids of all the objects 
     * in the roster
     */
    List<T> getAllObjects() throws GenericPersistenceException;

    /**
     * Returns the object object associated with the given object id.
     * Returns null if no such object exists
     * 
     * @param objectId ID of the object to retrieve
     * @return the Student object associated with the given object id,  
     * null if no such object exists
     * @throws com.gen10.milestone2.classroster.dao.GenericPersistenceException
     */
    T getObject(String objectId) throws GenericPersistenceException;

    public void editObject(T object, String[] newData) throws GenericPersistenceException;
    
    /**
     * Removes from the roster the object associated with the given id. 
     * Returns the object object that is being removed or null if 
     * there is no object associated with the given id
     * 
     * @param objectId id of object to be removed
     * @return Student object that was removed or null if no object 
     * was associated with the given object id
     */
    T removeObject(String objectId) throws GenericPersistenceException;

}
