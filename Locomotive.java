
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Locomotive implements TrainComponent {

    Component current;

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
        Collection c = current.getCollection();

        boolean yesOrNo = c.myComponentAtEnd(this);
        //ütközés
        if(current._TESTCOLLISION){
            Locomotive other = new Locomotive();
            this.collision(other);
        }

        if(current._TESTEND){ //ha végére értünk
            Component nextComponent = current.getNext(null, this);
            nextComponent.operateOn(this);

        }


        next.step(); //léptetjük a kocsikat
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

    public void setCurrent(Component c){
        current = c;
    }
}