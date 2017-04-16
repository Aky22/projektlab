
import java.util.*;

/**
 * 
 */
public class TunnelEnd extends Component {

    private boolean active;

    public TunnelEnd(double x_0, double y_0, double x_1, double y_1){
        super(x_0, y_0, x_1, y_1);
        active = false;
    }

    /**
     * 
     */
    protected void activate() {
        System.out.println("[TunnelEnd].activate()");
        active = !active;
        /*if(active) {
            active = false;
        } else active = true;*/
    }

    /**
     * @return
     */
    private boolean isActive() {
        // TODO implement here
        return active;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[TunnelEnd].operateOn(l: Locomotive");
        tcCollection.insert(l);
        if(active){
            //l.inTunnel();
        }
    }
}