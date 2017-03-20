
import java.util.*;

/**
 * 
 */
public class Siding extends Component {
    /**
     * @param l
     */
    @Override
    public void operateOn(Locomotive l) {
        System.out.println("[Siding].operateOn(Locomotive l)");
        tcCollection.insert(l);
        l.derail();
    }
}