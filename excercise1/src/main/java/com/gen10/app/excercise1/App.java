/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.app.excercise1;

/**
 *
 * @author sakim
 */
public class App {
    
    public static void  main(String[] args) {
        CommentingCode();
    }
    
        private static void gutenberg() {
            System.out.println("Did you know that in 1440 (or thereabouts)");
            System.out.println("Johannes Gutenberg invented the printing press?");
            System.out.println("He started out as a goldsmith!");
            System.out.println("His invention made rapid and prolific typed volumes available for the first time ever...!");
            System.out.println("We are like a modern Gutenberg!");
            System.out.println("Printing vast amounts to the waiting console with ease!");
        }
        
        private static void CommentingCode() {
            // comments are written to explain code in an easily
            // understandable way
            // single line comments
            System.out.println("Normal code is compiled and runs ...");
            System.out.println("Comments however ... "); // do not execute!
            
            //comments can be on their own line
            System.out.println("..."); //or they can share like this
            
            // However if you put // BEFORE  line of code
            // System.out.println("Then it is considered a comment");
            
            /*
            
                This is a multi-lined comment
            */
            
           }
        
        private static void AllTheMaths() {
            System.out.print("1 + 2 is: ");
            System.out.println(1 + 2);
            
            System.out.print("42001 modulus 5 is: ");
            System.out.println(42001 % 5);
            
            System.out.print("5565.0 divided by 22.0 is : ");
            System.out.println(5565.0 / 22.0);
            
            System.out.print("223 times 31 - 42: ");
            System.out.println(223 * 31 - 42);
            
            System.out.print("Is 4 greater than -1? ");
            System.out.println(4 > -1);
            
            System.out.println("\n****** Now make the computer do some harder maths!");
            
            System.out.print("8043.52 minus 4.2 plus 23.0 divided by 56.0 times -76.13 is: ");
            System.out.println(8043.52 - 4.2 + 23.0 / 56.0 * -76.13);
            
            System.out.print("11111 modulus 3 minus 67 minus 1 plus 9 is: ");
            System.out.println(11111 % 3 - 67 - 1 + 9);
            
            System.out.print("44 minus 22 minus 11 minus 66 minus 88 minus 76 minus 11 minus 33 is : ");
            System.out.println(44 - 22 - 11 - 66 - 88 - 76 - 11 - 33);
            
            System.out.print("22 times 3 minus 1 plus 4 times 6 minus -9 is : ");
            System.out.println(22 * 3 - 1 + 4 * 6 - -9);
            
            System.out.print("Is 67 greater than 4 * 5? ");
            System.out.println(67 > (4 * 5));
            
            System.out.print("Is 78 less than than 4 * 5? ");
            System.out.println(78 < (4 * 5));
    }
}
