/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shared.repositories;

import com.sg.shared.entities.OurObject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joshua Vannatter
 */
@Repository
public interface ObjectRepository extends JpaRepository<OurObject, Integer>{
//    findById	
//        -Retrieves one object based on the ID you pass it.
//    findAll 
//        -Retrieves a List of all the objects of the type.
//    save	
//        -Used for both creating and updating an object. Returns to you the object that was created or updated as it now exists in the database.
//    deleteById	
//        -Deletes the object with the passed ID from the database.
//    count	
//        -Retrieves a count of all of that type of object in the database.
//    existsById	
//        -Tells you true or false if an object with the passed ID exists in the database.
    
    
    
//    List<Object> findByOtherObject(OtherObject ob);
//    if you need something like this, then you must set up relationships in the entity class.

    List<OurObject> findByProperty2Between(int a, int b);
}
