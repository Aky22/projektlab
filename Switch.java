
import java.util.*;

/**
 * 
 */
public class Switch extends Component {

    private boolean state;

    public Switch(double x0, double y0, double x1, double y1){
        super(x0, y0, y1, x1);
        state = false;
    }

    /**
     * @return
     */
    public void Switch() {
        System.out.println("[Switch].switch()");
        TrainComponent first = tcCollection.getFirst();
        if(first != null){
            first.derail();
        }
        state = !state; //+ valami az iránnyal??

    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[Switch].operateOn(Locomotive l)");
        tcCollection.insert(l);
    }
}