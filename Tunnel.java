
import java.util.*;

/**
 * 
 */
public class Tunnel {

    private TunnelEnd sideA;
    private TunnelEnd sideB;
    private boolean trainInside;
    private boolean active;

    /**
     * Default constructor
     */
    public Tunnel() {
        sideA = null;
        sideB = null;
        trainInside = false;
        active = false;
    }


    /**
     * @param t 
     * @return
     */
    public void setEnd(TunnelEnd t) {
        System.out.println("[Tunnel].setEnd(TunnelEnd t)");
        t.activate();
    }

    /**
     * @return
     */
    public boolean isActive() {
        System.out.println("[Tunnel].isActive()");
        //TODO valami
        return active;
    }

    /**
     * @return
     */
    public boolean trainInside() {
        // TODO implement here
        return trainInside;
    }

}