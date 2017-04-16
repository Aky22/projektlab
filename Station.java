
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
        super(x0, y0, y1, x1, 0);
        c = color;
        passengerNumber = pNumber;
    }

    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l) {
        //System.out.println("[Locomotive].operateOn(l: Locomotive)");
        tcCollection.insert(l); //behelyezzük a kollekcióba
        l.atStation(c,passengerNumber); //értesítjük a mozdonyt hogy állomásra ért //felszállók száma kell
    }

    /**
     * Visszaadja a vonatelemeket tartalmazó kollekciót
     * @return A vonatelemeket tartalmazó kollekció
     */
    public Collection getCollection() {
        System.out.println("[Locomotive].getCollection()");
        return tcCollection;
    }

    /**
     * Visszaadja a következő pályaelemet attól függően hogy honnan jött a mozdony
     * @param previous - Az a pályakomponens ahonnan ide került
     * @param tc - A vonatelem ami a függvényt hívja
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        System.out.println("[Locomotive].getNext(Component previous, TrainComponent tc)");
        return null; //nem vizsgáljuk részletesen, majd később
    }

    /**
     * Behelyez egy vonatelemet a kollekcióba (csak vagont!)
     * @param tc - a vagon
     */
    public void insert(TrainComponent tc) {
        System.out.println("[Locomotive].insert(tc: TrainComponent)");
        tcCollection.insert(tc);
    }
}