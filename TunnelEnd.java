
import java.util.*;

/**
 * 
 */
public class TunnelEnd extends Component {
    boolean active;

    /**
     * Default constructor
     */
    public TunnelEnd() {
        active = false;
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
}