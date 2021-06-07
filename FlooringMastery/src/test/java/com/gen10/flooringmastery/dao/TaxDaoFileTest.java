/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import com.gen10.flooringmastery.dto.Tax;
import java.math.BigDecimal;
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
public class TaxDaoFileTest {
    TaxDaoFile taxDao = new TaxDaoFile();
    
    public TaxDaoFileTest() {
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
     * Test of getTax method, of class TaxDaoFile.
     */
    @Test
    public void testGetTax_int() throws Exception {
        Tax chosentax = taxDao.getTax(1);
        String expected = "OH";
        String result = chosentax.getState();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getTaxRate method, of class TaxDaoFile.
     */
    @Test
    public void testGetTaxRate() throws Exception {
        BigDecimal result = taxDao.getTaxRate(1);
        BigDecimal expected = new BigDecimal(6.25);
       
        assertEquals(expected, result);
    }

    /**
     * Test of getTax method, of class TaxDaoFile.
     */
    @Test
    public void testGetTax_String() throws Exception {
       Tax chosenTax = taxDao.getTax("OH");
       BigDecimal resultTaxRate = chosenTax.getTaxRate();
       BigDecimal expectedTaxRate = new BigDecimal(6.25);
       
       assertEquals(expectedTaxRate, resultTaxRate);
    }
    
}
