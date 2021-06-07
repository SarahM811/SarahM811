/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.generic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public abstract class GenericDaoFileImpl<T> implements GenericDao<T> {

    public static final String ROSTER_FILE = "class_roster.txt";
    public static final String DELIMITER = "::";    

    private Map<String, T> objects = new HashMap<>();

    @Override
    public T addObject(String objectId, T object) throws GenericPersistenceException {
        objects.put(objectId, object);
        writeRoster();
        return object;
    }

    @Override
    public List<T> getAllObjects() throws GenericPersistenceException {
        loadRoster();
        return new ArrayList<>(objects.values());
    }

    @Override
    public T getObject(String objectId) throws GenericPersistenceException {
        loadRoster();
        return objects.get(objectId);
    }

    @Override
    public void editObject(T object, String[] newData) throws GenericPersistenceException {
        for (int i = 0; i < newData.length; i++) {
            String newValue = newData[i];
            if ( !"".equals(newValue) ) {
                editProperty(object, i, newValue);
            }
        }
        objects.put(getId(object), object);
    }

    @Override
    public T removeObject(String objectId) throws GenericPersistenceException {
        T toRemove = getObject(objectId);
        objects.remove(getId(toRemove));
        writeRoster();
        return toRemove;
    }


    private void loadRoster() throws GenericPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new GenericPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // T object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new T object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the T constructor

            // Put currentStudent into the map using studentID as the key
            if ( !getObjectIds().contains(currentTokens[0]) ) {
                T newObject = buildObject(currentTokens);
                objects.put(getId(newObject), newObject);
            }
        }
        // close scanner
        scanner.close();        
    }
    
    private void writeRoster() throws GenericPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new GenericPersistenceException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        for (T obj : objects.values()) {
            // write the Student object to the file
            out.println(marshalize(obj, DELIMITER));
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    
    private List<String> getObjectIds() {
        List<String> objectIds = new ArrayList<>();
        for (T obj : objects.values()) {
            String objectId = getId(obj);
            if ( !objectIds.contains(objectId) ) {
                objectIds.add(objectId);
            }
        }
        return objectIds;
    }

    abstract public String getId(T object);

    abstract public void editProperty(T object, int i, String newValue);

    abstract public T buildObject(String[] currentTokens);

    abstract public String marshalize(T object, String DELIMITER);
    
}
