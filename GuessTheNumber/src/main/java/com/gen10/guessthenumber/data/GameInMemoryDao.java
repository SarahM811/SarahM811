/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

import com.gen10.guessthenumber.models.Game;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
@Profile("memory")
public class GameInMemoryDao implements GameDao {

    List<Game> allGames = new ArrayList<>();

    @Override
    public Game addGame(Game game) {
        int nextId = allGames.stream()
                .mapToInt(i -> i.getGameId())
                .max()
                .orElse(0) + 1;

        game.setGameId(nextId);
        allGames.add(game);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(allGames);
    }

    @Override
    public Game getGameById(int gameId) {
        return allGames.stream()
                .filter(i -> i.getGameId() == gameId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateStatus(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGameById(int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
