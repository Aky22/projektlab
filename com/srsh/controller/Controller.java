package com.srsh.controller;

import com.srsh.model.Game;
import com.srsh.view.View;

/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public class Controller {
    private View view;
    private Game game;

    public Controller(){
        view = new View();
        game = new Game();
    }


    public void loadMap(String file){
        view.clear();
        game.clear();
        //TODO
        System.out.println("selected" + file);
    }

    public void run(){
        //TODO
    }
}
