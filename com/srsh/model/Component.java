package com.srsh.model;

import java.awt.*;

/**
 * Pályát alkotó elemek absztrakt ősosztálya
 */
public abstract class Component {

    /**
     * Rajta lévő vonatelemek kollekciója
     */
    protected Collection tcCollection;

    /**
     * A vége
     */
    protected Component A_End = null;

    /**
     * B vége
     */
    protected Component B_End = null;

    /**
     * C vége - csak váltónál és kereszteződésnél értelmezett
     */
    protected Component C_End = null;

    /**
     * D vége - csak kereszteződésnél értelmezett
     */
    protected Component D_End = null;

    /**
     * Hossz
     */
    protected double lenght;

    /**
     * Végpontok világ koordinátarendszerben
     */
    protected double x0, y0, x1, y1;

    /**
     * Model-beli azonosítószám
     */
    protected int id = 0;

    /**
     * A vég modellbeli id-je
     */
    protected int A_id = 0;

    /**
     * B vég id-je modellben
     */
    protected int B_id = 0;

    /**
     * C vég id-je modellben
     */
    protected int C_id = 0;

    /**
     * D véd id-je modellben
     */
    protected int D_id = 0;

    /**
     * Konstuktor
     * @param id modell id
     */
    public Component(int id){
        x0 = 0;
        y0 = 0;
        x1 = 0;
        y1 = 0;
        lenght = 0;
        this.id = id;
    }

    /**
     * Konstruktor világkoordináta pozíciókkal
     * @param x_0 A vég x koord.
     * @param y_0 A vég y koord.
     * @param x_1 B vég x koord.
     * @param y_1 B vég y koord.
     * @param id modell id
     */
    public Component(double x_0, double y_0, double x_1, double y_1, int id){
        tcCollection = new Collection();
        x0 = x_0;
        y0 = y_0;
        x1 = x_1;
        y1 = y_1;
        if(x0 == x1 && y0 == y1)
            lenght = 0;
        else lenght = Math.sqrt(Math.pow(x_0 - x_1, 2) + Math.pow(y_0 - y_1, 2));
        this.id = id;
    }

    /**
     * Új sínelemre lépéskor hívódik meg
     * Leszármazott osztálynak megfelelően
     * @param l mozdony ami rálépett
     * @param startSide kezdőoldala
     */
    abstract public void operateOn(Locomotive l, char startSide);

    /**
     * Visszaadja a kollekciót
     * @return
     */
    public Collection getCollection(){
        return tcCollection;
    }

    /**
     * Visszaadja a paraméterként kapott vonatelemnek a következő
     * pályaelemet
     * @param previous vonatelem korábbi pályaeleme
     * @param tc vonatelem
     * @return következő pályaelem
     */
    public Component getNext(Component previous, TrainComponent tc){        // átlépteti a következő elemre a paraméterként kapott komponenst
        //asszem ki is kell szedni kollekcióból - D.
        switch(tcCollection.getEntrySideOf(tc)){
            case 'A':
                tcCollection.remove(tc);
                return B_End;
            case 'B':
                tcCollection.remove(tc);
                return A_End;
            case 'C':
                tcCollection.remove(tc);
                return D_End;
            case 'D':
                tcCollection.remove(tc);
                return C_End;
        }
        return null;
    }

    /**
     * Paraméterrel ellentétes oldalt adja vissza
     * @param side
     * @return
     */
    public Component getNextSide(char side){

        switch (side){
            case 'A':
                return A_End;
            case 'B':
                return B_End;
            case 'C':
                return C_End;
            case 'D':
                return D_End;
            default:
                return null;
        }
    }

    /**
     * Behelyezi a tc-t a kollekcióba megfelelő eltolással
     * és kezdőoldallal
     * @param tc berakni kívánt elem
     * @param startSide kezdőoldala
     * @param offset eltolás
     */
    public void insert(TrainComponent tc, char startSide, int offset){      //vagont helyez be
        tcCollection.insert(tc, startSide, offset);
    }


    /**
     * Beállítja az adott elem adott végét
     * @param side - Az az oldal ahova csatlakozik a másik elem
     * @param end - Ehhez az elemhez kapcsolódó másik elem
     */
    public void setEnd(char side, Component end, int otherId){
        switch (side){
            case 'A':
                A_End = end;
                A_id = otherId;
                break;
            case 'B':
                B_End = end;
                B_id = otherId;
                break;
            case 'C':
                C_End = end;
                C_id = otherId;
                break;
            case 'D':
                D_End = end;
                D_id = otherId;
                break;
        }
    }

    /**
     * Státusz lekérdezésre szolgál list parancs kiadása esetén
     */
    abstract public void list();

    public int _getId(){
        return id;
    }

    /**
     * Megadja, hogy pontszerű-e
     * @return
     */
    abstract public boolean isPoint();

    /**
     * Ha pontszerű, visszaadja a pontot
     * @return
     */
    public Point getPoint(){
        return new Point((int)x0, (int)y0);
    }

    /**
     * Ha nem pontszerű az A vég
     * @return
     */
    public Point getAEnd(){
        return getPoint();
    }

    /**
     * Ha nem pontszerű a B vég
     * @return
     */
    public Point getBEnd(){
        return new Point((int)x1,(int)y1);
    }

    public void click(Game game){

    }
}