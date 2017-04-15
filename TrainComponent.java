
import java.util.*;
import java.awt.Color;

/**
 * 
 */
public interface TrainComponent {

    public TrainComponent previous = null;
    public TrainComponent next = null;
    public Component current = null;
    public boolean destroyed = false;
    public boolean derailed = false;
    public boolean inTunnel = false;


    public void derail();

    public void atStation(Color c, int passengerNumber);

    public void step();

    public void connect(char side, TrainComponent tc);

    abstract public void place(Component current);

}