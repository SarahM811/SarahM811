/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.json_practice;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sakim
 */
public class Json_encode {
    static Map<String, Product>inventoryMap;
    public static void main(String[] args) {
        JSONObject tax = new JSONObject();
        tax.put("OH", 6.25);
        tax.put("PA", 6.75);
        tax.put("MI", 5.75);
        tax.put("IN", 6.00);
        
        try {  

            // Writing to a file  
            File file=new File("JsonFile.json");  
            file.createNewFile();  
            try (FileWriter fileWriter = new FileWriter(file)) {
                System.out.println("Writing JSON object to file");
                System.out.println("-----------------------");
                System.out.print(tax);
                
                fileWriter.write(tax.toString());
                fileWriter.flush();
            }  

        } catch (IOException e) {  
        }  
        //ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
        //Carpet,2.25,2.10


//Laminate,1.75,2.10
//
//
//Tile,3.50,4.15
//
//
//Wood,5.15,4.75

//        JSONArray carpet = new JSONArray();
//        carpet.put("carpet");
//        carpet.put(2.25);
//        carpet.put(2.10);
//        JSONArray laminate = new JSONArray();
//        laminate.put("laminate");
//        laminate.put(1.75);
//        laminate.put(2.10);
//        JSONArray tile = new JSONArray();
//        tile.put("tile");
//        tile.put(3.50);
//        tile.put(4.15);
//        JSONArray wood = new JSONArray();
//        wood.put("wood");
//        wood.put(5.15);
//        wood.put(4.75);
        
//        Product carpet = new Product();
//        carpet.setProductType("carpet");
//        carpet.setCostPerSqFt((2));
//        carpet.setLaborCostPerSqFtCarpet((2));
//        
//        Product laminate = new Product();
//        laminate.setProductType("laminate");
//        laminate.setCostPerSqFt((3));
//        laminate.setLaborCostPerSqFtCarpet((4));
//        
               
//        
//        JSONObject product = new JSONObject();
//        product.put("carpet", carpet);
//        product.put("laminate", laminate);
//        product.put("tile", tile);
//        product.put("wood", wood);
//        
//        
//        try {  
//
//            // Writing to a file  
//            File file=new File("JsonFileProducts.json");  
//            file.createNewFile();  
//            try (FileWriter fileWriter = new FileWriter(file)) {
//                System.out.println("Writing JSON object to file");
//                System.out.println("-----------------------");
//                System.out.print(product);
//                
//                fileWriter.write(product.toString());
//                fileWriter.flush();
//            }  
//
//        } catch (IOException e) {  
//        }  
        String json = "{\"product type\": \"product\", \"cost per sqft\": \"2.2\",\"labor cost per sqft\" : \"1.3\"}";
         Gson gson = new Gson();

       BufferedReader br;
       //Product currentProduct = null;
        try {
            br = new BufferedReader(
                    new FileReader("JsonFileProducts.json"));

            // Example Json string for product {\"productNumber\": \"20\",\"name\":\"Wood\"}";
            //currentProduct = gson.fromJson(br, Product.class);
            Product currentProduct = gson.fromJson(br, Product.class);
            inventoryMap.put(currentProduct.getProductType(), currentProduct);
//            inventoryMap = toMap(product);
//            
//            Iterator<String> keyItr = product.keySet().iterator();
//            while(keyItr.hasNext()) {
//                String key = keyItr.next();
//                Product currentprod = product.get(key);
//            }
            System.out.println(currentProduct.getProductType());
            
        } catch (FileNotFoundException ex) {
         ex.getMessage();
        }
        
       
        
    }
}
