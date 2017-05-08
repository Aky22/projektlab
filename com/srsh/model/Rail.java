package com.srsh.model;

/**
 * Sínt megvalósító osztály
 */
public class Rail extends Component {

    /**
     * Konstruktor világ koordinátákkal, modell id-vel
     * @param x_0 A x koord.
     * @param y_0 A y koord.
     * @param x_1 B x koord.
     * @param y_1 B y koord.
     * @param id modell id
     */
    public Rail(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created com.srsh.model.Rail with id: ");
    }


    /**
     * Nem végez módosítást a mozdonyon csak elhelyezi a saját kollekciójában
     * amikor rálépnek
     * @param l mozdony ami rálépett
     * @param startSide kezdőoldala
     */
    @Override
    public void operateOn(Locomotive l, char startSide) {
        tcCollection.insert(l, startSide,0); //behelyezzük a kollekcióba
    }

    /**
     * Elhelyezi a mozdonyt saját magán megadott eltolással és oldallal
     * @param side belépési odlal
     * @param locomotive mozdony
     * @param offset eltolás
     */
    public void placeLocomotive(char side, Locomotive locomotive, int offset){
        tcCollection.insert(locomotive, side,offset);
    }

    /**
     * Státuszt írja ki standard outputra
     */
    @Override
    public void list(){
        System.out.println("com.srsh.model.Rail " + id + " at " + x0 + ", " + y0 + " to " + x1 + ", " + y1 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }

    /**
     * Nem pontszerű
     * @return false
     */
    @Override
    public boolean isPoint() {
        return false;
    }
}