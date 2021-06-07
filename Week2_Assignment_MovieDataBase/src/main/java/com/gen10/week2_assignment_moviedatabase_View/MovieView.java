/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.week2_assignment_moviedatabase_View;

import com.gen10.week2_assignment_moviedatabase.dto.Movie;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class MovieView {
    private UserIO io;
    Scanner scanner = new Scanner(System.in);
    
    public MovieView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. Add Movie");
            io.print("2. Remove Movie");
            io.print("3. Edit existing Movie");
            io.print("4. Find the movie ID");
            io.print("5. View the list of all movies");
            io.print("6. View information about a selected movie- search by title");
            io.print("7. Exit");
            
            return io.readInt("Please select an option: ",1,7);
    }
    
    public Movie getMovieInfo() {
        String title = io.readString("Please enter the title of the movie.");
        String directorName = io.readString("Please enter the name of the director");
       // String releaseDate = io.readString("Please enter release date of the movie.");
        LocalDate releaseDate = LocalDate.now();
        String MPAArate = io.readString("Please enter MPAA rate of the movie.");
        String studio = io.readString("Please enter the studio of the movie");
        String userNote = io.readString("Add any notes: ");
        
        Movie ToGetMovieId = new Movie();
        
       int movieId = ToGetMovieId.getMovieId();
        
        return new Movie(movieId, title, directorName, releaseDate.toString(), MPAArate, studio, userNote);
    }
    
    public void displayAddMovieBanner() {
        io.print("===Add Movie===");
    }

   public void displayCreateSuccessBanner() {
        io.print("=== Movie successfully created.");
        io.print("");
    }

   public void displayListMovieBanner() {
        io.print("=== List of Movies ===");
    }

//    public void displayMovieList(List<Movie> movieList) {
//        for (Movie currentMovie: movieList) {
//            io.print("Title: " + currentMovie.getTitle() + " Director's name: " + currentMovie.getDirectorName() + " Release Date: " + currentMovie.getReleaseDate()
//            + " Studio: " + currentMovie.getStudio() + " MPAA rate:" + currentMovie.getMPAArate() + " User Note: " + currentMovie.getUserNote());
//        }
//    }
   public void displayMovieList(List<Movie> movieList) {
        for (Movie currentMovie: movieList) {
            io.print("MovieID: " + currentMovie.getMovieId() +  "| Title: " + currentMovie.getTitle() + "| Director's name: " + currentMovie.getDirectorName() + "| Release Date: " + currentMovie.getReleaseDate()
            + "| Studio: " + currentMovie.getStudio() + "| MPAA rate:" + currentMovie.getMPAArate() + "| User Note: " + currentMovie.getUserNote());
        }
    }
    
   public void displayEditMovieInfo(Movie editedMovie) {
        io.print("Title: " + editedMovie.getTitle() + " Director's name: " + editedMovie.getDirectorName() + " Release Date: " + editedMovie.getReleaseDate()
            + " Studio: " + editedMovie.getStudio() + " MPAA rate:" + editedMovie.getMPAArate() + " User Note: " + editedMovie.getUserNote());
        
    }
    
  public  void displayMovieTitleList(List<String> movieTitleList) {
        for (String currentTitle : movieTitleList) {
            io.print("Movie Title: " + currentTitle);
        }
    }
    
  public  String GetMovieChoiceByTitle() {
        return io.readString("Which movie do you want to search? Search by the first word of the title of the movie:");
    }
    
   public String GetMovieChoiceByDirector() {
        return io.readString("Enter the name of the director of the movie you are searching.");
    }

  public  void displayRemoveMovieBanner() {
        io.print("=== Remove Movie ===");
    }

  public  void displayRemoveSuccessBanner() {
        io.print("=== Movie Successfully Removed ===");
    }

  public  void displayEditMovieBanner() {
        io.print("===Edit Movie===");
    }

 public   void displayEditSuccessBanner() {
        io.print("=== Movie Successfully Editted ===");
    }

 public   void displayMovieBanner() {
        io.print("=== Movie Search ===");
    }

  public  void displayUnknownCommandBanner() {
       io.print("Unknown Command!");
    }

 public   void displayExitMessage() {
        io.print("Good Bye!!");
    }

  public  void displayErrorMessage(String errorMessage) {
        io.print("=== ERROR ===");
        io.print(errorMessage);
        
    }
    
    
 public   void displayMovieId(int movieId) {
        io.print("Assigned movie Id is: " + movieId);
    } 
    
 public   int getMovieId() {
      return io.readInt("What is the movie ID? It should be a number.");
    }
    
    public String getPropertyValueInput(String PropertyName) {
        String propertyValue = "";
        System.out.println("Edit property " + PropertyName + "? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("yes") || answer.equals("y")) {
            System.out.println("Enter new property value");
            propertyValue = scanner.nextLine();

        }
        return propertyValue;
    }
}

