import java.awt.*;

/**
 * Created by Andras on 2017.04.15..
 */
public class CoalWagon implements TrainComponent{
    //??
    public TrainComponent previous = null;
    public TrainComponent next = null;
    public Component current = null;
    public boolean destroyed = false;
    public boolean derailed = false;
    public boolean inTunnel = false;
    //?

    public CoalWagon(TrainComponent pre, TrainComponent nex, Component curr){
        super(); //??
    }

    @Override
    public void derail() {
        derailed = true;
        previous.derail(); //elozo kisiklatasa
    }

    @Override
    public void atStation(Color c, int passengerNumber) {
        if(previous != null){
            next.atStation(c, passengerNumber);
        }
    }

    @Override
    public void step() {

    }

    @Override
    public void connect(char side, TrainComponent tc) {
        if(side == 'p'){
            previous = tc;
        }
        else if(side == 'n'){
            next = tc;
        }
    }

    @Override
    public void place(Component current) {      // ??

    }
}
