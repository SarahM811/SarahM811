/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shared.service;

import com.sg.shared.entities.OurObject;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {
    
    @Autowired
    ServiceLayer service;
    
    public ServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<OurObject> allList = service.findAll();
        for (int i=0; i<allList.size(); i++) {
            OurObject obj = allList.get(i);
            service.deleteById(obj.getId());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class ServiceLayer.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");

        List<OurObject> expResult = new ArrayList();
        List<OurObject> result = service.findAll();
        assertEquals(expResult, result);

    }

    /**
     * Test of save method, of class ServiceLayer.
     */
    @Test
    public void testSaveAndFindById() {
        System.out.println("save");
        OurObject ob = new OurObject();
       
        OurObject expResult = ob;
        ob.setProperty1("qeinek");
        ob.setProperty2(5);
        ob.setProperty3("ghjkjh");
//        ob.setProperty4("coolDude@cool.com");
        OurObject result = service.save(ob);
        assertEquals(expResult, result);
        
        OurObject serviceFindResult = service.findById(ob.getId());
        assertEquals(ob, serviceFindResult);
       
    }

    /**
     * Test of deleteById method, of class ServiceLayer.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        
        OurObject ob = new OurObject();
        
        ob.setProperty1("qeinek");
        ob.setProperty2(5);
        ob.setProperty3("ghjkjh");
        ob.setProperty4("coolDude@cool.com");
               
        OurObject afterSaveResult = service.save(ob);
        assertEquals(ob, afterSaveResult);
        List<OurObject> listAfterAdd = service.findAll();
        assertEquals(1, listAfterAdd.size());
        
        service.deleteById(ob.getId());
        
        assertNull(service.findById(ob.getId()));
       
    }
    
}
