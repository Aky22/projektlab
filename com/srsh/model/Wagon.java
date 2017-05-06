package com.srsh.model;

import java.awt.*;

/**
 * 
 */
public class Wagon extends TrainComponent {
    Color color;
    int passengerNumber;
    Point pos;

    /**
     * @param c
     * @param i
     * @param id
     */
    public Wagon(Color c, int i, int id) {
        super(id);
        color = c;
        passengerNumber = i;
        System.out.print("created com.srsh.model.Wagon with id: ");
    }

    /**
     * Állomásra érve hívódik meg.
     *
     * @param c Az állomás színe
     * @return - Leszállt utasok száma
     */
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if (color == c) {
            //ez a különbség
            ret = passengerNumber - this.passengerNumber;

            //utasok felszállása (mindenki felszáll):
            this.passengerNumber = passengerNumber;

            //mivel ekkor ez már "üres":
            if (next != null) {
                ret += next.atStation(c, 0); //következőre már nem száll fel ezért senki
            }

            return ret; //visszatérünk a leszállt utasok számával
        }
        return ret; //ha nem egyezik a szín felesleges tovább hívni...
    }

    /**
     * Vagon léptetési metódusa.
     */
    @Override
    public void step() {
        Collection collection = current.getCollection();

        //ellenőrzi, hogy a végén van-e
        boolean atEnd = collection.myComponentAtEnd(this);

        //ha igen
        if (atEnd) {
            //lekéri a következő pályaelemet
            previousComponent = current;
            Component next = current.getNext(previousComponent, this);

            //beállítja az aktuálisat és az előzőt
            current = next;

            //vagon behelyezés
            if (previousComponent == current.getNextSide('A'))   //előző komponensünk megegyezik a jelenlegi A/B/C/D oldallal akkor a jelenlegi komponensünk azon oldalára kell lehelyezni a vonatelemet
                current.insert(this, 'A',0);
            else if (previousComponent == current.getNextSide('B'))
                current.insert(this, 'B',0);
            else if (previousComponent == current.getNextSide('C'))
                current.insert(this, 'C',0);
            else if (previousComponent == current.getNextSide('D'))
                current.insert(this, 'D',0);

        }
        System.out.println("which moved " + id + " new position " + current._getId() + " " + current.getCollection()._getMyPosition(this));

        //következőt lépteti ha van
        if (next != null)
            next.step();


    }


    @Override
    public void place(Component current, char side, int offset) {
        this.current = current;
        this.current.insert(this, side, offset);
        if(next != null){
            next.place(current, side, offset + 40);
        }
    }

    @Override
    public void list() {
        System.out.println("com.srsh.model.Wagon " + this.id + " on " + this.current.id + " at " + current.getCollection()._getMyPosition(this) +
                " next: " + nextId  + ", previous " + previousId+ ";\ncollided " + this.collided + "; destroyed " + this.destroyed + "; derailed " + derailed +
                "\npassenger number: " + passengerNumber + ", color: " + color);
    }

    //Getter a szin visszaadasahoz
    public Color getColor(){return color;}



}