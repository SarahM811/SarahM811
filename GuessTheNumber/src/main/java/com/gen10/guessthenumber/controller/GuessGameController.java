/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.controller;

import com.gen10.guessthenumber.data.GameDao;
import com.gen10.guessthenumber.data.RoundDao;
import com.gen10.guessthenumber.models.Game;
import com.gen10.guessthenumber.models.Round;
import com.gen10.guessthenumber.service.GuessGameService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sakim
 */

@RestController
@RequestMapping("/GuessGame")
public class GuessGameController {

    @Autowired
    GuessGameService service;
    
    public GuessGameController(GuessGameService service) {
        this.service = service;
    }

    @GetMapping("/game")
    public List<Game> all() {
        return service.getAllGames();
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int beginGame() {
       // Game game = new Game();
       // service.addGame(game);
       Game game = service.addGame();
        return game.getGameId();
    }

//    @PostMapping("/guess/{gameId}")
//    public Round playGame(@PathVariable int gameId, @RequestBody Round round) throws UnsupportedEncodingException {
//
//        return service.makeGuess(gameId, round);
//
//    }
    @PostMapping("/guess")
    public Round playGame(@RequestBody Round round) throws UnsupportedEncodingException {

        return service.makeGuess(round);

    }
  
    
//    @GetMapping("/{gameId}")
//    public Game getGame(@PathVariable int gameId) {
//        return service.getGameById(gameId);
//    }
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable int gameId) {
        Game result = service.getGameById(gameId);
        if (result == null) {
            return new ResponseEntity (null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/rounds/{gameId}")
    public List<Round> getRoundsForGame(@PathVariable int gameId) {
        return service.getAllRoundsByGameId(gameId);
    }

}
