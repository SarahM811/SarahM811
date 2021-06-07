/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase.controller;


import com.gen10.week2_assignment_moviedatabase.dto.Movie;
import com.gen10.week2_assignment_moviedatabase_View.MovieView;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoException;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDao;
import java.util.List;

/**
 *
 * @author sakim
 */
public class MovieController {

    List<Movie> movieList;
    MovieView view;
    MovieDao dao;

    public MovieController(MovieDao dao, MovieView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            try {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createMovie();
                        break;
                    case 2:
                        removeMovie();
                        break;
                    case 3:
                        editMovie();
                        break;
                    case 4:
                        findMovieId();
                        break;
                    case 5:
                        listMovies();
                        break;
                    case 6:
                        displayMovie();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            } catch (MovieDaoException e) {
                view.displayErrorMessage(e.getMessage());
            }

        }
        exitMessage();
    }

    public int getMenuSelection() {
        int menuChoice = view.printMenuAndGetSelection();
        return menuChoice;
    }

    private void createMovie() throws MovieDaoException {
        view.displayAddMovieBanner();
        Movie newMovie = view.getMovieInfo();

        dao.addMovie(newMovie.getTitle(), newMovie);
        view.displayCreateSuccessBanner();

    }

    private void listMovies() throws MovieDaoException {
        view.displayListMovieBanner();
     //   List<String> movieTitleList = dao.getAllMovieTitles();
        List<Movie> movieTitleList = dao.getAllMovies();
     //   view.displayMovieTitleList(movieTitleList);
        view.displayMovieList(movieTitleList);

    }

    //now asks movie ID to remove
    private void removeMovie() throws MovieDaoException {
        int movieId = view.getMovieId();
        dao.removeMovie(movieId);
        view.displayRemoveSuccessBanner();
    }

    private void editMovie() throws MovieDaoException {
        view.displayEditMovieBanner();

        int movieIdOfChoice = view.getMovieId();

        Movie selectedMovie = dao.getMovie(movieIdOfChoice);
        if (selectedMovie != null) {
            String[] newData = new String[6];
            String[] propertyNames = selectedMovie.getPropertyNames();

            for (int i = 0; i < propertyNames.length; i++) {
                String propertyValue = view.getPropertyValueInput(propertyNames[i]);
                if (!propertyValue.equals("")) {
                    newData[i] = propertyValue;
                }
            }

            dao.editMovie(selectedMovie, newData);

            view.displayEditMovieInfo(selectedMovie);
            view.displayEditSuccessBanner();
        } else {
            view.displayErrorMessage("Error");
        }

    }

    private void displayMovie() throws MovieDaoException {
        view.displayMovieBanner();

        String selectedMovieTitle = view.GetMovieChoiceByTitle();
        movieList = dao.getAllMovies(selectedMovieTitle);
        if (movieList == null) {
            view.displayErrorMessage("No movie was found");
        } else {
            view.displayMovieList(movieList);
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private void findMovieId() throws MovieDaoException {
        String searchTitle = view.GetMovieChoiceByTitle();
        String searchDirector = view.GetMovieChoiceByDirector();
        List<Movie> selectedMovieList = dao.getAllMovies(searchTitle);

        Movie searchMovie = dao.getMovie(selectedMovieList, searchDirector);
        if (searchMovie != null) {
            int searchMovieId = searchMovie.getMovieId();
            view.displayMovieId(searchMovieId);
        }
    }
}
