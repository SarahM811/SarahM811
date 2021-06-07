/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week3.vendingmachine.dao;

import com.gen10.week3.vendingmachine.dto.Change;
import com.gen10.week3.vendingmachine.dto.Inventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Inventory> inventoryMap = new HashMap<>();
    public static final String VM_FILE = "Vending_Machine.txt";
    public static final String DELIMITER = "::";

    @Override
    public boolean EnoughMoney(BigDecimal userMoney, BigDecimal price) {
        if (userMoney.compareTo(price) >= 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int[] calculateChange(BigDecimal userMoney, BigDecimal price) {
        BigDecimal totalChange = userMoney.subtract(price);
        int numQuart;
        int numDime;
        int numNickel;
        int numPennies;

        BigDecimal getNumQuarters = totalChange.divide(Change.QUARTER, 2, RoundingMode.HALF_DOWN);
        numQuart = getNumQuarters.intValue();
        BigDecimal quarterValue = valueOf(numQuart).multiply(Change.QUARTER);

        BigDecimal remainderFromQuarter = totalChange.subtract(quarterValue);
        numDime = (remainderFromQuarter.divide(Change.DIME, 2, RoundingMode.HALF_DOWN)).intValue();
        BigDecimal dimeValue = valueOf(numDime).multiply(Change.DIME);

        BigDecimal calculateNickel = (totalChange.subtract(quarterValue.add(dimeValue)));
        numNickel = (calculateNickel.divide(Change.NICKEL, 2, RoundingMode.HALF_DOWN)).intValue();

        BigDecimal nickelValue = (valueOf(numNickel)).multiply(Change.NICKEL);

        BigDecimal penniesValue = totalChange.subtract(quarterValue.add(dimeValue).add(nickelValue));
        numPennies = (penniesValue.divide(Change.PENNIES, 2, RoundingMode.HALF_DOWN)).intValue();

        int[] numberOfChanges = {numQuart, numDime, numNickel, numPennies};

        return numberOfChanges;
    }

    @Override
    public Inventory updateInventory(Inventory item) throws VendingMachineDaoException {

        item.setInventoryCount(item.getInventoryCount() - 1);

        inventoryMap.put(item.getItem(), item);

        writeFile();
        return item;

    }

    @Override
    public Inventory chooseItem(int userChoice) throws VendingMachineDaoException {
        Inventory selectedItem = null;

        switch (userChoice) {
            case 1:
                selectedItem = inventoryMap.get("Snickers");
                break;

            case 2:

                selectedItem = inventoryMap.get("Milkyway");
                break;
            case 3:

                selectedItem = inventoryMap.get("Sunchips");
                break;
            case 4:

                selectedItem = inventoryMap.get("Doritos");
                break;

            default:
                break;
        }
        return selectedItem;
    }

    @Override
    public ArrayList<Inventory> inventoryList() throws VendingMachineDaoException {
        loadFile();
        ArrayList<Inventory> itemList = new ArrayList<>(inventoryMap.values());
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getInventoryCount() <= 0) {
                itemList.remove(i);
            }
        }

        return itemList;
    }

    public void writeFile() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VM_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not save data.", e);
        }

        List<Inventory> inventoryList = new ArrayList<Inventory>(inventoryMap.values());
        for (Inventory currentItem : inventoryList) {
            out.println(currentItem.getItem() + DELIMITER
                    + currentItem.getPrice() + DELIMITER
                    + currentItem.getInventoryCount());

            out.flush();
        }

        out.close();
    }

    public void loadFile() throws VendingMachineDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader((VM_FILE))));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not load the database into memory", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Inventory currentInventory = new Inventory();
            currentInventory.setItem(currentTokens[0]);
            currentInventory.setPrice(new BigDecimal(currentTokens[1]));
            currentInventory.setInventoryCount(Integer.parseInt(currentTokens[2]));

            inventoryMap.put(currentInventory.getItem(), currentInventory);

        }

        scanner.close();

    }

    @Override
    public void removeItem(String item) throws VendingMachineDaoException {
        inventoryMap.remove(item);
        writeFile();
    }

}
