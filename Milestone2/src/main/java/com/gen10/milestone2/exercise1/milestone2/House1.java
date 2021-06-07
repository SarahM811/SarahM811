/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.milestone2.exercise1.milestone2;

/**
 *
 * @author sakim
 */
public class House1 {
    private float[] GPSCoordinates;
    private int houseNumber;
    private String streetName;
    private String city;
    private String state;
    private int zipcode;
    private String county;
    private String country;

    public float[] getGPSCoordinates() {
        return GPSCoordinates;
    }

    public void setGPSCoordinates(float[] GPSCoordinates) {
        this.GPSCoordinates = GPSCoordinates;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
