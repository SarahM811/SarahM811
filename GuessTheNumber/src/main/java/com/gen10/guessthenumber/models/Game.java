/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author sakim
 */
public class Game {

    private int gameId;
    private boolean InProgress;
    private String answer;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.gameId;
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
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return true;
    }



    Random random = new Random();

    public Game() {
        this.answer = generateAnswer();
        this.InProgress = true;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public boolean isInProgress() {
        return InProgress;
    }

    public void setInProgress(boolean InProgress) {
        this.InProgress = InProgress;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String generateAnswer() {
        Set<Integer> set = new HashSet<Integer>();

        while (set.size() < 4) {
            set.add(random.nextInt(9) + 1);
        }

        String numStr = "";
        for (Integer n : set) {
            numStr += n;
        }
        int num = Integer.parseInt(numStr);
        return numStr;
    }
}
