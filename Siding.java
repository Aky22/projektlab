
import java.util.*;

/**
 * 
 */
public class Siding extends Component {
    public Siding(double x_0, double y_0, double x_1, double y_1){
        super(x_0, y_0, x_1, y_1);
    }

    /**
     * @param l
     */
    @Override
    public void operateOn(Locomotive l) { //kész
        tcCollection.insert(l); //behelyezzük a kollekcióba
        l.derail();
    }

    /**
     * @param previous
     * @param tc
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        //teljesen mindegy idáig úgyse jut el
        return null;
    }
}