package com.srsh.model;

import java.awt.*;

/**
 * Mozdonyt megvalósító osztály
 */
public class Locomotive extends TrainComponent {
    /**
     * Modell-t összefogó osztály, hogy jelezhesse a kisiklást, ütközést
     */
    private  Game game;

    /**
     * Konstruktor
     * @param id modell id
     * @param game modell
     */
    public Locomotive(int id, Game game){
        super(id);
        this.game = game;
        System.out.print("created com.srsh.model.Locomotive with id: ");
    }

    /**
     * Állomásra éréskor hívódik meg, mögötte lévő kocsi
     * azonos metódusát hívja meg
     * @param c - Állomás színe
     * @param passengerNumber - Állomáson lévő utasok száma
     * @return leszállók száma
     */
    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(next != null) {
            ret += next.atStation(c, passengerNumber); //leszállók száma
        }//
        return ret;
    }

    /**
     * Kisikláskor hívódik meg
     */
    @Override
    public void derail(){
        super.derail();
        game.trainDerailed(this);
    }

    /**
     * Ütközéskor hívódik meg
     */
    @Override
    public void collision(){
        super.collision();
        game.trainCollided(this);
    }

    /**
     * Léptetés
     */
    @Override
    public void step() {
        Collection collection = current.getCollection();

        //ellenőrzi, hogy a végén van-e
        boolean atEnd = collection.myComponentAtEnd(this);
        //ha igen
        if(atEnd){
            //lekéri a következő pályaelemet
            previousComponent = current;
            Component next = current.getNext(previousComponent, this);
            if(!derailed) {

                //beállítja az aktuálisat és az előzőt
                current = next;

                //előző komponensünk megegyezik a jelenlegi A/B/C/D oldallal akkor a
                //jelenlegi komponensünk azon oldalára kell lehelyezni a vonatelemet
                if (previousComponent == current.getNextSide('A'))
                    current.operateOn(this, 'A');
                else if (previousComponent == current.getNextSide('B'))
                    current.operateOn(this, 'B');
                else if (previousComponent == current.getNextSide('C'))
                    current.operateOn(this, 'C');
                else if (previousComponent == current.getNextSide('D'))
                    current.operateOn(this, 'D');
            }
        }

//        System.out.println("stepped " + id + " new position " + current._getId() + " " + current.getCollection()._getMyPosition(this));

        //következőt lépteti ha van
        if(next != null)
            next.step();

    }

    /**
     * Pálya felépítése után meghívódó inicializáló függvény
     * Paraméterként kapott sín megfelelő oldalára, megfelelő eltolással
     * helyezi el a mozdonyt, ill. meghívja az őt követő kocsi
     * azonos metódusát
     * @param current sín amire el kell helyezni
     * @param side oldal
     * @param offset eltolás
     */
    @Override
    public void place(Component current, char side, int offset) {
        this.current = current;

        int l = 0;
        //vonat hosszát meg határozza
        if(next != null){
            l =  countLength(0);
        }
        Rail rail = (Rail)this.current;
        rail.placeLocomotive(side, this, (l-1)*40);

        if(next != null){
            next.place(current, side, (l-2) * 40);
        }
    }


    /**
     * Státuszt ír standard outputra
     */
    @Override
    public void list(){
        System.out.println("com.srsh.model.Locomotive "+ this.id +" on "+ this.current.id +  " at " + current.getCollection()._getMyPosition(this) +
                " next: "+nextId+";\ncollided "+ this.collided +"; destroyed "+this.destroyed+"; derailed "+derailed);
    }
}