/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase_dao;

import com.gen10.week2_assignment_moviedatabase.dto.Movie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class MovieDaoFileImpl implements MovieDao {

    Random randomizer = new Random();
    public static final String MOVIE_DATABASE_FILE = "MovieDatabase.txt";
    public static final String DELIMITER = "::";
    private ArrayList<Movie> movieList = new ArrayList<>();
    private static int startId = 1;

    public MovieDaoFileImpl() throws MovieDaoException {
        loadMovieDatabase();
    }
    
    @Override
    public Movie addMovie(String title, Movie movie) throws MovieDaoException {

        movieList.add(movie);
        writeMovieDatabase();
        return movie;
    }


    @Override
    public void removeMovie(int movieId) throws MovieDaoException {
        Movie selectedMovie = null;
        for (Movie currentMovie : movieList) {
            if (currentMovie.getMovieId() == movieId) {
                selectedMovie = currentMovie;
            }
        }
        movieList.remove(selectedMovie);
        writeMovieDatabase();

    }


    @Override
    public List<Movie> getAllMovies() throws MovieDaoException {
        loadMovieDatabase();
        Movie allMovie;
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            allMovie = movieList.get(i);
            listOfMovies.add(allMovie);
        }
        
        return listOfMovies;

    }

    @Override
    public List<String> getAllMovieTitles() throws MovieDaoException {
        loadMovieDatabase();
        Movie allMovie;
        String allMovieTitles;
        ArrayList<String> listOfMovies = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            allMovie = movieList.get(i);
            allMovieTitles = allMovie.getTitle();
            listOfMovies.add(allMovieTitles);
        }
       
        return listOfMovies;

    }

    //for search by title to show multiple movies that includes that word in their titles
    @Override
    public List<Movie> getAllMovies(String title) throws MovieDaoException {
        loadMovieDatabase();
        Movie selectedMovie = null;
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            selectedMovie = movieList.get(i);
           
            if ((selectedMovie.getTitle().toLowerCase()).startsWith(title.toLowerCase())) {
                listOfMovies.add(selectedMovie);

            }
        }
        if (listOfMovies == null) {
            throw new MovieDaoException("No movie was found.");
        } else {
            return listOfMovies;
        }

    }

    //to be able to edit or remove a specific movie
    @Override
    public Movie getMovie(String title) throws MovieDaoException {
        loadMovieDatabase();
        Movie selectedMovie = null;

        for (int i = 0; i < movieList.size(); i++) {
            selectedMovie = movieList.get(i);
            String selectedTitle = selectedMovie.getTitle();
            //  String selectedDirector = selectedMovie.getDirectorName();
            if (selectedTitle.startsWith(title)) {
                selectedMovie = movieList.get(i);
            }
        }
        if (selectedMovie == null) {
            throw new MovieDaoException("No movie was found.");
        } else {
            return selectedMovie;
        }

    }
//get one movie for remove/edit, getting it from the list of movies that starts with the same word.
    public Movie getMovie(List<Movie> selectedList, String directorName) throws MovieDaoException {
        Movie selectedOneMovie = null;
        for (Movie selectedMovie : selectedList) {
            if (selectedMovie.getDirectorName().equals(directorName)) {
                selectedOneMovie = selectedMovie;
                break;
            } 
        }
        
        if (selectedOneMovie == null) {
                System.out.println("No movie was found. ");
            }
        return selectedOneMovie;
    }

    public Movie getMovie(int movieId) throws MovieDaoException {
        Movie selectedMovie = null;

        for (Movie currentMovie : movieList) {
            if (currentMovie.getMovieId() == movieId) {
                selectedMovie = currentMovie;
            } 
        }

        return selectedMovie;
    }

    
    @Override
    public void editMovie(Movie selectedMovie, String[] newData)
            throws MovieDaoException {
        
        String[] oldData = {selectedMovie.getTitle(), selectedMovie.getDirectorName(), selectedMovie.getReleaseDate(), selectedMovie.getMPAArate(),
            selectedMovie.getStudio(), selectedMovie.getUserNote()};
        
        removeMovie(selectedMovie.getMovieId());
        for (int i = 0; i < newData.length; i++) {
            String newValue = newData[i];
            if (newValue != null && !newValue.equals("")) {
                selectedMovie.editProperty(i, newValue);
            }
        }

        addMovie(selectedMovie.getTitle(), selectedMovie);
        writeMovieDatabase();
    }

    public void loadMovieDatabase() throws MovieDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader((MOVIE_DATABASE_FILE))));
        } catch (FileNotFoundException e) {
            throw new MovieDaoException("Could not load the movie database into memory", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            //turn currentToken [0] into integer for movieId, pass in other elements
            Movie currentMovie = new Movie(Integer.parseInt(currentTokens[0]), currentTokens[1], currentTokens[2], currentTokens[3], currentTokens[4], currentTokens[5],
                    currentTokens[6]);

            if (!getAllIds().contains(currentMovie.getMovieId())) {
                movieList.add(currentMovie);
            }
        }

        scanner.close();
    }

    public void writeMovieDatabase() throws MovieDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(MOVIE_DATABASE_FILE));
        } catch (IOException e) {
            throw new MovieDaoException("Could not save movie data.", e);
        }

        List<Movie> movieList = this.getAllMovies();
        for (Movie currentMovie : movieList) {
            out.println(currentMovie.getMovieId() + DELIMITER
                    + currentMovie.getTitle() + DELIMITER
                    + currentMovie.getDirectorName() + DELIMITER
                    + currentMovie.getReleaseDate() + DELIMITER
                    + currentMovie.getMPAArate() + DELIMITER
                    + currentMovie.getStudio() + DELIMITER
                    + currentMovie.getUserNote());

            out.flush();
        }
        out.close();
    }


    public List<Integer> getAllIds() {
        List<Integer> movieIdList = new ArrayList<>();
        for (Movie currentMovie : movieList) {
            int currentId = currentMovie.getMovieId();
            movieIdList.add(currentId);
        }
        return movieIdList;
    }
}
