/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.service;

import com.gen10.guessthenumber.TestApplicationConfiguration;
import com.gen10.guessthenumber.data.GameDao;
import com.gen10.guessthenumber.data.RoundDao;
import com.gen10.guessthenumber.models.Game;
import com.gen10.guessthenumber.models.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GuessGameServiceTest {

    @Autowired
    GuessGameService service;
    @Autowired
    RoundDao roundDao;
    @Autowired
    GameDao gameDao;

    Game game = new Game();
    Round round = new Round();

    public GuessGameServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Game> allGames = gameDao.getAllGames();
        for (int i = 0; i < allGames.size(); i++) {
            Game game = allGames.get(i);
            roundDao.deleteRoundsByGameId(game.getGameId());
        }

        for (int i = 0; i < allGames.size(); i++) {
            Game game = allGames.get(i);
            gameDao.deleteGameById(game.getGameId());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GuessGameService.
     */
    @Test
    public void testAddGame() {

        Game fromService = service.addGame(game);

        assertEquals(game, fromService);

        Game fromServiceGet = service.getGameById(game.getGameId());
        assertEquals(game, fromServiceGet);

    }

    /**
     * Test of addRound method, of class GuessGameService.
     */
    @Test
    public void testAddRound() {

        service.addGame(game);

        round.setGuess("1234");
        round.setResult("result");
        round.setGameId(game.getGameId());
        Round fromService = service.addRound(round);

        assertEquals(round, fromService);

        List<Round> rounds = service.getAllRoundsByGameId(game.getGameId());
        for (Round roundService : rounds) {
            assertEquals(round, roundService);
        }

    }

    /**
     * Test of getAllGames method, of class GuessGameService.
     */
    @Test
    public void testGetAllGames() {
        int initialSize = service.getAllGames().size();
        game.setInProgress(false);
        service.addGame(game);

        Game InProgressGame = new Game();
        InProgressGame.setInProgress(true);
        service.addGame(InProgressGame);

        List<Game> gamesService = service.getAllGames();
        int resultSize = gamesService.size();
        int expectedSize = initialSize + 2;

        assertEquals(expectedSize, resultSize);

        for (Game eachGame : gamesService) {
            assertTrue(eachGame instanceof Game);
            if (eachGame.getGameId() == InProgressGame.getGameId()) {
                String expectedHiddenAnswer = "This game is still in progress- cannot show the answer";
                String resultAnswer = eachGame.getAnswer();

                assertEquals(expectedHiddenAnswer, resultAnswer);
            }
        }

        String expected = game.getAnswer();

        assertEquals(expected, game.getAnswer());

    }

    /**
     * Test of getAllRoundsByGameId method, of class GuessGameService.
     */
    @Test
    public void testGetAllRoundsByGameId() {

        service.addGame(game);

        int initialRoundSize = service.getAllRoundsByGameId(game.getGameId()).size();

        round.setGuess("1234");
        round.setResult("result");
        round.setGameId(game.getGameId());
        service.addRound(round);

        List<Round> roundsFromService = service.getAllRoundsByGameId(game.getGameId());
        int expected = initialRoundSize + 1;
        int result = roundsFromService.size();

        assertEquals(expected, result);

    }

    /**
     * Test of getGameById method, of class GuessGameService.
     */
    @Test
    public void testGetGameById() {
        service.addGame(game);

        Game fromService = service.getGameById(game.getGameId());

        assertEquals(game, fromService);
        
        Game newGame = new Game();
        service.addGame(newGame);
        
        Game result = service.getGameById(newGame.getGameId());
        assertEquals(newGame, result);
    }

    /**
     * Test of calculateResult method, of class GuessGameService.
     */
    @Test
    public void testCalculateResult() {
        String answer = "1234";
        String correctGuess = "1234";

        String expected = "e:4| p:0| You guessed it right! Game is finished.";
        String result = service.calculateResult(answer, correctGuess);

        assertEquals(expected, result);

        String wrongGuess = "5678";
        String expectedAllWrong = "e:0| p:0";
        String resultAllWrong = service.calculateResult(answer, wrongGuess);

        String partialGuess = "3456";
        String expectedPartial = "e:0| p:2";
        String resultPartial = service.calculateResult(answer, partialGuess);
    }

    /**
     * Test of makeGuess method, of class GuessGameService.
     */
    @Test
    public void testMakeGuess() {
        Game newGame = new Game();
        newGame.setAnswer("1234");
        service.addGame(newGame);
        
        Round round = new Round();
        round.setGameId(newGame.getGameId());
        round.setGuess("1234");    
      
        Round fromService = service.makeGuess(newGame.getGameId(), round);

        String expectedResult = "e:4| p:0| You guessed it right! Game is finished.";
        String resultFromService = fromService.getResult();
        
        assertEquals(expectedResult, resultFromService);
        
        String expectedGuess = "1234";
        String resultGuess = fromService.getGuess();
        
        assertEquals(expectedGuess, resultGuess);
        
        Game afterMakeGuessGame = service.getGameById(newGame.getGameId());
        Boolean resultStatus = afterMakeGuessGame.isInProgress();
        assertFalse(resultStatus);
        
        List<Round> roundsFromService = service.getAllRoundsByGameId(newGame.getGameId());
        int expSize = 1;
        int resultSize = roundsFromService.size();
        assertEquals(expSize, resultSize);
    }

    /**
     * Test of setGameStatus method, of class GuessGameService.
     */
    @Test
    public void testSetGameStatus() {
        String correctResult = "e:4| p:0| You guessed it right! Game is finished.";
        
        service.setGameStatus(game, correctResult);
        assertFalse(game.isInProgress());
        
        Game game1 = new Game();
        String partialResult = "e:2| p:2";
        service.setGameStatus(game1, partialResult);
        assertTrue(game1.isInProgress());
    }

}
