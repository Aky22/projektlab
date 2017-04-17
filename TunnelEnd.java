
import java.util.*;

/**
 * 
 */
public class TunnelEnd extends Component {

    private boolean active;

    public TunnelEnd(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        active = false;
        System.out.print("created TunnelEnd with id: ");
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
        tcCollection.insert(l);
        if(active){
            //l.inTunnel();
        }
    }

    @Override
    public void list(){
        String act;
        if(active)
            act = "activated";
        else act = "deactivated";

        System.out.println("TunnelEnd " + id + " at " + x0 + ", " + y0 + ": " + act + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}