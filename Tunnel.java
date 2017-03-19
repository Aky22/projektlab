
import java.util.*;

/**
 * 
 */
public class Tunnel {
    TunnelEnd sideA;
    TunnelEnd sideB;

    /**
     * Default constructor
     */
    public Tunnel() {
        sideA = null;
        sideB = null;
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
        return false;
    }

    /**
     * @return
     */
    public boolean trainInside() {
        // TODO implement here
        return false;
    }

}