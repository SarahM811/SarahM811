/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase_dao;

import com.gen10.week2_assignment_moviedatabase.dto.Movie;
import java.util.List;

/**
 *
 * @author sakim
 */
public interface MovieDao {
    
    Movie addMovie(String Title, Movie movie) throws MovieDaoException;

    void removeMovie(int indexNumber) throws MovieDaoException;

    List<Movie> getAllMovies() throws MovieDaoException;

    List<String> getAllMovieTitles() throws MovieDaoException;

    List<Movie> getAllMovies(String title) throws MovieDaoException;

    Movie getMovie(String title) throws MovieDaoException;

    Movie getMovie(List<Movie> selectedList, String title) throws MovieDaoException;

    Movie getMovie(int indexNumber) throws MovieDaoException;

    void editMovie(Movie selectedMovie, String[] newData) throws MovieDaoException;
    
    
}
