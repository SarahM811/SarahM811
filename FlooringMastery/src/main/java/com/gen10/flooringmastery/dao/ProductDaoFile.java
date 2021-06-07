/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.flooringmastery.dao;

import static com.gen10.flooringmastery.dao.FlooringMasteryDaoFileImpl.DELIMITER;
import com.gen10.flooringmastery.dto.Product;
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
public class ProductDaoFile {
    Scanner scanner = new Scanner(System.in);
    Map<String, Product> productMap = new HashMap<>();
    
    
    private void loadInventory() throws FlooringMasteryPersistenceException {
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("products.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load data from " + "products.txt", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Product currentProduct = new Product(currentTokens[0], new BigDecimal(currentTokens[1]), new BigDecimal(currentTokens[2]));
            productMap.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
    
    public Product getProduct(int userChoice) throws FlooringMasteryPersistenceException {
        loadInventory();
        Product chosenProduct = null;
        
        switch(userChoice) {
            case 1:
                chosenProduct = productMap.get("Carpet");
                
                break;
            case 2:
                chosenProduct = productMap.get("Laminate");
               
                break;
            case 3:
                chosenProduct = productMap.get("Tile");
                
                break;
            case 4:
                chosenProduct = productMap.get("Wood");
                
                break;
            default: 
                break;
        }
        return chosenProduct;
    }
    
    public Product getProduct(String productType) throws FlooringMasteryPersistenceException {
        loadInventory();
        return productMap.get(productType);
    }
}
