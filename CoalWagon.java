import java.awt.*;

/**
 * Created by Andras on 2017.04.15..
 */
public class CoalWagon extends TrainComponent{
    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(next != null){
            ret += next.atStation(c, passengerNumber);
        }
        return ret;
    }

    @Override
    public void step() {
        //TODO !!!!
    }

    @Override
    public void place(Component current) {      // ??
        //TODO !!!!!
    }
}
