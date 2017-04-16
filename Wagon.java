
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Wagon extends TrainComponent {
    Color color;
    int passengerNumber;

    public Wagon(Color c, int i){
        color =  c;
        passengerNumber = i;
    }

    /**
     * Állomásra érve hívódik meg.
     * @param c Az állomás színe
     * @return - Leszállt utasok száma
     */
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(color == c){
            //utasok leszállása:
            ret = passengerNumber; //mivel kikötöttük hogy mindenki leszáll

            //utasok felszállása (mindenki felszáll):
            this.passengerNumber = passengerNumber;

            //mivel ekkor ez már "üres":
            if(next != null){
                ret += next.atStation(c, 0); //következőre már nem száll fel ezért senki
            }

            return ret; //visszatérünk a leszállt utasok számával
        }
        return ret; //ha nem egyezik a szín felesleges tovább hívni...
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
    }


    @Override
    public void place(Component current) {

    }
}