/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

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
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoTest {

    @Autowired
    GameDao gameDao;
    @Autowired
    RoundDao roundDao;

    public GameDaoTest() {
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

    Game game = new Game();

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GameDao.
     */
    @Test
    public void testAddGame() {

        Game result = gameDao.addGame(game);

        assertEquals(game, result);

        Game fromDao = gameDao.getGameById(game.getGameId());
        assertEquals(game, fromDao);
    }

    /**
     * Test of getAllGames method, of class GameDao.
     */
    @Test
    public void testGetAllGames() {
        int initialSize = gameDao.getAllGames().size();

        Game addedGame = new Game();
        addedGame = gameDao.addGame(addedGame);

        List<Game> gamesFromDao = gameDao.getAllGames();
        int expected = initialSize + 1;
        int result = gamesFromDao.size();

        assertEquals(expected, result);

        gameDao.addGame(game);
        int expected2 = expected + 1;
        int result2 = gameDao.getAllGames().size();

        assertEquals(expected2, result2);

    }

    /**
     * Test of getGameById method, of class GameDao.
     */
    @Test
    public void testGetGameById() {
        gameDao.addGame(game);
        Game fromDao = gameDao.getGameById(game.getGameId());

        assertEquals(game, fromDao);

        Game addedGame = new Game();
        gameDao.addGame(addedGame);
        Game secondFromDao = gameDao.getGameById(addedGame.getGameId());

        assertEquals(addedGame, secondFromDao);

    }

    /**
     * Test of updateStatus method, of class GameDao.
     */
    @Test
    public void testUpdateStatus() {
        boolean result = game.isInProgress();
        boolean expected = true;
        assertEquals(expected, result);

        game.setInProgress(false);
        gameDao.updateStatus(game);
        boolean resultAfterDao = game.isInProgress();
        boolean expectedAfterDao = false;
        assertEquals(expectedAfterDao, resultAfterDao);

    }

    @Test
    public void testDeleteGameById() {
        int initialSize = gameDao.getAllGames().size();
        Game newGame = new Game();
        gameDao.addGame(newGame);
        int expectedSize = initialSize + 1;
        int resultSize = gameDao.getAllGames().size();

        assertEquals(expectedSize, resultSize);

        gameDao.deleteGameById(newGame.getGameId());

        int result = gameDao.getAllGames().size();
        int expected = initialSize;
        assertEquals(expected, result);

        try {
            gameDao.getGameById(newGame.getGameId());
        } catch (EmptyResultDataAccessException e) {
            assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
        }

    }

}
