
import java.util.*;
import java.awt.Color;

/**
 * 
 */
public abstract class TrainComponent {

    public TrainComponent previous = null;
    public TrainComponent next = null;
    public Component current = null;
    public boolean destroyed = false;
    public boolean derailed = false;
    public boolean inTunnel = false;

    /**
     * Kisiklatás - derailed flaget a teljes vonaton beállítja
     */
    public void derail(){
        derailed = true;
        destroyed = true;
        if(next != null){ //következő kisiklatása ha nem null, és nem siklott ki
            if(next.isDerailed()){}
            else {
                next.derail();
            }
        }
        if(previous != null){//előző kisiklatása ha nem null, és nem siklott ki
            if(previous.isDerailed()){}
            else {
                previous.derail();
            }
        }
    }

    /**
     * Állomásra érés absztrakt metódusa - állomás hívja
     * @param c - Állomás színe
     * @param passengerNumber - Állomáson lévő utasok száma
     * @return - Leszállt utasok száma
     */
    abstract public int atStation(Color c, int passengerNumber);

    /**
     * Léptetés, adott elemet megelőző elem hívja (vagy mozdonyét a Game)
     */
    abstract public void step();

    /**
     * Vonat összekapcsolásáért felelős
     * @param side - Melyik oldalára P - előző; N következő
     * @param tc - A hozzákapcsolandó elem
     */
    public void connect(char side, TrainComponent tc){
        switch(side){
            case 'P':
                previous = tc;
                break;
            case 'N':
                next = tc;
                break;
        }
    }

    /**
     * Init során elhelyezi az elemet az adott pályaelemen
     * @param current
     */
    abstract public void place(Component current);

    /**
     * Megadja, hogy az adott elem kisiklott-e
     * @return - Kisiklott-e
     */
    public boolean isDerailed(){
        return derailed;
    }

}