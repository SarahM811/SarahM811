/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import com.gen10.flooringmastery.dto.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sakim
 */
public class ProductDaoFileTest {
    ProductDaoFile productDao = new ProductDaoFile();
    
    public ProductDaoFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProduct method, of class ProductDaoFile.
     */
    @Test
    public void testGetProduct_int() throws Exception {
       Product product= productDao.getProduct(4);
       String result = product.getProductType();
       String expected = "Wood";
       
       assertEquals(expected, result);
    }

    /**
     * Test of getProduct method, of class ProductDaoFile.
     */
    @Test
    public void testGetProduct_String() throws Exception {
        
        Product product = productDao.getProduct("Carpet");
        String result = product.getProductType();
        String expected = "Carpet";
        
        assertEquals(expected, result);
        
    }
    
}
