/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.service;

import com.gen10.guessthenumber.data.GameDBDao;
import com.gen10.guessthenumber.data.GameDao;

import com.gen10.guessthenumber.data.RoundDao;
import com.gen10.guessthenumber.models.Game;
import com.gen10.guessthenumber.models.Round;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author sakim
 */
@Component

public class GuessGameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private RoundDao roundDao;

    Random random = new Random();

    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }
    
    public Game addGame() {
        Game game = new Game();
        return gameDao.addGame(game);
    }

    public Round addRound(Round round) {
        return roundDao.addRound(round);
    }

   
    public List<Game> getAllGames() {
       
        List<Game> gamesWithAnswer = gameDao.getAllGames();
        List<Game> gamesWithAnswerHidden = new ArrayList<>();
        for (int i = 0; i < gamesWithAnswer.size(); i++) {
            Game game = gamesWithAnswer.get(i);
            if (game.isInProgress() == true) {
                game.setAnswer("This game is still in progress- cannot show the answer");
                gamesWithAnswerHidden.add(game);
            } else {
                gamesWithAnswerHidden.add(game);
            }
        }
        return gamesWithAnswerHidden;

    }

    public List<Round> getAllRoundsByGameId(int gameId) {
        return roundDao.getAllRoundsByGameId(gameId);
    }

    public Game getGameById(int gameId) {
        Game chosenGame = gameDao.getGameById(gameId);

        if (chosenGame.isInProgress() == true) {
            chosenGame.setAnswer("Still in Progress- answer cannot be shonw");

            return chosenGame;
        }
        return chosenGame;
    }

    public String calculateResult(String answer, String guess) {
        String result;
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
        result = "e:" + exactMatch + "| p:" + partialMatch;
        
        if (exactMatch==4 && partialMatch ==0) {
            result = "e:4| p:0| You guessed it right! Game is finished.";
        }
        return result;
    }

    public Round makeGuess(int gameId, Round round) {

        Game currentGame = gameDao.getGameById(gameId);
        String result = calculateResult(currentGame.getAnswer(), round.getGuess());
        round.setResult(result);
        addRound(round);
        setGameStatus(currentGame, round.getResult());
        return round;
    }
    
    public Round makeGuess(Round round) {
        int gameId = round.getGameId();
        Game currentGame = gameDao.getGameById(gameId);
        String result = calculateResult(currentGame.getAnswer(), round.getGuess());
        round.setResult(result);
        addRound(round);
        setGameStatus(currentGame, round.getResult());
        return round;
    }

    public void setGameStatus(Game game, String result) {
        if (result.equals("e:4| p:0| You guessed it right! Game is finished.")) {
            game.setInProgress(false);
            gameDao.updateStatus(game);
        } else {
            game.setInProgress(true);
            gameDao.updateStatus(game);
        }
    }
}
