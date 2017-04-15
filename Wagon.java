
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Wagon implements TrainComponent {

    private Color color;
    private int passengerNumber;

    /**
     *
     */
    private TrainComponent next = null;

    /**
     *
     */
    private TrainComponent previous = null;

    /**
     * Default constructor
     */
    public Wagon() {
    }

    public Wagon(Color c, int i){
        color =  c;
        passengerNumber = i;
    }

    /**
     * Állomásra érve hívódik meg.
     * @param c Az állomás színe
     * @return
     */
    public void atStation(Color c, int passengerNumber) {
        System.out.println("[Wagon].atStation(c: Color)");
        if(color == c){
            getOff(passengerNumber);    //ez így elég fura és kéne ellenőrizni az elötte lévő wagonokon van-e még utas
        }
        if(next != null){ //ha van mögötte lévő kocsi akkor értesítjük hogy állomáson vagyunk
            //üresség vizsgálata itt még nem jelenik meg.
            next.atStation(c, passengerNumber);
        }
    }

    /**
     * Vagon léptetési metódusa.
     * @param c  - őt hívó komponens
     * @return
     */
    @Override
    public void step() {
        System.out.println("[Locomotive].step()");
        // TODO implement here
        //return null;
    }

    @Override
    public void connect(char side, TrainComponent tc) {

    }

    @Override
    public void place(Component current) {

    }

    /**
     * Kisiklatja a kocsit
     * @return
     */
    public void derail() {
        System.out.println("[Wagon].derail()");
        if(next != null){ //ha van mögette lévő kocsi kisiklatjuk
            next.derail();
        }
    }



    /**
     * A kocsit követő elem beállítására szolgál.
     * @param tc - A következő elem a vonatban
     */
    public void setNext(TrainComponent tc){
        next = tc;
    }

    /**
     * A kocsit megelőző elem beállítására szolgál
     * @param tc
     */
    public void setPrevious(TrainComponent tc){
        previous = tc;
    }

    private void getOn(int n){
        passengerNumber += n;
    }

    private void getOff(int n){
        passengerNumber -= n;
    }

}