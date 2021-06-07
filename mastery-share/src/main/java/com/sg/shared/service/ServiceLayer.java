/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shared.service;

import org.springframework.stereotype.Service;
import com.sg.shared.entities.OurObject;
import com.sg.shared.repositories.ObjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Krystal
 */
@Service
public class ServiceLayer {

    @Autowired
    ObjectRepository object;

    public List<OurObject> findAll() {
        return object.findAll();
    }

    public OurObject save(OurObject ob) {
        return object.save(ob);
    }

    public void deleteById(Integer id) {
        object.deleteById(id);
    }

    public OurObject findById(int Id) {
        return object.findById(Id).orElse(null);
    }
    
    public List<OurObject> searchBetween(int a, int b) {
        return object.findByProperty2Between(a, b);
    }
}
