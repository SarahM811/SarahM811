/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import static com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl.DELIMITER;
import com.gen10.flooringmastery.dto.Product;
import com.gen10.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class TaxDaoFile {
    Scanner scanner = new Scanner(System.in);
    Map<String, Tax> taxMap = new HashMap<>();
    
    private void loadTax() throws FlooringMasteryPersistenceException {
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("taxes.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load data from " + "taxes.txt", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Tax currentTax = new Tax(currentTokens[0], new BigDecimal(currentTokens[1]));
            taxMap.put(currentTax.getState(), currentTax);
        }
        scanner.close();
    }
    
    public Tax getTax(int userChoice) throws FlooringMasteryPersistenceException {
        loadTax();
        Tax chosenTax = null;
        
        switch(userChoice) {
            case 1:
                chosenTax = taxMap.get("OH");
                
                break;
            case 2:
                chosenTax = taxMap.get("PA");
               
                break;
            case 3:
                chosenTax = taxMap.get("MI");
                
                break;
            case 4:
                chosenTax = taxMap.get("IN");
                
                break;
            default: 
                break;
        }
        return chosenTax;
    }
    public BigDecimal getTaxRate(int userChoice) throws FlooringMasteryPersistenceException {
        loadTax();
        BigDecimal chosenTaxRate = null;
        
        switch(userChoice) {
            case 1:
                chosenTaxRate = taxMap.get("OH").getTaxRate();
                
                break;
            case 2:
                chosenTaxRate = taxMap.get("PA").getTaxRate();
               
                break;
            case 3:
                chosenTaxRate = taxMap.get("MI").getTaxRate();
                
                break;
            case 4:
                chosenTaxRate = taxMap.get("IN").getTaxRate();
                
                break;
            default: 
                break;
        }
        return chosenTaxRate;
    }
    public Tax getTax(String state) throws FlooringMasteryPersistenceException {
        loadTax();
        return taxMap.get(state);
    }
}
