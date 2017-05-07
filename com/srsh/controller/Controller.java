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
    private boolean gameOver = false;

    public Controller(){
        view = new View(this);
        game = new Game(view, this);
    }


    public void loadMap(String file){
        view.clear();
        game.clear();

        try(BufferedReader br = new BufferedReader(new FileReader("resources/" + file + ".txt"))) {
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
        view.setVisible(true);
        new Thread(){
            @Override
            public void run(){
                while(!gameOver) {
                    try {
                        Thread.sleep(1000/60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    view.invalidate();
                    game.giveCommand("step");
                    if(game.allTrainsAreEmpty()){
                        gameOver("Map completed!");
                    }
                }
            }
        }.start();
    }

    public void handleClick(int x, int y){
        game.handleClick(x, y);
    }

    public void gameOver(String message){
        gameOver = true;
        view.gameOverDialog(message);
    }
}