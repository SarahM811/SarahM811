/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sakim
 */
public class Round {

    private int roundId;
    private int gameId;
    // private String date;
    private Object date;
    private String formattedDate;
    private String guess;
    private String result;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.roundId;
        hash = 61 * hash + this.gameId;
        hash = 61 * hash + Objects.hashCode(this.guess);
        hash = 61 * hash + Objects.hashCode(this.result);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.roundId != other.roundId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return true;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Round() {

        this.date = getDateTime();

    }

    public Round(int gameId, String guess) {
        this.gameId = gameId;
        this.guess = guess;
    }

    public Round(String answer, String guess) {
        this.result = calculateResult(answer, guess);
        this.roundId = roundId;
        setDate(date);
        this.guess = guess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = getDateTime();
    }

    private Object getDateTime() {
//        LocalDateTime dateTime = LocalDateTime.now();
//        long timeNow = Calendar.getInstance().getTimeInMillis();
//        Timestamp ts = new java.sql.Timestamp(timeNow);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date date = new Date();
        //  Object param = new java.sql.Timestamp(date.getTime());
        Object param = new java.sql.Timestamp(System.currentTimeMillis());

        //return formattedDate = sdf.format(dateTime);
        return param;
    }

    private String calculateResult(String answer, String guess) {
        //  String answer = generateAnswer();

        String[] answerArr = answer.trim().split("");
        String[] guessArr = guess.trim().split("");
        int partialMatch = 0;
        int exactMatch = 0;

        for (int i = 0; i < answerArr.length; i++) {
            if (answer.contains(guess.substring(i)) && !answerArr[i].equals(guessArr[i])) {
                partialMatch++;
            } else if (answerArr[i].equals(guessArr[i])) {
                exactMatch++;
            }
        }
        return ("e:" + exactMatch + "| p:" + partialMatch);
    }
}
