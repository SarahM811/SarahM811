/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase.dto;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class Movie {
    private String title;
    private String releaseDate;
    private String MPAArate;
    private String directorName;
    private String studio;
    private String userNote;
    private int movieId;
    private static int startId = 1;
    
    private Scanner scanner = new Scanner(System.in);
   
    public Movie () {
         this.movieId = makeIds();
      }
    
    public Movie  (int movieId, String title, String directorName, String releaseDate, String MPAArate, String studio, String userNote) {
        setMovieId(movieId);
        this.title = title;
        this.directorName = directorName;
        this.releaseDate = releaseDate;
        this.MPAArate = MPAArate;
        this.studio = studio;
        this.userNote = userNote;
    }
    
    public int getMovieId() {
        return movieId;
    }
    
    
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
        
         if(Movie.startId <= movieId) {
            Movie.startId = movieId + 1;
        }
    }

    
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAArate() {
        return MPAArate;
    }

    public void setMPAArate(String MPAArate) {
        this.MPAArate = MPAArate;
    }

    
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    public void editProperty(int propertyIndex, String newValue) {
        switch(propertyIndex) {
            case 0:
                setTitle(newValue);
                break;
            case 1:
                setDirectorName(newValue);
                break;
            case 2:
                setReleaseDate(newValue);
                break;
            case 3:
                setMPAArate(newValue);
                break;
            case 4:
                setStudio(newValue);
                break;
            case 5:
                setUserNote(newValue);
                break;
            default:
                System.out.println("");
        }
    }
    
    public String[] getPropertyNames() {
        return new String[] {"Movie Title", "Director's Name", "Release Date", "MPAArate", "Studio", "User Note"};
    }
    
       
    public int makeIds() {
        return Movie.startId++;
    }
}
