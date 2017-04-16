
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Station extends Component {

    /**
     * Állomás színe
     */
    private Color c;

    /**
     * Utasok száma az állomáson
     */
    private int passengerNumber;



    public Station(double x0, double y0, double x1, double y1, Color color, int pNumber){
        super(x0, y0, y1, x1);
        c = color;
        passengerNumber = pNumber;
    }

    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l) {
        tcCollection.insert(l); //behelyezzük a kollekcióba
        l.atStation(c,passengerNumber); //értesítjük a mozdonyt hogy állomásra ért //felszállók száma kell
    }
}