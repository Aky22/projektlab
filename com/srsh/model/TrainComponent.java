package com.srsh.model;

import java.awt.*;

/**
 * Vonatot alkotó elemek absztrakt ősosztálya
 */
public abstract class TrainComponent {
    /**
     * Előző vonatelem
     */
    public TrainComponent previous = null;

    /**
     * Következő vonatelem
     */
    public TrainComponent next = null;

    /**
     * Az a pályát alkotó elem amin épp rajta van
     */
    public Component current = null;

    /**+
     * Az a pályát alkotó elem amin ezt megelőzően volt
     */
    protected Component previousComponent = null;

    /**
     * Megsemmisülést jelző flag
     */
    public boolean destroyed = false;

    /**
     * Kisiklást jelző flag
     */
    public boolean derailed = false;

    /**
     * Ütközést jelző flag
     */
    public boolean collided = false;

    /**
     * Azt jelzi hogy alagútban van-e
     */
    public boolean inTunnel = false;

    /**
     * modell id
     */
    public int id = 0;

    /**
     * következő kocsi id-je
     */
    protected int nextId = 0;

    /**
     * előző kocsi id-je
     */
    protected int previousId = 0;

    /**
     * Konstruktor
     * @param id modell id
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

    /**
     * Ütközést jelző metódus
     */
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

    /**
     * Beállítja az inTunnel flag-et
     */
    public void setInTunnel(){
        inTunnel = !inTunnel;
    }

    /**
     * Megadja a mögötte lévő kocsik számát
     * @param n előtte lévő kocsik száma
     * @return kocsik száma
     */
    protected int countLength(int n){
        if(next != null)
            return next.countLength(n + 1);
        return n + 1;
    }

    /**
     * Megadja a mögötte lévő összes utas számát
     * @return utasok száma
     */
    public int getAllPassengerNumber(){
        if(next != null)
            return next.getAllPassengerNumber();
        return 0;
    }
}