package com.srsh.model;

import java.awt.*;

/**
 * Állomást reprezentáló osztály
 */
public class Station extends Component {

    /**
     * Állomás színe
     */
    private Color c;

    /**
     * Utasok száma az állomáson
     */
    private int passengerNumber;


    /**
     * Konstruktor világ koord.al ill. színnel, utasszámmal, modell id-vel
     * @param x0 A x koord
     * @param y0 A y koord
     * @param x1 B x koord
     * @param y1 B y koord
     * @param color szín
     * @param pNumber utasszám
     * @param id modell id
     */
    public Station(double x0, double y0, double x1, double y1, Color color, int pNumber, int id){
        super(x0, y0, x1, y1, id);
        c = color;
        passengerNumber = pNumber;
        System.out.print("created com.srsh.model.Station with id: " + x0 + " " + y0 + " "  +
        x1 + " " + y1);
    }

    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l, char side) {
        tcCollection.insert(l, side,0); //behelyezzük a kollekcióba
        passengerNumber -= l.atStation(c,passengerNumber); //értesítjük a mozdonyt hogy állomásra ért //felszállók száma kell
    }

    /**
     * Standard output-ra státusz kiírás
     */
    @Override
    public void list(){
        System.out.println("com.srsh.model.Station " + id + " at " + x0 + ", " + y0 + " with " + passengerNumber +
                " passengers and " + c.toString() + " color\n"+
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }

    /**
     * Megadja hogy pontszerű-e (override)
     * @return
     */
    @Override
    public boolean isPoint() {
        return true;
    }

    /**
     * Visszaadja az állomás színét
     * @return
     */
    public Color getColor(){
        return c;
    }

    /**
     * Visszatér az utasok számával
     * @return
     */
    public int getPassengerNumber(){
        return passengerNumber;
    }
}