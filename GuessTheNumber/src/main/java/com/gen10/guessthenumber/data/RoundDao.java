/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

import com.gen10.guessthenumber.models.Round;
import java.util.List;

/**
 *
 * @author sakim
 */
public interface RoundDao {

    Round addRound(Round round);

    List<Round> getAllRoundsByGameId(int gameId);
    
    void deleteRoundsByGameId(int gameId);

}
