
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
    public void operateOn(Locomotive l) {
        // TODO implement here
    }

    /**
     * @param previous
     * @param tc
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        // TODO implement here kisiklatás
        return null;
    }
}