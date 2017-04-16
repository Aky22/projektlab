
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Locomotive implements TrainComponent {


    public TrainComponent previous = null;
    public TrainComponent next = null;
    public Component current = null;
    public boolean destroyed = false;
    public boolean derailed = false;
    public boolean inTunnel = false;


    public Locomotive() {
    }



    /**
     * @param c 
     * @return
     */
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        //System.out.println("[Locomotive].atStation(c: Color)");
        ret += next.atStation(c, passengerNumber); //leszállók száma
        return ret;
    }

    /**
     * @return
     */
    public void step() {
        System.out.println("[Locomotive].step()");
        Collection c = current.getCollection();

        /*boolean yesOrNo = c.myComponentAtEnd(this);
        //ütközés
        if(current._TESTCOLLISION){
            Locomotive other = new Locomotive();
            this.collision(other);
        }

        if(current._TESTEND){ //ha végére értünk
            Component nextComponent = current.getNext(null, this);
            nextComponent.operateOn(this);

            next.step();
        }*/
    }

    @Override
    public void connect(char side, TrainComponent tc) {

    }

    @Override
    public void place(Component current) {

    }

    /**
     * @return
     */
    public void inTunnel() {
        inTunnel = true;
        System.out.println("[Locomotive].inTunnel()");
    }

    /**
     * @return
     */
    public void destroy() {
        destroyed = true;
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
        this.destroy();
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

    public void placeLocomotive(Component current){

    }


}