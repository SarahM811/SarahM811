/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.exercise4.exercise4;

import java.util.Scanner;

/**
 *
 * @author sakim
 */
public class exercise4App {
        //for tiviaNight method
        final static String QUESTION_1 = "What is 2+2?";
        final static String QUESTION_2 = "What color is grass?";
        final static String QUESTION_3 = "When is Christmas?";
        final static String ANSWERC1 = "4";
        final static String ANSWERC2 = "green";
        final static String ANSWERC3 = "Dece25";
        
        
    public static void main(String[] args) {
        BirthStones();
    }
    
    private static void LlamasWhalesAndDodosOhMy() {
        int llamas = 20;
        int whales = 15;
        int dodos = 0;
        
        if (dodos > 0) {
            System.out.println("Egads, I thought dodos were extinct!");
        }
        
        if (dodos < 0) {
            System.out.println("Hold on, how can we have NEGATIVE dodos??!");
        }
        
        if (llamas > whales) {
            System.out.println("Whales may be bigger, but llamas are better, ha!");
        }
        
        if (llamas <= whales) {
            System.out.println("Aw man, brawn over brains I guess. Whales beat llamas.");
        } 
            System.out.println("There's been a huge increase in the dodo population via cloning!");
            dodos += 100;
         
         if ((whales + llamas) < dodos) {
             System.out.println("I never thought I'd see the day when dodos ruled the earth.");
         }
         
         if (llamas > whales || llamas > dodos) {
             System.out.println("I don't know how, but the llamas have come out ahead! Sneaky!");
         }
                
    }
    
    private static void GuessMe() {
        
        Scanner myScanner = new Scanner(System.in);
        
        int number = 7;
        int answer;
        
              
        System.out.println("I've chosent a number. Betcha can't guess it!");
        System.out.println("Your guess: ");
        answer = myScanner.nextInt();
        
        if (answer == number) {
            System.out.println("Wow, nice guess! That was it!");
        }
        
        if (answer < number) {
            System.out.println("Ha, nice try- too low! I chose 7");
        }
        
        else {
            System.out.println("Too bad, way too high. I chose 7");
        }
    }
    
    public static void YourLifeInMovies() {
        Scanner myScanner = new Scanner(System.in);
        String name;
        int year;
        
    
        name = askQuestion("Hey, let's play a game! What's your name? ");
        
        System.out.println("Ok, " + name + ", when were you born? ");
        year = myScanner.nextInt();
        
        if (year < 2005) {
        System.out.println("Did you know that Pixar's 'up' came out half a decade ago?");
        }
        
        if (year < 1995) {
            System.out.println("First Harry Potter came out over 15 years ago");
        }
        
        if (year < 1985) {
            System.out.println("Spcae Jam came out not last decade, but the one before THAT.");
        }
        
        if (year < 1975) {
            System.out.println("Jurassic Park release is closer to the lunar landing, than today.");
        }
        
        if (year < 1965) {
            System.out.println("MASH has been around for almost half a century!");
        }
    }
    
    private static String askQuestion(String question) {
        Scanner myScanner = new Scanner(System.in);
        String response;
        
        System.out.println(question);
        response = myScanner.nextLine();
        
        return response;
    }
    
