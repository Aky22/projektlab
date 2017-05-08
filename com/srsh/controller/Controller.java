package com.srsh.controller;

import com.srsh.model.Game;
import com.srsh.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Model-t és View-t vezérlő osztály
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public class Controller {
    /**
     * Játék megjelenítéséért felelős
     */
    private View view;

    /**
     * Modell
     */
    private Game game;

    /**
     * Pálya befejezését jelző flag
     */
    private boolean gameOver = false;

    /**
     * Futó játékot jelző flag
     */
    private boolean inGame = false;

    /**
     * Default konstruktor, egy új modellt és view-t hoz létre
     */
    public Controller(){
        view = new View(this);
        game = new Game(view, this);
    }


    /**
     * Paraméterként kapott dokumentumban található parancsokkal meghívja
     * a Game megfelelő metódusát, ezzel betöltve a pályát.
     * @param file pályát tartalmazó fájl
     */
    public void loadMap(String file){
        game.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resources/" + file + ".txt"))) {
            String line;
            while((line = br.readLine()) != null){
                game.giveCommand(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        }
        gameOver = false;
    }

    /**
     * Új szálat indít ami a vonatok mozgatásáért felelős
     */
    public void run(){
        view.setVisible(true);
        inGame = true;
        new Thread(){
            @Override
            public void run(){
                while(!gameOver) {
                    try {
                        Thread.sleep(1000/100);
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

    /**
     * Kattintást kezelő függvény, amit a View hív
     * @param x kattintás x koordinátája
     * @param y kattintás y koordinátája
     */
    public void handleClick(int x, int y){
        game.handleClick(x, y);
    }

    /**
     * Játék végét jelző metódus
     * View megfelelő metódusát hívja a paraméterként kapott
     * szöveggel, valamint bebillenti a megfelelő flag-et
     * @param message Megjelenő üzenetablak szövege
     */
    public void gameOver(String message){
        gameOver = true;
        view.gameOverDialog(message);
    }

    /**
     * Beállítja, hogy fut-e éppen egy játék
     * @param value
     */
    public void setInGame(boolean value){
        inGame = value;
    }

    /**
     * Megadja, hogy fut-e éppen egy játék
     * @return
     */
    public boolean gameInProgress(){
        return inGame;
    }

    /**
     * Megadja, hogy vége van-e a pályának
     * @return
     */
    public boolean isGameOver(){
        return gameOver;
    }
}