/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.guessthenumber;

import com.gen10.guessthenumber.controller.GuessGameController;
import com.gen10.guessthenumber.data.GameDao;
import com.gen10.guessthenumber.data.GameInMemoryDao;
import com.gen10.guessthenumber.data.RoundDao;
import com.gen10.guessthenumber.data.RoundInMemoryDao;
import com.gen10.guessthenumber.service.GuessGameService;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author sakim
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
