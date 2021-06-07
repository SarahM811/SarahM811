/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

import com.gen10.guessthenumber.models.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.gen10.guessthenumber.models.Game;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.gen10.guessthenumber.TestApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDaoTest {

    @Autowired
    RoundDao roundDao;
    @Autowired
    GameDao gameDao;

    public RoundDaoTest() {
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
     * Test of addRound method, of class RoundDao.
     */
    @Test
    public void testAddRound() {
        Game game = new Game();
        gameDao.addGame(game);
        Round round = new Round();
        round.setGuess("1234");
        round.setResult("result");
        round.setGameId(game.getGameId());
        Round fromDao = roundDao.addRound(round);

        assertEquals(round, fromDao);

        List<Round> roundsFromDao = roundDao.getAllRoundsByGameId(game.getGameId());
        int expected = 1;
        int result = roundsFromDao.size();
        assertEquals(expected, result);
        
        for (Round RoundFromDao : roundsFromDao) {
            assertEquals(round, RoundFromDao);
        }
        
        

    }

    /**
     * Test of getAllRoundsByGameId method, of class RoundDao.
     */
    @Test
    public void testGetAllRoundsByGameId() {
        Game game = new Game();
        gameDao.addGame(game);
        Round round = new Round();
        round.setGuess("1234");
        round.setResult("result");
        round.setGameId(game.getGameId());
        Round fromDao = roundDao.addRound(round);

        assertEquals(round, fromDao);

        List<Round> roundsFromDao = roundDao.getAllRoundsByGameId(game.getGameId());
        int expected = 1;
        int result = roundsFromDao.size();
        assertEquals(expected, result);
    }
     @Test
    public void testDeleteRoundsByGameId() {
        Game game = new Game();
        gameDao.addGame(game);
        Round round = new Round();
        round.setGuess("1234");
        round.setResult("result");
        round.setGameId(game.getGameId());
        Round fromDao = roundDao.addRound(round);
        
        List<Round> roundsFromDao = roundDao.getAllRoundsByGameId(game.getGameId());
        int expected = 1;
        int result = roundsFromDao.size();
        assertEquals(expected, result);
        
        roundDao.deleteRoundsByGameId(game.getGameId());
        List<Round> afterDeleteRoundsList = roundDao.getAllRoundsByGameId(game.getGameId());
        int expected1 = 0;
        int result1 = afterDeleteRoundsList.size();
        assertEquals(expected1, result1);

        List<Round> afterDeleteList = roundDao.getAllRoundsByGameId(game.getGameId());
        int expectedSize = 0;
        int afterDeleteSize = afterDeleteList.size();
        assertEquals(expectedSize, afterDeleteSize);


    }

}
