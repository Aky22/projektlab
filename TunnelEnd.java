
import java.util.*;

/**
 * 
 */
public class TunnelEnd implements Component {
    boolean active;
    private Collection tcCollection;
    /**
     * Default constructor
     */
    public TunnelEnd() {
        active = false;
        tcCollection = new Collection();
    }


    /**
     * 
     */
    public void activate() {
        System.out.println("[TunnelEnd].activate()");
        if(active) {
            active = false;
        } else active = true;
    }

    /**
     * @return
     */
    public boolean isActive() {
        // TODO implement here
        return false;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[TunnelEnd].operateOn(l: Locomotive");
        tcCollection.insert(l);
        if(active){
            l.inTunnel();
        }
    }

    /**
     * @return
     */
    public Collection getCollection() {
        // TODO implement here
        return null;
    }

    /**
     * @param previous 
     * @param tc 
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        // TODO implement here
        return null;
    }

    /**
     * @param tc
     */
    public void insert(TrainComponent tc) {
        // TODO implement here
    }

}