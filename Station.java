
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



    public Station(double x0, double y0, double x1, double y1, Color color, int pNumber, int id){
        super(x0, y0, y1, x1, id);
        c = color;
        passengerNumber = pNumber;
        System.out.print("created Station with id: ");
    }

    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l) {
        tcCollection.insert(l); //behelyezzük a kollekcióba
        l.atStation(c,passengerNumber); //értesítjük a mozdonyt hogy állomásra ért //felszállók száma kell
    }

    @Override
    public void list(){
        System.out.println("Station " + id + " at " + x0 + ", " + y0 + " with " + passengerNumber +
                " passengers and " + c.toString() + " color\n"+
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}