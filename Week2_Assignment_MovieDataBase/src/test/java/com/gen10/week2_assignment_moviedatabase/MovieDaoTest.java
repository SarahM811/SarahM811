/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase;

import com.gen10.week2_assignment_moviedatabase.dto.Movie;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoFileImpl;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDao;
import com.gen10.week2_assignment_moviedatabase_dao.MovieDaoException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sakim
 */
public class MovieDaoTest {
    
    MovieDao dao;
    
    public MovieDaoTest() throws MovieDaoException {
        this.dao = new MovieDaoFileImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Movie> movieList = dao.getAllMovies();
        for (Movie movie: movieList) {
            dao.removeMovie(movie.getMovieId());
        }
        
        List<String> movieTitleList = dao.getAllMovieTitles();
        for (int i = 0; i<movieTitleList.size(); i++) {
            String movieTitle = movieTitleList.get(i);
            movieTitleList.remove(movieTitle);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMovie method, of class MovieDao.
     */
    @Test
    public void testAddMovie() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        Movie fromDao = dao.getMovie(movie.getTitle());
        
        assertEquals(movie, fromDao);
    }

    /**
     * Test of removeMovie method, of class MovieDao.
     */
    @Test
    public void testRemoveMovie() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        Movie movie2 = new Movie();
        movie2.setMovieId(movie2.getMovieId());
        movie2.setTitle("hello");
        movie2.setDirectorName("world");
        movie2.setReleaseDate("2012");
        movie2.setMPAArate("91");
        movie2.setStudio("blah");
        movie2.setUserNote("n/a");
        
        dao.addMovie(movie2.getTitle(), movie2);
        
        dao.removeMovie(movie.getMovieId());
        assertEquals(1, dao.getAllMovies().size());
        assertNull(dao.getMovie(movie.getMovieId()));
        
        dao.removeMovie(movie2.getMovieId());
        assertEquals(0, dao.getAllMovies().size());
        assertNull(dao.getMovie(movie2.getMovieId()));
     
        
    }

    /**
     * Test of getAllMovies method, of class MovieDao.
     */
    @Test
    public void testGetAllMovies_0args() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        Movie movie2 = new Movie();
        movie.setMovieId(movie2.getMovieId());
        movie.setTitle("hello");
        movie.setDirectorName("world");
        movie.setReleaseDate("2012");
        movie.setMPAArate("91");
        movie.setStudio("blah");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie2.getTitle(), movie2);
        
        assertEquals(2, dao.getAllMovies().size());
        
    }

    /**
     * Test of getAllMovieTitles method, of class MovieDao.
     */
    @Test
    public void testGetAllMovieTitles() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        String movieTitle = movie.getTitle();
        List<String> fromDao = dao.getAllMovieTitles();
        
        assertEquals(1, fromDao.size());
        
    }

    /**
     * Test of getAllMovies method, of class MovieDao.
     */
    @Test
    public void testGetAllMovies_String() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        String movieTitle = movie.getTitle();
        List<Movie> fromDao = dao.getAllMovies(movie.getTitle());
        
        assertEquals(1, fromDao.size());
    }

    /**
     * Test of getMovie method, of class MovieDao.
     */
    @Test
    public void testGetMovie_String() throws Exception {
    }

    /**
     * Test of getMovie method, of class MovieDao.
     */
    @Test
    public void testGetMovie_List_String() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        List<Movie> movieList = dao.getAllMovies();
        dao.addMovie(movie.getTitle(), movie);
         movieList = dao.getAllMovies();
        Movie fromDao = dao.getMovie(movieList, movie.getDirectorName());
        
        assertEquals(movie, fromDao);
        
    }

    /**
     * Test of getMovie method, of class MovieDao.
     */
    @Test
    public void testGetMovie_int() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
              
        Movie daoMovie = dao.getMovie(movie.getMovieId());
        
        assertEquals(movie, daoMovie);
    }

    /**
     * Test of editMovie method, of class MovieDao.
     */
    @Test
    public void testEditMovie() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(movie.getMovieId());
        movie.setTitle("coco");
        movie.setDirectorName("director");
        movie.setReleaseDate("2018");
        movie.setMPAArate("99");
        movie.setStudio("disney");
        movie.setUserNote("n/a");
        
        dao.addMovie(movie.getTitle(), movie);
        
        String title = "lionking";
        String directorName = "Joe";
        String releaseDate = "2014";
        String MPAA = "98";
        String Studio = "disney2";
        String userNote = "blah";
        
        String[] newData = {title, directorName, releaseDate, MPAA, Studio, userNote};
        
        dao.editMovie(movie, newData);
        assertEquals(movie.getTitle(), title);
    }

    
    
}
