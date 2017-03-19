
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Locomotive implements TrainComponent {

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
    public Locomotive() {
    }

    /**
     * @param c 
     * @return
     */
    public void atStation(Color c) {
        System.out.println("[Locomotive].atStation(c: Color)");
        next.atStation(c); //mivel minimum 1 kocsi van mögötte, ezért feltétel nélkül hívjuk
    }

    /**
     * @return
     */
    public void step() {
        System.out.println("[Locomotive].step()");
        //TODO: teljes függvény
        //return null;
    }

    /**
     * @return
     */
    public void inTunnel() {
        System.out.println("[Locomotive].inTunnel()");
    }

    /**
     * @return
     */
    public void destroy() {
        System.out.println("[Locomotive].destroy()");
        //return null;
    }

    /**
     * @return
     */
    public void derail() {
        System.out.println("[Locomotive].derail()");
        next.derail(); //kisiklatjuk a mögötte lévőt is, mivel minimum 1 kocsi van mögötte.
    }

    /**
     * Mozdonynak jelzés hogy ütközött
     * @param other - Az ütközésben résztvevő másik mozdony
     */
    public void collision(Locomotive other){
        System.out.println("[Locomotive].collision(Locomotive other)");
        other.destroy();
    }

    /**
     * A mozdfonyt követő elem beállítására szolgál.
     * @param tc - A következő elem a vonatban
     */
    public void setNext(TrainComponent tc) {
        next = tc;
    }
}