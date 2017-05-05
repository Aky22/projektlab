package com.srsh.model;

import java.awt.*;

/**
 * 
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
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param color
     * @param pNumber
     * @param id
     */
    public Station(double x0, double y0, double x1, double y1, Color color, int pNumber, int id){
        super(x0, y0, y1, x1, id);
        c = color;
        passengerNumber = pNumber;
        System.out.print("created com.srsh.model.Station with id: ");
    }

    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l, char side) {
        tcCollection.insert(l, side); //behelyezzük a kollekcióba
        passengerNumber -= l.atStation(c,passengerNumber); //értesítjük a mozdonyt hogy állomásra ért //felszállók száma kell
    }

    @Override
    public void list(){
        System.out.println("com.srsh.model.Station " + id + " at " + x0 + ", " + y0 + " with " + passengerNumber +
                " passengers and " + c.toString() + " color\n"+
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}