    private static void SpaceRustlers() {
        
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        if (aliens > spaceships) {
            System.out.println("Vroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }
        
        if (cows == spaceships) {
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships) {
            System.out.println("Dangit! I don't know how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        
        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        }
        else if (cows >= aliens ){
            System.out.println("Oh no! The herds got resless and took over! Looks like_we're_hamburger now!!");
        }
    }
    
    private static void BirthStones() {
        Scanner myScanner = new Scanner(System.in);
        int month;
        
        
        System.out.println("What month's birthstone are you wanting to know? ");
        month = myScanner.nextInt();
        
        if (month == 1) {
            System.out.println("January's birthstone is Garnet");
        } else if (month == 2) {
            System.out.println("February's birthstone is Amethyst");
        } else if (month == 3) {
            System.out.println("March's birthstone is Aquamarine");
        } else if (month == 4) {
            System.out.println("April's birthstone is Diamond");
        } else if (month == 5) {
            System.out.println("May's birthstone is Emerald");
        } else if (month == 6) {
            System.out.println("June's birthstone is Pearl");
        } else if (month == 7) {
            System.out.println("July's birthstone is Ruby");
        } else if (month == 8) {
            System.out.println("August's birthstone is Peridot");
        } else if (month == 9) {
            System.out.println("September's birthstone is Sapphire");
        } else if (month == 10) {
            System.out.println("October's birthstone is Opal");
        } else if (month == 11) {
            System.out.println("November's birthstone is Topaz");
        } else if (month == 12) {
            System.out.println("January's birthstone is Turquoise");
        } else {
            System.out.println("Invalid month");
        }
    }
    
    private static void TriviaNight() {
        
        Scanner myscanner = new Scanner(System.in);
        int response1, response2, response3, correct;
        
        
        
        System.out.println("It's a TRIVITA NIGHT! Are you ready?!");
        
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code                  2) Assembly Language");
        System.out.println("3) C#                           4) Machine Code");
        
        response1 = myscanner.nextInt();
        
        System.out.println("SECOND QUESTIONS!");
        System.out.println("Website Security CAPTCHA Forms are descended From the Work of?");
        System.out.println("1) Grace Hopper           2) Alan Turing  ");
        System.out.println("3) Charles Babbage        4) Larry Page  ");
        
        response2 = myscanner.nextInt();
        
        System.out.println("LAST QUESTION!");
        System.out.println("Which of these Sci-Fie ships Was Once Slated for a full-size replica in Las Vegas?");
        System.out.println("1) Serenity         2) The Battlestar Galactica");
        
        response3 = myscanner.nextInt();
        
        if ( response1 == 4 && response2 == 2 && response3 == 3) {
             correct = 3;
             System.out.println("Nice job- you got" + correct + "correct!");
        } else if ()
    }
    
    //IN CLASS
    public static void triviaNight() {
        
              
        int correctTally = 0;
        boolean answerC1, answerC2, answerC3;
        String answer;
        
        //Ask question -- put under "class" to be applied to every method
       String answer1 = askQuestions(QUESTION_1);
       String answer2 = askQuestions(QUESTION_2);
       String answer3 = askQuestions(QUESTION_3);
       
       
        //Show option
        showOptions(QUESTION_1);
           
        //collect input
        answer1 = collectInput();
        
        //Check answers
        answerC1 = checkAnswer(QUESTION_1, answer1);
        answerC2 = checkAnswer(QUESTION_2, answer3);
        answerC3 = checkAnswer(QUESTION_3, answer3);
        
        //Tally right answers
        if (answerC1)(correctTally++);
        if (answerC2)(correctTally++);
        if (answerC3)(correctTally++);
        //output correct answers
        correctAnswersOutput(correctTally);
    
    }   
    
    private static void askQuestions(String question) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println(question);
    
        //show options
        showOptions(QUESTION_1);
        //collect input
        String answer = inputReader.nextLine();
        return answer;
    }

    private static void showOptions(String question) {
      switch(question) {
          case QUESTION_1:
              System.out.println("Question1 Options");
            break;
          case QUESTION_2:
              System.out.println("Question2 Options");
            break;
          case QUESTION_3:
              System.out.println("Question3 Options");
            break;
          default:
              System.out.println("Unknown Question");
            break;
      }
    }

    private static int collectInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void checkAnswer(String question, String answer) {
         String correctAnswer = getCorrectAnswer(question);
         return correctAnswer.equals(answer);
         
         
    }

    private static String getCorrectAnswer(String question) {
        String correctAnswer;
        switch(question) {
          case QUESTION_1:
              correctAnswer = ANSWERC1;
            break;
          case QUESTION_2:
              correctAnswer = ANSWERC2;
            break;
          case QUESTION_3:
              correctAnswer = ANSWERC3;
            break;
          default:
              correctAnswer = "";
            break;
        }
        return correctAnswer;
    }

    private static void correctAnswersOutput(int correctTally) {
        System.out.println("You got " + correctTally + "answers right!");
    }
    
        
    
}
