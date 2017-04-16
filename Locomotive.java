
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Locomotive extends TrainComponent {

    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        ret += next.atStation(c, passengerNumber); //leszállók száma
        return ret;
    }

    @Override
    public void step() {
        //TODO
    }


    @Override
    public void place(Component current) {
        //TODO
    }
}