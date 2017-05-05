package com.srsh.controller;

import com.srsh.model.Game;
import com.srsh.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public class Controller {
    private View view;
    private Game game;

    public Controller(){
        view = new View();
        game = new Game(view);
    }


    public void loadMap(String file){
        view.clear();
        game.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(file + ".txt"))) {
            String line;
            while((line = br.readLine()) != null){
                game.giveCommand(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        //TODO
        view.setVisible(true);
    }
}
