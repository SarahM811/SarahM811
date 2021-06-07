/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber.data;

import com.gen10.guessthenumber.models.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
@Profile("database")
public class GameDBDao implements GameDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDBDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game addGame(Game game) {

        final String sql = "INSERT INTO game(answer, InProgress) VALUES(?,?);";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, game.getAnswer());
            statement.setBoolean(2, game.isInProgress());
            return statement;

        }, keyHolder);

        game.setGameId(keyHolder.getKey().intValue());

        return game;

    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "SELECT gameId, answer, inProgress FROM Game;";
        List<Game> test = jdbcTemplate.query(sql, new GameMapper());
        return test;
       // return jdbcTemplate.query(sql, new GameMapper());

    }

    @Override
    public Game getGameById(int gameId) {
        final String sql = "SELECT gameid, answer, InProgress "
                + "FROM Game WHERE gameId = ?;";

        return jdbcTemplate.queryForObject(sql, new GameMapper(), gameId);

    }

    @Override
    public boolean updateStatus(Game game) {
        final String sql = "UPDATE game SET "
                + "inProgress = ? "
                + "WHERE gameId = ?;";

        return jdbcTemplate.update(sql,
                game.isInProgress(),
                game.getGameId()) > 0;
    }

    @Override
    public void deleteGameById(int gameId) {
         final String sql = "DELETE FROM game WHERE gameId = ?;";
         jdbcTemplate.update(sql, gameId);
    }

   

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameId(rs.getInt("GameId"));
            game.setAnswer(rs.getString("answer"));
            game.setInProgress(rs.getBoolean("InProgress"));

            return game;
        }
    }
}
