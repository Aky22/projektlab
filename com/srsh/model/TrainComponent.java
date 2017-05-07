package com.srsh.model;

import java.awt.*;

/**
 * 
 */
public abstract class TrainComponent {

    public TrainComponent previous = null;
    public TrainComponent next = null;
    public Component current = null;
    protected Component previousComponent = null;
    public boolean destroyed = false;
    public boolean derailed = false;
    public boolean collided = false;
    public boolean inTunnel = false;
    public int id = 0;
    protected int nextId = 0;
    protected int previousId = 0;

    /**
     *
     * @param id
     */
    public TrainComponent(int id){
        this.id = id;
    }

    /**
     * Kisiklatás - derailed flaget a teljes vonaton beállítja
     */
    public void derail(){
        derailed = true;
        destroyed = true;
        if(next != null){ //következő kisiklatása ha nem null, és nem siklott ki
            if(next.isDerailed()){}
            else {
                next.derail();
            }
        }
        if(previous != null){//előző kisiklatása ha nem null, és nem siklott ki
            if(previous.isDerailed()){}
            else {
                previous.derail();
            }
        }
    }

    public void collision(){
        collided = true;
        destroyed = true;
        if(next != null)
            next.collision();
    }


    /**
     * Állomásra érés absztrakt metódusa - állomás hívja
     * @param c - Állomás színe
     * @param passengerNumber - Állomáson lévő utasok száma
     * @return - Leszállt utasok száma
     */
    abstract public int atStation(Color c, int passengerNumber);

    /**
     * Léptetés, adott elemet megelőző elem hívja (vagy mozdonyét a com.srsh.model.Game)
     */
    abstract public void step();

    /**
     * Vonat összekapcsolásáért felelős
     * @param side - Melyik oldalára P - előző; N következő
     * @param tc - A hozzákapcsolandó elem
     */
    public void connect(char side, TrainComponent tc, int otherId){
        switch(side){
            case 'P':
                previous = tc;
                previousId = otherId;
                break;
            case 'N':
                next = tc;
                nextId = otherId;
                break;
        }
    }

    /**
     * Init során elhelyezi az elemet az adott pályaelemen
     * @param current
     */
    abstract public void place(Component current, char side, int offset);

    /**
     * Megadja, hogy az adott elem kisiklott-e
     * @return - Kisiklott-e
     */
    public boolean isDerailed(){
        return derailed;
    }


    /**
     * Státusz lekérdezésre szolgál list parancs kiadása esetén
     */
    abstract public void list();

    public void setInTunnel(){
        inTunnel = !inTunnel;
    }

    protected int countLength(int n){
        if(next != null)
            return next.countLength(n + 1);
        return n + 1;
    }

    public int getAllPassengerNumber(){
        if(next != null)
            return next.getAllPassengerNumber();
        return 0;
    }
}