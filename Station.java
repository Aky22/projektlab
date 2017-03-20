
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Station extends Component {

    private Color c;


    /**
     * Eltároljuk a mozdonyt és értesítjük hogy állomásra ért.
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[Locomotive].operateOn(l: Locomotive)");
        tcCollection.insert(l); //behelyezzük a kollekcióba
        l.atStation(c); //értesítjük a mozdonyt hogy állomásra ért
    }

}