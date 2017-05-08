package com.srsh.model;

/**
 * Vakvágányt megvalósító osztály
 */
public class Siding extends Component {
    /**
     * Konstruktor
     * @param x_0 A x koord
     * @param y_0 A y koord
     * @param x_1 B x koord
     * @param y_1 B y koord
     * @param id modell id
     */
    public Siding(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created com.srsh.model.Siding with id: ");
    }

    /**
     * Rálépő mozdonyt kisiklatja
     * @param l mozdony ami rálépett
     * @param side belépési oldal
     */
    @Override
    public void operateOn(Locomotive l, char side) { //kész
        tcCollection.insert(l, side,0); //behelyezzük a kollekcióba
        l.derail();
    }

    /**
     * Visszatér a következő pályaelemmel, de ideáig nem jut el
     * @param previous vonatelem korábbi pályaeleme
     * @param tc vonatelem
     * @return
     */
    @Override
    public Component getNext(Component previous, TrainComponent tc) {
        //teljesen mindegy idáig úgyse jut el
        return null;
    }

    /**
     * Státusz kiírás standard outputra
     */
    @Override
    public void list(){
        System.out.println("com.srsh.model.Siding " + id + " at " + x0 + ", " + y0 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
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