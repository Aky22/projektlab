
import java.util.*;

/**
 * 
 */
public class Rail extends Component {
    /**
     * @param l
     */
    @Override
    public void operateOn(Locomotive l) {
        System.out.println("[Rail].operateOn");
        tcCollection.insert(l);
    }
}