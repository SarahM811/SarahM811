/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

import com.gen10.guessthenumber.models.Round;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
@Profile("memory")
public class RoundInMemoryDao implements RoundDao {

    private static List<Round> rounds = new ArrayList<>();
    Map<Integer, String> roundGuess = new HashMap<>();
    
    @Override
    public Round addRound(Round round) {
        int nextId = roundGuess.keySet()
                .stream()
                .mapToInt(i -> i)
                .max()
                .orElse(0) + 1;

        round.setRoundId(nextId);
        
        rounds.add(round);
        return round;
    }

//    @Override
//    public List<Round> getAllRounds() {
//        return new ArrayList<>(rounds);
//    }
//
//    @Override
//    public Round getRoundById(int roundId) {
//        return rounds.stream()
//                .filter(i -> i.getRoundId() == roundId)
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public String addGuess(Round round, String guess) {
//        int nextId = roundGuess.keySet()
//                .stream()
//                .mapToInt(i -> i)
//                .max()
//                .orElse(0) + 1;
//
//        round.setRoundId(nextId);
//        roundGuess.put(nextId, guess);
//        return guess;
//    }
//
//    @Override
//    public List<String> getAllGuesses() {
//        return roundGuess.values()
//                .stream()
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getGuess(Round round) {
//       return roundGuess.get(round.getRoundId());
//    }

    @Override
    public List<Round> getAllRoundsByGameId(int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoundsByGameId(int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
