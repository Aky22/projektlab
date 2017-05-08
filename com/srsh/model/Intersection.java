package com.srsh.model;

/**
 * Kereszteződés megvalósító osztály
 * Created by Andras on 2017.04.15..
 */
public class Intersection extends Component{
    /**
     * Konstruktor világ koordinátákkal, modell id-vel
     * @param x_0 A vég x koord
     * @param y_0 A vég y koord
     * @param x_1 B vég x koord
     * @param y_1 B vég y koord
     * @param id modell id
     */
    public Intersection(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created com.srsh.model.Intersection with id: ");
    }

    /**
     * Behelyezi a rálépett mozdonyt a kollekcióba
     * @param l mozdony ami rálépett
     * @param side belépési oldal
     */
    @Override
    public void operateOn(Locomotive l, char side) { //kész
        tcCollection.insert(l, side,0); //behelyezzük a kollekcióba
    }

    /**
     * Kiírja az adatait standard outputra
     */
    @Override
    public void list(){
        System.out.println("com.srsh.model.Intersection " + id + " at " + x0 + ", " + y0 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id + "\n" +
                "C side connected to " + C_id + "\n" +
                "D side connected to " + D_id);
    }

    /**
     * Megadja, hogy pontszerű
     * @return true
     */
    @Override
    public boolean isPoint() {
        return true;
    }
}
